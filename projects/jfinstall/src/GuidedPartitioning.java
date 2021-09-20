/**
 *
 * @author pquiring
 */

import java.util.*;
import javax.swing.table.*;

import jfparted.*;

import javaforce.*;
import javaforce.awt.*;

public class GuidedPartitioning extends IPanel {

  /**
   * Creates new form GuidedPartitioning
   */
  public GuidedPartitioning() {
    initComponents();
    calcDevicePartitioning();
    showDeviceImage();
    showPartitionTable();
    status.setText("Review proposed partitioning and continue.");
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        status = new javax.swing.JTextField();

        image.setPreferredSize(new java.awt.Dimension(256, 32));
        image.setLayout(new java.awt.GridLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Device", "Type", "Mount", "Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        status.setEditable(false);
        status.setText("status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(status))
                .addContainerGap())
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField status;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

  public Data.Device device;
  public boolean error = false;

  public void calcDevicePartitioning() {
    Data.getPartitions();
    device = Data.getDevice(Data.guidedTarget.dev).clone();
    Data.ops1 = new ArrayList<String>();  //removes
    Data.ops2 = new ArrayList<String>();  //adds
    Data.ops1.add("select " + device.dev + "\n");
    if (Data.installType == Data.installTypes.ALL) {
      //delete ALL partitions
      for(int a=0;a<device.parts.size();a++) {
        Data.Partition part = device.parts.get(a);
        if (part.number == -1) continue;
        if (part.type.equals("logical")) continue;  //deleting the extended part will do this one already
        Data.ops1.add("rm " + part.number + "\n");
        part.delete = true;
      }
      Data.deletePartitions(device);
    } else {
      //delete Linux partitions
      boolean hasLogical = false;  //has logical partitions that will NOT be deleted
      Data.Partition ext = null;
      for(int a=0;a<device.parts.size();a++) {
        Data.Partition part = device.parts.get(a);
        if (part.number == -1) continue;
        String filesys = part.filesys;
        boolean ok = false;
        if (filesys.equals("ext2")) ok = true;
        if (filesys.equals("ext3")) ok = true;
        if (filesys.equals("ext4")) ok = true;
        if (filesys.equals("swap")) ok = true;
        if (!ok) {
          if (part.type.equals("logical")) hasLogical = true;
          if (part.type.equals("extended")) ext = part;
          continue;
        }
        Data.ops1.add("rm " + part.number + "\n");
        part.delete = true;
      }
      if (ext != null && !hasLogical) {
        Data.ops1.add("rm " + ext.number + "\n");
        ext.delete = true;
      }
      Data.deletePartitions(device);
    }
    Data.ops1.add("quit\n");
    //calc smallest block for 4GB swap area (near end of device if possible)
    Data.swap = Data.findPartition(device, "4GB", "swap");
    if (Data.swap == null) {
      error = true;
      JFAWT.showError("Error", "Unable to find space for a swap partition.\nPlease use Custom Partitioning.");
      return;
    }
    Data.swap.mount = "swap";
    Data.ops2.add("select " + device.dev + "\n");
    Data.ops2.add("mkpart primary linux-swap(v1) " + Data.swap.start + " " + Data.swap.end + "\n");
    //calc largest block for "/" file system (near start of device if possible)
    Data.root = Data.findPartition(device, null, "ext4");
    if (Data.root == null) {
      error = true;
      JFAWT.showError("Error", "Unable to find space for the root partition.\nPlease use Custom Partitioning.");
      return;
    }
    Data.root.mount = "/";
    Data.ops2.add("mkpart primary ext4 " + Data.root.start + " " + Data.root.end + "\n");
    Data.ops2.add("quit\n");

    //generate fstab records
    Data.clearfstab();
    Data.addfstab(Data.root.device.dev + Data.root.number, Data.root.mount, Data.root.filesys,
      "errors=remount-ro", 0, 1);
    Data.addfstab(Data.swap.device.dev + Data.swap.number, Data.swap.mount, Data.swap.filesys,
      "sw", 0, 0);
}

  public void showDeviceImage() {
    image.add(new DeviceImage(device));
    image.revalidate();
    image.repaint();
  }

  public void showPartitionTable() {
    DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
    while (tableModel.getRowCount() > 0) tableModel.removeRow(0);
    tableModel.addRow(new Object[] {device.dev,"","",device.size});
    for(int p=0;p<device.parts.size();p++) {
      Data.Partition part = device.parts.get(p);
      tableModel.addRow(
        new Object[] {(part.number == -1) ? "" : part.device.dev + part.number,
        part.filesys,part.mount,part.size});
    }
  }

  public IPanel next() {
    ShellProcess sp;
    ArrayList<String> cmd;
    String output;
    if ((Data.swap == null) || (Data.root == null) || error) {
      JFAWT.showError("Error", "An error occured, please go back and try again.");
      return null;
    }
    return new Install();
  }
  public IPanel prev() {
    if (Data.getDeviceCount() > 1) {
      return new GuidedPartSelectDevice();
    }
    return new InstallTypes();
  }
  public IPanel getThis() {return this;}
}
