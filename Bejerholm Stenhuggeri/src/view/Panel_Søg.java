/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DatabaseObjectHandler;
import control.exceptions.ControlException;
import java.awt.LayoutManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JRootPane;
import javax.swing.border.EtchedBorder;
import model.Faktura;
import model.Ordre;

/**
 *
 * @author T
 */
public class Panel_Søg extends javax.swing.JPanel {

    private DatabaseObjectHandler dbhandler;
    private MainFrame frame;
    private ArrayList<Faktura> fakturaliste;
    private Faktura faktura;

    /**
     * Creates new form NewJPanel1
     */
    public Panel_Søg(DatabaseObjectHandler dbhandler, MainFrame frame) {
        this.dbhandler = dbhandler;
        this.frame = frame;
        initComponents();
        // sæt Søge knappen til at væred en knap der trykker på når der trykker ENTER på keyboardet
        JRootPane rootPane = frame.getRootPane();
        rootPane.setDefaultButton(jButton_Søg);
        jPanel_Visfaktura.setLayout((LayoutManager) new WrapLayout());



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel_Søg = new javax.swing.JPanel();
        jButton_Søg = new javax.swing.JButton();
        jTextField_SøgeNr = new javax.swing.JTextField();
        jComboBox_VælgType = new javax.swing.JComboBox();
        jScrollPane_SøgeResultat = new javax.swing.JScrollPane();
        jPanel_SøgeResultat = new javax.swing.JPanel();
        jLabel_Fejlbesked = new javax.swing.JLabel();
        jScrollPane_IgangværendeScroll = new javax.swing.JScrollPane();
        jPanel_Visfaktura = new javax.swing.JPanel();
        jPanel_Vælg = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setMinimumSize(new java.awt.Dimension(830, 500));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Søg.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Søg", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel_Søg.setOpaque(false);

        jButton_Søg.setText("Søg");
        jButton_Søg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SøgActionPerformed(evt);
            }
        });

        jTextField_SøgeNr.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jComboBox_VælgType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ordre", "Faktura", "Kunde" }));
        jComboBox_VælgType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_VælgTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_SøgLayout = new javax.swing.GroupLayout(jPanel_Søg);
        jPanel_Søg.setLayout(jPanel_SøgLayout);
        jPanel_SøgLayout.setHorizontalGroup(
            jPanel_SøgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_SøgLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel_SøgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_VælgType, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_SøgeNr, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Søg, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel_SøgLayout.setVerticalGroup(
            jPanel_SøgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SøgLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jComboBox_VælgType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jTextField_SøgeNr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton_Søg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        add(jPanel_Søg, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jScrollPane_SøgeResultat.setBorder(null);
        jScrollPane_SøgeResultat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_SøgeResultat.setFocusable(false);
        jScrollPane_SøgeResultat.setOpaque(false);

        jPanel_SøgeResultat.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_SøgeResultat.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Søge Resultat"));
        jPanel_SøgeResultat.setFocusTraversalPolicyProvider(true);
        jPanel_SøgeResultat.setOpaque(false);
        jScrollPane_SøgeResultat.setViewportView(jPanel_SøgeResultat);

        add(jScrollPane_SøgeResultat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 310, 220));

        jLabel_Fejlbesked.setForeground(new java.awt.Color(153, 0, 0));
        jLabel_Fejlbesked.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add(jLabel_Fejlbesked, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 24, 280, 20));

        jScrollPane_IgangværendeScroll.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane_IgangværendeScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_IgangværendeScroll.setOpaque(false);

        jPanel_Visfaktura.setOpaque(false);
        jScrollPane_IgangværendeScroll.setViewportView(jPanel_Visfaktura);

        add(jScrollPane_IgangværendeScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 112, 420, 346));

        jPanel_Vælg.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Vælg"));
        jPanel_Vælg.setOpaque(false);
        jPanel_Vælg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Faktura");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel_Vælg.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 13, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Ordre");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel_Vælg.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 13, -1, -1));

        add(jPanel_Vælg, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 50, 422, 45));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SøgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SøgActionPerformed

        jPanel_SøgeResultat.removeAll();
        jLabel_Fejlbesked.setText("");
        if (jTextField_SøgeNr != null) {
            if (!jTextField_SøgeNr.getText().isEmpty()) {
                if ((jComboBox_VælgType.getSelectedIndex() == 0)) {
                    String ordrenr = jTextField_SøgeNr.getText();

                    try {

                        Integer.parseInt(jTextField_SøgeNr.getText());

                        try {
                            Ordre ordre = dbhandler.getOrdre(ordrenr);
                            Panel_Søg_Resultat panel = new Panel_Søg_Resultat(dbhandler, ordre,this);
                            jPanel_SøgeResultat.add(panel);
                            jPanel_SøgeResultat.revalidate();

                        } catch (SQLException ex) {
                            jLabel_Fejlbesked.setText("Der skete en fejl hentning af ordre" + ex);
                        } catch (Exception e) {
                            jLabel_Fejlbesked.setText("Ordre ikke fundet");
                        }

                    } catch (Exception e) {
                        jLabel_Fejlbesked.setText("Ordre nr må kun være tal");
                    }



                } else if (jComboBox_VælgType.getSelectedIndex() == 1) {
                    String fakturanr = jTextField_SøgeNr.getText();

                    if (jTextField_SøgeNr.getText().length() == 16) {
                        try {
                            Faktura faktura = dbhandler.getFaktura(fakturanr);
                            System.out.println(faktura.getFaktura_nr());
                            Panel_Søg_Resultat panel = new Panel_Søg_Resultat(dbhandler, faktura,this);
                            jPanel_SøgeResultat.add(panel);
                            jPanel_SøgeResultat.revalidate();

                        } catch (SQLException ex) {
                            jLabel_Fejlbesked.setText("Der skete en fejl hentning af fakturaen" + ex);
                        } catch (Exception e) {
                            jLabel_Fejlbesked.setText("fakturaen ikke fundet" + e);
                        }
                    } else {
                        jLabel_Fejlbesked.setText("Faktura nr skal være 16 tegn inkl -");
                    }


                } else if (jComboBox_VælgType.getSelectedIndex() == 2) {

                    if (jTextField_SøgeNr.getText().length() == 8) {
                        try {
                            int parseint = Integer.parseInt(jTextField_SøgeNr.getText());
                            try {
                                jPanel_SøgeResultat.setLayout((LayoutManager) new WrapLayout());
                                ArrayList<Ordre> ordre = dbhandler.getKundeOrdre(Integer.parseInt(jTextField_SøgeNr.getText()));

                                if (ordre.size() != 0) {
                                    for (int i = 0; i < ordre.size(); i++) {
                                        Panel_Søg_Resultat panel = new Panel_Søg_Resultat(dbhandler, ordre.get(i),this);
                                        jPanel_SøgeResultat.add(panel);
                                        jPanel_SøgeResultat.revalidate();

                                    }

                                } else {
                                    jLabel_Fejlbesked.setText("Der blev ikke fundet nogle ordre med angivne telefon nr.");
                                }

                            } catch (SQLException ex) {
                                jLabel_Fejlbesked.setText("Det var ikke muligt at hente kunde ordre");
                                jLabel_Fejlbesked.setToolTipText("Fejl: " + ex);
                            } catch (Exception e) {
                                jLabel_Fejlbesked.setText("Kunde ordre ikke fundet");
                                jLabel_Fejlbesked.setToolTipText("Fejl " + e);
                            }

                        } catch (Exception e) {
                            jLabel_Fejlbesked.setText("Telefon nr skal være et tal");
                        }


                    } else {
                        jLabel_Fejlbesked.setText("Telefon nr skal være på 8 cifre");
                    }

                }

            } else {
                jLabel_Fejlbesked.setText("Du skal indtaste noget før du kan søge");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SøgActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jScrollPane_IgangværendeScroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Igangværende Faktura"));
        hentfakturaer();
        opdaterfaktura();
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jScrollPane_IgangværendeScroll.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Igangværende Ordre"));
        hentordre();
        opdaterfaktura();
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jComboBox_VælgTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_VælgTypeActionPerformed
        jPanel_SøgeResultat.removeAll();
        jPanel_SøgeResultat.revalidate();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_VælgTypeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_Søg;
    private javax.swing.JComboBox jComboBox_VælgType;
    private javax.swing.JLabel jLabel_Fejlbesked;
    private javax.swing.JPanel jPanel_Søg;
    private javax.swing.JPanel jPanel_SøgeResultat;
    private javax.swing.JPanel jPanel_Visfaktura;
    private javax.swing.JPanel jPanel_Vælg;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane_IgangværendeScroll;
    private javax.swing.JScrollPane jScrollPane_SøgeResultat;
    private javax.swing.JTextField jTextField_SøgeNr;
    // End of variables declaration//GEN-END:variables

    public void opdaterfaktura() {
        jPanel_Visfaktura.revalidate();
    }

    public void hentfakturaer() {
        jPanel_Visfaktura.removeAll();
        try {
            fakturaliste = dbhandler.getFakturaListe();
        } catch (SQLException ex) {
            Logger.getLogger(Panel_Søg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ControlException ex) {
            Logger.getLogger(Panel_Søg.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < fakturaliste.size(); i++) {
            if (!fakturaliste.get(i).getBetalingsstatus()) {
                Panel_Søg_Ingangværende panel = new Panel_Søg_Ingangværende(fakturaliste.get(i), dbhandler, this);
                jPanel_Visfaktura.add(panel);
                jPanel_Visfaktura.revalidate();
            }
        }

    }

    public void hentordre() {
        jPanel_Visfaktura.removeAll();
        ArrayList<Ordre> ordrelist;
        jPanel_Visfaktura.removeAll();
        try {
            ordrelist = dbhandler.getIganværendeOrdre();
            for (int i = 0; i < ordrelist.size(); i++) {
                Panel_Søg_Ingangværende panel = new Panel_Søg_Ingangværende(ordrelist.get(i), dbhandler);
                jPanel_Visfaktura.add(panel);

            }

        } catch (SQLException ex) {
            jLabel_Fejlbesked.setText("Der skete en fejl ved hentning af igangværende faktura");
            jLabel_Fejlbesked.setToolTipText("fejl: " + ex);
        } catch (ControlException ex) {
        }


    }

}
