/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBConnection;
import control.DatabaseObjectHandler;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import model.User;

/**
 *
 * @author T
 */
public class Login extends javax.swing.JFrame {

    private DatabaseObjectHandler dbhandler;
    private DBConnection db;
    private CardLayout layout;

    /**
     * Creates new form Login
     */
    public Login() {
          try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }  
        initComponents();
        // set icon til windows toolbar og vinduet
         java.net.URL url = ClassLoader.getSystemResource("img/icon.png");        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        this.setIconImage(img);
        
       // sæt den til at tryk på login knappen ved klik på enter
        // sæt Søge knappen til at væred en knap der trykker på når der trykker ENTER på keyboardet
        JRootPane rootPane = this.getRootPane();
        rootPane.setDefaultButton(jButton_Login);
        layout = (CardLayout) (jPanel_MainCard.getLayout());
        
      


        try {
            db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");

        } catch (Exception ex) {
            System.out.println("fejl: " + ex);
        }

        if (db.isConnected() == false) {
            layout.show(jPanel_MainCard, "DB");
        }
 dbhandler = new DatabaseObjectHandler(db);

    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_MainCard = new javax.swing.JPanel();
        jPanel_Login = new javax.swing.JPanel();
        jPanel_LoginRamme = new javax.swing.JPanel();
        jButton_Login = new javax.swing.JButton();
        jTextField_Brugernavn = new javax.swing.JTextField();
        jLabel_BrugerNavn = new javax.swing.JLabel();
        jLabel_BrugerKode = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Kodeord = new javax.swing.JPasswordField();
        jLabel_LoginOverskrift = new javax.swing.JLabel();
        jPanel_DB = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField_port = new javax.swing.JTextField();
        jTextField_dbNavn = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Host = new javax.swing.JTextField();
        jTextField_user = new javax.swing.JTextField();
        jTextField_pw = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel_fejl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(231, 231, 231));
        setMinimumSize(new java.awt.Dimension(640, 450));
        setPreferredSize(new java.awt.Dimension(643, 450));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_MainCard.setOpaque(false);
        jPanel_MainCard.setPreferredSize(new java.awt.Dimension(580, 430));
        jPanel_MainCard.setLayout(new java.awt.CardLayout());

        jPanel_Login.setBackground(new java.awt.Color(231, 231, 231));
        jPanel_Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_LoginRamme.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton_Login.setText("Login");
        jButton_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LoginActionPerformed(evt);
            }
        });

        jTextField_Brugernavn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel_BrugerNavn.setText("Brugernavn");

        jLabel_BrugerKode.setText("Kodeord");

        jTextField_Kodeord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel_LoginRammeLayout = new javax.swing.GroupLayout(jPanel_LoginRamme);
        jPanel_LoginRamme.setLayout(jPanel_LoginRammeLayout);
        jPanel_LoginRammeLayout.setHorizontalGroup(
            jPanel_LoginRammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LoginRammeLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(jTextField_Kodeord, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(jPanel_LoginRammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_LoginRammeLayout.createSequentialGroup()
                    .addGap(0, 173, Short.MAX_VALUE)
                    .addGroup(jPanel_LoginRammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_BrugerNavn)
                        .addComponent(jTextField_Brugernavn, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_BrugerKode)
                        .addComponent(jButton_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 174, Short.MAX_VALUE)))
        );
        jPanel_LoginRammeLayout.setVerticalGroup(
            jPanel_LoginRammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_LoginRammeLayout.createSequentialGroup()
                .addContainerGap(161, Short.MAX_VALUE)
                .addComponent(jTextField_Kodeord, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel_LoginRammeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_LoginRammeLayout.createSequentialGroup()
                    .addGap(0, 36, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel_BrugerNavn)
                    .addGap(11, 11, 11)
                    .addComponent(jTextField_Brugernavn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(jLabel_BrugerKode)
                    .addGap(76, 76, 76)
                    .addComponent(jButton_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanel_Login.add(jPanel_LoginRamme, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 330));

        jLabel_LoginOverskrift.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_LoginOverskrift.setText("Log ind");
        jPanel_Login.add(jLabel_LoginOverskrift, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel_MainCard.add(jPanel_Login, "Login");

        jPanel_DB.setBackground(new java.awt.Color(231, 231, 231));
        jPanel_DB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField_port.setText("3306");

        jTextField_dbNavn.setText("bejerholmstenhuggeri");

        jLabel7.setText("Databasenavn");

        jLabel4.setText("Port");

        jLabel5.setText("Brugernavn");

        jLabel6.setText("Host:");

        jTextField_Host.setText("Localhost");

        jTextField_user.setText("root");

        jTextField_pw.setText("1234");

        jLabel8.setText("Password");

        jButton2.setText("Opret Forbindelse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(120, 120, 120)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_dbNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jTextField_port, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(164, 164, 164)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_Host, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jTextField_user, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(jTextField_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_fejl, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_fejl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_dbNavn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_port, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Host, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(jTextField_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jPanel_DB.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Indtast database oplysninger");
        jLabel9.setToolTipText("");
        jPanel_DB.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel_MainCard.add(jPanel_DB, "DB");

        getContentPane().add(jPanel_MainCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LoginActionPerformed

        try {
            User bruger = dbhandler.getUser(jTextField_Brugernavn.getText());
            if (bruger != null) {
                if (bruger.getPassword().equals(jTextField_Kodeord.getText())) {
                    jLabel3.setText("Det er den rigtige bruger");
                   MainFrame frame = new MainFrame(db, bruger);
                  frame.show();
                  this.dispose();
                  
                } else {
                    jLabel3.setText("forkert brugernavn eller kode.");
                }
            } else {
                jLabel3.setText("Brugernavnet findes ikke");
            }


        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_jButton_LoginActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        db.setDbNavn(jTextField_dbNavn.getText());
        db.setHost(jTextField_Host.getText());
        db.setPort(jTextField_port.getText());
        db.setUser(jTextField_user.getText());
        db.setPw(jTextField_pw.getText());

        db.connect();
        if (db.isConnected()) {
            layout.show(jPanel_MainCard, "Login");
            } else {

            jLabel_fejl.setText("Det er ikke muligt at oprette forbindelse til databasen!");

        }




        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_Login;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_BrugerKode;
    private javax.swing.JLabel jLabel_BrugerNavn;
    private javax.swing.JLabel jLabel_LoginOverskrift;
    private javax.swing.JLabel jLabel_fejl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_DB;
    private javax.swing.JPanel jPanel_Login;
    private javax.swing.JPanel jPanel_LoginRamme;
    private javax.swing.JPanel jPanel_MainCard;
    private javax.swing.JTextField jTextField_Brugernavn;
    private javax.swing.JTextField jTextField_Host;
    private javax.swing.JPasswordField jTextField_Kodeord;
    private javax.swing.JTextField jTextField_dbNavn;
    private javax.swing.JTextField jTextField_port;
    private javax.swing.JTextField jTextField_pw;
    private javax.swing.JTextField jTextField_user;
    // End of variables declaration//GEN-END:variables
}
