/**
 *
 * @author pquiring
 */

import java.awt.*;
import java.awt.event.*;

import javaforce.*;
import javaforce.awt.*;

public class GetValue2 extends javax.swing.JDialog {

  /**
   * Creates new form NewDialog
   */
  public GetValue2(java.awt.Frame parent, boolean modal, String title
    , String name1 , int min1, int max1, int value1
    , String name2 , int min2, int max2, int value2
  )
  {
    super(parent, modal);
    initComponents();
    setTitle(title);
    this.name1.setText(name1);
    slider1.setMinimum(min1);
    slider1.setMaximum(max1);
    slider1.setValue(value1);
    this.name2.setText(name2);
    slider2.setMinimum(min2);
    slider2.setMaximum(max2);
    slider2.setValue(value2);
    setPosition();
    JFAWT.assignHotKey(this, ok, KeyEvent.VK_ENTER);
    JFAWT.assignHotKey(this, cancel, KeyEvent.VK_ESCAPE);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    name1 = new javax.swing.JLabel();
    ok = new javax.swing.JButton();
    cancel = new javax.swing.JButton();
    slider1 = new javax.swing.JSlider();
    name2 = new javax.swing.JLabel();
    slider2 = new javax.swing.JSlider();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("New Size");
    setResizable(false);

    name1.setText("v1");

    ok.setText("Ok");
    ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okActionPerformed(evt);
      }
    });

    cancel.setText("Cancel");
    cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelActionPerformed(evt);
      }
    });

    slider1.setMajorTickSpacing(10);
    slider1.setPaintLabels(true);
    slider1.setPaintTicks(true);

    name2.setText("v2");

    slider2.setMajorTickSpacing(10);
    slider2.setPaintLabels(true);
    slider2.setPaintTicks(true);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(name1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(slider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(ok)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cancel)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(slider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(slider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(name1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(slider2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(name2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ok)
          .addComponent(cancel))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
    value1 = slider1.getValue();
    value2 = slider2.getValue();
    setVisible(false);
  }//GEN-LAST:event_okActionPerformed

  private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    value1 = -1;
    value2 = -1;
    setVisible(false);
  }//GEN-LAST:event_cancelActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancel;
  private javax.swing.JLabel name1;
  private javax.swing.JLabel name2;
  private javax.swing.JButton ok;
  private javax.swing.JSlider slider1;
  private javax.swing.JSlider slider2;
  // End of variables declaration//GEN-END:variables

  public int value1, value2;

  private void setPosition() {
    Rectangle s = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    Dimension d = getPreferredSize();
    setLocation(s.width/2 - d.width/2, s.height/2 - (d.height/2));
  }
}
