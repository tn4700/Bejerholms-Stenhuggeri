/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import control.DBConnection;
import java.sql.SQLException;

/**
 *
 * @author T
 */
public class Panel_DBConnect extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel1
     */
    private DBConnection db;
    
    public Panel_DBConnect() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_DBconn = new javax.swing.JPanel();
        jLabe_DBnavn = new javax.swing.JLabel();
        jLabel_Port = new javax.swing.JLabel();
        jLabel_Host = new javax.swing.JLabel();
        jLabel_Brugernavn = new javax.swing.JLabel();
        jLabel_Password = new javax.swing.JLabel();
        jTextField_DBnavn = new javax.swing.JTextField();
        jTextField_Port = new javax.swing.JTextField();
        jTextField_Host = new javax.swing.JTextField();
        jTextField_Brugernavn = new javax.swing.JTextField();
        jTextField_Password = new javax.swing.JTextField();
        jButton_DBconnect = new javax.swing.JButton();
        jLabel_ConnFejlbesked = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_DBconn.setLayout(null);

        jLabe_DBnavn.setText("Databasenavn");
        jPanel_DBconn.add(jLabe_DBnavn);
        jLabe_DBnavn.setBounds(176, 65, 90, 20);

        jLabel_Port.setText("Port");
        jPanel_DBconn.add(jLabel_Port);
        jLabel_Port.setBounds(458, 65, 90, 20);

        jLabel_Host.setText("Host");
        jPanel_DBconn.add(jLabel_Host);
        jLabel_Host.setBounds(176, 142, 90, 20);

        jLabel_Brugernavn.setText("Brugernavn");
        jPanel_DBconn.add(jLabel_Brugernavn);
        jLabel_Brugernavn.setBounds(458, 142, 90, 20);

        jLabel_Password.setText("Password");
        jPanel_DBconn.add(jLabel_Password);
        jLabel_Password.setBounds(176, 220, 90, 20);
        jPanel_DBconn.add(jTextField_DBnavn);
        jTextField_DBnavn.setBounds(176, 90, 140, 30);
        jPanel_DBconn.add(jTextField_Port);
        jTextField_Port.setBounds(456, 90, 140, 30);
        jPanel_DBconn.add(jTextField_Host);
        jTextField_Host.setBounds(176, 164, 140, 30);
        jPanel_DBconn.add(jTextField_Brugernavn);
        jTextField_Brugernavn.setBounds(456, 164, 140, 30);
        jPanel_DBconn.add(jTextField_Password);
        jTextField_Password.setBounds(176, 250, 140, 30);

        jButton_DBconnect.setText("Connect");
        jButton_DBconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DBconnectActionPerformed(evt);
            }
        });
        jPanel_DBconn.add(jButton_DBconnect);
        jButton_DBconnect.setBounds(310, 380, 170, 40);
        jPanel_DBconn.add(jLabel_ConnFejlbesked);
        jLabel_ConnFejlbesked.setBounds(370, 320, 0, 0);

        add(jPanel_DBconn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 959, 567));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_DBconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DBconnectActionPerformed
        // sætter db info
        try{
        db = new DBConnection(jTextField_Host.getText(), jTextField_Port.getText(), jTextField_DBnavn.getText(), 
                jTextField_Brugernavn.getText(), jTextField_Password.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (db.isConnected()) {
            MainFrame mainFrame = new MainFrame(db);
        } else {
            jLabel_ConnFejlbesked.setForeground(Color.red);
            jLabel_ConnFejlbesked.setText("Forbindelsen fejlede - kontroller felterne");
        }
    }//GEN-LAST:event_jButton_DBconnectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DBconnect;
    private javax.swing.JLabel jLabe_DBnavn;
    private javax.swing.JLabel jLabel_Brugernavn;
    private javax.swing.JLabel jLabel_ConnFejlbesked;
    private javax.swing.JLabel jLabel_Host;
    private javax.swing.JLabel jLabel_Password;
    private javax.swing.JLabel jLabel_Port;
    private javax.swing.JPanel jPanel_DBconn;
    private javax.swing.JTextField jTextField_Brugernavn;
    private javax.swing.JTextField jTextField_DBnavn;
    private javax.swing.JTextField jTextField_Host;
    private javax.swing.JTextField jTextField_Password;
    private javax.swing.JTextField jTextField_Port;
    // End of variables declaration//GEN-END:variables
}
