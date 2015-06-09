/*
 * HelpApp.java
 *
 * Created : Apr 12, 2012
 *
 * @author  pquiring
 */

import java.awt.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.html.*;
import java.net.*;
import javaforce.*;
import java.io.*;

public class HelpApp extends javax.swing.JFrame {

  /** Creates new form JWeb */
  public HelpApp() {
    initComponents();
    clear();
    if ((args.length > 0) && (args[0].length() > 0)) {
      gotoURL(args[0]);
    } else {
      homeActionPerformed(null);
    }
    setPosition();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        htmlScroll = new javax.swing.JScrollPane();
        html = new javax.swing.JEditorPane();
        home = new javax.swing.JButton();
        contents = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jHelp");

        html.setContentType("text/html");
        html.setEditable(false);
        html.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                htmlHyperlinkUpdate(evt);
            }
        });
        htmlScroll.setViewportView(html);

        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        contents.setText("Contents");
        contents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contents)
                .addGap(0, 325, Short.MAX_VALUE))
            .addComponent(htmlScroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contents)
                    .addComponent(home))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(htmlScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void contentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentsActionPerformed
//    System.out.println("Contents");
    try {
      StringBuilder sb = new StringBuilder();
      sb.append("<html><body>");
      sb.append("<a href='file:///usr/share/jfhelp/index.html'>Home</a> - Contents<br><br><br>");
      File files[] = new File("/usr/share/jfhelp").listFiles();
      for(int a=0;a<files.length;a++) {
        if (files[a].isDirectory()) continue;
        String name = files[a].getName();
        if (!name.endsWith(".html")) continue;
        if (name.equals("index.html")) continue;
        sb.append("<a href='file://" + files[a].getAbsolutePath() + "'>" + name.substring(0, name.length()-5) + "</a><br>");
      }
      sb.append("</body></html>");
      clear();
//      html.setText(sb.toString());  //seems to reset content type
      html.read(new ByteArrayInputStream(sb.toString().getBytes()), "HTMLDocument");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }//GEN-LAST:event_contentsActionPerformed

  private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
//    System.out.println("Home");
    try {
      clear();
      html.setPage("file:///usr/share/jfhelp/index.html");
    } catch(Exception e) {
      e.printStackTrace();
    }
  }//GEN-LAST:event_homeActionPerformed

  private void htmlHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_htmlHyperlinkUpdate
//    System.out.println("event="+evt);
    if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
      try {
//        System.out.println("url="+evt.getURL().toExternalForm());
        String url = evt.getURL().toExternalForm();
        if (url.equals("file:/usr/share/jfhelp/contents.html")) {
          contentsActionPerformed(null);
        }  else if (url.startsWith("http")) {
          Runtime.getRuntime().exec("x-www-browser " + url);
        } else {
          clear();
          html.setPage(evt.getURL());
        }
        System.out.println(evt.getURL().toExternalForm());
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }//GEN-LAST:event_htmlHyperlinkUpdate

  public static void main(String args[]) {
    HelpApp.args = args;
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new HelpApp().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contents;
    private javax.swing.JButton home;
    private javax.swing.JEditorPane html;
    private javax.swing.JScrollPane htmlScroll;
    // End of variables declaration//GEN-END:variables

  private static String args[];

  private void clear() {
    html.setDocument(new HTMLDocument());
    html.setContentType("text/html");
  }

  private void gotoURL(String page) {
    try {
      clear();
      html.setPage("file:///usr/share/jfhelp/" + page + ".html");
    } catch(Exception e) {
      e.printStackTrace();
    }
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
