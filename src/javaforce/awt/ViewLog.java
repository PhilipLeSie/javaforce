package javaforce.awt;

/** View Log File
 *
 * @author pquiring
 */

import java.io.*;

import javaforce.*;

public class ViewLog extends javax.swing.JFrame {

  /**
   * Creates new form ViewLog
   */
  public ViewLog(String file) {
    initComponents();
    JFAWT.centerWindow(this);
    try {
      FileInputStream fis = new FileInputStream(file);
      byte[] txt = JF.readAll(fis);
      load(txt);
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public ViewLog(InputStream is) {
    initComponents();
    load(JF.readAll(is));
  }

  public ViewLog(byte[] txt) {
    initComponents();
    load(txt);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    close = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    txt = new javax.swing.JTextArea();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    close.setText("Close");
    close.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        closeActionPerformed(evt);
      }
    });

    txt.setEditable(false);
    txt.setColumns(20);
    txt.setRows(5);
    jScrollPane1.setViewportView(txt);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(close))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(close)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
    isClosed = true;
    dispose();
  }//GEN-LAST:event_closeActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    isClosed = true;
  }//GEN-LAST:event_formWindowClosing

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    final String file = args[0];
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ViewLog(file).setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton close;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea txt;
  // End of variables declaration//GEN-END:variables

  private void load(byte[] data) {
    txt.setText(new String(data));
  }

  public boolean isClosed = false;
}
