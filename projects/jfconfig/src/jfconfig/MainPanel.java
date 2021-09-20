package jfconfig;

/**
 * Created : Mar 4, 2012
 *
 * @author pquiring
 */

import javax.swing.*;

import javaforce.*;
import javaforce.awt.*;

public class MainPanel extends javax.swing.JPanel {

  /**
   * Creates new form MainPanel
   */
  public MainPanel() {
    initComponents();
    ConfigApp.This.setTitle("Config");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    users = new javax.swing.JButton();
    servers = new javax.swing.JButton();
    groups = new javax.swing.JButton();
    network = new javax.swing.JButton();
    fixStuff = new javax.swing.JButton();
    display = new javax.swing.JButton();
    sound = new javax.swing.JButton();
    sound1 = new javax.swing.JButton();
    global = new javax.swing.JButton();
    backup = new javax.swing.JButton();
    printers = new javax.swing.JButton();
    certs = new javax.swing.JButton();
    apps = new javax.swing.JButton();
    repo = new javax.swing.JButton();
    parted = new javax.swing.JButton();

    users.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-users.png"))); // NOI18N
    users.setText("Users");
    users.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    users.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    users.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        usersActionPerformed(evt);
      }
    });

    servers.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    servers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-servers.png"))); // NOI18N
    servers.setText("Servers");
    servers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    servers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    servers.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        serversActionPerformed(evt);
      }
    });

    groups.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    groups.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-users.png"))); // NOI18N
    groups.setText("Groups");
    groups.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    groups.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    groups.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        groupsActionPerformed(evt);
      }
    });

    network.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    network.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-network.png"))); // NOI18N
    network.setText("Network");
    network.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    network.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    network.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        networkActionPerformed(evt);
      }
    });

    fixStuff.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    fixStuff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-fix.png"))); // NOI18N
    fixStuff.setText("Fix Stuff");
    fixStuff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    fixStuff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    fixStuff.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fixStuffActionPerformed(evt);
      }
    });

    display.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    display.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-display.png"))); // NOI18N
    display.setText("Display");
    display.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    display.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    display.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        displayActionPerformed(evt);
      }
    });

    sound.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    sound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-sound.png"))); // NOI18N
    sound.setText("Sound");
    sound.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    sound.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    sound.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        soundActionPerformed(evt);
      }
    });

    sound1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    sound1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-datetime.png"))); // NOI18N
    sound1.setText("Date/Time");
    sound1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    sound1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    sound1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        sound1ActionPerformed(evt);
      }
    });

    global.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    global.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-global.png"))); // NOI18N
    global.setText("Global");
    global.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    global.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    global.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        globalActionPerformed(evt);
      }
    });

    backup.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-backup.png"))); // NOI18N
    backup.setText("Backup");
    backup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    backup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    backup.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backupActionPerformed(evt);
      }
    });

    printers.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
    printers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-printers.png"))); // NOI18N
    printers.setText("Printers");
    printers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    printers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    printers.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        printersActionPerformed(evt);
      }
    });

    certs.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
    certs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-certificates.png"))); // NOI18N
    certs.setText("Certificates");
    certs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    certs.setMargin(new java.awt.Insets(2, 0, 2, 0));
    certs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    certs.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        certsActionPerformed(evt);
      }
    });

    apps.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
    apps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-apps.png"))); // NOI18N
    apps.setText("Apps");
    apps.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    apps.setMargin(new java.awt.Insets(2, 0, 2, 0));
    apps.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    apps.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        appsActionPerformed(evt);
      }
    });

    repo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
    repo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-repo.png"))); // NOI18N
    repo.setText("Repository");
    repo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    repo.setMargin(new java.awt.Insets(2, 0, 2, 0));
    repo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    repo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        repoActionPerformed(evt);
      }
    });

    parted.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
    parted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfconfig/jfconfig-parted.png"))); // NOI18N
    parted.setText("Disk Manager");
    parted.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    parted.setMargin(new java.awt.Insets(2, 0, 2, 0));
    parted.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    parted.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        partedActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(printers, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(certs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(groups, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(sound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(network, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(sound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(apps, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(servers, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
          .addComponent(global, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(repo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(fixStuff, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
          .addComponent(backup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(parted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(74, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(groups, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(fixStuff, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(servers, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(network, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(sound, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(sound1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(global, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(backup, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(printers, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(certs, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(apps, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(repo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(parted, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
    setPanel(new UsersPanel());
  }//GEN-LAST:event_usersActionPerformed

  private void groupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupsActionPerformed
    setPanel(new GroupsPanel());
  }//GEN-LAST:event_groupsActionPerformed

  private void serversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serversActionPerformed
    setPanel(new ServersPanel());
  }//GEN-LAST:event_serversActionPerformed

  private void networkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkActionPerformed
    setPanel(new NetworkPanel());
  }//GEN-LAST:event_networkActionPerformed

  private void fixStuffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixStuffActionPerformed
    setPanel(new FixStuffPanel());
  }//GEN-LAST:event_fixStuffActionPerformed

  private void displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayActionPerformed
    setPanel(new DisplayPanel());
  }//GEN-LAST:event_displayActionPerformed

  private void soundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundActionPerformed
    setPanel(new SoundPanel());
  }//GEN-LAST:event_soundActionPerformed

  private void sound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sound1ActionPerformed
    setPanel(new DateTimePanel());
  }//GEN-LAST:event_sound1ActionPerformed

  private void globalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalActionPerformed
    setPanel(new GlobalPanel());
  }//GEN-LAST:event_globalActionPerformed

  private void backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupActionPerformed
    setPanel(new BackupPanel());
  }//GEN-LAST:event_backupActionPerformed

  private void printersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printersActionPerformed
    setPanel(new PrintersPanel());
  }//GEN-LAST:event_printersActionPerformed

  private void certsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certsActionPerformed
    setPanel(new OpenSSLConfigPanel());
  }//GEN-LAST:event_certsActionPerformed

  private void appsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appsActionPerformed
    setPanel(new AppsPanel());
  }//GEN-LAST:event_appsActionPerformed

  private void repoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repoActionPerformed
    setPanel(new RepoPanel());
  }//GEN-LAST:event_repoActionPerformed

  private void partedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partedActionPerformed
    setPanel(new PartedPanel());
  }//GEN-LAST:event_partedActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton apps;
  private javax.swing.JButton backup;
  private javax.swing.JButton certs;
  private javax.swing.JButton display;
  private javax.swing.JButton fixStuff;
  private javax.swing.JButton global;
  private javax.swing.JButton groups;
  private javax.swing.JButton network;
  private javax.swing.JButton parted;
  private javax.swing.JButton printers;
  private javax.swing.JButton repo;
  private javax.swing.JButton servers;
  private javax.swing.JButton sound;
  private javax.swing.JButton sound1;
  private javax.swing.JButton users;
  // End of variables declaration//GEN-END:variables

  public void setPanel(JPanel panel) {
    ConfigApp.setPanel(panel);
  }

}
