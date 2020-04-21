/**
 *
 * @author pquiring
 *
 * Created : Sept 27, 2013
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javaforce.*;
import javaforce.media.*;

public class MainPanel extends javax.swing.JPanel implements MediaIO, ActionListener {

  /**
   * Creates new form MainPanel
   */
  public MainPanel(JFrame frame) {
    initComponents();
    listAudioDevices();
    this.frame = frame;
    mouse = new JFImage();
    mouse.loadPNG(this.getClass().getClassLoader().getResourceAsStream("mouse.png"));
    initTray();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    buttonGroup2 = new javax.swing.ButtonGroup();
    audio = new javax.swing.JRadioButton();
    noaudio = new javax.swing.JRadioButton();
    start = new javax.swing.JButton();
    freq = new javax.swing.JComboBox();
    mono = new javax.swing.JRadioButton();
    stereo = new javax.swing.JRadioButton();
    jLabel3 = new javax.swing.JLabel();
    fps = new javax.swing.JSpinner();
    jLabel4 = new javax.swing.JLabel();
    audioDevices = new javax.swing.JComboBox();
    showMouseCursor = new javax.swing.JCheckBox();
    jLabel5 = new javax.swing.JLabel();
    vBitRate = new javax.swing.JComboBox();
    jLabel6 = new javax.swing.JLabel();
    aBitRate = new javax.swing.JComboBox();
    jLabel7 = new javax.swing.JLabel();
    delay3seconds = new javax.swing.JCheckBox();
    jLabel8 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    trim3seconds = new javax.swing.JCheckBox();

    buttonGroup1.add(audio);
    audio.setSelected(true);
    audio.setText("Audio");

    buttonGroup1.add(noaudio);
    noaudio.setText("No Audio");

    start.setText("Start");
    start.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        startActionPerformed(evt);
      }
    });

    freq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "44100", "22050", "11025", "8000" }));
    freq.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        freqActionPerformed(evt);
      }
    });

    buttonGroup2.add(mono);
    mono.setSelected(true);
    mono.setText("mono");

    buttonGroup2.add(stereo);
    stereo.setText("stereo");

    jLabel3.setText("FPS");

    fps.setModel(new javax.swing.SpinnerNumberModel(16, 1, 60, 1));

    jLabel4.setText("Audio Device");

    showMouseCursor.setSelected(true);
    showMouseCursor.setText("Show mouse cursor");

    jLabel5.setText("Video Quality");

    vBitRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8M", "6M", "4M", "2M", "1M", "800k", "400k", "200k" }));
    vBitRate.setSelectedIndex(4);
    vBitRate.setToolTipText("");
    vBitRate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        vBitRateActionPerformed(evt);
      }
    });

    jLabel6.setText("Audio Quality");

    aBitRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "256k", "192k", "128k", "64k", "32k" }));
    aBitRate.setSelectedIndex(2);
    aBitRate.setToolTipText("");

    jLabel7.setText("Freq:");

    delay3seconds.setText("3 second delay");
    delay3seconds.setToolTipText("Delay so you can minimize this window (Applet)");

    jLabel8.setText("When you start a tray icon will be added to pause/stop recording.");

    jLabel1.setText("bits/sec");

    jLabel2.setText("bits/sec");

    trim3seconds.setText("3 second trim at end");
    trim3seconds.setToolTipText("Delay so you can minimize this window (Applet)");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addComponent(audioDevices, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(audio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                      .addComponent(noaudio))
                    .addComponent(freq, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mono)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(stereo))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(fps, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)))
            .addGap(22, 22, 22))
          .addGroup(layout.createSequentialGroup()
            .addComponent(delay3seconds)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(trim3seconds)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(start))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
              .addComponent(showMouseCursor)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
              .addComponent(jLabel8))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(audioDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(fps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(audio)
          .addComponent(freq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(mono)
          .addComponent(stereo)
          .addComponent(jLabel7))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(noaudio)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(showMouseCursor)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(vBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(aBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel8)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(start)
          .addComponent(delay3seconds)
          .addComponent(trim3seconds))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
    start();
  }//GEN-LAST:event_startActionPerformed

  private void freqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freqActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_freqActionPerformed

  private void vBitRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBitRateActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_vBitRateActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox aBitRate;
  private javax.swing.JRadioButton audio;
  private javax.swing.JComboBox audioDevices;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.ButtonGroup buttonGroup2;
  private javax.swing.JCheckBox delay3seconds;
  private javax.swing.JSpinner fps;
  private javax.swing.JComboBox freq;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JRadioButton mono;
  private javax.swing.JRadioButton noaudio;
  private javax.swing.JCheckBox showMouseCursor;
  private javax.swing.JButton start;
  private javax.swing.JRadioButton stereo;
  private javax.swing.JCheckBox trim3seconds;
  private javax.swing.JComboBox vBitRate;
  // End of variables declaration//GEN-END:variables

  private AudioInput mic;
  private RandomAccessFile raf;
  private boolean active = false;
  private boolean paused = false;
  private boolean working = false;
  private JFrame frame;
  private JFImage mouse;

  public void listAudioDevices() {
    mic = new AudioInput();
    String list[] = mic.listDevices();
    audioDevices.removeAllItems();
    for(int a=0;a<list.length;a++) {
      audioDevices.addItem(list[a]);
    }
  }

  public void setState(boolean state) {
    start.setEnabled(state);
    if (state) start.setText("Start");
    audioDevices.setEnabled(state);
    audio.setEnabled(state);
    noaudio.setEnabled(state);
    mono.setEnabled(state);
    stereo.setEnabled(state);
    freq.setEnabled(state);
    fps.setEnabled(state);
    delay3seconds.setEnabled(state);
    trim3seconds.setEnabled(state);
  }

  public void start() {
    if (working) {
      active = false;
      start.setText("Stopping");
      return;
    }
    working = true;
    setState(false);
    new Worker().start();
  }

  public void failed(String msg) {
    JFAWT.showError("Error", msg);
    setState(true);
    working = false;
  }

  public void swapEndian(byte in[], short out[]) {
    int p = 0;
    short s;
    int cnt = out.length;
    for(int a=0;a<cnt;a++) {
      s = in[p++];
      s <<= 8;
      s += in[p++] & 0xff;
      out[a] = s;
    }
  }

  public class Worker extends Thread {
    public void run() {
      setState(false);

      JFileChooser chooser = new JFileChooser();
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      chooser.setMultiSelectionEnabled(false);
      chooser.setCurrentDirectory(new File(JF.getUserPath() + "/Videos"));
      javax.swing.filechooser.FileFilter ffAVI = new javax.swing.filechooser.FileFilter() {
        public boolean accept(File file) {
          if (file.isDirectory()) return true;
          if (file.getName().endsWith(".avi")) return true;
          return false;
        }
        public String getDescription() {
          return "AVI (*.avi)";
        }
        public String toString() {
          return ".avi";
        }
      };
      chooser.addChoosableFileFilter(ffAVI);
      chooser.setFileFilter(ffAVI);
      if (chooser.showSaveDialog(MainPanel.this) != JFileChooser.APPROVE_OPTION) {
        setState(true);
        working = false;
        return;
      }
      String fn = chooser.getSelectedFile().getAbsolutePath();
      String fnlc = fn.toLowerCase();
      if ((!fnlc.endsWith(".avi"))) {
  //      javax.swing.filechooser.FileFilter ff = chooser.getFileFilter();
  //      fn += ff.toString();
        fn += ".avi";
      }
      boolean doAudio = audio.isSelected();
      int audioRate = JF.atoi((String)freq.getSelectedItem());
      if (audioRate < 8000 || audioRate > 44100) audioRate = 44100;
      int chs = mono.isSelected() ? 1 : 2;
      int frameRate = (Integer)fps.getValue();
      int samples = audioRate * chs / frameRate;
      try {
        raf = new RandomAccessFile(fn, "rw");
        raf.setLength(0);
      } catch (Exception e) {
        JFLog.log(e);
        failed("Unable to create output file");
        return;
      }

      JFImage img = JFImage.createScreenCapture();

      MediaEncoder encoder = new MediaEncoder();
      encoder.setAudioBitRate(getAudioBitRate());
      encoder.setVideoBitRate(getVideoBitRate());
      int width = img.getWidth();
      int height = img.getHeight();
      JFLog.log("size=" + width + "," + height);
      JFLog.log("frameRate=" + frameRate);
      JFLog.log("audioRate=" + audioRate + ",chs=" + chs);
      int abufsiz = audioRate * chs * 3;
      AudioBuffer abuffer = new AudioBuffer(audioRate, chs, 3 + 1);
      int vbufsiz = frameRate * 3;
      int imgsiz = width * height;
      VideoBuffer vbuffer = new VideoBuffer(width, height, vbufsiz + 1);
      if (delay3seconds.isSelected()) {
        JF.sleep(3000);
      }
      if (!encoder.start(MainPanel.this, width, height, frameRate, chs
        , audioRate, "avi", true, doAudio))
      {
        failed("Unable to create output file");
        return;
      }
      if (doAudio) {
        mic = new AudioInput();
        if (!mic.start(chs, audioRate, 16, samples * 2, (String)audioDevices.getSelectedItem())) {
          failed("Unable to start recording audio");
          return;
        }
      }

      active = true;
      paused = false;
      start.setText("Stop");
      start.setEnabled(true);
      byte sams8[] = new byte[samples*2];
      short sams16[] = new short[samples];
      short sams16trim[] = new short[samples];

      double current = System.currentTimeMillis();
      double delay = 1000.0 / frameRate;

      boolean showMouse = showMouseCursor.isSelected();
      boolean trim = trim3seconds.isSelected();

      if (frame != null) frame.setVisible(false);
      boolean skip_frame = false;
      pause.setLabel("Pause");
      addTray();
      while (active) {
        if (paused) {
          while (mic.read(sams8)) {}  //discard audio
          JF.sleep(100);
          continue;
        }
        if (!skip_frame) {
          img = JFImage.createScreenCapture();
          if (showMouse) {
            Point mpt = MouseInfo.getPointerInfo().getLocation();
            img.putJFImageBlend(mouse, mpt.x, mpt.y, true);
          }
        } else {
          skip_frame = false;
        }
        int px[] = img.getBuffer();
        if (trim) {
          //System.out.println("vsize=" + vbuffer.size() + " == " + vbufsiz);
          if (vbuffer.size() >= vbufsiz) {
            encoder.addVideo(vbuffer.getNextFrame().getBuffer());
            vbuffer.freeNextFrame();
          }
          System.arraycopy(px, 0, vbuffer.getNewFrame().getBuffer(), 0, imgsiz);
          vbuffer.freeNewFrame();
        } else {
          encoder.addVideo(px);
        }
        if (doAudio) {
          while (mic.read(sams8)) {
            swapEndian(sams8, sams16);
            if (trim) {
              //System.out.println("asize=" + abuffer.size() + " == " + abufsiz);
              if (abuffer.size() >= abufsiz) {
                abuffer.get(sams16trim, 0, sams16.length);
                encoder.addAudio(sams16trim);
              }
              abuffer.add(sams16, 0, sams16.length);
            } else {
              encoder.addAudio(sams16);
            }
          }
        }
        double now = System.currentTimeMillis();
        int sleep = (int)(delay - (now - current));
        if (sleep > 0) {
          JFLog.log("sleep=" + sleep);
          JF.sleep(sleep);
        } else {
          JFLog.log("sleep <= 0");
          skip_frame = true;  //system too slow
        }
        current += delay;
      }
      delTray();
      if (frame != null) frame.setVisible(true);
      encoder.stop();
      if (doAudio) mic.stop();
      try {
        raf.close();
      } catch (Exception e) {
        JFLog.log(e);
      }
      working = false;
      setState(true);
    }
  }

  public int read(MediaCoder coder, byte[] bytes) {
    return 0;
  }

  public int write(MediaCoder coder, byte[] bytes) {
    try {
      raf.write(bytes);
      return bytes.length;
    } catch (Exception e) {
      JFLog.log(e);
      return 0;
    }
  }

  public long seek(MediaCoder coder, long pos, int how) {
    try {
      switch (how) {
        case MediaCoder.SEEK_SET: break;
        case MediaCoder.SEEK_CUR: pos += raf.getFilePointer(); break;
        case MediaCoder.SEEK_END: pos += raf.length(); break;
      }
      raf.seek(pos);
      return pos;
    } catch (Exception e) {
      JFLog.log(e);
    }
    return 0;
  }

  public SystemTray tray;
  public TrayIcon icon;
  public MenuItem stop, pause;

  private void initTray() {
    if (SystemTray.isSupported()) {
      tray = SystemTray.getSystemTray();
      // create a popup menu
      PopupMenu popup = new PopupMenu();
      pause = new MenuItem("Pause");
      pause.addActionListener(this);
      popup.add(pause);
      popup.addSeparator();
      stop = new MenuItem("Stop");
      stop.addActionListener(this);
      popup.add(stop);
      Dimension size = tray.getTrayIconSize();
      JFImage appicon = new JFImage();
      appicon.loadPNG(this.getClass().getResourceAsStream("jfrecorddesktop.png"));
      JFImage scaled = new JFImage(size.width, size.height);
      scaled.fill(0, 0, size.width, size.height, 0x00000000, true);  //fill with alpha transparent
      if (false) {
        //scaled image (looks bad sometimes)
        scaled.getGraphics().drawImage(appicon.getImage()
          , 0, 0, size.width, size.height
          , 0, 0, appicon.getIconWidth(), appicon.getIconHeight()
          , null);
      } else {
        //center image
        scaled.getGraphics().drawImage(appicon.getImage()
          , (size.width - appicon.getIconWidth()) / 2
          , (size.height - appicon.getIconHeight()) / 2
          , null);
      }
      icon = new TrayIcon(scaled.getImage(), "jfRecordDesktop", popup);
      icon.addActionListener(this);
    }
  }

  private void addTray() {
    try { tray.add(icon); } catch (Exception e) { JFLog.log(e); }
  }

  private void delTray() {
    try { tray.remove(icon); } catch (Exception e) { JFLog.log(e); }
  }

  public void actionPerformed(ActionEvent e) {
    Object o = e.getSource();
    if (o == stop) {
      active = false;
    }
    if (o == pause) {
      paused = !paused;
      if (paused) {
        pause.setLabel("Unpause");
      } else {
        pause.setLabel("Pause");
      }
    }
  }

  private int getRate(String rate) {
    int scale = 1;
    if (rate.endsWith("M")) {
      rate = rate.substring(0, rate.length()-1);
      scale = 1024 * 1024;
    }
    else if (rate.endsWith("k")) {
      rate = rate.substring(0, rate.length()-1);
      scale = 1024;
    }
    int value = JF.atoi(rate) * scale;
    System.out.println("rate=" + value);
    return value;
  }

  private int getAudioBitRate() {
    return getRate((String)aBitRate.getSelectedItem());
  }

  private int getVideoBitRate() {
    return getRate((String)vBitRate.getSelectedItem());
  }
}
