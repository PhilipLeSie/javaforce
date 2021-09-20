/**
 * Created : July 10, 2012
 *
 * @author pquiring
 */

import java.awt.*;
import java.io.*;
import javax.swing.*;

import javaforce.*;
import javaforce.awt.*;
import javaforce.linux.*;

import jffile.*;

public class Desktop extends javax.swing.JWindow {

  /**
   * Creates new form Desktop
   */
  public Desktop() {
    try {
      initComponents();
      setPosition();
      desktop = this;
      showIcons.setSelected(Dock.dock.config.showIcons);
      arrangeAuto.setSelected(Dock.dock.config.arrangeIconsAuto);
      browser = new JFileBrowser(JFileBrowser.VIEW_ICONS, JF.getUserPath() + "/Desktop"
        , DesktopMenu, IconMenu, Dock.dock.config.desktopFile, Dock.dock.config.desktopMode
        , true, "jffile", "jfopen", Dock.dock.config.bc, Dock.dock.config.fc
        , false, true, false, Dock.dock.config.arrangeIconsAuto, Dock.jbusClient, true, Dock.dock);
      setContentPane(browser);
      browser.refresh();
      if (!new File(JF.getUserPath() + "/Desktop/Home.desktop").exists()) {
        browser.createIcon("Home", "jffile " + JF.getUserPath(), "jfdesktop-home", JF.getUserPath() + "/Desktop/Home.desktop", true);
      }
      x11id = Linux.x11_get_id(this);
      JFLog.log("Desktop.window=0x" + Long.toString(x11id, 16));
      try {
        Linux.x11_set_desktop(x11id);
      } catch (Throwable t) {
        JFLog.log(t);
      }
      if (!Dock.dock.config.showIcons) {
        newShortcut.setEnabled(false);
        newFolder.setEnabled(false);
        browser.setIconsVisible(false);
      }
      try {
        Linux.x11_set_desktop(x11id);
      } catch (Throwable t) {
        JFLog.log(t);
      }
      JFLog.log("Desktop init complete");
    } catch (Exception e) {
      JFLog.log(e);
    }
    ready = true;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    IconMenu = new javax.swing.JPopupMenu();
    open = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    delete = new javax.swing.JMenuItem();
    jSeparator2 = new javax.swing.JPopupMenu.Separator();
    props = new javax.swing.JMenuItem();
    DesktopMenu = new javax.swing.JPopupMenu();
    arrange = new javax.swing.JMenu();
    arrangeByName = new javax.swing.JMenuItem();
    arrangeAuto = new javax.swing.JCheckBoxMenuItem();
    showIcons = new javax.swing.JCheckBoxMenuItem();
    newMenu = new javax.swing.JMenu();
    newShortcut = new javax.swing.JMenuItem();
    newFolder = new javax.swing.JMenuItem();
    desktopResolution = new javax.swing.JMenuItem();
    desktopProps = new javax.swing.JMenuItem();

    open.setText("Open");
    open.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        openActionPerformed(evt);
      }
    });
    IconMenu.add(open);
    IconMenu.add(jSeparator1);

    delete.setText("Delete");
    delete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteActionPerformed(evt);
      }
    });
    IconMenu.add(delete);
    IconMenu.add(jSeparator2);

    props.setText("Properties");
    props.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        propsActionPerformed(evt);
      }
    });
    IconMenu.add(props);

    arrange.setText("Arrange...");

    arrangeByName.setText("By Name");
    arrangeByName.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        arrangeByNameActionPerformed(evt);
      }
    });
    arrange.add(arrangeByName);

    arrangeAuto.setSelected(true);
    arrangeAuto.setText("Auto");
    arrangeAuto.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        arrangeAutoActionPerformed(evt);
      }
    });
    arrange.add(arrangeAuto);

    showIcons.setSelected(true);
    showIcons.setText("Show Icons");
    showIcons.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        showIconsActionPerformed(evt);
      }
    });
    arrange.add(showIcons);

    DesktopMenu.add(arrange);

    newMenu.setText("New...");

    newShortcut.setText("Shortcut");
    newShortcut.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        newShortcutActionPerformed(evt);
      }
    });
    newMenu.add(newShortcut);

    newFolder.setText("Folder");
    newFolder.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        newFolderActionPerformed(evt);
      }
    });
    newMenu.add(newFolder);

    DesktopMenu.add(newMenu);

    desktopResolution.setText("Resolution");
    desktopResolution.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        desktopResolutionActionPerformed(evt);
      }
    });
    DesktopMenu.add(desktopResolution);

    desktopProps.setText("Properties");
    desktopProps.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        desktopPropsActionPerformed(evt);
      }
    });
    DesktopMenu.add(desktopProps);

    setIconImage(null);
    setName("desktop"); // NOI18N
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });

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

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    try {
      x11_set_desktop();
    } catch (Throwable t) {
      JFLog.log(t);
    }
  }//GEN-LAST:event_formMouseClicked

  private void propsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propsActionPerformed
    JMenuItem mi = (JMenuItem)evt.getSource();
    JPopupMenu pm = (JPopupMenu)mi.getParent();
    JFileIcon button = (JFileIcon)pm.getInvoker();
    FileEntry entry = button.entry;
    JFileProperties dialog = new JFileProperties(entry, false);
    dialog.setVisible(true);
  }//GEN-LAST:event_propsActionPerformed

  private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
    try {
      JMenuItem mi = (JMenuItem)evt.getSource();
      JPopupMenu pm = (JPopupMenu)mi.getParent();
      browser.invoke((JFileIcon)pm.getInvoker());
    } catch (Exception e) {
      JFLog.log(e);
    }
  }//GEN-LAST:event_openActionPerformed

  private void desktopPropsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desktopPropsActionPerformed
    Dock.dock.showConfig();
  }//GEN-LAST:event_desktopPropsActionPerformed

  private void newShortcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newShortcutActionPerformed
    int i = 0;
    String name;
    String fn;
    do {
      name = "New Shortcut" + (i == 0 ? "" : " (" + i + ")");
      fn = JF.getUserPath() + "/Desktop/" + name + ".desktop";
      i++;
    } while (new File(fn).exists());
    try {
      FileEntry entry = browser.createIcon(name, "", "jffile-file", fn, false);
      JFileProperties dialog = new JFileProperties(entry, true);
      dialog.setVisible(true);
    } catch (Exception e) {
      JFLog.log(e);
    }
  }//GEN-LAST:event_newShortcutActionPerformed

  private void newFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFolderActionPerformed
    try {
      String fn = JFAWT.getString("Enter Folder Name", "");
      if (fn == null) return;
      String full = JF.getUserPath() + "/Desktop/" + fn;
      new File(full).mkdir();
    } catch (Exception e) {
      JFLog.log(e);
    }
  }//GEN-LAST:event_newFolderActionPerformed

  private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
    if (!JFAWT.showConfirm("Confirm", "Delete?")) return;
    try {
      JMenuItem mi = (JMenuItem)evt.getSource();
      JPopupMenu pm = (JPopupMenu)mi.getParent();
      JFileIcon button = (JFileIcon)pm.getInvoker();
      FileEntry entry = button.entry;
      browser.deleteFile(entry.file);
    } catch (Exception e) {
      JFLog.log(e);
    }
  }//GEN-LAST:event_deleteActionPerformed

  private void arrangeByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrangeByNameActionPerformed
    browser.arrangeByName();
  }//GEN-LAST:event_arrangeByNameActionPerformed

  private void arrangeAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrangeAutoActionPerformed
    if (!ready) return;
    Dock.dock.config.arrangeIconsAuto = arrangeAuto.isSelected();
    Dock.dock.saveConfig();
    if (Dock.dock.config.arrangeIconsAuto) browser.arrangeByGrid();
    browser.setAutoArrange(Dock.dock.config.arrangeIconsAuto);
  }//GEN-LAST:event_arrangeAutoActionPerformed

  private void showIconsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showIconsActionPerformed
    if (!ready) return;
    boolean state = showIcons.isSelected();
    if (state) {
      newShortcut.setEnabled(true);
      newFolder.setEnabled(true);
    } else {
      newShortcut.setEnabled(false);
      newFolder.setEnabled(false);
    }
    Dock.dock.config.showIcons = state;
    Dock.dock.saveConfig();
    browser.setIconsVisible(showIcons.isSelected());
  }//GEN-LAST:event_showIconsActionPerformed

  private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    //layout will be complete - safe to let file browser start
    try {
      browser.refresh();
      if (Dock.dock.config.arrangeIconsAuto) browser.arrangeByGrid();
    } catch (Exception e) {
      JFLog.log(e);
    }
  }//GEN-LAST:event_formComponentShown

  private void desktopResolutionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desktopResolutionActionPerformed
    try {
      Runtime.getRuntime().exec(new String[] {"jfconfig", "display"});
    } catch (Exception e) {
      JFLog.log(e);
    }
  }//GEN-LAST:event_desktopResolutionActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPopupMenu DesktopMenu;
  private javax.swing.JPopupMenu IconMenu;
  private javax.swing.JMenu arrange;
  private javax.swing.JCheckBoxMenuItem arrangeAuto;
  private javax.swing.JMenuItem arrangeByName;
  private javax.swing.JMenuItem delete;
  private javax.swing.JMenuItem desktopProps;
  private javax.swing.JMenuItem desktopResolution;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JPopupMenu.Separator jSeparator2;
  private javax.swing.JMenuItem newFolder;
  private javax.swing.JMenu newMenu;
  private javax.swing.JMenuItem newShortcut;
  private javax.swing.JMenuItem open;
  private javax.swing.JMenuItem props;
  private javax.swing.JCheckBoxMenuItem showIcons;
  // End of variables declaration//GEN-END:variables

  public static Desktop desktop;
  public JFileBrowser browser;
  public JFImage wallPaper;
  public long x11id;
  private int sx, sy;  //screen size
  private int mx, my;  //mouse x/y on screen
  private boolean ready = false;

  public void setPosition() {
    Rectangle s = JFAWT.getMaximumBounds();
    sx = s.width;
    sy = s.height;
    setLocation(0, 0);
    setSize(sx, sy);
    revalidate();
    repaint();
  }

  public void x11_set_desktop() {
     try {
       Linux.x11_set_desktop(x11id);
     } catch (Throwable t) {
        JFLog.log(t);
     }
  }
}
