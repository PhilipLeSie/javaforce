package jfconfig;

/**
 * Created : May 5, 2012
 *
 * @author pquiring
 */

import java.io.*;
import javax.swing.*;
import java.util.*;

import javaforce.*;
import javaforce.linux.*;

/*
 * Folders:
 *   ~/.ssl/ca
 *   ~/.ssl/keys
 *
 */

public class OpenSSLPanel extends javax.swing.JPanel {

  /**
   * Creates new form OpenSSLPanel
   */
  public OpenSSLPanel(String folder, String type) {
    initComponents();
    File file1 = new File(JF.getUserPath() + "/.ssl/ca");
    file1.mkdirs();
    File file2 = new File(JF.getUserPath() + "/.ssl/keys");
    file2.mkdirs();
    if ((folder == null) || (type == null)) {
      apply.setVisible(false);
    } else {
      serverFolder = folder;
      serverType = type;
    }
    cfgFolder = JF.getUserPath() + "/.ssl";
    caFolder = JF.getUserPath() + "/.ssl/ca";
    keysFolder = JF.getUserPath() + "/.ssl/keys";
    listCAs();
    listKeys();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    caStatus = new javax.swing.JTextField();
    caGenerate = new javax.swing.JButton();
    caImport = new javax.swing.JButton();
    ca = new javax.swing.JComboBox();
    jPanel2 = new javax.swing.JPanel();
    key = new javax.swing.JComboBox();
    keyStatus = new javax.swing.JTextField();
    keyGenerate = new javax.swing.JButton();
    keyImport = new javax.swing.JToggleButton();
    exportCertRequest = new javax.swing.JButton();
    help = new javax.swing.JButton();
    selfSign = new javax.swing.JButton();
    apply = new javax.swing.JButton();
    load_nss = new javax.swing.JButton();

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Certificate Authority"));

    caStatus.setEditable(false);

    caGenerate.setText("Generate");
    caGenerate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        caGenerateActionPerformed(evt);
      }
    });

    caImport.setText("Import");
    caImport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        caImportActionPerformed(evt);
      }
    });

    ca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    ca.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        caItemStateChanged(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(caGenerate)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(caImport)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(ca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(caStatus, javax.swing.GroupLayout.Alignment.TRAILING))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addComponent(ca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(caStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(caGenerate)
          .addComponent(caImport))
        .addContainerGap())
    );

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Keys"));

    key.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    key.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        keyItemStateChanged(evt);
      }
    });

    keyStatus.setEditable(false);

    keyGenerate.setText("Generate");
    keyGenerate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        keyGenerateActionPerformed(evt);
      }
    });

    keyImport.setText("Import Signed Request");
    keyImport.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        keyImportActionPerformed(evt);
      }
    });

    exportCertRequest.setText("Export Cert Request");
    exportCertRequest.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        exportCertRequestActionPerformed(evt);
      }
    });

    help.setText("Help");
    help.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        helpActionPerformed(evt);
      }
    });

    selfSign.setText("Self Sign");
    selfSign.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        selfSignActionPerformed(evt);
      }
    });

    apply.setText("Apply to Server");
    apply.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        applyActionPerformed(evt);
      }
    });

    load_nss.setText("Load into Local NSS System");
    load_nss.setToolTipText("Used by Google Chrome");
    load_nss.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        load_nssActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(key, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(keyStatus)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(apply)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(help))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(keyGenerate)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                  .addComponent(selfSign)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(load_nss))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                  .addComponent(exportCertRequest)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(keyImport))))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(keyStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(keyGenerate)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(exportCertRequest)
          .addComponent(keyImport))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(selfSign)
          .addComponent(load_nss))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(help)
          .addComponent(apply))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(26, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void caGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caGenerateActionPerformed
    caGenerate();
  }//GEN-LAST:event_caGenerateActionPerformed

  private void caImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caImportActionPerformed
    caImport();
  }//GEN-LAST:event_caImportActionPerformed

  private void keyGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyGenerateActionPerformed
    keyGenerate();
  }//GEN-LAST:event_keyGenerateActionPerformed

  private void caItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_caItemStateChanged
    status();
  }//GEN-LAST:event_caItemStateChanged

  private void exportCertRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportCertRequestActionPerformed
    exportCSR();
  }//GEN-LAST:event_exportCertRequestActionPerformed

  private void keyImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyImportActionPerformed
    importKey();
  }//GEN-LAST:event_keyImportActionPerformed

  private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
    try {
      Runtime.getRuntime().exec(new String[] {"jhelp", "jopenssl"});
    } catch (Exception e) {
      JFLog.log(e);
    }
  }//GEN-LAST:event_helpActionPerformed

  private void keyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_keyItemStateChanged
    status();
  }//GEN-LAST:event_keyItemStateChanged

  private void selfSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selfSignActionPerformed
    selfSign();
  }//GEN-LAST:event_selfSignActionPerformed

  private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
    apply();
  }//GEN-LAST:event_applyActionPerformed

  private void load_nssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_load_nssActionPerformed
    load_nss();
  }//GEN-LAST:event_load_nssActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton apply;
  private javax.swing.JComboBox ca;
  private javax.swing.JButton caGenerate;
  private javax.swing.JButton caImport;
  private javax.swing.JTextField caStatus;
  private javax.swing.JButton exportCertRequest;
  private javax.swing.JButton help;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JComboBox key;
  private javax.swing.JButton keyGenerate;
  private javax.swing.JToggleButton keyImport;
  private javax.swing.JTextField keyStatus;
  private javax.swing.JButton load_nss;
  private javax.swing.JButton selfSign;
  // End of variables declaration//GEN-END:variables

  private String caFolder, keysFolder, cfgFolder, serverFolder, serverType;

  public static class Config {
    //values needed in openssl.cnf
    String caName, keyName;
    String country, state, city, company, department, domain, email;
  }

  private void listCAs() {
    ca.removeAllItems();
    File folder = new File(caFolder);
    if (!folder.exists()) return;
    File files[] = folder.listFiles();
    for(int a=0;a<files.length;a++) {
      String name = files[a].getName();
      if (!name.endsWith(".crt")) continue;
      ca.addItem(name.substring(0, name.length() - 4));
    }
  }

  private void listKeys() {
    key.removeAllItems();
    File folder = new File(keysFolder);
    if (!folder.exists()) return;
    File files[] = folder.listFiles();
    for(int a=0;a<files.length;a++) {
      String name = files[a].getName();
      if (!name.endsWith(".key")) continue;
      key.addItem(name.substring(0, name.length() - 4));
    }
  }

  public void status() {
    int caidx = ca.getSelectedIndex();
    if (caidx != -1) {
      String name = (String)ca.getSelectedItem();
      boolean ca_crt = new File(caFolder + "/" + name + ".crt").exists();
//      boolean ca_key = new File(caFolder + "/" + name + ".key").exists();
      //TODO : add more useful info here
      if (ca_crt) caStatus.setText("Okay"); else caStatus.setText("Not found");
    } else {
      caStatus.setText("");
    }

    int keyidx = key.getSelectedIndex();
    if (keyidx == -1) {
      keyStatus.setText("");
      return;
    }

    String name = (String)key.getSelectedItem();
    boolean key = new File(keysFolder + "/" + name + ".key").exists();
    boolean csr = new File(keysFolder + "/" + name + ".csr").exists();
    boolean crt = new File(keysFolder + "/" + name + ".crt").exists();

    String msg = null;
    if ((!key) && (!csr) && (!crt)) msg = "Not found";
    if ((key) && (csr) && (!crt)) msg = "Not signed";
    if ((key) && (csr) && (crt)) msg = "Okay";
    if (msg == null) msg = "Invalid";
    keyStatus.setText(msg);
  }

  private boolean editConfig(Config config) {
    OpenSSLGetDetails dialog = new OpenSSLGetDetails(null, true, config);
    dialog.setVisible(true);
    if (!dialog.accepted) return false;
    //generate cfgFolder/openssl.cnf
    try {
      String cnf = new String(JF.readAll(this.getClass().getClassLoader().getResourceAsStream("openssl.cnf")));
      cnf = cnf.replaceAll("[$]caFolder", caFolder);
      if (config.caName == null) config.caName = config.keyName;
      cnf = cnf.replaceAll("[$]name", config.caName);  //this is not really used during caGenerate()

      cnf = cnf.replaceAll("[$]ENTER_COUNTRY_NAME", config.country);
      cnf = cnf.replaceAll("[$]ENTER_STATE_NAME", config.state);
      cnf = cnf.replaceAll("[$]ENTER_CITY_NAME", config.city);
      cnf = cnf.replaceAll("[$]ENTER_COMPANY_NAME", config.company);
      cnf = cnf.replaceAll("[$]ENTER_ORG_UNIT_NAME", config.department);
      cnf = cnf.replaceAll("[$]ENTER_DOMAIN_NAME", config.domain);
      cnf = cnf.replaceAll("[$]ENTER_YOUR_DOMAIN_ADMIN_EMAIL_ADDRESS", config.email);
      FileOutputStream fos = new FileOutputStream(cfgFolder + "/" + "openssl.cnf");
      fos.write(cnf.getBytes());
      fos.close();
    } catch (Exception e) {
      JF.showError("Error", "Exception:" + e);
      return false;
    }
    return true;
  }

  private void caGenerate() {
    //openssl req -days 3650 -nodes -new -x509 -keyout ca.key -out ca.crt -config openssl.cnf
    Config config = new Config();
    if (!editConfig(config)) return;  //generates cfgFolder + "/" + "openssl.cnf"
    ArrayList<String> cmd = new ArrayList<String>();
    cmd.add("openssl");
    cmd.add("req");
    cmd.add("-days");
    cmd.add("3650");
    cmd.add("-nodes");
    cmd.add("-new");
    cmd.add("-x509");
    cmd.add("-keyout");
    cmd.add(caFolder + "/" + config.keyName + ".key");
    cmd.add("-out");
    cmd.add(caFolder + "/" + config.keyName + ".crt");
    cmd.add("-config");
    cmd.add(cfgFolder + "/" + "openssl.cnf");
    ShellProcess sp = new ShellProcess();
    sp.addRegexResponse("Country Name.+", "\n", true);
    sp.addRegexResponse("State or Province Name.+", "\n", true);
    sp.addRegexResponse("Locality Name.+", "\n", true);
    sp.addRegexResponse("Organization Name.+", "\n", true);
    sp.addRegexResponse("Organizational Unit Name.+", "\n", true);
    sp.addRegexResponse("Common Name.+", "\n", true);
    sp.addRegexResponse("Email Address.+", "\n", true);
    String output = sp.run(cmd.toArray(new String[0]), true);
    new File(cfgFolder + "/" + "openssl.cnf").delete();
    if (sp.getErrorLevel() != 0) {
      JF.showError("Error", "Output=" + output);
      return;
    }
    //create index and serial files
    try {
      FileOutputStream index = new FileOutputStream(caFolder + "/" + config.keyName + ".index");
      index.close();
      FileOutputStream serial = new FileOutputStream(caFolder + "/" + config.keyName + ".serial");
      serial.write("01\r\n".getBytes());
      serial.close();
    } catch (Exception e) {
      e.printStackTrace();
      JF.showError("Error", "Failed to generate index/serial files for Cert Authority");
    }
    listCAs();
    status();
  }

  private void caImport() {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    chooser.setMultiSelectionEnabled(false);
    File path = new File(JF.getUserPath());
    chooser.setCurrentDirectory(path);
    if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
    String file = chooser.getSelectedFile().getAbsolutePath();
    //copy file to caFolder
    ShellProcess sp = new ShellProcess();
    sp.run(new String[] {"cp", file, caFolder}, true);
    listCAs();
    status();
  }

  private void keyGenerate() {
    //openssl req -days 3650 -nodes -new -keyout %1.key -out %1.csr -config openssl.cnf
    Config config = new Config();
    if (ca.getSelectedIndex() == -1) {
      JF.showError("Error", "Please select a Cert Authority first");
      return;
    }
    config.caName = (String)ca.getSelectedItem();
    if (!editConfig(config)) return;  //generates cfgFolder + "/" + "openssl.cnf"
    ArrayList<String> cmd = new ArrayList<String>();
    cmd.add("openssl");
    cmd.add("req");
    cmd.add("-days");
    cmd.add("3650");
    cmd.add("-nodes");
    cmd.add("-new");
    cmd.add("-keyout");
    cmd.add(keysFolder + "/" + config.keyName + ".key");
    cmd.add("-out");
    cmd.add(keysFolder + "/" + config.keyName + ".csr");
    cmd.add("-config");
    cmd.add(cfgFolder + "/" + "openssl.cnf");
    ShellProcess sp = new ShellProcess();
    sp.addRegexResponse("Country Name.+", "\n", true);
    sp.addRegexResponse("State or Province Name.+", "\n", true);
    sp.addRegexResponse("Locality Name.+", "\n", true);
    sp.addRegexResponse("Organization Name.+", "\n", true);
    sp.addRegexResponse("Organizational Unit Name.+", "\n", true);
    sp.addRegexResponse("Common Name.+", "\n", true);
    sp.addRegexResponse("Email Address.+", "\n", true);
    sp.addRegexResponse("A challenge password.+", "\n", true);
    sp.addRegexResponse("An optional company name.+", "\n", true);
    sp.log = true;  //test
    String output = sp.run(cmd.toArray(new String[0]), true);
    new File(cfgFolder + "/" + "openssl.cnf").delete();
    if (sp.getErrorLevel() != 0) {
      JF.showError("Error", "Output=" + output);
      return;
    }
    listKeys();
    status();
  }

  private void selfSign() {
    //openssl ca -days 3650 -out $1.crt -in $1.csr -config openssl.cnf
    Config config = new Config();
    if (ca.getSelectedIndex() == -1) {
      JF.showError("Error", "Please select a Cert Authority first");
      return;
    }
    config.caName = (String)ca.getSelectedItem();
    config.keyName = (String)key.getSelectedItem();
    if (!editConfig(config)) return;  //generates cfgFolder + "/" + "openssl.cnf"
    ArrayList<String> cmd = new ArrayList<String>();
    cmd.add("openssl");
    cmd.add("ca");
    cmd.add("-days");
    cmd.add("3650");
    cmd.add("-out");
    cmd.add(keysFolder + "/" + config.keyName + ".crt");
    cmd.add("-in");
    cmd.add(keysFolder + "/" + config.keyName + ".csr");
    cmd.add("-config");
    cmd.add(cfgFolder + "/" + "openssl.cnf");
    ShellProcess sp = new ShellProcess();
    sp.log = true;
    sp.addResponse("Sign the certificate? [y/n]:", "y\n", false);
    sp.addRegexResponse(".+certificate requests certified[,] commit.+", "y\n", false);
    String output = sp.run(cmd.toArray(new String[0]), true);
    if (sp.getErrorLevel() != 0) {
      JF.showError("Error", "Output=" + output);
      return;
    }
    new File(cfgFolder + "/" + "openssl.cnf").delete();
    listKeys();
    status();
  }

  private void exportCSR() {
    int idx = key.getSelectedIndex();
    if (idx == -1) return;
    String keyName = (String)key.getSelectedItem();
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    chooser.setMultiSelectionEnabled(false);
    File path = new File(JF.getUserPath());
    chooser.setCurrentDirectory(path);
    if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
    String file = chooser.getSelectedFile().getAbsolutePath();
    //copy keysFolder/key.csr to file
    ShellProcess sp = new ShellProcess();
    String output = sp.run(new String[] {"cp", keysFolder + "/" + keyName + ".csr", file}, true);
    if (sp.getErrorLevel() != 0) {
      JF.showError("Error", "Output=" + output);
      return;
    }
    listKeys();
    status();
  }

  private void importKey() {
    int idx = key.getSelectedIndex();
    if (idx == -1) return;
    String keyName = (String)key.getSelectedItem();
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    chooser.setMultiSelectionEnabled(false);
    File path = new File(JF.getUserPath());
    chooser.setCurrentDirectory(path);
    if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return;
    String file = chooser.getSelectedFile().getAbsolutePath();
    //copy file to keysFolder/key.crt
    ShellProcess sp = new ShellProcess();
    sp.run(new String[] {"cp", file, keysFolder + "/" + keyName + ".crt"}, true);
    listKeys();
    status();
  }

  private void load_nss() {
    //execute : certutil -A -n "name" -t TC -i "file" -d sql:$HOME/.pki/nssdb/
    String keyName = (String)key.getSelectedItem();
    ShellProcess sp = new ShellProcess();
    String output = sp.run(new String[] {
      "certutil", "-A", "-n", keyName, "-t", "TC", "-i"
      , keysFolder + "/" + keyName + ".crt"
      , "-d", "sql:" + System.getenv("HOME") + "/.pki/nssdb/"
    }, true);
    if (sp.getErrorLevel() == 0) {
      JF.showMessage("Notice", "Import successful");
    } else {
      JFLog.log(output);
      JF.showError("Error", "Import failed");
    }
  }

  private void apply() {
    int caidx = ca.getSelectedIndex();
    if (caidx == -1) return;
    String caName = (String)ca.getSelectedItem();
    int keyidx = key.getSelectedIndex();
    if (keyidx == -1) return;
    String keyName = (String)key.getSelectedItem();
    if (serverType.equals("apache")) {
      //copy key.crt and key.crt to serverFolder (as root)
      boolean ok = Linux.runScript(new String[] {
        "mkdir -p " + serverFolder,
        "cp " + keysFolder + "/" + keyName + ".crt " + serverFolder + "/" + "public.crt",
        "cp " + keysFolder + "/" + keyName + ".key " + serverFolder + "/" + "private.key"
      });
      if (!ok) {
        JF.showError("Error", "Failed to apply cert/key");
        return;
      }
      JF.showMessage("Notice", "Apply complete!");
    } else if (serverType.equals("tomcat")) {
      //convert key/crt to DER format and import into a keystore

      //Convert private key
      //openssl pkcs8 -topk8 -nocrypt -in %1.key -inform PEM -out %1.der -outform DER
      ArrayList<String> cmd = new ArrayList<String>();
      cmd.add("openssl");
      cmd.add("pkcs8");
      cmd.add("-topk8");
      cmd.add("-nocrypt");
      cmd.add("-in");
      cmd.add(keysFolder + "/" + keyName + ".key");
      cmd.add("-inform");
      cmd.add("PEM");
      cmd.add("-out");
      cmd.add(keysFolder + "/" + keyName + "_key.der");
      cmd.add("-outform");
      cmd.add("DER");
      ShellProcess sp = new ShellProcess();
      String output = sp.run(cmd.toArray(new String[0]), true);
      if (sp.getErrorLevel() != 0) {
        JF.showError("Error", "Output=" + output);
        return;
      }
      //Convert public cert
      //openssl x509 -in %1.crt -inform PEM -out %1_crt.der -outform DER
      cmd = new ArrayList<String>();
      cmd.add("openssl");
      cmd.add("x509");
      cmd.add("-in");
      cmd.add(keysFolder + "/" + keyName + ".crt");
      cmd.add("-inform");
      cmd.add("PEM");
      cmd.add("-out");
      cmd.add(keysFolder + "/" + keyName + "_crt.der");
      cmd.add("-outform");
      cmd.add("DER");
      sp = new ShellProcess();
      output = sp.run(cmd.toArray(new String[0]), true);
      if (sp.getErrorLevel() != 0) {
        JF.showError("Error", "Output=" + output);
        return;
      }
      try {
        //now import into a temp keystore and copy to serverFolder
        File tmpFile = File.createTempFile("keystore", ".ks", new File("/tmp"));
        ImportKey.importKeys(
            new FileInputStream(keysFolder + "/" + keyName + "_crt.der")
          , new FileInputStream(keysFolder + "/" + keyName + "_key.der")
          , tmpFile.getAbsolutePath()
        );
        //copy to serverFolder
        boolean ok = Linux.runScript(new String[] {
          "mkdir -p " + serverFolder,
          "cp " + tmpFile.getAbsolutePath() + " " + serverFolder + "/.keystore"
        });
        tmpFile.delete();
        if (!ok) {
          JF.showError("Error", "Failed to copy keystore file");
          return;
        }
      } catch (Exception e) {
        JF.showError("Error", "Exception:" + e);
        return;
      }
      JF.showMessage("Notice", "Apply complete!");
    } else {
      JF.showError("Error", "Unknown server type");
    }
  }
}
