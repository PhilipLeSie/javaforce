package javaforce.controls;

/** Monitors a PLC Tag.
 *
 * Auto-reconnects when disconnects.
 *
 * @author pquiring
 */

import java.util.*;

import javaforce.*;

public class Tag {
  /** Host (usually IP Address) */
  public String host;
  /** Type of host (S7, AB, MB, NI) */
  public Controller.types type;
  /** Tag name. */
  public String tag;
  /** Size of tag. */
  public Controller.sizes size;
  /** Color of tag (for reporting) */
  public int color;
  /** int min/max values (for reporting) */
  public int min, max;
  /** float min/max values (for reporting) */
  public float fmin, fmax;
  /** Speed to poll data (delay = ms delay between polls) (min = 25ms) */
  public int delay;
  /** Get user data. */
  public Object getData(String key) {
    return user.get(key);
  }
  /** Set user data. */
  public void setData(String key, Object value) {
    user.put(key, value);
  }
  /** Set host,type,tag,size,delay(ms). */
  public void setTag(String host, Controller.types type, String tag, Controller.sizes size, int delay) {
    this.host = host;
    this.type = type;
    this.tag = tag;
    this.size = size;
    this.delay = delay;
  }

  private Controller c;
  private Timer timer;
  private Reader reader;
  private TagListener listener;
  private HashMap<String, Object> user = new HashMap<String, Object>();
  private Tag parent;

  /** Returns true if data type is float32 or float64 */
  public boolean isFloat() {
    return size == Controller.sizes.float32 || size == Controller.sizes.float64;
  }

  /** Returns true is controller is Big Endian byte order. */
  public boolean isBE() {
    switch (type) {
      case S7: return true;
      case AB: return false;
      case MB: return true;
      case NI: return false;
      default: return true;
    }
  }

  /** Returns true is controller is Little Endian byte order. */
  public boolean isLE() {
    return !isBE();
  }

  /** Returns # of bytes tag uses. */
  public int getSize() {
    switch (size) {
      case bit: return 1;
      case int8: return 1;
      case int16: return 2;
      case int32: return 4;
      case float32: return 4;
      case float64: return 8;
    }
    return 0;
  }

  public String getURL() {
    switch (type) {
      case S7: return "S7:" + host;
      case AB: return "AB:" + host;
      case MB: return "MB:" + host;
      case NI: return "NI:" + host;
    }
    return null;
  }

  public Controller getController() {
    if (parent != null) {
      return parent.c;
    } else {
      return c;
    }
  }

  public void setListener(TagListener listener) {
    this.listener = listener;
  }

  public String toString() {
    if (type == Controller.types.NI) {
      return host;
    }
    return tag;
  }

  public String getmin() {
    if (isFloat()) {
      return Float.toString(fmin);
    } else {
      return Integer.toString(min);
    }
  }

  public String getmax() {
    if (isFloat()) {
      return Float.toString(fmax);
    } else {
      return Integer.toString(max);
    }
  }

  private boolean startTimer() {
    if (parent == null) {
      c = new Controller();
    } else {
      c = null;
    }
    timer = new Timer();
    reader = new Reader();
    reader.tag = this;
    if (delay < 25) delay = 25;
    timer.scheduleAtFixedRate(reader, delay, delay);
    return true;
  }

  /** Start reading tag at interval (delay). */
  public boolean start() {
    parent = null;
    return startTimer();
  }

  /** Start reading tag at interval (delay) using another Tags connection. */
  public boolean start(Tag parent) {
    this.parent = parent;
    if (parent != null && parent.type != type) return false;
    return startTimer();
  }

  /** Stop monitoring tag value. */
  public void stop() {
    if (timer != null) {
      timer.cancel();
      timer = null;
    }
    if (reader != null) {
      reader = null;
    }
    disconnect();
  }

  public boolean connect() {
    if (parent != null) return false;  //wait for parent to connect
    if (c.connect(getURL())) return true;
    return false;
  }

  public void disconnect() {
    if (parent != null) return;
    if (c != null) {
      c.disconnect();
      c = null;
    }
  }

  private String value = "0";

  /** Returns current value (only valid if start() has been called). */
  public String getValue() {
    return value;
  }

  /** Returns current value as int (only valid if start() has been called). */
  public int intValue() {
    return Integer.valueOf(value);
  }

  /** Returns current value as float (only valid if start() has been called). */
  public float floatValue() {
    return Float.valueOf(value);
  }

  /** Returns current value as double (float64) (only valid if start() has been called). */
  public double doubleValue() {
    return Double.valueOf(value);
  }

  /** Reads value directly. */
  public byte[] read() {
    if (parent != null) {
      if (parent.c == null) return null;
      return parent.c.read(tag);
    } else {
      return c.read(tag);
    }
  }

  /** Writes data to tag. */
  public void write(byte data[]) {
    if (parent != null) {
      if (parent.c == null) return;
      parent.c.write(tag, data);
    } else {
      c.write(tag, data);
    }
  }

  private static class Reader extends TimerTask {
    public Tag tag;
    public byte data[];
    public void run() {
      try {
        String lastValue = tag.value;
        if (tag.parent == null) {
          if (!tag.c.isConnected()) {
            if (!tag.connect()) {
              return;
            }
          }
        }
        data = tag.read();
        if (data == null) {
          System.out.println("Tag:error:data==null:Controller=" + tag.getController());
          return;
        }
        if (tag.isBE()) {
          switch (tag.size) {
            case bit: tag.value = data[0] == 0 ? "0" : "1"; break;
            case int8: tag.value = Byte.toString(data[0]); break;
            case int16: tag.value = Short.toString((short)BE.getuint16(data, 0)); break;
            case int32: tag.value = Integer.toString(BE.getuint32(data, 0)); break;
            case float32: tag.value = Float.toString(Float.intBitsToFloat(BE.getuint32(data, 0))); break;
            case float64: tag.value = Double.toString(Double.longBitsToDouble(BE.getuint64(data, 0))); break;
          }
        } else {
          switch (tag.size) {
            case bit: tag.value = data[0] == 0 ? "0" : "1"; break;
            case int8: tag.value = Byte.toString(data[0]); break;
            case int16: tag.value = Short.toString((short)LE.getuint16(data, 0)); break;
            case int32: tag.value = Integer.toString(LE.getuint32(data, 0)); break;
            case float32: tag.value = Float.toString(Float.intBitsToFloat(LE.getuint32(data, 0))); break;
            case float64: tag.value = Double.toString(Double.longBitsToDouble(LE.getuint64(data, 0))); break;
          }
        }
        if (tag.listener == null) return;
        if (lastValue == null || !tag.value.equals(lastValue)) {
          tag.listener.tagChanged(tag);
        }
      } catch (Exception e) {
        JFLog.log(e);
      }
    }
  }
}