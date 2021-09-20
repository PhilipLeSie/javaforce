package jffile;

/**
 * Created : Apr 25, 2012
 *
 * @author pquiring
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.*;

import javaforce.*;
import javaforce.awt.*;

public class ShareDialog extends javax.swing.JDialog {

  /**
   * Creates new form ShareDialog
   */
  public ShareDialog(java.awt.Frame parent, boolean modal, File file, String orgShareName) {
    super(parent, modal);
    initComponents();
    setPosition();
    folderName.setText(file.getAbsolutePath());
    this.orgShareName = orgShareName;
    if (orgShareName == null) {
      shareName.setText(file.getName());
    } else {
      shareName.setText(orgShareName);
      shareName.setEditable(false);
      enable.setSelected(true);
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

    accept = new javax.swing.JButton();
    cancel = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    folderName = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    shareName = new javax.swing.JTextField();
    enable = new javax.swing.JCheckBox();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Share Folder");
    setResizable(false);

    accept.setText("Accept");
    accept.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        acceptActionPerformed(evt);
      }
    });

    cancel.setText("Cancel");
    cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelActionPerformed(evt);
      }
    });

    jLabel1.setText("Folder:");

    folderName.setEditable(false);

    jLabel2.setText("Share Name:");

    enable.setText("Share this folder");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(enable)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 342, Short.MAX_VALUE)
            .addComponent(cancel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(accept))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(folderName))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(shareName)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(enable)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(folderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(shareName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(accept)
          .addComponent(cancel))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    dispose();
  }//GEN-LAST:event_cancelActionPerformed

  private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
    if (shareName.getText().length() < 3) return;
    if (enable.isSelected()) {
      //add share
      if (orgShareName == null) {
        ShellProcess sp = new ShellProcess();
        String output = sp.run(new String[] {"net", "usershare", "add", shareName.getText(), folderName.getText()}, true);
        if (sp.getErrorLevel() != 0) {
          int idx = output.indexOf("NetShare");
          if (idx == -1) idx = 0;
          JFAWT.showError("Error", output.substring(idx));
          return;
        }
        NetworkShares.addShare(shareName.getText(), folderName.getText());
      }
    } else {
      //delete share
      if (orgShareName != null) {
        ShellProcess sp = new ShellProcess();
        String output = sp.run(new String[] {"net", "usershare", "delete", shareName.getText()}, true);
        if (output.indexOf("failed") != -1) {
          int idx = output.indexOf("NetShare");
          if (idx == -1) idx = 0;
          JFAWT.showError("Error", output.substring(idx));
          return;
        }
        NetworkShares.delShare(shareName.getText());
      }
    }
    dispose();
  }//GEN-LAST:event_acceptActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton accept;
  private javax.swing.JButton cancel;
  private javax.swing.JCheckBox enable;
  private javax.swing.JTextField folderName;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JTextField shareName;
  // End of variables declaration//GEN-END:variables

  private String orgShareName;

  private void setPosition() {
    Rectangle s = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    Dimension d = getPreferredSize();
    setLocation(s.width/2 - d.width/2, s.height/2 - (d.height/2));
  }
}
