/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBConnection;
import control.DatabaseObjectHandler;
import control.exceptions.ControlException;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            //      
            userlist = dbhandler.getUserList();
        } catch (SQLException ex) {
            System.out.println("Der kunne ikke henstes brugere" + ex);
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
        jLabel_brugerNavn.setText("Goddag " + user);

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
        jPanel_redigerbruger = new javax.swing.JPanel();
        jButton_Rediger2 = new javax.swing.JButton();
        jTextField_brugerKode2 = new javax.swing.JTextField();
        jTextField_brugerKodeNu = new javax.swing.JTextField();
        jPanel_admin = new javax.swing.JPanel();
        jComboBox_Brugere = new javax.swing.JComboBox();
        jButton_Hent = new javax.swing.JButton();
        jTextField_brugerNavn = new javax.swing.JTextField();
        jTextField_brugerKode = new javax.swing.JTextField();
        jButton_Rediger = new javax.swing.JButton();
        jButton_Slet = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_brugerNavn.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel_brugerNavn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_brugerNavn.setText("[Navn]");
        add(jLabel_brugerNavn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 360, 60));

        jLabel_brugerinfo.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel_brugerinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLabel_brugerinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 490, 110));

        jPanel_Opretbruger.setBorder(javax.swing.BorderFactory.createTitledBorder("Opret bruger"));
        jPanel_Opretbruger.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField_opretVælgbrugernavn.setText("[Vælg bruger navn]");
        jTextField_opretVælgbrugernavn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_opretVælgbrugernavnMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_opretVælgbrugernavnMousePressed(evt);
            }
        });
        jPanel_Opretbruger.add(jTextField_opretVælgbrugernavn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, -1));

        jTextField_opretKode.setText("[Kode]");
        jTextField_opretKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_opretKodeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_opretKodeMousePressed(evt);
            }
        });
        jPanel_Opretbruger.add(jTextField_opretKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 140, -1));

        jTextField_opretGenskrivkode.setText("[genskriv kode]");
        jTextField_opretGenskrivkode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_opretGenskrivkodeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_opretGenskrivkodeMousePressed(evt);
            }
        });
        jPanel_Opretbruger.add(jTextField_opretGenskrivkode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 140, -1));

        jButton_opret.setText("opret");
        jButton_opret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_opretActionPerformed(evt);
            }
        });
        jPanel_Opretbruger.add(jButton_opret, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        add(jPanel_Opretbruger, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 240, 220));

        jPanel_redigerbruger.setBorder(javax.swing.BorderFactory.createTitledBorder("Redigér bruger"));
        jPanel_redigerbruger.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Rediger2.setText("Ret Kode!");
        jButton_Rediger2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Rediger2ActionPerformed(evt);
            }
        });
        jPanel_redigerbruger.add(jButton_Rediger2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 110, 30));

        jTextField_brugerKode2.setText("[Ny kode]");
        jTextField_brugerKode2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_brugerKode2MousePressed(evt);
            }
        });
        jTextField_brugerKode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_brugerKode2ActionPerformed(evt);
            }
        });
        jPanel_redigerbruger.add(jTextField_brugerKode2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, -1));

        jTextField_brugerKodeNu.setText("[Nuværende Kode]");
        jTextField_brugerKodeNu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField_brugerKodeNuMousePressed(evt);
            }
        });
        jPanel_redigerbruger.add(jTextField_brugerKodeNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 150, -1));

        add(jPanel_redigerbruger, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 240, 220));

        jPanel_admin.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin bruger redigering"));
        jPanel_admin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_Brugere.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jComboBox_BrugereComponentRemoved(evt);
            }
        });
        jComboBox_Brugere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_BrugereActionPerformed(evt);
            }
        });
        jPanel_admin.add(jComboBox_Brugere, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 130, -1));

        jButton_Hent.setText("Hent Bruger");
        jButton_Hent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_HentActionPerformed(evt);
            }
        });
        jPanel_admin.add(jButton_Hent, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 100, 40));

        jTextField_brugerNavn.setText("Bruger Navn");
        jTextField_brugerNavn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_brugerNavnActionPerformed(evt);
            }
        });
        jPanel_admin.add(jTextField_brugerNavn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 135, -1));

        jTextField_brugerKode.setText("[Ny kode]");
        jPanel_admin.add(jTextField_brugerKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 135, -1));

        jButton_Rediger.setText("Ret!");
        jButton_Rediger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RedigerActionPerformed(evt);
            }
        });
        jPanel_admin.add(jButton_Rediger, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, -1));

        jButton_Slet.setText("Slet Bruger");
        jButton_Slet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SletActionPerformed(evt);
            }
        });
        jPanel_admin.add(jButton_Slet, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 90, -1));

        add(jPanel_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 240, 220));
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_BrugereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_BrugereActionPerformed
    }//GEN-LAST:event_jComboBox_BrugereActionPerformed

    private void jTextField_brugerNavnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_brugerNavnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_brugerNavnActionPerformed

    private void jButton_HentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_HentActionPerformed
        valgtebruger = (User) jComboBox_Brugere.getSelectedItem();
        jTextField_brugerNavn.setText(valgtebruger.getUsername());
    }//GEN-LAST:event_jButton_HentActionPerformed

    private void jButton_SletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SletActionPerformed
        try {
            if (valgtebruger.getUsername().equals("Mathias Bejerholm")) {
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='red'>Advarsel!</front></head><body><br>Brugernavnet på admin kan ikke rettes på systemmet,<br>eller slettes.</body></html>");
            } else {
                dbhandler.deleteUser(valgtebruger);
                jComboBox_Brugere.removeItem(valgtebruger);
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='green'>Success!</font> </head><body><br>" + jTextField_brugerNavn.getText() + " er slettet fra systemmet.</body></html>");
            }
        } catch (Exception e) {
            System.out.println("fejl ved seltbutton" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en fejl ved sletning af en bruger\nHusk at 'Hent Bruger' før du sletter/retter.",
                    "Hov! Beklager fejlen",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton_SletActionPerformed

    private void jButton_RedigerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RedigerActionPerformed
        try {
            if (valgtebruger.getUsername().equals("Bejerholm")) {
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='red'>Advarsel!</front></head><body><br>Brugernavnet på admin kan ikke rettes på systemmet.</body></html>");

            } else {
                valgtebruger.setPassword(jTextField_brugerKode.getText());
                dbhandler.editUser(valgtebruger);
                jLabel_brugerinfo.setText("<html><div style=\"text-align: center;\"> <font color='green'>Godkendt!</font><body><br>Koderen er nu ændret.</body></html>");
            }
        } catch (Exception e) {
            System.out.println("fejl ved retbuttonadmin" + e);
            JOptionPane.showMessageDialog(null,
                    "Der opstod en fejl ved redigering af en bruger\nHusk at 'Hent Bruger' før du sletter/retter.",
                    "Hov! Beklager fejlen",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton_RedigerActionPerformed

    private void jButton_Rediger2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Rediger2ActionPerformed
        try {
            if (user.getPassword().equals(jTextField_brugerKodeNu.getText()) && !user.getPassword().equals(jTextField_brugerKode2.getText())) {
                user.setPassword(jTextField_brugerKode2.getText());
                dbhandler.editUser(user);
                System.out.println("jeg har rettet kodefelt 2");
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='green'>Success!</font></head><body><br>Koderen er nu ændret.</body></html>");
            } else {
                jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"><font color='red'>Mislykkedes!</font></head><body><br>Der opstod en fejl ved ændring af kode.<br>Kontroller evt. nuværende kode og sørg for du ikke ændre til din gamle kode.</body></html>");

            }
        } catch (Exception e) {
            System.out.println("feg" + e);
        }
    }//GEN-LAST:event_jButton_Rediger2ActionPerformed

    private void jTextField_brugerKode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_brugerKode2ActionPerformed
    }//GEN-LAST:event_jTextField_brugerKode2ActionPerformed

    private void jTextField_brugerKodeNuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_brugerKodeNuMousePressed
        jTextField_brugerKodeNu.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_brugerKodeNuMousePressed

    private void jTextField_brugerKode2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_brugerKode2MousePressed
        jTextField_brugerKode2.setText("");
    }//GEN-LAST:event_jTextField_brugerKode2MousePressed

    private void jComboBox_BrugereComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jComboBox_BrugereComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_BrugereComponentRemoved

    private void jButton_opretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_opretActionPerformed

        if (jTextField_opretKode.getText().equals(jTextField_opretGenskrivkode.getText())) {
            user.setUsername(jTextField_opretVælgbrugernavn.getText());
            user.setPassword(jTextField_opretKode.getText());
            jLabel_brugerinfo.setText("<html><head><div style=\"text-align: center;\"> <font color='green'>Success!</font></head><body><br>Brugeren "+jTextField_opretVælgbrugernavn.getText()+" er oprettet.</body></html>");
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

    private void jTextField_opretVælgbrugernavnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretVælgbrugernavnMouseClicked
    }//GEN-LAST:event_jTextField_opretVælgbrugernavnMouseClicked

    private void jTextField_opretKodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretKodeMouseClicked
        jTextField_opretKode.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretKodeMouseClicked

    private void jTextField_opretGenskrivkodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretGenskrivkodeMouseClicked
        jTextField_opretGenskrivkode.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretGenskrivkodeMouseClicked

    private void jTextField_opretVælgbrugernavnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretVælgbrugernavnMousePressed
        jTextField_opretVælgbrugernavn.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretVælgbrugernavnMousePressed

    private void jTextField_opretKodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretKodeMousePressed
        jTextField_opretKode.setText("");  // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretKodeMousePressed

    private void jTextField_opretGenskrivkodeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_opretGenskrivkodeMousePressed
        jTextField_opretGenskrivkode.setText("");    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_opretGenskrivkodeMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Hent;
    private javax.swing.JButton jButton_Rediger;
    private javax.swing.JButton jButton_Rediger2;
    private javax.swing.JButton jButton_Slet;
    private javax.swing.JButton jButton_opret;
    private javax.swing.JComboBox jComboBox_Brugere;
    private javax.swing.JLabel jLabel_brugerNavn;
    private javax.swing.JLabel jLabel_brugerinfo;
    private javax.swing.JPanel jPanel_Opretbruger;
    private javax.swing.JPanel jPanel_admin;
    private javax.swing.JPanel jPanel_redigerbruger;
    private javax.swing.JTextField jTextField_brugerKode;
    private javax.swing.JTextField jTextField_brugerKode2;
    private javax.swing.JTextField jTextField_brugerKodeNu;
    private javax.swing.JTextField jTextField_brugerNavn;
    private javax.swing.JTextField jTextField_opretGenskrivkode;
    private javax.swing.JTextField jTextField_opretKode;
    private javax.swing.JTextField jTextField_opretVælgbrugernavn;
    // End of variables declaration//GEN-END:variables
}
