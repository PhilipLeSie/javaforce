/**
 *
 * Created : Feb 17, 2012
 *
 * @author pquiring
 */

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.*;

import javaforce.*;
import javaforce.jbus.*;
import javaforce.linux.*;

import jfparted.*;

public class Installer extends javax.swing.JFrame {

  public static String version = "0.5";

  /**
   * Creates new form Installer
   */
  public Installer() {
    initComponents();
    jbusClient = new JBusClient(null, null);
    jbusClient.start();
    jbusClient.call("org.jflinux.jsystemmgr", "stopAutoMounter", "");  //annoying
    loadPanel(new Welcome());
    setPosition();
    JFLog.init("/tmp/install.log", true);
    Linux.detectDistro();
    if (Linux.distro == Linux.DistroTypes.Unknown) {
      JF.showError("Error", "Unsupported Distro, Install can not continue.");
      System.exit(0);
    }
    installer = this;
    ShellProcess.log = true;  //enable logging
    frame = this;
    setTitle("jfinstall/" + version);
    next.grabFocus();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        finish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel.setLayout(new java.awt.GridLayout(1, 0));

        next.setText("Next >");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        prev.setText("< Prev");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        finish.setText("Finish");
        finish.setEnabled(false);
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 391, Short.MAX_VALUE)
                        .addComponent(prev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(next)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finish))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(next)
                    .addComponent(prev)
                    .addComponent(finish))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
    loadPanel(currentPanel.next());
  }//GEN-LAST:event_nextActionPerformed

  private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
    loadPanel(currentPanel.prev());
  }//GEN-LAST:event_prevActionPerformed

  private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
    System.exit(0);
  }//GEN-LAST:event_finishActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    if (disabled) return;
    jbusClient.call("org.jflinux.jsystemmgr", "startAutoMounter", "");
    System.exit(0);
  }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finish;
    private javax.swing.JButton next;
    private javax.swing.JPanel panel;
    private javax.swing.JButton prev;
    // End of variables declaration//GEN-END:variables

  public static IPanel currentPanel;
  public static Installer installer;
  public static JFrame frame;
  private boolean disabled = false;
  private JBusClient jbusClient;

  public void loadPanel(IPanel newPanel) {
    if (newPanel == null) return;
    currentPanel = newPanel;
    panel.removeAll();
    panel.add(currentPanel);
    panel.revalidate();
  }

  public static void disableButtons() {
    installer.next.setEnabled(false);
    installer.prev.setEnabled(false);
    installer.disabled = true;
  }

  public static void enableFinish() {
    installer.finish.setEnabled(true);
  }

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Installer().setVisible(true);
      }
    });
  }

  private void setPosition() {
    Dimension d = getSize();
    Rectangle s = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    if ((d.width > s.width) || (d.height > s.height)) {
      if (d.width > s.width) d.width = s.width;
      if (d.height > s.height) d.height = s.height;
      setSize(d);
    }
    setLocation(s.width/2 - d.width/2, s.height/2 - d.height/2);
  }
}
