/**
 * Text Properties
 *
 * @author pquiring
 *
 * Created : Jul 14, 2014
 */

import java.awt.*;

import javaforce.*;
import javaforce.awt.*;

public class TextProps extends javax.swing.JPanel {

  /**
   * Creates new form TextProps
   */
  public TextProps(Element e) {
    initComponents();
    String f[] = e.fx.split(",", 6);
    if (f[0].equals("left")) {
      halign.setSelectedIndex(0);
    } else if (f[0].equals("right")) {
      halign.setSelectedIndex(2);
    } else {
      halign.setSelectedIndex(1);
    }
    if (f[1].equals("top")) {
      valign.setSelectedIndex(0);
    } else if (f[1].equals("bottom")) {
      valign.setSelectedIndex(2);
    } else {
      valign.setSelectedIndex(1);
    }
    //f[2] = fontFamily
    fontFamily = f[2];
    //f[3] = fontStyle
    fontStyle = JF.atoi(f[3]);
    //f[4] = fontSize
    fontSize = JF.atoi(f[4]);
    //f[5] = text
    text.setText(f[5]);
    text.setFont(new Font(fontFamily, fontStyle, fontSize));
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
    valign = new javax.swing.JComboBox();
    jLabel2 = new javax.swing.JLabel();
    halign = new javax.swing.JComboBox();
    jLabel3 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    text = new javax.swing.JTextArea();
    font = new javax.swing.JButton();

    jLabel1.setText("Vertical Position:");

    valign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Top", "Center", "Bottom" }));

    jLabel2.setText("Horizontal Position:");

    halign.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Left", "Center", "Right" }));

    jLabel3.setText("Text:");

    text.setColumns(20);
    text.setRows(5);
    jScrollPane1.setViewportView(text);

    font.setText("Font...");
    font.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fontActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(valign, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(halign, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(font)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(valign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(halign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(font))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void fontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontActionPerformed
    JFontChooser chooser = new JFontChooser(null);
    chooser.setFont(new Font(fontFamily, fontStyle, fontSize));
    if (chooser.showDialog() != JFontChooser.OK_OPTION) return;
    Font font = chooser.getFont();
    fontFamily = font.getFamily();
    fontStyle = font.getStyle();
    fontSize = font.getSize();
    text.setFont(new Font(fontFamily, fontStyle, fontSize));
  }//GEN-LAST:event_fontActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton font;
  private javax.swing.JComboBox halign;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea text;
  private javax.swing.JComboBox valign;
  // End of variables declaration//GEN-END:variables

  public String fontFamily;
  public int fontStyle, fontSize;

  public void save(Element e) {
    e.fx = "";
    //h align
    switch (halign.getSelectedIndex()) {
      case 0: e.fx += "left,"; break;
      case 1: e.fx += "center,"; break;
      case 2: e.fx += "right,"; break;
    }
    //v align
    switch (valign.getSelectedIndex()) {
      case 0: e.fx += "top,"; break;
      case 1: e.fx += "center,"; break;
      case 2: e.fx += "bottom,"; break;
    }
    //font
    e.fx += fontFamily + "," + fontStyle + "," + fontSize + ",";
    //text
    e.fx += text.getText();
  }
}
