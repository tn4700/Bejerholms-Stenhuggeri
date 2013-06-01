/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.DocumentException;
import control.DatabaseObjectHandler;
import control.OpretFaktura;
import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import model.Faktura;
import model.Kunde;
import model.Ordre;
import model.Vare;
import model.Vare_linje;
import model.Varegruppe;
import control.Utility;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author T
 */
public class Panel_LynSalg extends javax.swing.JPanel {

    private CardLayout layout;
    private ArrayList<Panel_LynSalgLinje> panel;
    private DatabaseObjectHandler dbhandler;
    private ArrayList<Varegruppe> varegrup_list;
    private ArrayList<Vare> vare_list;
    private ArrayList<Vare> valgteVare_lynsalg;
    private Kunde kunde;
    private double købssum;
    private MainFrame frame;

    /**
     * Creates new form NewJPanel
     */
    public Panel_LynSalg(DatabaseObjectHandler dbhandler, MainFrame frame) {
        this.frame = frame;
        this.dbhandler = dbhandler;
        initComponents();
        købssum = 0;
        vare_list = new ArrayList();
        valgteVare_lynsalg = new ArrayList();
        panel = new ArrayList();
        jPanel_VareLinjer.setLayout((LayoutManager) new WrapLayout());


        // opret CardLayout
        layout = (CardLayout) (jPanel_MainCard.getLayout());

        // Hiv Kunden ud der bruges til Lynsalg - Hvilket er Firmaet i Korsør
        try {
            kunde = dbhandler.getKunde(50111211);
        } catch (SQLException ex) {
            System.out.println("Der skete en fejl ved hentning af kunde.");;
        }


        // Hent varegrupper op put dem i varegrup_list Arrayet.
        try {
            varegrup_list = dbhandler.getVaregruppeListe();
        } catch (Exception e) {
        }
        // fylder varegruppen op i jcomboboxen
        udskrivVaregrp();
        jPanel_VareLinjer.setLayout(new WrapLayout());
        jPanel_OversigtVarer.setLayout(new WrapLayout());
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);

    }

    /**
     * Denne Constructor kaldes når der skal redigeres et vare objekt
     *
     * @param dbhandler Send DBhandler med så den kan få adgang til data
     * @param ordre Det ordre objekt som skal redigeres
     */
    public Panel_LynSalg(DatabaseObjectHandler dbhandler, Vare vare) {
        this.dbhandler = dbhandler;
        initComponents();
        vare_list = new ArrayList();
        valgteVare_lynsalg = new ArrayList();
        panel = new ArrayList();
        købssum = 0;
        valgteVare_lynsalg.add(vare);
        for (int i = 0; i < valgteVare_lynsalg.size(); i++) {
            Panel_LynSalgLinje linje = new Panel_LynSalgLinje(valgteVare_lynsalg.get(i), this);
            panel.add(linje);

        }
        drawpanel(jPanel_VareLinjer);
        jLabel_VælgVareSum.setText("" + udregnpris());

        // opret CardLayout
        layout = (CardLayout) (jPanel_MainCard.getLayout());

        // Hiv Kunden ud der bruges til Lynsalg - Hvilket er Firmaet i Korsør
        try {
            kunde = dbhandler.getKunde(50111211);
        } catch (SQLException ex) {
            System.out.println("Der skete en fejl ved hentning af kunde.");;
        }


        // Hent varegrupper op put dem i varegrup_list Arrayet.
        try {
            varegrup_list = dbhandler.getVaregruppeListe();
        } catch (Exception e) {
        }
        udskrivVaregrp();
        jPanel_VareLinjer.setLayout(new WrapLayout());
        jPanel_OversigtVarer.setLayout(new WrapLayout());
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);





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
        jPanel_LynSalg = new javax.swing.JPanel();
        jComboBox_Lynsalgvaregruppe = new javax.swing.JComboBox();
        jComboBoxLynsalgVare = new javax.swing.JComboBox();
        jButtonLynsalgTilføj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonLynsalgVidere = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaVareInfo = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel_VælgVareSum = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel_VareLinjer = new javax.swing.JPanel();
        jLabel_overskrift = new javax.swing.JLabel();
        jLabel_fejlbesked = new javax.swing.JLabel();
        jPanel_OrdreBekræftigelse = new javax.swing.JPanel();
        jLabel_Overskrift = new javax.swing.JLabel();
        jLabel_købssum_lynsalg = new javax.swing.JLabel();
        jLabel_SamletprisOverskrift = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel_OversigtVarer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton_Ændre = new javax.swing.JButton();
        jButton_godkend = new javax.swing.JButton();
        jButton_Annuller = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel_MainCard.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_MainCard.setOpaque(false);
        jPanel_MainCard.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel_MainCard.setLayout(new java.awt.CardLayout());

        jPanel_LynSalg.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_LynSalg.setOpaque(false);
        jPanel_LynSalg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_Lynsalgvaregruppe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_LynsalgvaregruppeActionPerformed(evt);
            }
        });
        jPanel_LynSalg.add(jComboBox_Lynsalgvaregruppe, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 80, 220, 40));

        jComboBoxLynsalgVare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLynsalgVareActionPerformed(evt);
            }
        });
        jPanel_LynSalg.add(jComboBoxLynsalgVare, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 280, 40));

        jButtonLynsalgTilføj.setText("Tilføj");
        jButtonLynsalgTilføj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLynsalgTilføjActionPerformed(evt);
            }
        });
        jPanel_LynSalg.add(jButtonLynsalgTilføj, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 79, 218, 42));

        jLabel1.setText("Varegruppe: ");
        jPanel_LynSalg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel2.setText("Varer:");
        jPanel_LynSalg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jButtonLynsalgVidere.setText("Videre");
        jButtonLynsalgVidere.setBorder(null);
        jButtonLynsalgVidere.setBorderPainted(false);
        jButtonLynsalgVidere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLynsalgVidereActionPerformed(evt);
            }
        });
        jPanel_LynSalg.add(jButtonLynsalgVidere, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 452, 218, 30));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Vare Info"));
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setOpaque(false);

        jTextAreaVareInfo.setEditable(false);
        jTextAreaVareInfo.setBackground(new java.awt.Color(102, 0, 51));
        jTextAreaVareInfo.setColumns(20);
        jTextAreaVareInfo.setRows(5);
        jTextAreaVareInfo.setAutoscrolls(false);
        jTextAreaVareInfo.setBorder(null);
        jTextAreaVareInfo.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jTextAreaVareInfo.setOpaque(false);
        jScrollPane5.setViewportView(jTextAreaVareInfo);

        jPanel_LynSalg.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 220, 219));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pris")));
        jPanel1.setOpaque(false);

        jLabel_VælgVareSum.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_VælgVareSum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel_VælgVareSum, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel_VælgVareSum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel_LynSalg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 375, 220, 70));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valgte Varer"));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 100));

        jPanel_VareLinjer.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_VareLinjer.setName("LynSalg"); // NOI18N
        jPanel_VareLinjer.setOpaque(false);
        jScrollPane1.setViewportView(jPanel_VareLinjer);

        jPanel_LynSalg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 520, 333));

        jLabel_overskrift.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_overskrift.setText("Lyn Salg");
        jPanel_LynSalg.add(jLabel_overskrift, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jPanel_LynSalg.add(jLabel_fejlbesked, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 220, 20));

        jPanel_MainCard.add(jPanel_LynSalg, "card_LynSalg");

        jPanel_OrdreBekræftigelse.setOpaque(false);

        jLabel_Overskrift.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_Overskrift.setText("Ordre Bekræftigelse:");

        jLabel_købssum_lynsalg.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_købssum_lynsalg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_købssum_lynsalg.setText("jLabel32");

        jLabel_SamletprisOverskrift.setText("Samlet pris: ");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valgte Varer"));
        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(500, 100));

        jPanel_OversigtVarer.setName("LynSalg"); // NOI18N
        jPanel_OversigtVarer.setOpaque(false);
        jScrollPane2.setViewportView(jPanel_OversigtVarer);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valgmuligheder"));
        jPanel2.setOpaque(false);

        jButton_Ændre.setText("Ændre");
        jButton_Ændre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ÆndreActionPerformed(evt);
            }
        });

        jButton_godkend.setText("Godkend");
        jButton_godkend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_godkendActionPerformed(evt);
            }
        });

        jButton_Annuller.setText("Annuller");
        jButton_Annuller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AnnullerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_godkend, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Annuller, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Ændre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_godkend)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton_Annuller))
                    .addComponent(jButton_Ændre))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_OrdreBekræftigelseLayout = new javax.swing.GroupLayout(jPanel_OrdreBekræftigelse);
        jPanel_OrdreBekræftigelse.setLayout(jPanel_OrdreBekræftigelseLayout);
        jPanel_OrdreBekræftigelseLayout.setHorizontalGroup(
            jPanel_OrdreBekræftigelseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_OrdreBekræftigelseLayout.createSequentialGroup()
                .addGroup(jPanel_OrdreBekræftigelseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_OrdreBekræftigelseLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel_Overskrift))
                    .addGroup(jPanel_OrdreBekræftigelseLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_OrdreBekræftigelseLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel_OrdreBekræftigelseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_købssum_lynsalg, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_OrdreBekræftigelseLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel_SamletprisOverskrift)))))
                .addGap(10, 10, 10))
        );
        jPanel_OrdreBekræftigelseLayout.setVerticalGroup(
            jPanel_OrdreBekræftigelseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_OrdreBekræftigelseLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel_Overskrift)
                .addGap(16, 16, 16)
                .addGroup(jPanel_OrdreBekræftigelseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_OrdreBekræftigelseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_OrdreBekræftigelseLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel_købssum_lynsalg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_SamletprisOverskrift))
                .addContainerGap())
        );

        jPanel_MainCard.add(jPanel_OrdreBekræftigelse, "card_OrdreBekræftigelse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MainCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_MainCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_LynsalgvaregruppeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_LynsalgvaregruppeActionPerformed
        // Hvergang der bliver valgt en ny varegruppe skal den fjerne alle vare fra comboboxen så de nye kan fyldes i
        jComboBoxLynsalgVare.removeAllItems();
        // Tag den Varegruppe der er valgt i comboboxen og lav det til et objekt af Varegruppe
        Varegruppe varegruppe = (Varegruppe) jComboBox_Lynsalgvaregruppe.getSelectedItem();

        try {
            //Fyld vare_list array'et op med de varer der er i den pågældende varegruppe.
            vare_list = dbhandler.getVareListe(varegruppe.getGrp_nr());
            //Denne forløkke tjekker om der er nogle varer der allerede er valgt. De varer der er valgt bliver
            // fjernet fra vare_list array'et så de ikke bliver vist i comboboxen igen.
            for (int i = 0; i < vare_list.size(); i++) {
                for (int j = 0; j < valgteVare_lynsalg.size(); j++) {
                    if (vare_list.get(i).getVare_nr() == valgteVare_lynsalg.get(j).getVare_nr()) {
                        vare_list.remove(i);
                    }
                }
            }
            // DEnne for løkke fylder vare comboboxen op med de varer det er muligt at vælge i den pågældende varegruppe
            for (int i = 0; i < vare_list.size(); i++) {
                if (vare_list.get(i).getVareStatus() == 0) {
                    jComboBoxLynsalgVare.addItem(vare_list.get(i));
                }


            }


        } catch (Exception e) {
            System.out.println("fejl: " + e);
        }
    }//GEN-LAST:event_jComboBox_LynsalgvaregruppeActionPerformed

    private void jComboBoxLynsalgVareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLynsalgVareActionPerformed
        // tøm Vareinfo hvergang en varer vælges
        jTextAreaVareInfo.setText("");
        // Fyld Vareinfo boxen op med informationerne om den valgte vare - med mindre den er null
        if (jComboBoxLynsalgVare.getSelectedItem() != null) {
            Vare valgtvare = (Vare) jComboBoxLynsalgVare.getSelectedItem();
            jTextAreaVareInfo.append("" + valgtvare + "\n");
            jTextAreaVareInfo.append("Overflade: " + valgtvare.getOverflade() + "\n");
            jTextAreaVareInfo.append("Type: " + valgtvare.getTypenavn() + "\n");
            jTextAreaVareInfo.append("Højde: " + valgtvare.getHøjde() + "\n");
            jTextAreaVareInfo.append("Bredde: " + valgtvare.getBredde() + "\n");
            jTextAreaVareInfo.append("Pris" + valgtvare.getSalgspris() + "\n");
            jTextAreaVareInfo.append("Varegruppe: " + valgtvare.getGruppe() + "\n");
        }
    }//GEN-LAST:event_jComboBoxLynsalgVareActionPerformed

    private void jButtonLynsalgTilføjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLynsalgTilføjActionPerformed
        // Denne if sætning tjekker om der er nogle varer i comboboxen ellers kan den ikke tilføje
        if (jComboBoxLynsalgVare.getItemCount() != 0) {
            // Laver den valgte vare i comboboxen om til et Vare objekt
            Vare valgtvare = (Vare) jComboBoxLynsalgVare.getSelectedItem();
            // tilføj den valgte vare til arraylisten over valgte varer
            valgteVare_lynsalg.add(valgtvare);
            // fjern varen fra comboboxen
            jComboBoxLynsalgVare.removeItem(valgtvare);
            // opret et LynSalgLinje objekt - Dette er varelinjen der bliver vist med den valgte vare
            Panel_LynSalgLinje linje = new Panel_LynSalgLinje(valgtvare, this);
            //tilføj det nyoprettede jpanel med varen til array'et panel som indeholder alle varelinjer.
            panel.add(linje);
            // kald metoden drawpanel som tilføjer panelet til boksen så den bliver vist
            drawpanel(jPanel_VareLinjer);
            // opdaterer labelen med købsummen
            jLabel_VælgVareSum.setText("" + udregnpris());


        } else {
            // Brugeren skal have besked om, at det ikke var muligt at tilføje vare da listen er tom
            jLabel_fejlbesked.setText("Der er ikke valgt nogen varer");
        }


    }//GEN-LAST:event_jButtonLynsalgTilføjActionPerformed

    private void jButtonLynsalgVidereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLynsalgVidereActionPerformed
        jLabel_købssum_lynsalg.setText("" + udregnpris());
        drawpanel(jPanel_OversigtVarer);
        layout.show(jPanel_MainCard, "card_OrdreBekræftigelse");
    }//GEN-LAST:event_jButtonLynsalgVidereActionPerformed

    private void jButton_ÆndreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ÆndreActionPerformed
        layout.show(jPanel_MainCard, "card_LynSalg");
        drawpanel(jPanel_VareLinjer);
    }//GEN-LAST:event_jButton_ÆndreActionPerformed

    private void jButton_godkendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_godkendActionPerformed
        int status = JOptionPane.showConfirmDialog(this, "Godkender du ordren, oprettes fakturaseddel og ordren kan ikke redigeres", "Advarsel!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (status == 0) {


            ArrayList<Vare_linje> varelinjer = new ArrayList();
            for (int i = 0; i < valgteVare_lynsalg.size(); i++) {
                Vare_linje linje = new Vare_linje(i, null, valgteVare_lynsalg.get(i), null, null);
                varelinjer.add(linje);

            }
            Ordre lynordre = new Ordre(kunde, varelinjer);

            try {
                String ordrenr = dbhandler.createOrdre(lynordre);
                lynordre = dbhandler.getOrdre(ordrenr);
                Faktura nyfaktura = new Faktura(ordrenr, Utility.getCurrentTime(), Utility.getCurrentTime(), lynordre.getKunde().getAdresse(), false, false, lynordre, null, null);
                System.out.println("Ordren er blevet oprettet korrekt");
                try {
                    dbhandler.createFaktura(nyfaktura);
                } catch (Exception e) {
                    System.out.println("Det opstod en fejl ved oprettelse af faktura" + e);
                }

                try {
                    OpretFaktura opretFaktura = new OpretFaktura(nyfaktura);
                    opretFaktura.genererFaktura("FakturaTest.pdf");

                    Desktop desktop = Desktop.getDesktop();
                    File file = new File("docs/FakturaTest.pdf");
                    desktop.open(file);
                } catch (FileNotFoundException ex) {
                    System.out.println("Luk andre pdf'er før du prøver at se en ny!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (DocumentException ex) {
                    ex.printStackTrace();
                }
            } catch (Exception ex) {
                System.out.println("Der kunne ikke oprettes en ordre " + ex);
            }
            jButton_Annuller.doClick();
        }


    }//GEN-LAST:event_jButton_godkendActionPerformed

    private void jButton_AnnullerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AnnullerActionPerformed
               int status = JOptionPane.showConfirmDialog(this, "Ønsker du at annullere ordren?", "Advarsel!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
if(status ==0 ){
      vare_list = new ArrayList();
        valgteVare_lynsalg = new ArrayList();
        panel = new ArrayList();
       jPanel_OversigtVarer.removeAll();
       jPanel_VareLinjer.removeAll();
       udregnpris();
       frame.vishovedmenu();
}
      



    }//GEN-LAST:event_jButton_AnnullerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLynsalgTilføj;
    private javax.swing.JButton jButtonLynsalgVidere;
    private javax.swing.JButton jButton_Annuller;
    private javax.swing.JButton jButton_godkend;
    private javax.swing.JButton jButton_Ændre;
    private javax.swing.JComboBox jComboBoxLynsalgVare;
    private javax.swing.JComboBox jComboBox_Lynsalgvaregruppe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Overskrift;
    private javax.swing.JLabel jLabel_SamletprisOverskrift;
    private javax.swing.JLabel jLabel_VælgVareSum;
    private javax.swing.JLabel jLabel_fejlbesked;
    private javax.swing.JLabel jLabel_købssum_lynsalg;
    private javax.swing.JLabel jLabel_overskrift;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_LynSalg;
    private javax.swing.JPanel jPanel_MainCard;
    private javax.swing.JPanel jPanel_OrdreBekræftigelse;
    private javax.swing.JPanel jPanel_OversigtVarer;
    private javax.swing.JPanel jPanel_VareLinjer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextAreaVareInfo;
    // End of variables declaration//GEN-END:variables

    private void udskrivVaregrp() {
        for (int i = 0; i < varegrup_list.size(); i++) {
            jComboBox_Lynsalgvaregruppe.addItem(varegrup_list.get(i));

        }
    }

    /**
     * Denne metode bruges til at tegne de valgte ind i et jpanel.
     *
     * @param jpanel Den kaldes med det panel som den skal tegne på
     */
    public void drawpanel(JPanel jpanel) {

        jpanel.removeAll();
        jpanel.updateUI();
        for (int i = 0; i < panel.size(); i++) {
            jpanel.add(panel.get(i));
        }

    }

//Fjener en vare både fra array og panel
    public void removepanel(Panel_LynSalgLinje i) {
        panel.remove(i);
        valgteVare_lynsalg.remove(i.getVare());
        // foretag en action til varegruppe combobox så den opdaterer varelisten i comboboxen med varer
        jComboBox_Lynsalgvaregruppe.setSelectedIndex(jComboBox_Lynsalgvaregruppe.getSelectedIndex());
        jLabel_købssum_lynsalg.setText("" + udregnpris());
        jLabel_VælgVareSum.setText("" + udregnpris());

    }
// Bruges til at opdatere købssum når der fjernes en varer og der trykkes på videre knappen.

    public double udregnpris() {

        købssum = 0;
        for (int i = 0; i < valgteVare_lynsalg.size(); i++) {
            købssum = købssum + valgteVare_lynsalg.get(i).getSalgspris();

        }


        return købssum;
    }

    public void flytvarelinje(Panel_LynSalgLinje i, boolean flytvej) {

        int plads = panel.indexOf(i);

        if (flytvej == true) {

            if (plads != panel.size() - 1) {
                Collections.swap(panel, plads, plads + 1);
                Collections.swap(valgteVare_lynsalg, plads, plads + 1);
            }
        } else {
            if (plads != 0) {
                Collections.swap(panel, plads, plads - 1);
                Collections.swap(valgteVare_lynsalg, plads, plads - 1);
            }
        }



    }
}
