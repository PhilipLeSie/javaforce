package jffile;


import java.awt.Color;

/**
 * Created : May 1, 2012
 *
 * @author pquiring
 */

public class SearchWindow extends javax.swing.JWindow {

  /**
   * Creates new form Search
   */
  public SearchWindow(java.awt.Frame parent) {
    super(parent);
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    search = new javax.swing.JTextField();

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField search;
  // End of variables declaration//GEN-END:variables

  public void setText(String txt) {
    search.setText(txt);
  }

  public void setColor(Color clr) {
    search.setBackground(clr);
  }

}
