/**
 *
 * @author pquiring
 */

import jfparted.*;
import javaforce.*;

public class GuidedPartSelectDevice extends IPanel {

  /**
   * Creates new form GuidedPartSelectDevice
   */
  public GuidedPartSelectDevice() {
    initComponents();
    Data.getDevices();
    for(int a=0;a<Data.devices.size();a++) {
      target.addItem(Data.devices.get(a).dev);
    }
    target.setSelectedIndex(0);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        target = new javax.swing.JComboBox();

        jLabel1.setText("Select Installation Device");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(target, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(target, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox target;
    // End of variables declaration//GEN-END:variables

  public IPanel next() {
    Data.guidedTarget = Data.devices.get(target.getSelectedIndex());
    return new GuidedPartitioning();
  }
  public IPanel prev() {return new TimeZone();}
  public IPanel getThis() {return this;}

}
