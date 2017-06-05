package jfcontrols.tags;

/** Remote Tag
 *
 * @author pquiring
 */

import javaforce.*;

public class RemoteTag extends MonitoredTag {

  private javaforce.controls.Tag remoteTag;
  private String value = "0";

  public RemoteTag(int cid, String name, int type, boolean unsigned, boolean array_not_supported, SQL sql) {
    super(type, unsigned, array_not_supported);
    remoteTag = RemoteControllers.getTag(cid, name, type, sql);
  }

  public void updateRead(SQL sql) {
    String newValue = remoteTag.getValue();
    if (!newValue.equals(value)) {
      String oldValue = value;
      value = newValue;
      tagChanged(null, oldValue, newValue);
    }
  }

  public void updateWrite(SQL sql) {
    if (dirty) {
      remoteTag.setValue(value);
      dirty = false;
    }
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    dirty = true;
    this.value = value;
  }

  public TagBase getIndex(TagAddr ta) {
    return null;
  }
}
