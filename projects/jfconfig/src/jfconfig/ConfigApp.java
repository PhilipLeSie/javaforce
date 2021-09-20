package jfconfig;

/**
 * Created : Mar 4, 2012
 *
 * @author pquiring
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

import javaforce.*;
import javaforce.awt.*;
import javaforce.jbus.*;
import javaforce.linux.*;

public class ConfigApp extends javax.swing.JFrame {

  /**
   * Creates new form ConfigApp
   */
  public ConfigApp() {
    initComponents();
    JFLog.init(JF.getUserPath() + "/.jfconfig.log", true);
    This = this;
    if (!JF.isWindows()) {
      jbusClient = new JBusClient("org.jflinux.jfconfig." + new Random().nextInt(0x7fffff), new JBusMethods());
      jbusClient.start();
    }
    JF.initHttps();
    for(int a=0;a<args.length;a++) {
      if (args[a].equals("users")) panel = new UsersPanel();
      else if (args[a].equals("groups")) panel = new GroupsPanel();
      else if (args[a].equals("interfaces")) panel = new InterfacePanel();
      else if (args[a].equals("vpn")) panel = new VPNPanel();
      else if (args[a].equals("firewall")) panel = new FirewallPanel();
      else if (args[a].equals("routing")) panel = new RoutingPanel();
      else if (args[a].equals("servers")) panel = new ServersPanel();
      else if (args[a].equals("display")) panel = new DisplayPanel();
      else if (args[a].equals("sound")) panel = new SoundPanel();
      else if (args[a].equals("datetime")) panel = new DateTimePanel();
      else if (args[a].equals("date")) panel = new DateTimePanel();
      else if (args[a].equals("time")) panel = new DateTimePanel();
      else if (args[a].equals("timezone")) panel = new DateTimePanel();
      else if (args[a].equals("printers")) panel = new PrintersPanel();
      else if (args[a].equals("test")) test = true;
    }
    Linux.detectDistro();
    switch (Linux.distro) {
      case Ubuntu: break;
      case Fedora: break;
      default:
        if (!test) {
          JFAWT.showError("Error", "Unsupported Distro");
          System.exit(0);
        }
    }
    if (panel == null) panel = new MainPanel();
    setContentPane(panel);
    setPosition();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Config");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 607, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 715, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    ConfigApp.args = args;
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ConfigApp().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables

  public static ConfigApp This;
  public static String args[];
  public static JBusClient jbusClient;
  public static JPanel panel;
  public static boolean test = false;

  public static void setPanel(JPanel panel) {
    This.panel = panel;
    This.setContentPane(panel);
    panel.revalidate();
    This.repaint();
  }

  public static class JBusMethods {
    public void videoChanged(String reason) {
      if (!reason.equals("udev")) return;
      if (panel instanceof DisplayPanel) {
        ((DisplayPanel)panel).rescan();
      }
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
