/**
 * Created : Mar 23, 2012
 *
 * @author pquiring
 */

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

import javaforce.*;
import javaforce.awt.*;

public class ProjectDialog extends javax.swing.JDialog {

  /**
   * Creates new form ProjectDialog
   */
  public ProjectDialog(java.awt.Frame parent, boolean modal, Type type, String loadFilename) {
    super(parent, modal);
    initComponents();
    setPosition();
    if (loadFilename != null) {
      loadProject(loadFilename);
      xmlFiles = xml.getTag(new String[] {"jfburn", "files"});
      xmlOptions = xml.getTag(new String[] {"jfburn", "options"});
      XML.XMLTag typeTag = xml.getTag(new String[] {"jfburn", "options", "type"});
      XML.XMLTag nameTag = xml.getTag(new String[] {"jfburn", "options", "name"});
      if ((xmlFiles == null) || (xmlOptions == null) || (typeTag == null)) {
        JFAWT.showError("Error", "Invalid Project File");
        dispose();
        return;
      }
      xmlFiles.content = nameTag.content;
      if (typeTag.content.equals("audio")) type = Type.audio;
      if (typeTag.content.equals("data")) type = Type.data;
      if (typeTag.content.equals("video")) type = Type.video;
      if (type == Type.unknown) {
        JFAWT.showError("Error", "Invalid Project File");
        dispose();
        return;
      }
    } else {
      xml.root.setName("jfburn");
      xmlFiles = xml.addTag(xml.root, "files", "", "New Disc");  //NOTE : This is not a leaf node so the content is lost on save
      xmlOptions = xml.addTag(xml.root, "options", "", "");
      xml.addTag(xmlOptions, "type", "", type.toString());
      xml.addTag(xmlOptions, "name", "", "New Disc");  //backup of xmlFiles content for saving to disk
    }
    this.type = type;
    if (type == Type.audio) {
      toolbar.remove(createFolder);
    }
    xml.setRoot(xmlFiles);
    xml.setUseContentForName(true);
    showAll();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        files = new javax.swing.JTree();
        toolbar = new javax.swing.JToolBar();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        rename = new javax.swing.JButton();
        createFolder = new javax.swing.JButton();
        burn = new javax.swing.JButton();
        createImage = new javax.swing.JButton();
        save = new javax.swing.JButton();
        options = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Project");

        files.setModel(xml.getTreeModel());
        jScrollPane1.setViewportView(files);

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        add.setText("Add Files/Folders");
        add.setFocusable(false);
        add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        toolbar.add(add);

        remove.setText("Remove");
        remove.setFocusable(false);
        remove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        remove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        toolbar.add(remove);

        rename.setText("Rename");
        rename.setFocusable(false);
        rename.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rename.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameActionPerformed(evt);
            }
        });
        toolbar.add(rename);

        createFolder.setText("Create Folder");
        createFolder.setFocusable(false);
        createFolder.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createFolder.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFolderActionPerformed(evt);
            }
        });
        toolbar.add(createFolder);

        burn.setText("Burn Disc");
        burn.setFocusable(false);
        burn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        burn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        burn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                burnActionPerformed(evt);
            }
        });
        toolbar.add(burn);

        createImage.setText("Create Image");
        createImage.setFocusable(false);
        createImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createImage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createImageActionPerformed(evt);
            }
        });
        toolbar.add(createImage);

        save.setText("Save");
        save.setFocusable(false);
        save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        toolbar.add(save);

        options.setText("Options");
        options.setFocusable(false);
        options.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        options.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsActionPerformed(evt);
            }
        });
        toolbar.add(options);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
    addFiles();
  }//GEN-LAST:event_addActionPerformed

  private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
    removeFiles();
  }//GEN-LAST:event_removeActionPerformed

  private void createFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFolderActionPerformed
    createFolder();
  }//GEN-LAST:event_createFolderActionPerformed

  private void burnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_burnActionPerformed
    burnDisc();
  }//GEN-LAST:event_burnActionPerformed

  private void createImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createImageActionPerformed
    createImage();
  }//GEN-LAST:event_createImageActionPerformed

  private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    saveProject();
  }//GEN-LAST:event_saveActionPerformed

  private void optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsActionPerformed
    JDialog dialog = new OptionsDialog(BurnApp.This, true, xml, xmlOptions);
    dialog.setVisible(true);
  }//GEN-LAST:event_optionsActionPerformed

  private void renameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameActionPerformed
    rename();
  }//GEN-LAST:event_renameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton burn;
    private javax.swing.JButton createFolder;
    private javax.swing.JButton createImage;
    private javax.swing.JTree files;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton options;
    private javax.swing.JButton remove;
    private javax.swing.JButton rename;
    private javax.swing.JButton save;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

  public enum Type {unknown, audio, data, video};
  private XML xml = new XML();
  private XML.XMLTag xmlFiles, xmlOptions;
  private Type type;

  private String getName(String fullPath) {
    int idx = fullPath.lastIndexOf("/");
    if (idx == -1) return fullPath;
    return fullPath.substring(idx+1);
  }

  private void addFolder(XML.XMLTag parent, File folder) {
    File files[] = folder.listFiles();
    String folderPath = folder.getAbsolutePath();
    XML.XMLTag child = xml.addTag(parent, getName(folderPath), "", folderPath);
    for(int a=0;a<files.length;a++) {
      if (files[a].isDirectory()) {
        addFolder(child, files[a]);
      } else {
        String filePath = files[a].getAbsolutePath();
        xml.addTag(child, getName(filePath), "", filePath);
      }
    }
  }

  private void addFiles() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    chooser.setMultiSelectionEnabled(false);
    chooser.setCurrentDirectory(new File(JF.getCurrentPath()));
    if (type == Type.audio) {
      javax.swing.filechooser.FileFilter ff_wav = new javax.swing.filechooser.FileFilter() {
        public boolean accept(File file) {
        if (file.isDirectory()) return true;
          return (file.getName().endsWith(".wav"));
        }
        public String getDescription() {
          return "Audio Files (*.wav)";
        }
      };
      chooser.addChoosableFileFilter(ff_wav);
      chooser.setFileFilter(ff_wav);
    }
    if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
    String filename = chooser.getSelectedFile().getAbsolutePath();
    File file = new File(filename);
    if (file.isDirectory()) {
      addFolder(xmlFiles, file);
    } else {
      xml.addTag(xmlFiles, getName(filename), "", filename);
    }
    showAll();
    files.repaint();
  }

  private void removeFiles() {
    if (files.getSelectionCount() != 1) return;
    TreePath path = files.getSelectionPath();
    XML.XMLTag tag = xml.getTag(path);
    if (tag == xmlFiles) return;
    xml.deleteTag(tag);
  }

  private void createFolder() {
    TreePath sel = files.getSelectionPath();
    if (sel == null) return;
    String name = JFAWT.getString("Enter folder name", "");
    if ((name == null) || (name.length() == 0)) return;
    XML.XMLTag tag = xml.getTag(sel);
    xml.addTag(tag, name, "", name);
  }

  private void rename() {
    TreePath sel = files.getSelectionPath();
    if (sel == null) return;
    XML.XMLTag tag = xml.getTag(sel);
    String newName = JFAWT.getString("Enter new name", tag.getName());
    if (newName == null) return;
    if (tag == xmlFiles) {
      tag.content = newName;
      xml.addSetTag(xmlOptions, "name", "", newName);
    } else {
      tag.setName(newName);
    }
    files.repaint();
  }

  private void burnDisc() {
    switch (type){
      case audio: burnAudioDisc(); return;
      case video: //TODO - same as Data for now
      case data: burnDataDisc(); return;
    }
  }

  private void burnDataDisc() {
    File tmpImage;
    try {
      tmpImage = File.createTempFile("jfburn-image", ".iso");
      if (!saveImage(tmpImage.getAbsolutePath(), true)) return;
    } catch (Exception e) {
      JFAWT.showError("Error", "Exception:" + e);
      return;
    }
    this.setVisible(false);
    JDialog dialog = new BurnDialog(BurnApp.This, true, new String[] {tmpImage.getAbsolutePath()});
    dialog.setVisible(true);
    this.setVisible(true);
  }

  private void burnAudioDisc() {
    ArrayList<String> tracks = new ArrayList<String>();
    XML.XMLTag tag;
    int cnt = xmlFiles.getChildCount();
    for(int a=0;a<cnt;a++) {
      tracks.add(xmlFiles.getChildAt(a).content);
    }
    this.setVisible(false);
    JDialog dialog = new BurnDialog(BurnApp.This, true, tracks.toArray(new String[0]));
    dialog.setVisible(true);
    this.setVisible(true);
  }

  private void burnVideoDisc() {
    //TODO - create DVD files ???
    File tmpImage;
    try {
      tmpImage = File.createTempFile("jfburn-image", ".iso");
      saveImage(tmpImage.getAbsolutePath(), true);
    } catch (Exception e) {
      JFAWT.showError("Error", "Exception:" + e);
      return;
    }
    this.setVisible(false);
    JDialog dialog = new BurnDialog(BurnApp.This, true, new String[] {tmpImage.getAbsolutePath()});
    dialog.setVisible(true);
    this.setVisible(true);
  }

  private void createImage() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    chooser.setMultiSelectionEnabled(false);
    chooser.setCurrentDirectory(new File(JF.getCurrentPath()));
    javax.swing.filechooser.FileFilter ff_iso = new javax.swing.filechooser.FileFilter() {
      public boolean accept(File file) {
        if (file.isDirectory()) return true;
        return (file.getName().endsWith(".iso"));
      }
      public String getDescription() {
        return "ISO Files (*.iso)";
      }
    };
    chooser.addChoosableFileFilter(ff_iso);
    chooser.setFileFilter(ff_iso);
    if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
    String filename = chooser.getSelectedFile().getAbsolutePath();
    saveImage(filename, false);
  }

  private String escapeName(String name) {
    return name.replaceAll("[\\\\]", "\\\\").replaceAll("[=]", "\\=");
  }

  private String getTagName(XML.XMLTag tag) {
    StringBuilder sb = new StringBuilder();
    sb.append(tag.getName());
    while ((tag = tag.getParent()) != xmlFiles) {
      sb.insert(0, "/");
      sb.insert(0, tag.getName());
    }
    sb.insert(0, "/");
    return escapeName(sb.toString());
  }

  private void writeTag(XML.XMLTag tag, OutputStream ios) throws Exception {
    int cnt = tag.getChildCount();
    if (cnt > 0) {
      for(int a=0;a<cnt;a++) {
        writeTag(tag.getChildAt(a), ios);
      }
    } else {
      ios.write((getTagName(tag) + "=" + escapeName(tag.content) + "\n").getBytes());
    }
  }

  private boolean saveImage(String filename, boolean auto) {
    //mkisofs -path-list tmpFile -o filename <options>
    try {
      File tmpFile = File.createTempFile("jfburn-list-i", ".lst");
      FileOutputStream fos = new FileOutputStream(tmpFile);
      writeTag(xmlFiles, fos);
      fos.close();
      String cmd[] = {"mkisofs"
        , "-graft-points"
        , "-path-list", tmpFile.getAbsolutePath()
        , "-o", filename
        , "-udf", "-J", "-r"
        , "-V", xmlFiles.content};
      if (type == Type.video) {
        cmd = Arrays.copyOf(cmd, cmd.length+1);
        cmd[cmd.length-1] = "-dvd-video";
      }
      XML.XMLTag tag;
      int bootType;
      String bootFile;
      tag = xml.getTag(new String[] {"jfburn", "options", "boot"});
      if (tag != null) {
        if (tag.content.equals("true")) {
          tag = xml.getTag(new String[] {"jfburn", "options", "bootType"});
          if (tag != null) {
            bootType = JF.atoi(tag.content);
            if ((bootType >= 0) && (bootType <= 3)) {
              tag = xml.getTag(new String[] {"jfburn", "options", "bootFile"});
              if (tag != null) {
                bootFile = tag.content;
                //add boot options
                cmd = Arrays.copyOf(cmd, cmd.length+1);
                cmd[cmd.length-1] = "-b";
                cmd = Arrays.copyOf(cmd, cmd.length+1);
                cmd[cmd.length-1] = bootFile;  //TODO : must be relative to source files???
                cmd = Arrays.copyOf(cmd, cmd.length+1);
                cmd[cmd.length-1] = "-c";
                cmd = Arrays.copyOf(cmd, cmd.length+1);
                cmd[cmd.length-1] = "boot.cat";
                //bootType : 0=floppy 1=hard drive 2=no emul
                if (bootType == 1) {
                  cmd = Arrays.copyOf(cmd, cmd.length+1);
                  cmd[cmd.length-1] = "-hard-disk-boot";
                }
                if (bootType == 2) {
                  cmd = Arrays.copyOf(cmd, cmd.length+1);
                  cmd[cmd.length-1] = "-no-emul-boot";
                }
              }
            }
          }
        }
      }

      JFTask task = new JFTask() {
        ShellProcess sp;
        public boolean work() {
          String cmd[] = (String[])this.getProperty("cmd");
          boolean auto = (Boolean)this.getProperty("auto");
          this.setProgress(-1);
          setLabel("Building ISO image...");
          sp = new ShellProcess();
          String output = sp.run(cmd, false);
          this.setProgress(100);
          if (abort)
            setLabel("Building ISO image aborted!");
          else
            setLabel("Building ISO image complete!");
          if (auto) this.dispose();
          return !abort;
        }
        public void abort() {
          sp.destroy();
          abort = true;
        }
      };
      task.setProperty("cmd", cmd);
      task.setProperty("auto", (Boolean)auto);

      ProgressDialog dialog = new ProgressDialog(null, true, task);
      dialog.setVisible(true);

      tmpFile.delete();
      return task.getStatus();
    } catch (Exception e) {
      JFAWT.showError("Error", "Exception:" + e);
      return false;
    }
  }

  private void saveProject() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    chooser.setMultiSelectionEnabled(false);
    File path = new File(JF.getUserPath() + "/jfburn");
    path.mkdirs();
    chooser.setCurrentDirectory(path);
    javax.swing.filechooser.FileFilter ff_xml = new javax.swing.filechooser.FileFilter() {
      public boolean accept(File file) {
        if (file.isDirectory()) return true;
        return (file.getName().endsWith(".burn"));
      }
      public String getDescription() {
        return "Project Files (*.burn)";
      }
    };
    chooser.addChoosableFileFilter(ff_xml);
    chooser.setFileFilter(ff_xml);
    if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
    String filename = chooser.getSelectedFile().getAbsolutePath();
    if (!filename.endsWith(".burn")) filename += ".burn";
    try {
      FileOutputStream fos = new FileOutputStream(filename);
      xml.write(fos);
      fos.close();
    } catch (Exception e) {
      JFAWT.showError("Error", "Failed to save project");
    }
  }

  private void loadProject(String filename) {
    try {
      FileInputStream fis = new FileInputStream(filename);
      xml.read(fis);
      fis.close();
    } catch (Exception e) {
      JFAWT.showError("Error", "Failed to load project");
    }
  }

  private void showAll(XML.XMLTag tag) {
    files.makeVisible(new TreePath(tag.getPath()));
    int cnt = tag.getChildCount();
    for(int a=0;a<cnt;a++) {
      showAll(tag.getChildAt(a));
    }
  }

  private void showAll() {
    showAll(xmlFiles);
  }

  private void setPosition() {
    Rectangle s = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    Dimension d = getPreferredSize();
    setLocation(s.width/2 - d.width/2, s.height/2 - (d.height/2));
  }
}
