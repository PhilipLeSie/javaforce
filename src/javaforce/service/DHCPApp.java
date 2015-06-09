package javaforce.service;

/**
 *
 * @author pquiring
 *
 * Created : Nov 16, 2013
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javaforce.*;

public class DHCPApp extends javax.swing.JFrame implements ActionListener {

  /**
   * Creates new form DHCPApp
   */
  public DHCPApp() {
    initComponents();
    //create tray icon to open app
    JFImage img = new JFImage();
    img.setSize(16, 16);
    img.fill(0, 0, 16, 16, 0, true);
    img.getGraphics().drawString("Dh", 0,16);  //TODO : need an icon
    PopupMenu popup = new PopupMenu();
    show = new MenuItem("Show");
    show.addActionListener(this);
    popup.add(show);
    popup.addSeparator();
    exit = new MenuItem("Exit");
    exit.addActionListener(this);
    popup.add(exit);
    icon = new TrayIcon(img.getImage(), "DHCP", popup);
    icon.addActionListener(this);
    tray = SystemTray.getSystemTray();
    try { tray.add(icon); } catch (Exception e) { JFLog.log(e); }
    //start service
    service = new DHCP();
    service.start();
  }

  public void readConfig() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(JF.getUserPath() + "/.jdhcp.cfg"));
      StringBuilder str = new StringBuilder();
      while (true) {
        String ln = br.readLine();
        if (ln == null) break;
        str.append(ln);
        str.append("\n");
      }
      config.setText(str.toString());
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public void writeConfig() {
    try {
      String cfg = config.getText().replaceAll("\n", "\r\n");
      FileOutputStream fos = new FileOutputStream(JF.getUserPath() + "/.jdhcp.cfg");
      fos.write(cfg.getBytes());
      fos.close();
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public void restart() {
    service.close();
    JF.sleep(1000);
    service = new DHCP();
    service.start();
  }

  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    if (o == exit) {
      System.exit(0);
    }
    if (o == show) {
      readConfig();
      setVisible(true);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    save = new javax.swing.JButton();
    Cancel = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    config = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();

    setTitle("DHCP Server");

    save.setText("Save and Restart");
    save.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveActionPerformed(evt);
      }
    });

    Cancel.setText("Cancel");
    Cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        CancelActionPerformed(evt);
      }
    });

    config.setColumns(20);
    config.setRows(5);
    jScrollPane1.setViewportView(config);

    jLabel1.setText("DHCP Configuration:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 395, Short.MAX_VALUE)
            .addComponent(Cancel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(save))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(save)
          .addComponent(Cancel))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    writeConfig();
    restart();
    setVisible(false);
  }//GEN-LAST:event_saveActionPerformed

  private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
    setVisible(false);
  }//GEN-LAST:event_CancelActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new DHCPApp();  //NOTE:Do NOT make it visible (it places icon in tray)
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton Cancel;
  private javax.swing.JTextArea config;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton save;
  // End of variables declaration//GEN-END:variables

  public SystemTray tray;
  public TrayIcon icon;
  public MenuItem exit, show;
  public DHCP service;
}
