/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.DocumentException;
import control.DatabaseObjectHandler;
import control.OpretFaktura;
import control.OpretKontoudtog;
import control.OpretProvisionsseddel;
import control.OpretRevisorSeddel;
import javax.swing.JOptionPane;
import model.Faktura;
import util.Utility;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import model.Kunde;

/**
 *
 * @author T
 */
public class JDialog_SøgFaktura extends javax.swing.JDialog {

    private Faktura faktura;
    private DatabaseObjectHandler dbhandler;
    private Panel_Søg panel;
    private Kunde kunde;

    /**
     * Creates new form JDialog_SøgFaktura
     */
    public JDialog_SøgFaktura(java.awt.Frame parent, boolean modal, DatabaseObjectHandler dbhandler, Faktura faktura) {
        super(parent, modal);
        this.dbhandler = dbhandler;
        this.faktura = faktura;
        kunde = faktura.getOrdre().getKunde();
        initComponents();
        jLabel_VisOprettet.setText(Utility.formatTimestampToString(faktura.getFaktureringsdato()));
        jLabel_VisTlf.setText("" + kunde.getTlf());
        jLabel_VisAdresse.setText(kunde.getAdresse());
        jLabel_VisPostnrBy.setText(kunde.getPost_nr().getPost_nr() + " " + kunde.getPost_nr().getByNavn());
        jLabel_VisNavn.setText(kunde.getFornavn() + " " + kunde.getEfternavn());
        jLabel_VisSendtDato.setText(Utility.formatTimestampToString(faktura.getSendt_dato()));
        jLabel_VisPris.setText(NumberFormat.getCurrencyInstance().format(faktura.getOrdre().getTotalInklMoms()));
        if (faktura.getProvisionsseddel() != null) {
            jLabel_VisProvision.setText(faktura.getProvisionsseddel().getProvisions_nr());
            jLabel_VisKontoUdtog.setText(faktura.getProvisionsseddel().getKontoudtog().getKontoudtog_nr());

        } else {

            jButton_KontoPDF.setEnabled(false);
            jButton_KontoPDF.setToolTipText("Ingen Kontoudtogsseddel tilknyttet denne faktura");
            jButton_ProvisionPDF.setEnabled(false);
            jButton_ProvisionPDF.setToolTipText("Ingen Provisionsseddel tilknyttet denne faktura");
            jLabel_VisProvision.setText("Ingen tilknyttet");
            jLabel_VisKontoUdtog.setText("Ingen tilknyttet");
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

        jPanel_PanelInfo = new javax.swing.JPanel();
        jLabel_Navn = new javax.swing.JLabel();
        jLabel_Adresse = new javax.swing.JLabel();
        jLabel_PostBy = new javax.swing.JLabel();
        jLabel_tlf = new javax.swing.JLabel();
        jLabel_VisNavn = new javax.swing.JLabel();
        jLabel_VisAdresse = new javax.swing.JLabel();
        jLabel_VisPostnrBy = new javax.swing.JLabel();
        jLabel_VisTlf = new javax.swing.JLabel();
        jLabel_Overskrift = new javax.swing.JLabel();
        jPanel_FakturaInfo = new javax.swing.JPanel();
        jLabel_VisSendtDato = new javax.swing.JLabel();
        jLabel_VisOprettet = new javax.swing.JLabel();
        jLabel_Oprettet = new javax.swing.JLabel();
        jLabel_Sendt = new javax.swing.JLabel();
        jLabel_Kontoudtognr = new javax.swing.JLabel();
        jLabel_Provisionnr = new javax.swing.JLabel();
        jLabel_VisProvision = new javax.swing.JLabel();
        jLabel_VisKontoUdtog = new javax.swing.JLabel();
        jPanel_Beløb = new javax.swing.JPanel();
        jLabel_VisPris = new javax.swing.JLabel();
        jPanel_Valgmuligheder = new javax.swing.JPanel();
        jButton_FakturaPDF = new javax.swing.JButton();
        jButton_Rykker = new javax.swing.JButton();
        jButton_ProvisionPDF = new javax.swing.JButton();
        jButton_Betalt = new javax.swing.JButton();
        jButton_KontoPDF = new javax.swing.JButton();
        jButton_Slet = new javax.swing.JButton();
        jLabel_brugerbesked = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Faktura");
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_PanelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Faktura info"));

        jLabel_Navn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Navn.setText("Navn");

        jLabel_Adresse.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Adresse.setText("Adresse");

        jLabel_PostBy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_PostBy.setText("Post nr by");

        jLabel_tlf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_tlf.setText("Tlf nr");

        jLabel_VisNavn.setText("jLabel8");

        jLabel_VisAdresse.setText("jLabel12");

        jLabel_VisPostnrBy.setText("jLabel13");

        jLabel_VisTlf.setText("jLabel14");

        javax.swing.GroupLayout jPanel_PanelInfoLayout = new javax.swing.GroupLayout(jPanel_PanelInfo);
        jPanel_PanelInfo.setLayout(jPanel_PanelInfoLayout);
        jPanel_PanelInfoLayout.setHorizontalGroup(
            jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_PanelInfoLayout.createSequentialGroup()
                .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_PanelInfoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Navn)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel_PanelInfoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Adresse)
                            .addComponent(jLabel_PostBy)
                            .addComponent(jLabel_tlf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_VisTlf, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel_VisPostnrBy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                        .addComponent(jLabel_VisAdresse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_VisNavn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(141, 141, 141))
        );
        jPanel_PanelInfoLayout.setVerticalGroup(
            jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PanelInfoLayout.createSequentialGroup()
                .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Navn)
                    .addComponent(jLabel_VisNavn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Adresse)
                    .addComponent(jLabel_VisAdresse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_PostBy)
                    .addComponent(jLabel_VisPostnrBy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_PanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_VisTlf)
                    .addComponent(jLabel_tlf))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel_PanelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 47, 210, -1));

        jLabel_Overskrift.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_Overskrift.setText("Vis Faktura");
        getContentPane().add(jLabel_Overskrift, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel_FakturaInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Faktura Info"));

        jLabel_VisSendtDato.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_VisSendtDato.setText("jLabel16");

        jLabel_VisOprettet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_VisOprettet.setText("jLabel15");

        jLabel_Oprettet.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Oprettet.setText("Oprettet");

        jLabel_Sendt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Sendt.setText("Sendt dato");

        jLabel_Kontoudtognr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Kontoudtognr.setText("Kontoudtog nr");

        jLabel_Provisionnr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_Provisionnr.setText("Provisions nr:");

        jLabel_VisProvision.setText("jLabel18");

        jLabel_VisKontoUdtog.setText("jLabel17");

        jPanel_Beløb.setBackground(new java.awt.Color(255, 224, 224));
        jPanel_Beløb.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel_VisPris.setBackground(new java.awt.Color(255, 236, 236));
        jLabel_VisPris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_VisPris.setText("jLabel5");

        javax.swing.GroupLayout jPanel_BeløbLayout = new javax.swing.GroupLayout(jPanel_Beløb);
        jPanel_Beløb.setLayout(jPanel_BeløbLayout);
        jPanel_BeløbLayout.setHorizontalGroup(
            jPanel_BeløbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_BeløbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_VisPris, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_BeløbLayout.setVerticalGroup(
            jPanel_BeløbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_BeløbLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_VisPris)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_FakturaInfoLayout = new javax.swing.GroupLayout(jPanel_FakturaInfo);
        jPanel_FakturaInfo.setLayout(jPanel_FakturaInfoLayout);
        jPanel_FakturaInfoLayout.setHorizontalGroup(
            jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FakturaInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_FakturaInfoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel_Beløb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel_FakturaInfoLayout.createSequentialGroup()
                            .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel_Oprettet)
                                .addComponent(jLabel_Sendt)
                                .addComponent(jLabel_Kontoudtognr))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_VisSendtDato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_VisOprettet, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel_VisKontoUdtog)))
                        .addGroup(jPanel_FakturaInfoLayout.createSequentialGroup()
                            .addComponent(jLabel_Provisionnr)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_VisProvision))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel_FakturaInfoLayout.setVerticalGroup(
            jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FakturaInfoLayout.createSequentialGroup()
                .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Oprettet)
                    .addComponent(jLabel_VisOprettet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_VisSendtDato)
                    .addComponent(jLabel_Sendt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Kontoudtognr)
                    .addComponent(jLabel_VisKontoUdtog))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_FakturaInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Provisionnr)
                    .addComponent(jLabel_VisProvision))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_Beløb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel_FakturaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 47, -1, -1));

        jPanel_Valgmuligheder.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valgmuligheder"));

        jButton_FakturaPDF.setText("Faktura PDF");
        jButton_FakturaPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FakturaPDFActionPerformed(evt);
            }
        });

        jButton_Rykker.setText("Rykker");
        jButton_Rykker.setEnabled(false);
        jButton_Rykker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RykkerActionPerformed(evt);
            }
        });

        jButton_ProvisionPDF.setText("Prov. PDF");
        jButton_ProvisionPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ProvisionPDFActionPerformed(evt);
            }
        });

        jButton_Betalt.setText("Betalt");
        jButton_Betalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BetaltActionPerformed(evt);
            }
        });

        jButton_KontoPDF.setText("Konto PDF");
        jButton_KontoPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KontoPDFActionPerformed(evt);
            }
        });

        jButton_Slet.setText("Slet");
        jButton_Slet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SletActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ValgmulighederLayout = new javax.swing.GroupLayout(jPanel_Valgmuligheder);
        jPanel_Valgmuligheder.setLayout(jPanel_ValgmulighederLayout);
        jPanel_ValgmulighederLayout.setHorizontalGroup(
            jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ValgmulighederLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ValgmulighederLayout.createSequentialGroup()
                        .addComponent(jButton_Betalt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Rykker, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_ValgmulighederLayout.createSequentialGroup()
                        .addComponent(jButton_FakturaPDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_ProvisionPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Slet, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_KontoPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel_ValgmulighederLayout.setVerticalGroup(
            jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ValgmulighederLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Rykker)
                    .addComponent(jButton_Slet)
                    .addComponent(jButton_Betalt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_FakturaPDF)
                    .addComponent(jButton_ProvisionPDF)
                    .addComponent(jButton_KontoPDF))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel_Valgmuligheder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 213, -1, 110));
        getContentPane().add(jLabel_brugerbesked, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 310, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_FakturaPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FakturaPDFActionPerformed
        try {
            OpretFaktura fakturapdf = new OpretFaktura(faktura);
            fakturapdf.genererFaktura("Faktura-" + faktura.getFaktura_nr() + ".pdf");
            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/Faktura-" + faktura.getFaktura_nr() + ".pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            jLabel_brugerbesked.setText("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton_FakturaPDFActionPerformed

    private void jButton_ProvisionPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ProvisionPDFActionPerformed
        try {
            OpretProvisionsseddel provisionpdf = new OpretProvisionsseddel(faktura);
            provisionpdf.genererProvisionsseddel("Provision-" + faktura.getProvisionsseddel().getProvisions_nr() + ".pdf");
            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/Provision-" + faktura.getProvisionsseddel().getProvisions_nr() + ".pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            jLabel_brugerbesked.setText("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }       // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ProvisionPDFActionPerformed

    private void jButton_RykkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RykkerActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_RykkerActionPerformed

    private void jButton_BetaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BetaltActionPerformed
        int status = JOptionPane.showConfirmDialog(this, "Ændre betalingsstatus til betalt?", "Advarsel!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (status == 0) {
            try {
                faktura.setBetalingsstatus(true);
                dbhandler.editFaktura(faktura);
                panel.hentfakturaer();
            } catch (Exception e) {
                jLabel_brugerbesked.setText("Der opstod en fejl ved ændring af betalingsstatus");
                jLabel_brugerbesked.setToolTipText("fejl " + e);
            }
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton_BetaltActionPerformed
    }
    private void jButton_KontoPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KontoPDFActionPerformed

        try {
            OpretKontoudtog kontoudtogpdf = new OpretKontoudtog(faktura);
            kontoudtogpdf.genererKontoudtog("Kontoudtog-" + faktura.getProvisionsseddel().getKontoudtog().getKontoudtog_nr() + ".pdf");
            Desktop desktop = Desktop.getDesktop();
            File file = new File("docs/Kontoudtog-" + faktura.getProvisionsseddel().getKontoudtog().getKontoudtog_nr() + ".pdf");
            desktop.open(file);
        } catch (FileNotFoundException ex) {
            jLabel_brugerbesked.setText("Luk andre pdf'er før du prøver at se en ny!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }       // TODO add your handling code here:

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_KontoPDFActionPerformed

    private void jButton_SletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SletActionPerformed
        int status = JOptionPane.showConfirmDialog(this, "Du slettet samtidig provisionsseddel samt kontoudtog", "Advarsel!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (status == 0) {
            try {
                dbhandler.deleteFaktura(faktura);
            } catch (SQLException ex) {
                jLabel_brugerbesked.setText("Der opstod en fejl ved sletning af faktura");
                jLabel_brugerbesked.setToolTipText("Fejl " + ex);

            }
            dispose();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SletActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Betalt;
    private javax.swing.JButton jButton_FakturaPDF;
    private javax.swing.JButton jButton_KontoPDF;
    private javax.swing.JButton jButton_ProvisionPDF;
    private javax.swing.JButton jButton_Rykker;
    private javax.swing.JButton jButton_Slet;
    private javax.swing.JLabel jLabel_Adresse;
    private javax.swing.JLabel jLabel_Kontoudtognr;
    private javax.swing.JLabel jLabel_Navn;
    private javax.swing.JLabel jLabel_Oprettet;
    private javax.swing.JLabel jLabel_Overskrift;
    private javax.swing.JLabel jLabel_PostBy;
    private javax.swing.JLabel jLabel_Provisionnr;
    private javax.swing.JLabel jLabel_Sendt;
    private javax.swing.JLabel jLabel_VisAdresse;
    private javax.swing.JLabel jLabel_VisKontoUdtog;
    private javax.swing.JLabel jLabel_VisNavn;
    private javax.swing.JLabel jLabel_VisOprettet;
    private javax.swing.JLabel jLabel_VisPostnrBy;
    private javax.swing.JLabel jLabel_VisPris;
    private javax.swing.JLabel jLabel_VisProvision;
    private javax.swing.JLabel jLabel_VisSendtDato;
    private javax.swing.JLabel jLabel_VisTlf;
    private javax.swing.JLabel jLabel_brugerbesked;
    private javax.swing.JLabel jLabel_tlf;
    private javax.swing.JPanel jPanel_Beløb;
    private javax.swing.JPanel jPanel_FakturaInfo;
    private javax.swing.JPanel jPanel_PanelInfo;
    private javax.swing.JPanel jPanel_Valgmuligheder;
    // End of variables declaration//GEN-END:variables
}
