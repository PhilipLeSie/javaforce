package jfconfig;

/**
 * Created : Mar 18, 2012
 *
 * @author pquiring
 */

import java.io.*;
import java.util.*;
import javax.swing.*;

import javaforce.*;
import javaforce.awt.*;
import javaforce.linux.*;

public class DNSPanel extends javax.swing.JPanel {

  /**
   * Creates new form DNSPanel
   */
  public DNSPanel() {
    initComponents();
    loadZones();
    updateZones();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jToolBar1 = new javax.swing.JToolBar();
    back = new javax.swing.JButton();
    addZone = new javax.swing.JButton();
    editZone = new javax.swing.JButton();
    delZone = new javax.swing.JButton();
    save = new javax.swing.JButton();
    apply = new javax.swing.JButton();
    restart = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    zones = new javax.swing.JList();
    jScrollPane2 = new javax.swing.JScrollPane();
    entries = new javax.swing.JList();
    jToolBar2 = new javax.swing.JToolBar();
    addEntry = new javax.swing.JButton();
    editEntry = new javax.swing.JButton();
    delEntry = new javax.swing.JButton();
    up = new javax.swing.JButton();
    down = new javax.swing.JButton();

    jToolBar1.setFloatable(false);
    jToolBar1.setRollover(true);

    back.setText("<Back");
    back.setFocusable(false);
    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    back.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    back.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backActionPerformed(evt);
      }
    });
    jToolBar1.add(back);

    addZone.setText("Add Zone");
    addZone.setFocusable(false);
    addZone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    addZone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    addZone.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addZoneActionPerformed(evt);
      }
    });
    jToolBar1.add(addZone);

    editZone.setText("Edit Zone");
    editZone.setFocusable(false);
    editZone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    editZone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    editZone.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editZoneActionPerformed(evt);
      }
    });
    jToolBar1.add(editZone);

    delZone.setText("Del Zone");
    delZone.setFocusable(false);
    delZone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    delZone.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    delZone.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        delZoneActionPerformed(evt);
      }
    });
    jToolBar1.add(delZone);

    save.setText("Save");
    save.setFocusable(false);
    save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    save.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveActionPerformed(evt);
      }
    });
    jToolBar1.add(save);

    apply.setText("Apply");
    apply.setFocusable(false);
    apply.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    apply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    apply.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        applyActionPerformed(evt);
      }
    });
    jToolBar1.add(apply);

    restart.setText("Restart Server");
    restart.setFocusable(false);
    restart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    restart.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    restart.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        restartActionPerformed(evt);
      }
    });
    jToolBar1.add(restart);

    zones.setModel(zonesModel);
    zones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    zones.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        zonesValueChanged(evt);
      }
    });
    jScrollPane1.setViewportView(zones);

    entries.setModel(entriesModel);
    entries.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane2.setViewportView(entries);

    jToolBar2.setFloatable(false);
    jToolBar2.setRollover(true);

    addEntry.setText("Add Entry");
    addEntry.setFocusable(false);
    addEntry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    addEntry.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    addEntry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addEntryActionPerformed(evt);
      }
    });
    jToolBar2.add(addEntry);

    editEntry.setText("Edit Entry");
    editEntry.setFocusable(false);
    editEntry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    editEntry.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    editEntry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        editEntryActionPerformed(evt);
      }
    });
    jToolBar2.add(editEntry);

    delEntry.setText("Del Entry");
    delEntry.setFocusable(false);
    delEntry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    delEntry.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    delEntry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        delEntryActionPerformed(evt);
      }
    });
    jToolBar2.add(delEntry);

    up.setText("Up");
    up.setFocusable(false);
    up.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    up.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    up.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        upActionPerformed(evt);
      }
    });
    jToolBar2.add(up);

    down.setText("Down");
    down.setFocusable(false);
    down.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    down.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    down.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        downActionPerformed(evt);
      }
    });
    jToolBar2.add(down);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
      .addComponent(jScrollPane1)
      .addComponent(jScrollPane2)
      .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    ConfigApp.This.setPanel(new ServersPanel());
  }//GEN-LAST:event_backActionPerformed

  private void zonesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_zonesValueChanged
    updateEntries();
  }//GEN-LAST:event_zonesValueChanged

  private void addZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addZoneActionPerformed
    addZone();
  }//GEN-LAST:event_addZoneActionPerformed

  private void editZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editZoneActionPerformed
    int idx = zones.getSelectedIndex();
    if (idx == -1) return;
    editZone(idx);
  }//GEN-LAST:event_editZoneActionPerformed

  private void delZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delZoneActionPerformed
    int idx = zones.getSelectedIndex();
    if (idx == -1) return;
    delZone(idx);
  }//GEN-LAST:event_delZoneActionPerformed

  private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    saveZones();
  }//GEN-LAST:event_saveActionPerformed

  private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
    apply();
  }//GEN-LAST:event_applyActionPerformed

  private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed
    restart();
  }//GEN-LAST:event_restartActionPerformed

  private void addEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryActionPerformed
    addEntry();
  }//GEN-LAST:event_addEntryActionPerformed

  private void editEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEntryActionPerformed
    int idx = entries.getSelectedIndex();
    if (idx == -1) return;
    editEntry(idx);
  }//GEN-LAST:event_editEntryActionPerformed

  private void delEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delEntryActionPerformed
    int idx = entries.getSelectedIndex();
    if (idx == -1) return;
    delEntry(idx);
  }//GEN-LAST:event_delEntryActionPerformed

  private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
    int zidx = zones.getSelectedIndex();
    if (zidx == -1) return;
    int eidx = entries.getSelectedIndex();
    if (eidx == -1) return;
    if (eidx == 0) return;
    Entry tmp = config.zone[zidx].entry[eidx];
    config.zone[zidx].entry[eidx] = config.zone[zidx].entry[eidx-1];
    config.zone[zidx].entry[eidx-1] = tmp;
    updateEntries();
  }//GEN-LAST:event_upActionPerformed

  private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
    int zidx = zones.getSelectedIndex();
    if (zidx == -1) return;
    int eidx = entries.getSelectedIndex();
    if (eidx == -1) return;
    if (eidx == config.zone[zidx].entry.length-1) return;
    Entry tmp = config.zone[zidx].entry[eidx];
    config.zone[zidx].entry[eidx] = config.zone[zidx].entry[eidx+1];
    config.zone[zidx].entry[eidx+1] = tmp;
    updateEntries();
  }//GEN-LAST:event_downActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addEntry;
  private javax.swing.JButton addZone;
  private javax.swing.JButton apply;
  private javax.swing.JButton back;
  private javax.swing.JButton delEntry;
  private javax.swing.JButton delZone;
  private javax.swing.JButton down;
  private javax.swing.JButton editEntry;
  private javax.swing.JButton editZone;
  private javax.swing.JList entries;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JToolBar jToolBar2;
  private javax.swing.JButton restart;
  private javax.swing.JButton save;
  private javax.swing.JButton up;
  private javax.swing.JList zones;
  // End of variables declaration//GEN-END:variables

  public static class Entry {
    public String name, type, metric, value;  //metric is used the MX records
  }

  public static class Zone {
    public Zone() {
      entry = new Entry[0];
    }
    public boolean master;
    public String others;  //if master==true others=secdonary servers else others=master
    public String name;  //example.com
    public Entry entry[];
    public int ttl;  //in seconds
  }

  public static class Config {
    public Zone zone[];
  }

  private DefaultListModel zonesModel = new DefaultListModel();
  private DefaultListModel entriesModel = new DefaultListModel();

  private Config config;
  private String configFolder = "/etc/jfconfig.d/";
  private String configFile = "dns.xml";

  private void loadZones() {
    defaultConfig();
    try {
      XML xml = new XML();
      FileInputStream fis = new FileInputStream(configFolder + configFile);
      xml.read(fis);
      xml.writeClass(config);
    } catch (FileNotFoundException e1) {
      defaultConfig();
    } catch (Exception e2) {
      JFLog.log(e2);
      defaultConfig();
    }
  }

  private void defaultConfig() {
    config = new Config();
    config.zone = new Zone[0];
  }

  private void saveZones() {
    try {
      XML xml = new XML();
      File tmpFile = File.createTempFile("dns", ".xml");
      FileOutputStream fos = new FileOutputStream(tmpFile);
      xml.readClass("dns", config);
      xml.write(fos);
      fos.close();
      Linux.mkdir(configFolder);
      if (!Linux.copyFile(tmpFile.getAbsolutePath(), configFolder + configFile)) {
        tmpFile.delete();
        throw new Exception("file io error");
      }
      tmpFile.delete();
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  private String getZoneString(Zone zone) {
    return zone.name;
  }

  private void updateZones() {
    zonesModel.clear();
    for(int a=0;a<config.zone.length;a++) {
      zonesModel.addElement(getZoneString(config.zone[a]));
    }
  }

  private String getEntryString(Entry entry) {
    if (entry.type.equals("MX")) {
      return entry.name + "(" + entry.type + ")=" + entry.metric + " " + entry.value;
    } else {
      return entry.name + "(" + entry.type + ")=" + entry.value;
    }
  }

  private void updateEntries() {
    entriesModel.clear();
    int idx = zones.getSelectedIndex();
    if (idx == -1) return;
    Zone zone = config.zone[idx];
    for(int a=0;a<zone.entry.length;a++) {
      entriesModel.addElement(getEntryString(zone.entry[a]));
    }
  }

  private void restart() {
    if (Linux.restartService("bind9"))
      JFAWT.showMessage("Notice", "DNS Service Restarted");
    else
      JFAWT.showError("Error", "Failed to Restart DNS Service");
  }

  private void addZone() {
    DNSZoneDialog dialog = new DNSZoneDialog(ConfigApp.This, true, null);
    dialog.setVisible(true);
    if (!dialog.accepted) return;
    Zone newZone = new Zone();
    newZone.name = dialog.getName();
    newZone.master = dialog.getMaster();
    newZone.others = dialog.getOthers();
    newZone.ttl = dialog.getTTL();
    config.zone = Arrays.copyOf(config.zone, config.zone.length + 1);
    config.zone[config.zone.length-1] = newZone;
    updateZones();
  }

  private void editZone(int idx) {
    Zone zone = config.zone[idx];
    DNSZoneDialog dialog = new DNSZoneDialog(ConfigApp.This, true, zone);
    dialog.setVisible(true);
    if (!dialog.accepted) return;
    zone.name = dialog.getName();
    zone.master = dialog.getMaster();
    zone.others = dialog.getOthers();
    zone.ttl = dialog.getTTL();
    updateZones();
  }

  private void delZone(int idx) {
    Zone zone = config.zone[idx];
    if (!JFAWT.showConfirm("Confirm", "Are you sure you want to delete '" + zone.name + "'?")) return;
    int len = config.zone.length;
    Zone newList[] = new Zone[len-1];
    System.arraycopy(config.zone, 0, newList, 0, idx);
    System.arraycopy(config.zone, idx+1, newList, idx, len - idx - 1);
    config.zone = newList;
    updateZones();
  }

  private void addEntry() {
    int zidx = zones.getSelectedIndex();
    if (zidx == -1) return;
    DNSEntryDialog dialog = new DNSEntryDialog(ConfigApp.This, true, null);
    dialog.setVisible(true);
    if (!dialog.accepted) return;
    Entry newEntry = new Entry();
    newEntry.name = dialog.getName();
    newEntry.type = dialog.getDNSType();
    newEntry.metric = dialog.getMetric();
    newEntry.value = dialog.getValue();
    config.zone[zidx].entry = Arrays.copyOf(config.zone[zidx].entry, config.zone[zidx].entry.length + 1);
    config.zone[zidx].entry[config.zone[zidx].entry.length-1] = newEntry;
    updateEntries();
  }

  private void editEntry(int idx) {
    int zidx = zones.getSelectedIndex();
    if (zidx == -1) return;
    Entry entry = config.zone[zidx].entry[idx];
    DNSEntryDialog dialog = new DNSEntryDialog(ConfigApp.This, true, entry);
    dialog.setVisible(true);
    if (!dialog.accepted) return;
    entry.name = dialog.getName();
    entry.type = dialog.getDNSType();
    entry.metric = dialog.getMetric();
    entry.value = dialog.getValue();
    updateEntries();
  }

  private void delEntry(int idx) {
    int zidx = zones.getSelectedIndex();
    if (zidx == -1) return;
    Entry entry = config.zone[zidx].entry[idx];
    if (!JFAWT.showConfirm("Confirm", "Are you sure you want to delete '" + entry.name + "'?")) return;
    int len = config.zone[zidx].entry.length;
    Entry newList[] = new Entry[len-1];
    System.arraycopy(config.zone[zidx].entry, 0, newList, 0, idx);
    System.arraycopy(config.zone[zidx].entry, idx+1, newList, idx, len - idx - 1);
    config.zone[zidx].entry = newList;
    updateZones();
  }

  private void applyEntry(Entry entry, OutputStream os) throws Exception {
    StringBuilder str = new StringBuilder();
    str.append(entry.name);
    str.append(" IN ");
    str.append(entry.type);
    str.append(" ");
    if (entry.type.equals("MX")) {
      str.append(entry.metric);
      str.append(" ");
    }
    str.append(entry.value);
    str.append("\n");
    os.write(str.toString().getBytes());
  }

  private void applyZone(Zone zone, OutputStream os) throws Exception {
    StringBuilder str = new StringBuilder();
    File tmpFile = File.createTempFile("zoneFile", "");
    FileOutputStream fos = new FileOutputStream(tmpFile);
    fos.write(("$TTL " + zone.ttl + "\n").getBytes());
    fos.write(("$ORIGIN " + zone.name + ".\n").getBytes());
    fos.write(("@ " + zone.ttl + " IN SOA ns1." + zone.name + ". admin." + zone.name + ". (2002022401 3H 15 1w 3h)\n").getBytes());
    for(int a=0;a<zone.entry.length;a++) {
      applyEntry(zone.entry[a], fos);
    }
    fos.close();
    if (!Linux.copyFile(tmpFile.getAbsolutePath(), "/var/cache/bind/" + zone.name))
      throw new Exception("file copy error");
    tmpFile.delete();
    str.append("zone \"" + zone.name + "\" in{\n");
    str.append("  type " + (zone.master ? "master" : "slave") + ";\n");
    str.append("  file \"" + zone.name + "\";\n");
    if (zone.master) {
      if (zone.others.length() > 0) {
        str.append("  allow-transfer {");
        String others[] = zone.others.split(" ");
        for(int a=0;a<others.length;a++) {
          str.append(others[a]);
          str.append(";");
        }
        str.append("};\n");
      }
    } else {
      if (zone.others.length() > 0) {
        str.append("  masters {");
        String others[] = zone.others.split(" ");
        for(int a=0;a<others.length;a++) {
          str.append(others[a]);
          str.append(";");
        }
        str.append("};\n");
      }
    }
    str.append("};\n");
//JFLog.log("str="+str.toString());
    os.write(str.toString().getBytes());
  }

  private void apply() {
    //save config to /etc/bind/named.conf.local
    try {
      File tmpFile = File.createTempFile("dns", ".conf");
      FileOutputStream fos = new FileOutputStream(tmpFile);
      for(int a=0;a<config.zone.length;a++) applyZone(config.zone[a], fos);
      fos.close();
      //copy tmpFile to /etc/bind/named.conf.local
      if (!Linux.copyFile(tmpFile.getAbsolutePath(), "/etc/bind/named.conf.local"))
        throw new Exception("file copy error");
      JFAWT.showMessage("Notice", "Settings have been applied, please restart server.");
    } catch (Exception e) {
      JFLog.log(e);
      JFAWT.showError("Error", "Failed to apply settings.");
    }
  }
}
