/** SOCKS Client
 *
 *  Simple client that redirects local port to SOCKS server.
 *
 * @author pquiring
 */

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

import javaforce.*;

public class Main extends javax.swing.JFrame {

  /**
   * Creates new form SOCKSClient
   */
  public Main() {
    initComponents();
    JFAWT.centerWindow(this);
    loadConfig();
    genkeys.setVisible(false);  //SSL keys not needed on client side
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel7 = new javax.swing.JLabel();
    buttonGroup1 = new javax.swing.ButtonGroup();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    local_port = new javax.swing.JTextField();
    remote_host = new javax.swing.JTextField();
    secure = new javax.swing.JCheckBox();
    connect = new javax.swing.JButton();
    remote_port = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    socks_server = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    socks4 = new javax.swing.JRadioButton();
    socks5 = new javax.swing.JRadioButton();
    jPanel1 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    user = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    pass = new javax.swing.JTextField();
    jLabel10 = new javax.swing.JLabel();
    socks_port = new javax.swing.JTextField();
    genkeys = new javax.swing.JButton();

    jLabel7.setText("jLabel7");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("SOCKS Client");

    jLabel1.setText("SOCKS4/5 Client : Redirects local port to SOCKS Server");

    jLabel2.setText("Local Port");

    jLabel3.setText("Remote Port");

    jLabel4.setText("Remote IP/Host");

    secure.setText("Server is Secure (SSL)");

    connect.setText("Start");
    connect.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        connectActionPerformed(evt);
      }
    });

    jLabel5.setText("SOCKS Server");

    jLabel6.setText("SOCKS Type");

    buttonGroup1.add(socks4);
    socks4.setSelected(true);
    socks4.setText("SOCKS4");

    buttonGroup1.add(socks5);
    socks5.setText("SOCKS5");

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("SOCKS5 Authentication"));

    jLabel8.setText("User");

    jLabel9.setText("Pass");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(user))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pass)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9)
          .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel10.setText("SOCKS Port");

    genkeys.setText("Generate SSL Keys");
    genkeys.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        genkeysActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(genkeys)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(connect))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(socks_server))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(33, 33, 33)
            .addComponent(local_port))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel4)
              .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(remote_port)
              .addComponent(remote_host)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel10)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(socks_port))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(socks4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(socks5))
              .addComponent(secure))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(socks_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel10)
          .addComponent(socks_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(socks4)
          .addComponent(socks5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(secure)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(local_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(remote_host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(remote_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(connect)
          .addComponent(genkeys))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
    connect();
  }//GEN-LAST:event_connectActionPerformed

  private void genkeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genkeysActionPerformed
    genKeys();
  }//GEN-LAST:event_genkeysActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton connect;
  private javax.swing.JButton genkeys;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JTextField local_port;
  private javax.swing.JTextField pass;
  private javax.swing.JTextField remote_host;
  private javax.swing.JTextField remote_port;
  private javax.swing.JCheckBox secure;
  private javax.swing.JRadioButton socks4;
  private javax.swing.JRadioButton socks5;
  private javax.swing.JTextField socks_port;
  private javax.swing.JTextField socks_server;
  private javax.swing.JTextField user;
  // End of variables declaration//GEN-END:variables

  public Server server;

  public static class Config implements Serializable {
    public String socks_server;
    public int socks_port;
    public boolean secure;
    public boolean socks4, socks5;
    public String user, pass;
    public int local_port;
    public String remote_host;
    public int remote_port;

    public Config() {
      socks_server = "";
      socks_port = 1080;
      socks4 = true;
      socks5 = false;
      user = "";
      pass = "";
      local_port = 1080;
      remote_host = "";
      remote_port = 0;
    }
  }

  public static Config config = new Config();

  public void connect() {
    String str;
    int num;
    try {
      if (server != null) {
        server.close();
        server = null;
        connect.setText("Start");
        setState(true);
        return;
      }

      str = SQL.numbers(local_port.getText());
      if (str.length() == 0) throw new Exception("Invalid local port");
      num = Integer.valueOf(str);
      if (num < 1 || num > 65535) throw new Exception("Invalid local port");
      config.local_port = num;

      config.socks_server = socks_server.getText();
      str = SQL.numbers(socks_port.getText());
      if (str.length() == 0) throw new Exception("Invalid socks port");
      num = Integer.valueOf(str);
      if (num < 1 || num > 65535) throw new Exception("Invalid socks port");
      config.socks_port = num;

      config.remote_host = remote_host.getText();
      is_remote_ip4 = getIP(new byte[4], 0, config.remote_host);
      str = SQL.numbers(remote_port.getText());
      if (str.length() == 0) throw new Exception("Invalid remote port");
      num = Integer.valueOf(str);
      if (num < 1 || num > 65535) throw new Exception("Invalid remote port");
      config.remote_port = num;

      config.socks4 = socks4.isSelected();
      config.socks5 = socks5.isSelected();
      config.secure = secure.isSelected();

      config.user = user.getText();
      config.pass = pass.getText();

      server = new Server();
      server.ss = new ServerSocket(config.local_port);
      server.start();
      connect.setText("Cancel");
      setState(false);
      saveConfig();
    } catch (Exception e) {
      e.printStackTrace();
      JFAWT.showError("Error", e.toString());
    }
  }

  public void setState(boolean state) {
    socks_server.setEditable(state);
    socks_port.setEditable(state);
    socks4.setEnabled(state);
    socks5.setEnabled(state);
    secure.setEnabled(state);
    user.setEditable(state);
    pass.setEnabled(state);
    local_port.setEnabled(state);
    remote_host.setEnabled(state);
    remote_port.setEnabled(state);
  }

  public static class Server extends Thread {
    public ServerSocket ss;
    public boolean active;
    public void run() {
      active = true;
      while (active) {
        try {
          Socket s = ss.accept();
          Client client = new Client();
          client.c = s;
          client.start();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    public void close() {
      active = false;
      try {
        ss.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static boolean is_remote_ip4;

  public static boolean getIP(byte[] packet, int offset, String ip) {
    String[] ip4 = ip.split("[.]");
    if (ip4.length != 4) return false;
    for(int a=0;a<4;a++) {
      int value = Integer.valueOf(ip4[a]);
      if (value < 0 || value > 255) return false;
      packet[offset+a] = (byte)value;
    }
    return true;
  }

  public static void printArray(byte[] array, String msg) {
    StringBuilder sb = new StringBuilder();
    sb.append(msg);
    sb.append("=[");
    for(int a=0;a<array.length;a++) {
      if (a > 0) sb.append(",");
      sb.append(String.format("%02x", array[a] & 0xff));
    }
    sb.append("]");
    JFLog.log(sb.toString());
  }

  public static class Client extends Thread {
    public Socket c, s;
    //public InputStream cis;
    //public OutputStream cos;
    public InputStream sis;
    public OutputStream sos;
    private ProxyData pd1, pd2;
    public void run() {
      byte[] req;
      byte[] reply;
      try {
        //cis = c.getInputStream();
        //cos = c.getOutputStream();
        //connect to SOCKS server
        JFLog.log("Connecting to:" + config.socks_server + ":" + config.socks_port + ":secure=" + config.secure);
        if (config.secure) {
          KeyMgmt keys = new KeyMgmt();
          if (new File(getKeyFile()).exists()) {
            FileInputStream fis = new FileInputStream(getKeyFile());
            keys.open(fis, "password".toCharArray());
            fis.close();
          } else {
            JFLog.log("Warning:Client SSL keys not generated!");
          }
          s = JF.connectSSL(config.socks_server, config.socks_port/*, keys*/);
        } else {
          s = new Socket(config.socks_server, config.socks_port);
        }
        if (s == null) throw new Exception("Connection to SOCKS server failed");
        sis = s.getInputStream();
        sos = s.getOutputStream();
        JFLog.log("Connected to SOCKS server");
        //init connection
        if (config.socks4) {
          if (is_remote_ip4) {
            //ip4
            req = new byte[9];
            req[0] = 0x04;  //SOCKS ver 4
            req[1] = 0x01;  //connect
            BE.setuint16(req, 2, config.remote_port);
            getIP(req, 4, config.remote_host);
            sos.write(req);
            reply = new byte[8];
            if (!JF.readAll(sis, reply, 0, reply.length)) {
              throw new Exception("SOCKS4:read failed");
            }
            if (reply[1] != 0x5a) throw new Exception("SOCKS4 connection failed");
          } else {
            //TODO : domain
            throw new Exception("remote domain not implemented yet");
          }
        } else {
          req = new byte[3];
          //send auth type
          req[0] = 0x05;  //SOCKS ver 5
          req[1] = 1;  //nauth
          req[2] = 0x02;  //user/pass auth type
          sos.write(req);
          reply = new byte[2];
          if (!JF.readAll(sis, reply, 0, reply.length)) {
            throw new Exception("SOCKS5:read failed");
          }
          if (reply[1] != 0x02) throw new Exception("SOCKS5 auth type not supported");
          //send user/pass
          byte[] user = config.user.getBytes();
          byte[] pass = config.pass.getBytes();
          req = new byte[3 + user.length + pass.length];
          req[0] = 0x01;  //auth type ver
          req[1] = (byte)user.length;
          System.arraycopy(user, 0, req, 2, user.length);
          req[2 + user.length] = (byte)pass.length;
          System.arraycopy(pass, 0, req, 3 + user.length, pass.length);
          sos.write(req);
          reply = new byte[2];
          if (!JF.readAll(sis, reply, 0, reply.length)) {
            throw new Exception("SOCKS5:read failed");
          }
          if (reply[1] != 0x00) throw new Exception("SOCKS5 auth failed");
          if (is_remote_ip4) {
            req = new byte[10];
            req[0] = 0x05;  //SOCKS ver 5
            req[1] = 0x01;  //connect command
            //req[2] = reserved
            req[3] = 0x01;  //IP4 address
            getIP(req, 4, config.remote_host);
            BE.setuint16(req, 8, config.remote_port);
            sos.write(req);
            reply = new byte[10];
            if (!JF.readAll(sis, reply, 0, reply.length)) {
              throw new Exception("SOCKS5:read failed");
            }
            if (reply[1] != 0x00) throw new Exception("SOCKS5 connect failed");
          } else {
            //TODO : domain
            throw new Exception("remote domain not implemented yet");
          }
        }
        JFLog.log("Connection complete");
        //relay data between sockets
        pd1 = new ProxyData(c,s,"1");
        pd1.start();
        pd2 = new ProxyData(s,c,"2");
        pd2.start();
        pd1.join();
        pd2.join();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static class ProxyData extends Thread {
    private Socket sRead;
    private Socket sWrite;
    private volatile boolean active;
    private String name;
    public ProxyData(Socket sRead, Socket sWrite, String name) {
      this.sRead = sRead;
      this.sWrite = sWrite;
      this.name = name;
    }
    public void run() {
      try {
        InputStream is = sRead.getInputStream();
        OutputStream os = sWrite.getOutputStream();
        byte[] buf = new byte[1500];
        active = true;
        while (active) {
          int read = is.read(buf);
          if (read < 0) throw new Exception("bad read:pd" + name);
          if (read > 0) {
            os.write(buf, 0, read);
          }
        }
      } catch (Exception e) {
        try {sRead.close();} catch (Exception e2) {}
        try {sWrite.close();} catch (Exception e2) {}
      }
    }
    public void close() {
      active = false;
    }
  }

  public void loadConfig() {
    config = (Config)JF.readObject(JF.getUserPath() + "/.jfsocks-client.cfg");
    if (config == null) config = new Config();
    //apply to fields
    if (config.socks_server != null) {
      socks_server.setText(config.socks_server);
    }
    if (config.socks_port != 0) {
      socks_port.setText(Integer.toString(config.socks_port));
    }
    secure.setSelected(config.secure);
    socks4.setSelected(config.socks4);
    socks5.setSelected(config.socks5);
    if (config.user != null) {
      user.setText(config.user);
    }
    if (config.pass != null) {
      pass.setText(config.pass);
    }
    if (config.local_port != 0) {
      local_port.setText(Integer.toString(config.local_port));
    }
    if (config.remote_host != null) {
      remote_host.setText(config.remote_host);
    }
    if (config.remote_port != 0) {
      remote_port.setText(Integer.toString(config.remote_port));
    }
  }

  public void saveConfig() {
    JF.writeObject(config, JF.getUserPath() + "/.jfsocks-client.cfg");
  }

  public static String getKeyFile() {
    return JF.getUserPath() + "/.jfsocks.key";
  }

  public void genKeys() {
    if (KeyMgmt.keytool(new String[] {
      "-genkey", "-debug", "-alias", "jfsocks", "-keypass", "password", "-storepass", "password",
      "-keystore", getKeyFile(), "-validity", "3650", "-dname", "CN=jfsocks.sourceforge.net, OU=user, O=client, C=CA",
      "-keyalg" , "RSA", "-keysize", "2048"
    })) {
      JFAWT.showMessage("GenKeys", "OK");
    } else {
      JFAWT.showMessage("GenKeys", "Error");
    }
  }
}
