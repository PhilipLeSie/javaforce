package jfconfig;

/**
 * Created : May 12, 2012
 *
 * @author pquiring
 */

import java.io.*;
import javax.swing.table.*;

import javaforce.*;
import javaforce.linux.Linux;

public class VPNServerPanel extends javax.swing.JPanel {

  /**
   * Creates new form VPNServerPanel
   */
  public VPNServerPanel() {
    initComponents();
    loadConfig();

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
    apply = new javax.swing.JButton();
    restart = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    remoteIPbegin = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    remoteIPend = new javax.swing.JTextField();
    localIP = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    auth = new javax.swing.JTable();
    jLabel4 = new javax.swing.JLabel();
    addRow = new javax.swing.JButton();
    delRow = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    dns1 = new javax.swing.JTextField();

    jToolBar1.setFloatable(false);
    jToolBar1.setRollover(true);

    back.setText("< Back");
    back.setFocusable(false);
    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    back.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    back.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backActionPerformed(evt);
      }
    });
    jToolBar1.add(back);

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

    jLabel1.setText("Local IP:");

    jLabel2.setText("Remote IP:");

    jLabel3.setText("to");

    auth.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "username", "password"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane2.setViewportView(auth);

    jLabel4.setText("Authentiation:");

    addRow.setText("Add");
    addRow.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addRowActionPerformed(evt);
      }
    });

    delRow.setText("Delete");
    delRow.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        delRowActionPerformed(evt);
      }
    });

    jLabel5.setText("DNS:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addRow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delRow))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel2)
                  .addComponent(jLabel1)
                  .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(remoteIPbegin)
                  .addComponent(localIP)
                  .addComponent(dns1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remoteIPend, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(localIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(remoteIPbegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3)
          .addComponent(remoteIPend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(dns1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(addRow)
          .addComponent(delRow))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
    ConfigApp.This.setPanel(new ServersPanel());
  }//GEN-LAST:event_backActionPerformed

  private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
    DefaultTableModel model = (DefaultTableModel)auth.getModel();
    model.addRow(new Object[] {"","","",""});
    auth.editCellAt(model.getRowCount()-1, 0);
  }//GEN-LAST:event_addRowActionPerformed

  private void delRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delRowActionPerformed
    DefaultTableModel model = (DefaultTableModel)auth.getModel();
    int idx = auth.getSelectedRow();
    if (idx == -1) return;
    model.removeRow(idx);
  }//GEN-LAST:event_delRowActionPerformed

  private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed
    restart();
  }//GEN-LAST:event_restartActionPerformed

  private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
    apply();
  }//GEN-LAST:event_applyActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addRow;
  private javax.swing.JButton apply;
  private javax.swing.JTable auth;
  private javax.swing.JButton back;
  private javax.swing.JButton delRow;
  private javax.swing.JTextField dns1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JToolBar jToolBar1;
  private javax.swing.JTextField localIP;
  private javax.swing.JTextField remoteIPbegin;
  private javax.swing.JTextField remoteIPend;
  private javax.swing.JButton restart;
  // End of variables declaration//GEN-END:variables

  public static class Config {
    public String localIP, remoteIPbegin, remoteIPend;
    public String auth;  //user,pass;user,pass...
    public String dns1;
  }
  private String configFolder = "/etc/jconfig.d/";
  private String configFile = "vpnserver.xml";
  private Config config = new Config();

  private void loadConfig() {
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
    localIP.setText(config.localIP);
    remoteIPbegin.setText(config.remoteIPbegin);
    remoteIPend.setText(config.remoteIPend);
    dns1.setText(config.dns1);
    DefaultTableModel model = (DefaultTableModel)auth.getModel();
    String lns[] = config.auth.split(";");
    for(int a=0;a<lns.length;a++) {
      String f[] = lns[a].split(",");
      if (f.length != 2) continue;
      model.addRow(new Object[] {f[0], f[1]});
    }
  }

  private void defaultConfig() {
    config = new Config();
    config.localIP = "192.168.0.1";
    config.remoteIPbegin = "192.168.0.200";
    config.remoteIPend = "250";
    config.auth = "";
    config.dns1 = "192.168.0.1";
  }

  private void saveConfig() {
    //save config to configFile
    config.localIP = localIP.getText();
    config.remoteIPbegin = remoteIPbegin.getText();
    config.remoteIPend = remoteIPend.getText();
    config.dns1 = dns1.getText();
    String auths = "";
    DefaultTableModel model = (DefaultTableModel)auth.getModel();
    for(int a=0;a<model.getRowCount();a++) {
      if (a > 0) auths += ";";
      auths += model.getValueAt(a, 0) + "," + model.getValueAt(a, 1);
    }
    config.auth = auths;
    try {
      XML xml = new XML();
      File tmpFile = File.createTempFile("vpnserver", ".xml");
      FileOutputStream fos = new FileOutputStream(tmpFile);
      xml.readClass("vpnServer", config);
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

  private void apply() {
    saveConfig();
    boolean ok = true;
    try {
      String cfg1 = new String(JF.readAll(this.getClass().getClassLoader().getResourceAsStream("pptpd-options")));
      cfg1 = cfg1.replaceAll("[$]DNS1", config.dns1);
      File tmpFile1 = File.createTempFile("cfg1", ".conf");
      FileOutputStream fos1 = new FileOutputStream(tmpFile1);
      fos1.write(cfg1.getBytes());
      fos1.close();

      String cfg2 = new String(JF.readAll(this.getClass().getClassLoader().getResourceAsStream("pptpd.conf")));
      cfg2 = cfg2.replaceAll("[$]LOCALIP", config.localIP);
      cfg2 = cfg2.replaceAll("[$]REMOTEIPBEGIN", config.remoteIPbegin);
      cfg2 = cfg2.replaceAll("[$]REMOTEIPEND", config.remoteIPend);
      File tmpFile2 = File.createTempFile("cfg2", ".conf");
      FileOutputStream fos2 = new FileOutputStream(tmpFile2);
      fos2.write(cfg2.getBytes());
      fos2.close();

      File tmpFile3 = File.createTempFile("cfg3", ".conf");
      FileOutputStream fos3 = new FileOutputStream(tmpFile3);
      String lns[] = config.auth.split(";");
      for(int a=0;a<lns.length;a++) {
        String f[] = lns[a].split(",");
        if (f.length != 2) continue;
        fos3.write((f[0] + "\t*\t" + f[1] + "\t*\n").getBytes());
      }
      fos3.close();

      String cfg4 = new String(JF.readAll(new FileInputStream("/etc/sysctl.conf")));
      cfg4 = cfg4.replaceAll("[#]net.ipv4.ip_forward=1", "net.ipv4.ip_forward=1");  //enable IP forwarding
      File tmpFile4 = File.createTempFile("cfg4", ".conf");
      FileOutputStream fos4 = new FileOutputStream(tmpFile4);
      fos4.write(cfg4.getBytes());
      fos4.close();

      //copy tmpFile's to real files via root script
      if (!Linux.runScript(new String[] {
        "cp " + tmpFile1.getAbsolutePath() + " /etc/ppp/pptpd-options",
        "cp " + tmpFile2.getAbsolutePath() + " /etc/pptpd.conf",
        "cp " + tmpFile3.getAbsolutePath() + " /etc/ppp/chap-secrets",
        "cp " + tmpFile4.getAbsolutePath() + " /etc/sysctl.conf",
      })) {
        ok = false;
        JF.showError("Error", "Failed to apply configuration");
      }
      tmpFile1.delete();
      tmpFile2.delete();
      tmpFile3.delete();
      tmpFile4.delete();
    } catch (Exception e) {
      JFLog.log(e);
      JF.showError("Error", "Exception:" + e);
      return;
    }
    if (ok) JF.showMessage("Notice", "Apply successful!\nPlease restart server for settings to take effect");
  }

  private void restart() {
    if (Linux.restartService("pptpd"))
      JF.showMessage("Notice", "VPN Server Restarted");
    else
      JF.showError("Error", "Failed to Restart VPN Server");
  }
}
