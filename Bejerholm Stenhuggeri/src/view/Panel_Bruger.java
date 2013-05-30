/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBConnection;
import control.DatabaseObjectHandler;
import control.exceptions.ControlException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author T
 */
public class Panel_Bruger extends javax.swing.JPanel {

    private DatabaseObjectHandler dbhandler;
    private DBConnection db;
    private User user;
    private ArrayList<User> userlist;
    User valgtebruger;

    /**
     * Creates new form Panel_Bruger
     */
    public Panel_Bruger(DBConnection db) {
        this.db = db;
        dbhandler = new DatabaseObjectHandler(db);
        initComponents();
        // fiktiv ham der er logget ind
        user = new User("Mathias Bejerholm", "123");
        try {
            userlist = dbhandler.getUserList();
        } catch (SQLException ex) {
            System.out.println("Der kunne ikke hentes brugere" + ex);
        }
        for (int i = 0; i < userlist.size(); i++) {
            jComboBox_Brugere.addItem(userlist.get(i));
        }
        if (user.getUsername().equals("Mathias Bejerholm")) {
            jPanel_redigerbruger.setVisible(false);
        } else {
            jPanel_admin.setVisible(false);
            jPanel_Opretbruger.setVisible(false);
        }
        jLabel_brugerNavn.setText("" + user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_brugerNavn = new javax.swing.JLabel();
        jLabel_brugerinfo = new javax.swing.JLabel();
        jPanel_Opretbruger = new javax.swing.JPanel();
        jTextField_opretVælgbrugernavn = new javax.swing.JTextField();
        jTextField_opretKode = new javax.swing.JTextField();
        jTextField_opretGenskrivkode = new javax.swing.JTextField();
        jButton_opret = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel_redigerbruger = new javax.swing.JPanel();
        jButton_Redigerret = new javax.swing.JButton();
        jTextField_redigerbrugerKode = new javax.swing.JTextField();
        jTextField_redigerbrugerKodeNu = new javax.swing.JTextField();
        jPanel_admin = new javax.swing.JPanel();
        jComboBox_Brugere = new javax.swing.JComboBox();
        jTextField_adminbrugerKode = new javax.swing.JTextField();
        jButton_adminret = new javax.swing.JButton();
        jButton_adminslet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_brugerNavn.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel_brugerNavn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_brugerNavn.setText("[Navn]");
        add(jLabel_brugerNavn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 360, 60));

        jLabel_brugerinfo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel_brugerinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLabel_brugerinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 490, 110));

        jPanel_Opretbruger.setBorder(javax.swing.BorderFactory.createTitledBorder("Opret bruger"));
        jPanel_Opretbruger.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_opretVælgbrugernavn.setText("[Vælg bruger navn]");
        jTextField_opretVælgbrugernavn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_opretVælgbrugernavnMousePressed(evt);
            }
        });
        jPanel_Opretbruger.add(jTextField_opretVælgbrugernavn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, -1));

        jTextField_opretKode.setText("[Kode]");
        jTextField_opretKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_opretKodeMousePressed(evt);
            }
        });
        jPanel_Opretbruger.add(jTextField_opretKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 140, -1));

        jTextField_opretGenskrivkode.setText("[genskriv kode]");
        jTextField_opretGenskrivkode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_opretGenskrivkodeMousePressed(evt);
            }
        });
        jPanel_Opretbruger.add(jTextField_opretGenskrivkode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 140, -1));

        jButton_opret.setText("opret");
        jButton_opret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_opretActionPerformed(evt);
            }
        });
        jPanel_Opretbruger.add(jButton_opret, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel4.setText("Ny kode:");
        jPanel_Opretbruger.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, 28));

        jLabel3.setText("Navn:");
        jPanel_Opretbruger.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, 28));

        jLabel5.setText("Gens. Kode:");
        jPanel_Opretbruger.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 28));

        add(jPanel_Opretbruger, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 240, 220));

        jPanel_redigerbruger.setBorder(javax.swing.BorderFactory.createTitledBorder("Redigér bruger"));
        jPanel_redigerbruger.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Redigerret.setText("Ret Kode!");
        jButton_Redigerret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RedigerretActionPerformed(evt);
            }
        });
        jPanel_redigerbruger.add(jButton_Redigerret, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 90, 30));

        jTextField_redigerbrugerKode.setText("[Ny kode]");
        jTextField_redigerbrugerKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_redigerbrugerKodeMousePressed(evt);
            }
        });
        jPanel_redigerbruger.add(jTextField_redigerbrugerKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, -1));

        jTextField_redigerbrugerKodeNu.setText("[Nuværende Kode]");
        jTextField_redigerbrugerKodeNu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_redigerbrugerKodeNuMousePressed(evt);
            }
        });
        jPanel_redigerbruger.add(jTextField_redigerbrugerKodeNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 150, -1));

        add(jPanel_redigerbruger, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 240, 220));

        jPanel_admin.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin bruger redigering"));
        jPanel_admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_Brugere.setMaximumSize(new java.awt.Dimension(62, 28));
        jComboBox_Brugere.setMinimumSize(new java.awt.Dimension(62, 28));
        jComboBox_Brugere.setPreferredSize(null);
        jComboBox_Brugere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_BrugereActionPerformed(evt);
            }
        });
        jPanel_admin.add(jComboBox_Brugere, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 50, 150, 28));

        jTextField_adminbrugerKode.setText("[Ny kode]");
        jTextField_adminbrugerKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_adminbrugerKodeMousePressed(evt);
            }
        });
        jPanel_admin.add(jTextField_adminbrugerKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 90, 150, -1));

        jButton_adminret.setText("Ret!");
        jButton_adminret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_adminretActionPerformed(evt);
            }
        });
        jPanel_admin.add(jButton_adminret, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, -1));

        jButton_adminslet.setText("Slet Bruger");
        jButton_adminslet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_adminsletActionPerformed(evt);
            }
        });
        jPanel_admin.add(jButton_adminslet, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 90, -1));

        jLabel1.setText("Bruger:");
        jPanel_admin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 28));

        jLabel2.setText("Ny kode:");
        jPanel_admin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 50, 28));

        add(jPanel_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 240, 220));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_adminsletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_adminsletActionPerformed
        try {
            if (valgtebruger.getUsername().equals("Mathias Bejerholm")) {
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='red'>Advarsel!</font> </head><body><br>Brugernavnet på admin kan ikke rettes på systemmet,<br>eller slettes.</body></html>");
            } else {
                dbhandler.deleteUser(valgtebruger);
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='green'>Success!</font> </head><body><br>" + jComboBox_Brugere.getSelectedItem() + " er slettet fra systemmet.</body></html>");
                jComboBox_Brugere.removeItem(valgtebruger);
            }
        } catch (SQLException e) {
            System.out.println("fejl ved seltbutton" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en fejl under sletningen af en bruger\nKontrollér evt. der er forbindelse til databasen",
                    "Hov! Beklager",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("fejl ved seltbutton" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en ukendt fejl ved sletning af en bruger.",
                    "Hov! Beklager",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton_adminsletActionPerformed

    private void jButton_adminretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_adminretActionPerformed
        try {
            if (valgtebruger.getUsername().equals("Mathias Bejerholm")) {
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='red'>Advarsel!</front></head><body><br>Brugernavnet på admin kan ikke rettes på systemmet.</body></html>");

            } else {
                valgtebruger.setPassword(jTextField_adminbrugerKode.getText());
                dbhandler.editUser(valgtebruger);
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='green'>Godkendt!</font></head><body><br>Koderen er nu ændret.</body></html>");
            }
        } catch (SQLException e) {
            System.out.println("fejl ved retbuttonadmin" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en fejl ved redigering af en bruger\nKontrollér evt. du har fordindelse til databasen",
                    "Hov! Beklager",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("fejl ved retbuttonadmin" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en ukendt fejl ved redigering af en bruger",
                    "Hov! Beklager",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_adminretActionPerformed

    private void jButton_RedigerretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RedigerretActionPerformed
        try {
            if (user.getPassword().equals(jTextField_redigerbrugerKodeNu.getText()) && !user.getPassword().equals(jTextField_redigerbrugerKode.getText())) {
                user.setPassword(jTextField_redigerbrugerKode.getText());
                dbhandler.editUser(user);
                System.out.println("jeg har rettet kodefelt 2");
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='green'>Success!</font></head><body><br>Koderen er nu ændret.</body></html>");
            } else {
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"><font color='red'>Mislykkedes!</font></head><body><br>Der opstod en fejl ved ændring af kode.<br>Kontroller evt. nuværende kode og sørg for du ikke ændre til din gamle kode.</body></html>");

            }
        } catch (SQLException e) {
            System.out.println("fejl sqlexception ved redigerbutton2" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en fejl under kommunikationen med databasen\nKontrollér evt. der er forbindelse til Databasen.",
                    "Hov! Beklager.",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("fejl exception ukendt ved regiderbutton2" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en ukendt fejl",
                    "Hov! Beklager.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_RedigerretActionPerformed

    private void jTextField_redigerbrugerKodeNuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_redigerbrugerKodeNuMousePressed
        jTextField_redigerbrugerKodeNu.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_redigerbrugerKodeNuMousePressed

    private void jTextField_redigerbrugerKodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_redigerbrugerKodeMousePressed
        jTextField_redigerbrugerKode.setText("");
    }//GEN-LAST:event_jTextField_redigerbrugerKodeMousePressed

    private void jButton_opretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_opretActionPerformed

        if (jTextField_opretKode.getText().equals(jTextField_opretGenskrivkode.getText())) {
            user.setUsername(jTextField_opretVælgbrugernavn.getText());
            user.setPassword(jTextField_opretKode.getText());
            jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='green'>Success!</font></head><body><br>Brugeren " + jTextField_opretVælgbrugernavn.getText() + " er oprettet.</body></html>");
            jComboBox_Brugere.addItem(user);
            try {
                dbhandler.createUser(user);
            } catch (SQLException e) {
                System.out.println("vghg" + e);
            } catch (ControlException ex) {
                System.out.println("Control exception " + ex);
            } catch (Exception e) {
                System.out.println("Exception ukendt fe" + e);
            }
        } else {
            jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"><font color='red'>Mislykkeds!</font></head><body><br>Koden er ikke ens.</body></html>");
        }



//                jLabel_brugerinfo.setText("Brugernavnet: "+jTextField_opretVælgbrugernavn.getText()+" er optaget");
    }//GEN-LAST:event_jButton_opretActionPerformed

    private void jTextField_opretVælgbrugernavnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretVælgbrugernavnMousePressed
        jTextField_opretVælgbrugernavn.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretVælgbrugernavnMousePressed

    private void jTextField_opretKodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretKodeMousePressed
        jTextField_opretKode.setText("");  // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretKodeMousePressed

    private void jTextField_opretGenskrivkodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretGenskrivkodeMousePressed
        jTextField_opretGenskrivkode.setText("");    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretGenskrivkodeMousePressed

    private void jTextField_adminbrugerKodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_adminbrugerKodeMousePressed
        jTextField_adminbrugerKode.setText("");
    }//GEN-LAST:event_jTextField_adminbrugerKodeMousePressed

    private void jComboBox_BrugereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_BrugereActionPerformed
        valgtebruger = (User) jComboBox_Brugere.getSelectedItem();
    }//GEN-LAST:event_jComboBox_BrugereActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Redigerret;
    private javax.swing.JButton jButton_adminret;
    private javax.swing.JButton jButton_adminslet;
    private javax.swing.JButton jButton_opret;
    private javax.swing.JComboBox jComboBox_Brugere;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_brugerNavn;
    private javax.swing.JLabel jLabel_brugerinfo;
    private javax.swing.JPanel jPanel_Opretbruger;
    private javax.swing.JPanel jPanel_admin;
    private javax.swing.JPanel jPanel_redigerbruger;
    private javax.swing.JTextField jTextField_adminbrugerKode;
    private javax.swing.JTextField jTextField_opretGenskrivkode;
    private javax.swing.JTextField jTextField_opretKode;
    private javax.swing.JTextField jTextField_opretVælgbrugernavn;
    private javax.swing.JTextField jTextField_redigerbrugerKode;
    private javax.swing.JTextField jTextField_redigerbrugerKodeNu;
    // End of variables declaration//GEN-END:variables
}
