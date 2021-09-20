/** Resample track
 *
 * Created : Apr 23, 2014
 *
 * @author pquiring
 */

import java.io.*;

import javaforce.*;
import javaforce.awt.*;

public class FxResample extends javax.swing.JDialog {

  /**
   * Creates new form FxResample
   */
  public FxResample(java.awt.Frame parent, boolean modal, TrackPanel track) {
    super(parent, modal);
    initComponents();
    JFAWT.centerWindow(this);
    this.track = track;
    freq.setSelectedItem("" + track.rate);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    apply = new javax.swing.JButton();
    cancel = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    freq = new javax.swing.JComboBox();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Resample");
    setResizable(false);

    apply.setText("Apply");
    apply.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        applyActionPerformed(evt);
      }
    });

    cancel.setText("Cancel");
    cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelActionPerformed(evt);
      }
    });

    jLabel2.setText("Frequency:");

    freq.setEditable(true);
    freq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8000", "11025", "16000", "22050", "32000", "44100", "48000", "64000", "96000" }));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 132, Short.MAX_VALUE)
            .addComponent(cancel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(apply))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(freq, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(freq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(apply)
          .addComponent(cancel))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    dispose();
  }//GEN-LAST:event_cancelActionPerformed

  private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
    apply();
    dispose();
  }//GEN-LAST:event_applyActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton apply;
  private javax.swing.JButton cancel;
  private javax.swing.JComboBox freq;
  private javax.swing.JLabel jLabel2;
  // End of variables declaration//GEN-END:variables

  private TrackPanel track;

  private void apply() {
    int newFreq = JF.atoi((String)freq.getSelectedItem());
    if (newFreq < 8000) newFreq = 8000;
    if (newFreq > 96000) newFreq = 96000;
    if (newFreq == track.rate) {
      //no change
      dispose();
      return;
    }
    track.selectAll();
    track.createModifyUndo();
    String toPath = track.project.path + "/temp";
    new File(toPath).mkdir();
    double step = ((double)track.rate) / ((double)newFreq);
    FileOutputStream fos;
    long totalLength = 0;
    try {
      long length = track.totalLength;
      long offset = 0;
      double foffset = 0.0;
      double coffset = 0;
      int cid[] = new int[track.channels];
      int last[] = new int[track.channels];
      ByteArrayOutputStream baos[] = new ByteArrayOutputStream[track.channels];
      for(int ch=0;ch<track.channels;ch++) {
        baos[ch] = new ByteArrayOutputStream();
      }
      int size[] = new int[track.channels];
      short samples16[] = null;
      int samples32[] = null;
      int pos, sample = 0;
      double s1, s2, m1, m2;
      while (length > 0) {
        int read = track.maxChunkSize;
        if (read > length) read = (int)length;
        for(int ch=0;ch<track.channels;ch++) {
          coffset = foffset;
          byte samples[] = track.getSamples(offset, read, ch);
          pos = 0;
          switch (track.bits) {
            case 16: samples16 = LE.byteArray2shortArray(samples, null); break;
            case 32: samples32 = LE.byteArray2intArray(samples, null); break;
          }
          while (pos < read-1) {
            if (coffset == 0.0) {
              switch (track.bits) {
                case 16: sample = samples16[pos]; break;
                case 32: sample = samples32[pos]; break;
              }
            } else if (coffset < 0.0) {
              //interpolate between pos-1(last) and pos
              coffset += 1.0;
              m1 = 1.0 - coffset;
              m2 = coffset;
              coffset -= 1.0;
              switch (track.bits) {
                case 16:
                  s1 = last[ch];
                  s2 = samples16[pos];
                  sample = (int)((s1 * m1) + (s2 * m2));
                  break;
                case 32:
                  s1 = last[ch];
                  s2 = samples32[pos];
                  sample = (int)((s1 * m1) + (s2 * m2));
                  break;
              }
            } else {
              //interpolate between pos and pos+1
              m1 = 1.0 - coffset;
              m2 = coffset;
              switch (track.bits) {
                case 16:
                  s1 = samples16[pos];
                  s2 = samples16[pos+1];
                  sample = (int)((s1 * m1) + (s2 * m2));
                  break;
                case 32:
                  s1 = samples32[pos];
                  s2 = samples32[pos+1];
                  sample = (int)((s1 * m1) + (s2 * m2));
                  break;
              }
            }
            switch (track.bits) {
              case 16:
                baos[ch].write(sample & 0xff);
                sample >>= 8;
                baos[ch].write(sample & 0xff);
                break;
              case 32:
                baos[ch].write(sample & 0xff);
                sample >>= 8;
                baos[ch].write(sample & 0xff);
                sample >>= 8;
                baos[ch].write(sample & 0xff);
                sample >>= 8;
                baos[ch].write(sample & 0xff);
                break;
            }
            size[ch]++;
            coffset += step;
            while (coffset >= 1.0) {
              coffset -= 1.0;
              pos++;
            }
            if (size[ch] == track.maxChunkSize) {
              if (ch == 0) totalLength += track.maxChunkSize;
              fos = new FileOutputStream(toPath + "/c" + cid[ch] + "-" + ch + ".dat");
              TrackPanel.ChunkHeader chunk = new TrackPanel.ChunkHeader();
              chunk.cid = cid[ch]++;
              chunk.length = size[ch];
              chunk.next_cid = cid[ch];
              chunk.write(fos);
              fos.write(baos[ch].toByteArray());
              fos.close();
              size[ch] = 0;
              baos[ch].reset();
            }
          }
          switch (track.bits) {
            case 16: last[ch] = samples16[read-1]; break;
            case 32: last[ch] = samples32[read-1]; break;
          }
        }
        foffset = coffset - 1.0;
        length -= read;
      }
      for(int ch=0;ch<track.channels;ch++) {
        if (size[ch] > 0) {
          if (ch == 0) totalLength += size[ch];
          fos = new FileOutputStream(toPath + "/c" + cid[ch] + "-" + ch + ".dat");
          TrackPanel.ChunkHeader chunk = new TrackPanel.ChunkHeader();
          chunk.cid = cid[ch]++;
          chunk.length = size[ch];
          chunk.next_cid = 0;
          chunk.write(fos);
          fos.write(baos[ch].toByteArray());
          fos.close();
          size[ch] = 0;
          baos[ch].reset();
        } else {
          //need to patch last chunk (clear next_cid)
          RandomAccessFile raf = new RandomAccessFile(toPath + "/c" + (cid[ch]-1) + "-" + ch + ".dat", "rw");
          raf.seek(4);  //skip length
          raf.write(new byte[4]);  //write zero next_cid
          raf.close();
        }
      }
      //write clip header
      fos = new FileOutputStream(toPath + "/clip.dat");
      TrackPanel.ClipHeader clip = new TrackPanel.ClipHeader();
      clip.offset = 0;
      clip.length = totalLength;
      clip.tid = track.tid;
      clip.channels = track.channels;
      clip.bits = track.bits;
      clip.bytes = track.bytes;
      clip.rate = newFreq;
      clip.write(fos);
      fos.close();
    } catch (Exception e) {
      JFLog.log(e);
      dispose();
      return;
    }
    track.delete(false);
    track.undoRate = track.rate;
    track.rate = newFreq;
    track.paste(toPath, false);
    track.writeMainHeader();
    //now delete /temp contents
    File files[] = new File(toPath).listFiles();
    for(int a=0;a<files.length;a++) {
      files[a].delete();
    }
  }
}
