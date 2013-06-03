/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.DocumentException;
import control.DatabaseObjectHandler;
import control.OpretFaktura;
import util.Utility;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.LayoutManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Faktura;
import model.Kunde;
import model.Ordre;
import model.Vare;
import model.Vare_linje;
import model.Varegruppe;

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
    private ImageIcon tooltip;

    /**
     * Creates new form NewJPanel
     */
    public Panel_LynSalg(DatabaseObjectHandler dbhandler, MainFrame frame) {
        this.frame = frame;
        this.dbhandler = dbhandler;
        initComponents();
        // ClassLoader cldr = this.getClass().getClassLoader();
        //   tooltip = new ImageIcon(cldr.getResource("img/tooltip.png"));


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
            if(kunde == null){
               jLabel_fejlbesked.setText("Der skete en fejl ved indlæsning af butik som kunde");
            jLabel_fejlbesked.setToolTipText( jLabel_fejlbesked.getText() + " Undersøg om brugeren findes i databasen"); 
            }
        } catch (SQLException ex) {
           
            jLabel_fejlbesked.setText("Der skete en fejl ved indlæsning af butik som kunde");
            jLabel_fejlbesked.setToolTipText( jLabel_fejlbesked+ " Fejl: " + ex);
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
        jScrollPane_VarelinjeScroll.getViewport().setOpaque(false);
        jScrollPane_Bekræft_Varelinjer.getViewport().setOpaque(false);

    }

    /**
     * Denne Constructor kaldes når der skal redigeres et vare objekt
     *
     * @param dbhandler Send DBhandler med så den kan få adgang til data
     * @param ordre Det ordre objekt som skal redigeres
     */
    public Panel_LynSalg(DatabaseObjectHandler dbhandler, Vare vare, MainFrame frame) {
        this.frame = frame;
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
            jLabel_fejlbesked.setText("Der skete en fejl ved indlæsning af butik som kunde");
            jLabel_fejlbesked.setToolTipText("Fejl: " + ex);
        }


        // Hent varegrupper op put dem i varegrup_list Arrayet.
        try {
            varegrup_list = dbhandler.getVaregruppeListe();
        } catch (Exception e) {
        }
        udskrivVaregrp();
        jPanel_VareLinjer.setLayout(new WrapLayout());
        jPanel_OversigtVarer.setLayout(new WrapLayout());
        jScrollPane_VarelinjeScroll.getViewport().setOpaque(false);
        jScrollPane_Bekræft_Varelinjer.getViewport().setOpaque(false);





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
        jLabel_Varegruppe = new javax.swing.JLabel();
        jLabel_Varer = new javax.swing.JLabel();
        jButtonLynsalgVidere = new javax.swing.JButton();
        jPanel_Pris = new javax.swing.JPanel();
        jLabel_VælgVareSum = new javax.swing.JLabel();
        jScrollPane_VarelinjeScroll = new javax.swing.JScrollPane();
        jPanel_VareLinjer = new javax.swing.JPanel();
        jLabel_overskrift = new javax.swing.JLabel();
        jLabel_fejlbesked = new javax.swing.JLabel();
        jPanel_VareInfo = new javax.swing.JPanel();
        jLabel_Varenavn = new javax.swing.JLabel();
        jLabel_Overflade = new javax.swing.JLabel();
        jLabel_VareType = new javax.swing.JLabel();
        jLabel_Visoverflade = new javax.swing.JLabel();
        jLabel_VisVaretype = new javax.swing.JLabel();
        jLabel_Højde = new javax.swing.JLabel();
        jLabel_VisHøjde = new javax.swing.JLabel();
        jLabel_Bredde = new javax.swing.JLabel();
        jLabel_VisBredde = new javax.swing.JLabel();
        jLabel_Salgspris = new javax.swing.JLabel();
        jLabel_VisSalgsPris = new javax.swing.JLabel();
        jLabel_VisVareNavn = new javax.swing.JLabel();
        jPanel_OrdreBekræftigelse = new javax.swing.JPanel();
        jLabel_Overskrift = new javax.swing.JLabel();
        jLabel_købssum_lynsalg = new javax.swing.JLabel();
        jLabel_SamletprisOverskrift = new javax.swing.JLabel();
        jScrollPane_Bekræft_Varelinjer = new javax.swing.JScrollPane();
        jPanel_OversigtVarer = new javax.swing.JPanel();
        jPanel_Valgmuligheder = new javax.swing.JPanel();
        jButton_Ændre = new javax.swing.JButton();
        jButton_godkend = new javax.swing.JButton();
        jButton_Annuller = new javax.swing.JButton();
        jLabel_fejlbesked_Bekræft = new javax.swing.JLabel();

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

        jLabel_Varegruppe.setText("Varegruppe: ");
        jPanel_LynSalg.add(jLabel_Varegruppe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel_Varer.setText("Varer:");
        jPanel_LynSalg.add(jLabel_Varer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jButtonLynsalgVidere.setText("Videre");
        jButtonLynsalgVidere.setBorder(null);
        jButtonLynsalgVidere.setBorderPainted(false);
        jButtonLynsalgVidere.setMaximumSize(new java.awt.Dimension(30, 15));
        jButtonLynsalgVidere.setMinimumSize(new java.awt.Dimension(30, 15));
        jButtonLynsalgVidere.setPreferredSize(new java.awt.Dimension(30, 15));
        jButtonLynsalgVidere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLynsalgVidereActionPerformed(evt);
            }
        });
        jPanel_LynSalg.add(jButtonLynsalgVidere, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 452, 217, 29));

        jPanel_Pris.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pris")));
        jPanel_Pris.setOpaque(false);

        jLabel_VælgVareSum.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_VælgVareSum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel_PrisLayout = new javax.swing.GroupLayout(jPanel_Pris);
        jPanel_Pris.setLayout(jPanel_PrisLayout);
        jPanel_PrisLayout.setHorizontalGroup(
            jPanel_PrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_PrisLayout.createSequentialGroup()
                .addComponent(jLabel_VælgVareSum, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_PrisLayout.setVerticalGroup(
            jPanel_PrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_PrisLayout.createSequentialGroup()
                .addComponent(jLabel_VælgVareSum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel_LynSalg.add(jPanel_Pris, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 371, 220, -1));

        jScrollPane_VarelinjeScroll.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane_VarelinjeScroll.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valgte Varer"));
        jScrollPane_VarelinjeScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_VarelinjeScroll.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jScrollPane_VarelinjeScroll.setOpaque(false);
        jScrollPane_VarelinjeScroll.setPreferredSize(new java.awt.Dimension(500, 100));

        jPanel_VareLinjer.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_VareLinjer.setName("LynSalg"); // NOI18N
        jPanel_VareLinjer.setOpaque(false);
        jScrollPane_VarelinjeScroll.setViewportView(jPanel_VareLinjer);
        jPanel_VareLinjer.getAccessibleContext().setAccessibleName("VælgVare");

        jPanel_LynSalg.add(jScrollPane_VarelinjeScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 520, 333));

        jLabel_overskrift.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel_overskrift.setText("Lyn Salg");
        jPanel_LynSalg.add(jLabel_overskrift, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel_fejlbesked.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_fejlbesked.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel_LynSalg.add(jLabel_fejlbesked, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 220, 20));

        jPanel_VareInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Vare info"));
        jPanel_VareInfo.setOpaque(false);

        jLabel_Varenavn.setText("Navn");

        jLabel_Overflade.setText("Overflade:");

        jLabel_VareType.setText("Varetype:");

        jLabel_Visoverflade.setText("jLabel6");

        jLabel_VisVaretype.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_VisVaretype.setText("jLabel7");
        jLabel_VisVaretype.setToolTipText("");
        jLabel_VisVaretype.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel_VisVaretype.setMaximumSize(new java.awt.Dimension(30, 14));
        jLabel_VisVaretype.setMinimumSize(new java.awt.Dimension(30, 14));
        jLabel_VisVaretype.setPreferredSize(new java.awt.Dimension(30, 14));

        jLabel_Højde.setText("Højde:");

        jLabel_VisHøjde.setText("jLabel9");

        jLabel_Bredde.setText("Bredde:");

        jLabel_VisBredde.setText("jLabel11");

        jLabel_Salgspris.setText("Salgspris:");

        jLabel_VisSalgsPris.setText("jLabel13");

        jLabel_VisVareNavn.setText("jLabel3");

        javax.swing.GroupLayout jPanel_VareInfoLayout = new javax.swing.GroupLayout(jPanel_VareInfo);
        jPanel_VareInfo.setLayout(jPanel_VareInfoLayout);
        jPanel_VareInfoLayout.setHorizontalGroup(
            jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VareInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_VareInfoLayout.createSequentialGroup()
                        .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_VareType)
                            .addComponent(jLabel_Højde)
                            .addComponent(jLabel_Bredde)
                            .addComponent(jLabel_Salgspris))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_VisSalgsPris)
                            .addComponent(jLabel_VisHøjde)
                            .addComponent(jLabel_VisBredde)
                            .addComponent(jLabel_VisVaretype, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                    .addGroup(jPanel_VareInfoLayout.createSequentialGroup()
                        .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Overflade)
                            .addComponent(jLabel_Varenavn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_VisVareNavn)
                            .addComponent(jLabel_Visoverflade, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel_VareInfoLayout.setVerticalGroup(
            jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VareInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Varenavn)
                    .addComponent(jLabel_VisVareNavn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Overflade)
                    .addComponent(jLabel_Visoverflade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_VareType)
                    .addComponent(jLabel_VisVaretype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Højde)
                    .addComponent(jLabel_VisHøjde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Bredde)
                    .addComponent(jLabel_VisBredde))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_VareInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Salgspris)
                    .addComponent(jLabel_VisSalgsPris))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel_LynSalg.add(jPanel_VareInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 220, -1));

        jPanel_MainCard.add(jPanel_LynSalg, "card_LynSalg");

        jPanel_OrdreBekræftigelse.setOpaque(false);
        jPanel_OrdreBekræftigelse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Overskrift.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_Overskrift.setText("Ordre Bekræftigelse:");
        jPanel_OrdreBekræftigelse.add(jLabel_Overskrift, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel_købssum_lynsalg.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel_købssum_lynsalg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_købssum_lynsalg.setText("jLabel32");
        jPanel_OrdreBekræftigelse.add(jLabel_købssum_lynsalg, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 413, 280, 40));

        jLabel_SamletprisOverskrift.setText("Samlet pris: ");
        jPanel_OrdreBekræftigelse.add(jLabel_SamletprisOverskrift, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 399, -1, -1));

        jScrollPane_Bekræft_Varelinjer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valgte Varer"));
        jScrollPane_Bekræft_Varelinjer.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jScrollPane_Bekræft_Varelinjer.setOpaque(false);
        jScrollPane_Bekræft_Varelinjer.setPreferredSize(new java.awt.Dimension(500, 100));

        jPanel_OversigtVarer.setName("LynSalg"); // NOI18N
        jPanel_OversigtVarer.setOpaque(false);
        jScrollPane_Bekræft_Varelinjer.setViewportView(jPanel_OversigtVarer);
        jPanel_OversigtVarer.getAccessibleContext().setAccessibleName("Bekræftigelse");

        jPanel_OrdreBekræftigelse.add(jScrollPane_Bekræft_Varelinjer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 560, 300));

        jPanel_Valgmuligheder.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valgmuligheder"));
        jPanel_Valgmuligheder.setOpaque(false);

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

        javax.swing.GroupLayout jPanel_ValgmulighederLayout = new javax.swing.GroupLayout(jPanel_Valgmuligheder);
        jPanel_Valgmuligheder.setLayout(jPanel_ValgmulighederLayout);
        jPanel_ValgmulighederLayout.setHorizontalGroup(
            jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ValgmulighederLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_godkend, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Annuller, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Ændre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel_ValgmulighederLayout.setVerticalGroup(
            jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ValgmulighederLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_godkend)
                .addGap(17, 17, 17)
                .addGroup(jPanel_ValgmulighederLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ValgmulighederLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton_Annuller))
                    .addComponent(jButton_Ændre))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jPanel_OrdreBekræftigelse.add(jPanel_Valgmuligheder, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, -1, -1));

        jLabel_fejlbesked_Bekræft.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_fejlbesked_Bekræft.setText("jLabel3");
        jLabel_fejlbesked_Bekræft.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel_OrdreBekræftigelse.add(jLabel_fejlbesked_Bekræft, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 45, 180, -1));

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
            jLabel_fejlbesked.setText("Der skete en fejl ved idlæsning af varer i vare gruppen");
            jLabel_fejlbesked.setToolTipText("Fejl: " + e);
        }
    }//GEN-LAST:event_jComboBox_LynsalgvaregruppeActionPerformed

    private void jComboBoxLynsalgVareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLynsalgVareActionPerformed
        // tøm Vareinfo hvergang en varer vælges

        // Fyld Vareinfo boxen op med informationerne om den valgte vare - med mindre den er null
        if (jComboBoxLynsalgVare.getSelectedItem() != null) {
            Vare valgtvare = (Vare) jComboBoxLynsalgVare.getSelectedItem();
            jLabel_VisVareNavn.setText(valgtvare.getNavn());
            jLabel_Visoverflade.setText("" + valgtvare.getOverflade());
            if (valgtvare.getVaretype() != null) {
                jLabel_VisVaretype.setText(valgtvare.getVaretype().toString());
                jLabel_VisVaretype.setToolTipText(valgtvare.getVaretype().toString());
            } else {
                jLabel_VisVaretype.setText("Ingen");
                jLabel_VisVaretype.setToolTipText("");
            }
            jLabel_VisSalgsPris.setText(Utility.formatDoubleToKr(valgtvare.getSalgspris()));
            jLabel_VisHøjde.setText("" + valgtvare.getHøjde());
            jLabel_VisBredde.setText("" + valgtvare.getBredde());

        }
    }//GEN-LAST:event_jComboBoxLynsalgVareActionPerformed

    private void jButtonLynsalgTilføjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLynsalgTilføjActionPerformed
        jButtonLynsalgTilføj.setEnabled(true);

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
        if (valgteVare_lynsalg.size() > 8) {
            jButtonLynsalgTilføj.setEnabled(false);
            jLabel_fejlbesked.setIcon(tooltip);
            jLabel_fejlbesked.setText("Max varelinjer er nået");
        }

    }//GEN-LAST:event_jButtonLynsalgTilføjActionPerformed

    private void jButtonLynsalgVidereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLynsalgVidereActionPerformed
        if (valgteVare_lynsalg.size() != 0) {
            jLabel_købssum_lynsalg.setText("" + udregnpris());
            drawpanel(jPanel_OversigtVarer);
            layout.show(jPanel_MainCard, "card_OrdreBekræftigelse");
        } else {
            JOptionPane.showMessageDialog(frame, "Du skal vælge en vare for at komme videre.", "Fejl", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonLynsalgVidereActionPerformed

    private void jButton_ÆndreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ÆndreActionPerformed
        layout.show(jPanel_MainCard, "card_LynSalg");
        drawpanel(jPanel_VareLinjer);
    }//GEN-LAST:event_jButton_ÆndreActionPerformed

    private void jButton_godkendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_godkendActionPerformed
        if (valgteVare_lynsalg.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Det er ikke muligt at oprette en ordre uden varer!", "Fejl", JOptionPane.INFORMATION_MESSAGE);
        } else {


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
                    Faktura nyfaktura = new Faktura(ordrenr, Utility.getCurrentTime(), Utility.getCurrentTime(), null, false, false, lynordre, null, null);
                    try {
                        dbhandler.createFaktura(nyfaktura);
                    } catch (Exception e) {
                        jLabel_fejlbesked_Bekræft.setText("Det opstod en fejl ved oprettelse af faktura");
                        jLabel_fejlbesked_Bekræft.setToolTipText("Fejl:" + e);
                    }

                    try {
                        OpretFaktura opretFaktura = new OpretFaktura(nyfaktura);
                        opretFaktura.genererFaktura("Faktura-" + nyfaktura.getFaktura_nr() + ".pdf");

                        Desktop desktop = Desktop.getDesktop();
                        File file = new File("docs/Faktura-" + nyfaktura.getFaktura_nr() + ".pdf");
                        desktop.open(file);
                    } catch (FileNotFoundException ex) {
                        jLabel_fejlbesked_Bekræft.setText("Luk andre pfd'er før du prøver at se en ny ");
                        jLabel_fejlbesked_Bekræft.setToolTipText("Fejl:" + ex);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (DocumentException ex) {
                        ex.printStackTrace();
                    }
                    frame.vishovedmenu();
                } catch (Exception ex) {
                    jLabel_fejlbesked_Bekræft.setText("Det var ikke muligt at oprette orden, prøv venligst igen");
                    jLabel_fejlbesked_Bekræft.setToolTipText("Fejl" + ex);

                }

            }
        }

    }//GEN-LAST:event_jButton_godkendActionPerformed

    private void jButton_AnnullerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AnnullerActionPerformed
        int status = JOptionPane.showConfirmDialog(this, "Ønsker du at annullere ordren?", "Advarsel!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (status == 0) {
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
    private javax.swing.JLabel jLabel_Bredde;
    private javax.swing.JLabel jLabel_Højde;
    private javax.swing.JLabel jLabel_Overflade;
    private javax.swing.JLabel jLabel_Overskrift;
    private javax.swing.JLabel jLabel_Salgspris;
    private javax.swing.JLabel jLabel_SamletprisOverskrift;
    private javax.swing.JLabel jLabel_VareType;
    private javax.swing.JLabel jLabel_Varegruppe;
    private javax.swing.JLabel jLabel_Varenavn;
    private javax.swing.JLabel jLabel_Varer;
    private javax.swing.JLabel jLabel_VisBredde;
    private javax.swing.JLabel jLabel_VisHøjde;
    private javax.swing.JLabel jLabel_VisSalgsPris;
    private javax.swing.JLabel jLabel_VisVareNavn;
    private javax.swing.JLabel jLabel_VisVaretype;
    private javax.swing.JLabel jLabel_Visoverflade;
    private javax.swing.JLabel jLabel_VælgVareSum;
    private javax.swing.JLabel jLabel_fejlbesked;
    private javax.swing.JLabel jLabel_fejlbesked_Bekræft;
    private javax.swing.JLabel jLabel_købssum_lynsalg;
    private javax.swing.JLabel jLabel_overskrift;
    private javax.swing.JPanel jPanel_LynSalg;
    private javax.swing.JPanel jPanel_MainCard;
    private javax.swing.JPanel jPanel_OrdreBekræftigelse;
    private javax.swing.JPanel jPanel_OversigtVarer;
    private javax.swing.JPanel jPanel_Pris;
    private javax.swing.JPanel jPanel_Valgmuligheder;
    private javax.swing.JPanel jPanel_VareInfo;
    private javax.swing.JPanel jPanel_VareLinjer;
    private javax.swing.JScrollPane jScrollPane_Bekræft_Varelinjer;
    private javax.swing.JScrollPane jScrollPane_VarelinjeScroll;
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
        if (valgteVare_lynsalg.size() < 9) {
            jButtonLynsalgTilføj.setEnabled(true);
            jLabel_fejlbesked.setText("");
        }

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
