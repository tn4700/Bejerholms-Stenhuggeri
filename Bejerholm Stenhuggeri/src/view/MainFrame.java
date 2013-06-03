/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.DocumentException;
import control.DBConnection;
import control.DatabaseObjectHandler;
import control.OpretRevisorSeddel;
import util.Utility;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import model.User;
import model.Vare;

/**
 *
 * @author T
 */
public class MainFrame extends javax.swing.JFrame {

    private DBConnection db;
    private DatabaseObjectHandler dbhandler;
    private Panel_OrdreSalg ordresalg;
    private Panel_LynSalg lynsalg;
    private Panel_Lager lager;
    private Panel_Søg søg;
    private Panel_CSVFiler csv;
    private Panel_Bruger bruger;
    private User user;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (db.isConnected()) {

            dbhandler = new DatabaseObjectHandler(db);
            //Opret det panel som skal vises i framen
            opretPaneler();

            //   Man kan så bruge den her kode til at skifte panel når det er lavet til card. 
            ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Hovedmenu");

        } else {
            // skift til vindue
        }
    }

    public MainFrame(DBConnection db, User user) {
        this.db = db;
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        java.net.URL url = ClassLoader.getSystemResource("img/icon.png");        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        this.setIconImage(img);
        
        jLabel_dato.setText(Utility.getCurrentTimeToString());
        this.setLocationRelativeTo(null);

        jLabel_Brugernavn.setText(user.getUsername());

        if (db.isConnected()) {

            dbhandler = new DatabaseObjectHandler(db);
            //Opret det panel som skal vises i framen
            opretPaneler();

            //   Man kan så bruge den her kode til at skifte panel når det er lavet til card. 
            ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Hovedmenu");

        } else {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel_Hovedmenu = new javax.swing.JPanel();
        jButton_Administration = new javax.swing.JButton();
        jButton_Salg = new javax.swing.JButton();
        jButton_Lager = new javax.swing.JButton();
        jButton_Ordre = new javax.swing.JButton();
        jPanel_Administraion = new javax.swing.JPanel();
        jButton_BrugerAdministration = new javax.swing.JButton();
        jButton_Eksporter = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel_Salg = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel_Loggedindsom = new javax.swing.JLabel();
        jLabel_Brugernavn = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel_dato = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bejerholm Stenhuggeri");
        setBackground(new java.awt.Color(200, 236, 255));
        setMinimumSize(new java.awt.Dimension(1000, 720));
        setPreferredSize(new java.awt.Dimension(1000, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 255, 102));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(805, 510));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel_Hovedmenu.setOpaque(false);
        jPanel_Hovedmenu.setLayout(null);

        jButton_Administration.setText("Administration");
        jButton_Administration.setFocusable(false);
        jButton_Administration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AdministrationActionPerformed(evt);
            }
        });
        jPanel_Hovedmenu.add(jButton_Administration);
        jButton_Administration.setBounds(410, 250, 130, 50);

        jButton_Salg.setText("Salg");
        jButton_Salg.setFocusable(false);
        jButton_Salg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalgActionPerformed(evt);
            }
        });
        jPanel_Hovedmenu.add(jButton_Salg);
        jButton_Salg.setBounds(250, 140, 130, 50);

        jButton_Lager.setText("Lager");
        jButton_Lager.setFocusable(false);
        jButton_Lager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LagerActionPerformed(evt);
            }
        });
        jPanel_Hovedmenu.add(jButton_Lager);
        jButton_Lager.setBounds(410, 140, 130, 50);

        jButton_Ordre.setText("Ordre");
        jButton_Ordre.setFocusable(false);
        jButton_Ordre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OrdreActionPerformed(evt);
            }
        });
        jPanel_Hovedmenu.add(jButton_Ordre);
        jButton_Ordre.setBounds(250, 250, 130, 50);

        jPanel1.add(jPanel_Hovedmenu, "Hovedmenu");

        jPanel_Administraion.setOpaque(false);
        jPanel_Administraion.setLayout(null);

        jButton_BrugerAdministration.setText("Bruger Administration");
        jButton_BrugerAdministration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BrugerAdministrationActionPerformed(evt);
            }
        });
        jPanel_Administraion.add(jButton_BrugerAdministration);
        jButton_BrugerAdministration.setBounds(160, 170, 150, 50);

        jButton_Eksporter.setText("Eksporter");
        jButton_Eksporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EksporterActionPerformed(evt);
            }
        });
        jPanel_Administraion.add(jButton_Eksporter);
        jButton_Eksporter.setBounds(320, 170, 140, 50);

        jButton1.setText("Lageropgørelse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel_Administraion.add(jButton1);
        jButton1.setBounds(470, 170, 180, 50);

        jPanel1.add(jPanel_Administraion, "Administration");

        jPanel_Salg.setOpaque(false);
        jPanel_Salg.setLayout(null);

        jButton2.setText("Lyn Salg");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel_Salg.add(jButton2);
        jButton2.setBounds(220, 160, 130, 50);

        jButton6.setText("Ordre Salg");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel_Salg.add(jButton6);
        jButton6.setBounds(440, 160, 130, 50);

        jPanel1.add(jPanel_Salg, "Salg");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jButton7.setText("Hovedmenu");
        jButton7.setFocusable(false);
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 112, -1, 21));

        jLabel_Loggedindsom.setText("Du er logged ind som:");
        getContentPane().add(jLabel_Loggedindsom, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 112, 120, 20));

        jLabel_Brugernavn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Brugernavn.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Brugernavn.setText("jLabel3");
        getContentPane().add(jLabel_Brugernavn, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 107, 111, 28));

        jButton3.setBackground(new java.awt.Color(172, 172, 172));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Log ud");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 112, 40, 20));

        jLabel_dato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_dato.setText("jLabel2");
        getContentPane().add(jLabel_dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 657, 110, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AdministrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AdministrationActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Administration");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_AdministrationActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "LynSalg");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "OrdreSalg");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        vishovedmenu();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton_BrugerAdministrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BrugerAdministrationActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Bruger");
    }//GEN-LAST:event_jButton_BrugerAdministrationActionPerformed

    private void jButton_EksporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EksporterActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Csv");         // TODO add your handling code here:
    }//GEN-LAST:event_jButton_EksporterActionPerformed

    private void jButton_LagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LagerActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Lager");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_LagerActionPerformed

    private void jButton_OrdreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OrdreActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Søg");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_OrdreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String dato = Utility.getCurrentTimeToString();
            OpretRevisorSeddel revisorseddel = new OpretRevisorSeddel(dato, year, db);
            revisorseddel.genererRevisorseddel("test2.pdf");

            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/test2.pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_SalgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalgActionPerformed
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Salg");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SalgActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton_Administration;
    private javax.swing.JButton jButton_BrugerAdministration;
    private javax.swing.JButton jButton_Eksporter;
    private javax.swing.JButton jButton_Lager;
    private javax.swing.JButton jButton_Ordre;
    private javax.swing.JButton jButton_Salg;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Brugernavn;
    private javax.swing.JLabel jLabel_Loggedindsom;
    private javax.swing.JLabel jLabel_dato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Administraion;
    private javax.swing.JPanel jPanel_Hovedmenu;
    private javax.swing.JPanel jPanel_Salg;
    // End of variables declaration//GEN-END:variables

    public void skiftcard(Vare vare) {
        Panel_LynSalg lynsalg_ordre = new Panel_LynSalg(dbhandler, vare, this);
        jPanel1.add(lynsalg_ordre);
        ((CardLayout) jPanel1.getLayout()).addLayoutComponent(lynsalg_ordre, "LynSalg_Ordre");
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "LynSalg_Ordre");
    }

    public void vishovedmenu() {
        ((CardLayout) jPanel1.getLayout()).show(jPanel1, "Hovedmenu");
        opretPaneler();
    }

    public final void opretPaneler() {
        // opret paneler
        ordresalg = new Panel_OrdreSalg(dbhandler, this);
        lynsalg = new Panel_LynSalg(dbhandler, this);
        lager = new Panel_Lager(dbhandler, this);
        søg = new Panel_Søg(dbhandler, this);
        csv = new Panel_CSVFiler(db);
        bruger = new Panel_Bruger(db);
        // tilføj det til vores jpanel der skal fremvise det
        jPanel1.add(ordresalg);
        jPanel1.add(lynsalg);
        jPanel1.add(lager);
        jPanel1.add(søg);
        jPanel1.add(csv);
        jPanel1.add(bruger);
        // Typecast panelet til cardlayout kald metoden addlayout med det panel der skal tilføjes samt en string der navngiver det. 
        ((CardLayout) jPanel1.getLayout()).addLayoutComponent(ordresalg, "OrdreSalg");
        ((CardLayout) jPanel1.getLayout()).addLayoutComponent(lynsalg, "LynSalg");
        ((CardLayout) jPanel1.getLayout()).addLayoutComponent(lager, "Lager");
        ((CardLayout) jPanel1.getLayout()).addLayoutComponent(søg, "Søg");
        ((CardLayout) jPanel1.getLayout()).addLayoutComponent(csv, "Csv");
        ((CardLayout) jPanel1.getLayout()).addLayoutComponent(bruger, "Bruger");
    }
}
