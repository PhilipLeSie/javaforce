package jfconfig;

/** Time zone selector
 *
 * Created : Oct 21, 2014
 *
 * @author pquiring
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

import javaforce.*;
import javaforce.awt.*;

public class TimeZonePanel extends javax.swing.JPanel implements MouseListener, MouseMotionListener {

  /**
   * Creates new form TimeZone
   */
  public TimeZonePanel() {
    initComponents();
    initMap();
    loadZones();
    calcMapCoords();
    repaintMap();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    map = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    timezone = new javax.swing.JComboBox();

    map.setLayout(new java.awt.GridLayout(1, 0));

    jLabel2.setText("Timezone:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(timezone, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap(24, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(map, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(timezone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel2;
  private javax.swing.JPanel map;
  private javax.swing.JComboBox timezone;
  // End of variables declaration//GEN-END:variables

  private class Zone {
    double lng, lat;
    int x, y;  //translated screen coords
    String tz;
  }
  private JFImage imgorg, img;
  private ArrayList<Zone> zones = new ArrayList<Zone>();
  private int selIdx = -1;

  private void initMap() {
    imgorg = new JFImage();
    imgorg.load(getClass().getResourceAsStream("/worldmap.png"));
    img = new JFImage();
    img.setImageSize(imgorg.getWidth(), imgorg.getHeight());
    img.putJFImage(imgorg, 0, 0);
    img.addMouseMotionListener(this);
    img.addMouseListener(this);
    img.setResizeOperation(JFImage.ResizeOperation.CHOP);
    map.add(img);
    map.revalidate();
  }

  private float decodeDegMinSec(String dms) {
    boolean neg = dms.charAt(0) == '-';
    String d,m,s;
    switch (dms.length()) {
      default:
        return 0;
      case 5://-DDMM
        d = dms.substring(1,2+1);
        m = dms.substring(3,4+1);
        s = "0";
        break;
      case 6://-DDDMM
        d = dms.substring(1,3+1);
        m = dms.substring(4,5+1);
        s = "0";
        break;
      case 7://-DDMMSS
        d = dms.substring(1,2+1);
        m = dms.substring(3,4+1);
        s = dms.substring(5,6+1);
        break;
      case 8://-DDDMMSS
        d = dms.substring(1,3+1);
        m = dms.substring(4,5+1);
        s = dms.substring(6,7+1);
        break;
    }
    float deg = Integer.valueOf(d);
    float min = ((float)Integer.valueOf(m)) / 60.0f;
    float sec = ((float)Integer.valueOf(s)) / 3600.0f;
    float com = deg + min + sec;
    if (neg) return -com; else return com;
  }

  private void loadZones() {
    try {
      File tab = new File("/usr/share/zoneinfo/zone.tab");
      BufferedReader br = new BufferedReader(new FileReader(tab));
      while (true) {
        String ln = br.readLine();
        if (ln == null) break;
        if (ln.length() == 0) continue;
        if (ln.charAt(0) == '#') continue;
        String f[] = ln.split("\t");  //tab delimited
        //CC coords dir/file [desc]
        float lat, lng;
        if (f[1].length() == 11) {
          //-DDMM-DDDMM
          lat = decodeDegMinSec(f[1].substring(0, 1+4));
          lng = decodeDegMinSec(f[1].substring(5));
        } else {
          //-DDMMSS-DDDMMSS
          lat = decodeDegMinSec(f[1].substring(0, 1+6));
          lng = decodeDegMinSec(f[1].substring(7));
        }
        Zone zone = new Zone();
        zone.lat = lat;
        zone.lng = lng;
        zone.tz = f[2];
        zones.add(zone);
        timezone.addItem(f[2] + " (" + lat + " " + lng + ")");
      }
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  //see http://en.wikipedia.org/wiki/Miller_cylindrical_projection
  //image and equations taken from Ubuntu ubiquity
  private int lngToX(double lng) {
    double width = img.getWidth();
    double x = (lng * (Math.PI / 180.0)) + Math.PI;
    x = x / (2.0 * Math.PI);
    x = x * width;
    return (int)x;
  }

  private int latToY(double lat) {
    double height = img.getHeight();
    double y = 1.25 * Math.log(Math.tan(
      (0.25 * Math.PI) + (0.4 * (lat * (Math.PI / 180.0)))));
    //100 % = 4.6068250867599998
    y /= 2.30341254338;
    y *= 1.3;  //scale adjust
    y = y * -height/2.0 + height/2.0;
    return (int)y;
  }

  private void calcMapCoords() {
    for(int a=0;a<zones.size();a++) {
      Zone zone = zones.get(a);
      zone.x = lngToX(zone.lng);
      zone.y = latToY(zone.lat);
    }
  }

  private void repaintMap() {
    img.putJFImage(imgorg, 0, 0);
    Graphics2D g = img.getGraphics2D();
    for(int a=0;a<zones.size();a++) {
      Zone z = zones.get(a);
      if (a == selIdx)
        g.setColor(new Color(0x00ff00));  //green dot (selected)
      else
        g.setColor(new Color(0xff0000));  //red dot (not selected)
      int rad = 4;  //TODO : change size based on bandwidth
      g.fillOval(z.x-rad/2, z.y-rad/2, rad, rad);
    }
    img.repaint();
  }

  private void updateSelection() {
    if (selIdx == -1) return;
    timezone.setSelectedIndex(selIdx);
  }

  public void setTimeZone(String tz) {
    for(int a=0;a<zones.size();a++) {
      Zone z = zones.get(a);
      if (tz.equalsIgnoreCase(z.tz)) {
        selIdx = a;
        updateSelection();
        repaintMap();
        return;
      }
    }
    JFLog.log("Error:timezone unknown:" + tz);
  }

  public String getTimeZone() {
    if (selIdx == -1) return null;
    Zone z = zones.get(selIdx);
    return z.tz;
  }

  public boolean applyTimeZone() {
    if (selIdx == -1) return false;
    Zone z = zones.get(selIdx);
    ShellProcess sp;
    File file = new File("/tmp/settimezone");
    try {
      FileOutputStream fos = new FileOutputStream(file);
      fos.write("#/bin/bash\n".getBytes());
      fos.write("rm /etc/localtime\n".getBytes());
      fos.write(("ln -s /usr/share/zoneinfo/" + z.tz + " /etc/localtime\n").getBytes());
      fos.write(("echo " + z.tz + ">/etc/timezone").getBytes());
      fos.close();
      file.setExecutable(true);
      sp = new ShellProcess();
      sp.run(new String[]{
        "sudo", "/tmp/settimezone"
        }, false);
      if (sp.getErrorLevel() != 0) throw new Exception("failed");
      file.delete();
      return true;
    } catch (Exception e) {
      file.delete();
      JFAWT.showError("Error", "Unable to set timezone");
      JFLog.log(e);
      return false;
    }
  }

  /** Loads current zone from /etc/timezone */
  public void loadCurrentZone() {
    File file = new File("/etc/timezone");
    if (!file.exists()) {
      JFLog.log("Error:/etc/timezone does not exist");
      return;
    }
    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String tz = br.readLine();
      br.close();
      JFLog.log("current timezone=" + tz);
      setTimeZone(tz);
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public void mouseClicked(MouseEvent e) {
    //find closest to point
    int x = e.getX();
    int y = e.getY();
    int bd = 0xffffff;
    int bi = -1;
    Zone z;
    for(int a=0;a<zones.size();a++) {
      z = zones.get(a);
      int d = (int)Math.sqrt(Math.pow(z.x - x, 2) + Math.pow(z.y - y, 2));
      if (d < bd) {
        bi = a;
        bd = d;
      }
    }
    if (bi == -1) return;
    selIdx = bi;
    updateSelection();
    repaintMap();
  }
  public void mouseEntered(MouseEvent e) { }
  public void mouseExited(MouseEvent e) { }
  public void mousePressed(MouseEvent e) { }
  public void mouseReleased(MouseEvent e) { }

  public void mouseDragged(MouseEvent e) { }
  public void mouseMoved(MouseEvent e) { }
}
