
import javaforce.JF;

/**
 * Created : July 24, 2012
 *
 * @author pquiring
 */

public class SoundProps extends javax.swing.JPanel {

  /**
   * Creates new form SoundProps
   */
  public SoundProps(Element element) {
    initComponents();
    db.setValue(element.db);
    audioDelay.setText("" + element.audioDelay);
    mute.setSelected(element.mute);
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
    db = new javax.swing.JSlider();
    jLabel2 = new javax.swing.JLabel();
    audioDelay = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    mute = new javax.swing.JCheckBox();

    jLabel1.setText("Audio Gain (dB):");

    db.setMajorTickSpacing(10);
    db.setMaximum(50);
    db.setMinimum(-50);
    db.setPaintLabels(true);
    db.setPaintTicks(true);
    db.setValue(0);

    jLabel2.setText("Audio Delay");
    jLabel2.setToolTipText("Delay for split second timing");

    audioDelay.setText("0");

    jLabel3.setText("(0-999 ms)");

    mute.setText("Mute");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(db, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(mute)
              .addComponent(jLabel1)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(audioDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(db, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(audioDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(mute)
        .addContainerGap(169, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField audioDelay;
  private javax.swing.JSlider db;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JCheckBox mute;
  // End of variables declaration//GEN-END:variables

  public void save(Element element) {
    element.db = db.getValue();
    element.audioDelay = JF.atoi(audioDelay.getText());
    if (element.audioDelay < 0) element.audioDelay = 0;
    if (element.audioDelay > 999) element.audioDelay = 999;
    element.mute = mute.isSelected();
  }

}
