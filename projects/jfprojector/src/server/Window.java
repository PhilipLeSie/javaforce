package server;

/**
 *
 * @author pquiring
 */

import java.awt.*;

import javaforce.*;
import javaforce.awt.*;

public class Window extends javax.swing.JFrame {

  /**
   * Creates new form Window
   */
  public Window() {
    initComponents();
    setVisible(true);
    setFullScreen();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setUndecorated(true);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables

  private JFImage img, new_img;
  private volatile boolean needPainting = true;
  private Object lock = new Object();

  public void setImage(JFImage src) {
    new_img = src;
    synchronized(lock) {
      if (needPainting) {
        JFLog.log("Warning:Video updating too slow");
      } else {
        needPainting = true;
      }
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          img = new_img;
          repaint();
        } catch (Exception e) {
          JFLog.log(e);
        }
      }
    });
  }

  public void paint(Graphics g) {
    try {
      synchronized(lock) {
        if (!needPainting) {
          JFLog.log("VideoPanel:not painting");
          return;
        }
      }
      int w = getWidth();
      int h = getHeight();
      //paint controls
      if (img == null) {
        JFLog.log("VideoPanel:no image available");
        g.fillRect(0, 0, w, h);
      } else {
        int iw = img.getWidth();
        int ih = img.getHeight();
        if (((iw != w) || (ih != h))) {
//          JFLog.log("VideoPanel:image scaled");
          JFImage scaled = new JFImage();
          scaled.setImageSize(w, h);
          scaled.getGraphics().drawImage(img.getImage(), 0,0, w,h, 0,0, iw,ih, null);
          img = scaled;
        }
        g.drawImage(img.getImage(), 0, 0, null);
      }
      synchronized(lock) {
        needPainting = false;
      }
    } catch (Exception e) {
      JFLog.log(e);
    }
  }

  public void setFullScreen() {
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    gd.setFullScreenWindow(this);
  }
}
