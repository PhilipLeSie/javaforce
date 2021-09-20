/**
 * Created : July 24, 2012
 *
 * @author pquiring
 */

import javaforce.awt.*;

public class ImageProps extends javax.swing.JPanel {

  /**
   * Creates new form ImageProps
   */
  public ImageProps(Element element) {
    initComponents();
    alphaFadeIn.setSelected(element.alphaFadeIn);
    alphaFadeInDuration.setValue(new Integer(element.alphaFadeInDuration));
    alphaLevel.setValue(255 - element.alphaLevel);
    int lvl = 128;
    if ((element.clrAlpha & 0xff0000) > 0) {
      transparentClr.setSelectedIndex(1);
      lvl = (element.clrAlpha & 0xff0000) >> 16;
    }
    if ((element.clrAlpha & 0xff00) > 0) {
      transparentClr.setSelectedIndex(2);
      lvl = (element.clrAlpha & 0xff00) >> 8;
    }
    if ((element.clrAlpha & 0xff) > 0) {
      transparentClr.setSelectedIndex(3);
      lvl = (element.clrAlpha & 0xff);
    }
    clrThreshold.setValue(lvl);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    alphaFadeIn = new javax.swing.JCheckBox();
    jLabel1 = new javax.swing.JLabel();
    alphaLevel = new javax.swing.JSlider();
    alphaFadeInDuration = new javax.swing.JSpinner();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    transparentClr = new javax.swing.JComboBox();
    clrThreshold = new javax.swing.JSlider();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();

    alphaFadeIn.setText("Transparent Fade In");

    jLabel1.setText("Transparency (None <-> Full)");

    alphaLevel.setMaximum(255);
    alphaLevel.setValue(0);

    alphaFadeInDuration.setModel(new javax.swing.SpinnerNumberModel(5, 1, 60, 1));

    jLabel2.setText("Seconds");

    jLabel3.setText("Transparent Color");

    transparentClr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Red", "Green", "Blue" }));

    clrThreshold.setMaximum(255);
    clrThreshold.setValue(0);

    jLabel4.setText("Threshold (Any <-> Exact)");

    jLabel5.setText("An ideal threshold is around 25% to 75%");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(alphaFadeIn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(alphaFadeInDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(alphaLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(transparentClr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel5)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clrThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(41, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(alphaFadeIn)
          .addComponent(alphaFadeInDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1)
          .addComponent(alphaLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(transparentClr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(clrThreshold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel5)
        .addContainerGap(120, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox alphaFadeIn;
  private javax.swing.JSpinner alphaFadeInDuration;
  private javax.swing.JSlider alphaLevel;
  private javax.swing.JSlider clrThreshold;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JComboBox transparentClr;
  // End of variables declaration//GEN-END:variables

  public void save(Element element) {
    element.alphaFadeIn = alphaFadeIn.isSelected();
    element.alphaFadeInDuration = (Integer)alphaFadeInDuration.getValue();
    element.alphaLevel = 255 - alphaLevel.getValue();
    int idx = transparentClr.getSelectedIndex();
    int lvl = clrThreshold.getValue();
    switch (idx) {
      case 0: element.clrAlpha = 0; break;
      case 1: element.clrAlpha = lvl << 16; break;
      case 2: element.clrAlpha = lvl << 8; break;
      case 3: element.clrAlpha = lvl; break;
    }
  }
}
