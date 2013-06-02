package view;

import control.DatabaseObjectHandler;
import control.Utility;
import java.awt.Color;
import java.awt.LayoutManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Vare;
import model.Varegruppe;

public class Panel_Lager extends javax.swing.JPanel {

    private DatabaseObjectHandler dbhandler;
    private ArrayList<Vare> vareListe;
    private ArrayList<Varegruppe> vareGruppeListe;
    private MainFrame main;

    public Panel_Lager(DatabaseObjectHandler dbhandler, MainFrame mf) {
        initComponents();
        main = mf;
        vareListe = new ArrayList();
        this.dbhandler = dbhandler;
        vareLinjePanel.setLayout((LayoutManager) new WrapLayout());
        try {
            vareGruppeListe = dbhandler.getVaregruppeListe();
            vareGruppeComboBox.addItem(new Varegruppe(0, "Alle varegrupper"));
            for (int i = 0; i < vareGruppeListe.size(); i++) {
                vareGruppeComboBox.addItem(vareGruppeListe.get(i));
            }
            getFiltreretVareListe();
            opdaterVareLinjePanel();
        } catch (Exception ex) {
            vareInfoErrorLabel.setText("Problem med databasen, hold over denne besked for detaljer");
            vareInfoErrorLabel.setToolTipText(ex.getLocalizedMessage());
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

        vareLinjeScrollPane = new javax.swing.JScrollPane();
        vareLinjePanel = new javax.swing.JPanel();
        vareInfoPanel = new javax.swing.JPanel();
        redigerVareButton = new javax.swing.JButton();
        sletVareButton = new javax.swing.JButton();
        købVareButton = new javax.swing.JButton();
        vareNrLabel = new javax.swing.JLabel();
        vareHøjdeLabel = new javax.swing.JLabel();
        vareNavnLabel = new javax.swing.JLabel();
        vareBreddeLabel = new javax.swing.JLabel();
        indkøbsPrisLabel = new javax.swing.JLabel();
        typeNavnLabel = new javax.swing.JLabel();
        salgsPrisLabel = new javax.swing.JLabel();
        overfladeLabel = new javax.swing.JLabel();
        vareNrTextField = new javax.swing.JTextField();
        vareHøjdeTextField = new javax.swing.JTextField();
        vareNavnTextField = new javax.swing.JTextField();
        vareBreddeTextField = new javax.swing.JTextField();
        indkøbsPrisTextField = new javax.swing.JTextField();
        typeNavnTextField = new javax.swing.JTextField();
        salgsPrisTextField = new javax.swing.JTextField();
        overfladeTextField = new javax.swing.JTextField();
        vareStatusLabel = new javax.swing.JLabel();
        dekorationLabel = new javax.swing.JLabel();
        vareGruppeLabel = new javax.swing.JLabel();
        vareStatusTextField = new javax.swing.JTextField();
        dekorationTextField = new javax.swing.JTextField();
        vareGruppeTextField = new javax.swing.JTextField();
        opretNyVareButton = new javax.swing.JButton();
        vareInfoOverskriftLabel = new javax.swing.JLabel();
        vareFilterPanel = new javax.swing.JPanel();
        filtrerVarelistButton = new javax.swing.JButton();
        vareFilterGruppeLabel = new javax.swing.JLabel();
        maxBreddeLabel = new javax.swing.JLabel();
        maxHøjdeLabel = new javax.swing.JLabel();
        minimumPrisLabel = new javax.swing.JLabel();
        maxPrisLabel = new javax.swing.JLabel();
        vareGruppeComboBox = new javax.swing.JComboBox();
        maxBreddeTextField = new javax.swing.JTextField();
        maxHøjdeTextField = new javax.swing.JTextField();
        minPrisTextField = new javax.swing.JTextField();
        maxPrisTextField = new javax.swing.JTextField();
        minHøjdeTextField = new javax.swing.JTextField();
        minBreddeTextField = new javax.swing.JTextField();
        minimumHøjdeLabel = new javax.swing.JLabel();
        minimumBreddeLabel = new javax.swing.JLabel();
        vareStatusFilterLabel = new javax.swing.JLabel();
        vareStatusComboBox = new javax.swing.JComboBox();
        resetFilterButton = new javax.swing.JButton();
        vareOverskriftLabel1 = new javax.swing.JLabel();
        vareInfoOverskriftLabel1 = new javax.swing.JLabel();
        vareFilterErrorLabel = new javax.swing.JLabel();
        vareInfoErrorLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vareLinjeScrollPane.setBackground(new java.awt.Color(255, 51, 51));
        vareLinjeScrollPane.setBorder(null);
        vareLinjeScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        vareLinjeScrollPane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        vareLinjeScrollPane.setOpaque(false);
        vareLinjeScrollPane.setPreferredSize(new java.awt.Dimension(500, 100));

        vareLinjePanel.setBackground(new java.awt.Color(255, 255, 255));
        vareLinjePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vareLinjePanel.setName("LynSalg"); // NOI18N
        vareLinjePanel.setOpaque(false);
        vareLinjeScrollPane.setViewportView(vareLinjePanel);

        add(vareLinjeScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 38, 330, 452));

        vareInfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vareInfoPanel.setOpaque(false);
        vareInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        redigerVareButton.setText("Rediger vare");
        redigerVareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redigerVareButtonActionPerformed(evt);
            }
        });
        vareInfoPanel.add(redigerVareButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, -1));

        sletVareButton.setText("Slet vare");
        sletVareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sletVareButtonActionPerformed(evt);
            }
        });
        vareInfoPanel.add(sletVareButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        købVareButton.setText("Køb vare");
        købVareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                købVareButtonActionPerformed(evt);
            }
        });
        vareInfoPanel.add(købVareButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        vareNrLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareNrLabel.setText("Vare nr.");
        vareInfoPanel.add(vareNrLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 45, 60, -1));

        vareHøjdeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareHøjdeLabel.setText("Højde");
        vareInfoPanel.add(vareHøjdeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 45, -1, -1));

        vareNavnLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareNavnLabel.setText("Vare navn");
        vareInfoPanel.add(vareNavnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 19, 60, -1));

        vareBreddeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareBreddeLabel.setText("Bredde");
        vareInfoPanel.add(vareBreddeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 71, -1, -1));

        indkøbsPrisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        indkøbsPrisLabel.setText("Købspris");
        vareInfoPanel.add(indkøbsPrisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 71, 60, -1));

        typeNavnLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typeNavnLabel.setText("Typenavn");
        vareInfoPanel.add(typeNavnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 148, 60, -1));

        salgsPrisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        salgsPrisLabel.setText("Salgspris");
        vareInfoPanel.add(salgsPrisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 97, 60, -1));

        overfladeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        overfladeLabel.setText("Overflade");
        vareInfoPanel.add(overfladeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 97, -1, -1));

        vareNrTextField.setEditable(false);
        vareInfoPanel.add(vareNrTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 39, 141, -1));

        vareHøjdeTextField.setEditable(false);
        vareInfoPanel.add(vareHøjdeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 39, 110, -1));

        vareNavnTextField.setEditable(false);
        vareInfoPanel.add(vareNavnTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 13, 345, -1));

        vareBreddeTextField.setEditable(false);
        vareInfoPanel.add(vareBreddeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 65, 110, -1));

        indkøbsPrisTextField.setEditable(false);
        vareInfoPanel.add(indkøbsPrisTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 65, 141, -1));

        typeNavnTextField.setEditable(false);
        vareInfoPanel.add(typeNavnTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 143, 345, -1));

        salgsPrisTextField.setEditable(false);
        vareInfoPanel.add(salgsPrisTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 91, 141, -1));

        overfladeTextField.setEditable(false);
        vareInfoPanel.add(overfladeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 91, 110, -1));

        vareStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareStatusLabel.setText("Varestatus");
        vareInfoPanel.add(vareStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 123, 60, -1));

        dekorationLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dekorationLabel.setText("Dekoration");
        vareInfoPanel.add(dekorationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 123, -1, -1));

        vareGruppeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareGruppeLabel.setText("Vare grp.");
        vareInfoPanel.add(vareGruppeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 174, 60, -1));

        vareStatusTextField.setEditable(false);
        vareInfoPanel.add(vareStatusTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 117, 141, -1));

        dekorationTextField.setEditable(false);
        vareInfoPanel.add(dekorationTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 117, 110, -1));

        vareGruppeTextField.setEditable(false);
        vareInfoPanel.add(vareGruppeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 168, 141, -1));

        opretNyVareButton.setText("Opret ny vare");
        opretNyVareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opretNyVareButtonActionPerformed(evt);
            }
        });
        vareInfoPanel.add(opretNyVareButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 210, -1, -1));

        add(vareInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 450, 250));

        vareInfoOverskriftLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vareInfoOverskriftLabel.setText("Varefilter");
        vareInfoOverskriftLabel.setToolTipText("lol");
        add(vareInfoOverskriftLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 90, -1));

        vareFilterPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vareFilterPanel.setOpaque(false);
        vareFilterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        filtrerVarelistButton.setText("Filtrer");
        filtrerVarelistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrerVarelistButtonActionPerformed(evt);
            }
        });
        vareFilterPanel.add(filtrerVarelistButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 121, -1, -1));

        vareFilterGruppeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareFilterGruppeLabel.setText("Vælg varegruppe");
        vareFilterPanel.add(vareFilterGruppeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));

        maxBreddeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maxBreddeLabel.setText("Max bredde");
        vareFilterPanel.add(maxBreddeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 98, -1, -1));

        maxHøjdeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maxHøjdeLabel.setText("Max højde");
        vareFilterPanel.add(maxHøjdeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 73, -1, -1));

        minimumPrisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        minimumPrisLabel.setText("Min. pris");
        vareFilterPanel.add(minimumPrisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 47, -1, -1));

        maxPrisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        maxPrisLabel.setText("Max pris");
        vareFilterPanel.add(maxPrisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 47, -1, -1));

        vareFilterPanel.add(vareGruppeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 13, 315, -1));

        maxBreddeTextField.setText("0");
        vareFilterPanel.add(maxBreddeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 95, 100, -1));

        maxHøjdeTextField.setText("0");
        vareFilterPanel.add(maxHøjdeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 70, 100, -1));

        minPrisTextField.setText("0.00");
        vareFilterPanel.add(minPrisTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 44, 100, -1));

        maxPrisTextField.setText("0.00");
        vareFilterPanel.add(maxPrisTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 44, 100, -1));

        minHøjdeTextField.setText("0");
        vareFilterPanel.add(minHøjdeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 70, 100, -1));

        minBreddeTextField.setText("0");
        vareFilterPanel.add(minBreddeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 95, 100, -1));

        minimumHøjdeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        minimumHøjdeLabel.setText("Min. højde");
        vareFilterPanel.add(minimumHøjdeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 73, -1, -1));

        minimumBreddeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        minimumBreddeLabel.setText("Min. bredde");
        vareFilterPanel.add(minimumBreddeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 98, -1, -1));

        vareStatusFilterLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareStatusFilterLabel.setText("Varestatus");
        vareFilterPanel.add(vareStatusFilterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 125, -1, -1));

        vareStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "På lager", "Reserveret", "Solgt", "Alle varer" }));
        vareFilterPanel.add(vareStatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 123, 100, -1));

        resetFilterButton.setText("Nulstil filter");
        resetFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFilterButtonActionPerformed(evt);
            }
        });
        vareFilterPanel.add(resetFilterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 121, -1, -1));

        add(vareFilterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 450, 160));

        vareOverskriftLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vareOverskriftLabel1.setText("Vareliste");
        vareOverskriftLabel1.setToolTipText("lol");
        add(vareOverskriftLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        vareInfoOverskriftLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vareInfoOverskriftLabel1.setText("Vareinfo");
        vareInfoOverskriftLabel1.setToolTipText("lol");
        add(vareInfoOverskriftLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        vareFilterErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        vareFilterErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(vareFilterErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 320, 20));

        vareInfoErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        vareInfoErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        add(vareInfoErrorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 340, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void filtrerVarelistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrerVarelistButtonActionPerformed
        if (validerVareFilterInput()) {
            resetVareInfoErrors();
            resetVareInfo();
            getFiltreretVareListe();
            opdaterVareLinjePanel();
        }
    }//GEN-LAST:event_filtrerVarelistButtonActionPerformed

    private void sletVareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sletVareButtonActionPerformed
        resetVareInfoErrors();
        Vare vare = null;
        if (!vareNrTextField.getText().equals("")) {
            try {
                vare = dbhandler.getVare(Integer.parseInt(vareNrTextField.getText()));
                String message = "Er du sikker på at du vil slette varen " + vare.getNavn() + "?";
                String title = "Bekræft sletning";
                if (visAcceptDialog(message, title)) {
                    dbhandler.deleteVare(dbhandler.getVare(Integer.parseInt(vareNrTextField.getText())));
                    resetVareInfo();
                    getFiltreretVareListe();
                    opdaterVareLinjePanel();
                }
            } catch (SQLException ex) {
                if (vare == null) {
                    vareInfoErrorLabel.setText("Problem med databasen, hold over denne besked for detaljer");
                    vareInfoErrorLabel.setToolTipText(ex.getLocalizedMessage());
                } else {
                    vareInfoErrorLabel.setText("Vare kan ikke slettes, da den bruges i en ordre/faktura.");
                }
            }
        }
    }//GEN-LAST:event_sletVareButtonActionPerformed

    private void redigerVareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redigerVareButtonActionPerformed
        resetVareInfoErrors();
        if (!vareNrTextField.getText().equals("")) {
            try {
                int vare_nr = Integer.parseInt(vareNrTextField.getText());
                Vare vare = dbhandler.getVare(vare_nr);
                JDialog_LagerVare jDialog = new JDialog_LagerVare(main, true, dbhandler, vare);
                jDialog.setVisible(true);
                enterVareInfo(dbhandler.getVare(vare_nr));
                resetVareFilter();
                getFiltreretVareListe();
                opdaterVareLinjePanel();
            } catch (SQLException ex) {
                vareInfoErrorLabel.setText("Problem med databasen, hold over denne besked for detaljer");
                vareInfoErrorLabel.setToolTipText(ex.getMessage());
            }
        } else {
            vareInfoErrorLabel.setText("Du skal først vælge en vare før du kan trykke rediger.");
        }
    }//GEN-LAST:event_redigerVareButtonActionPerformed

    private void opretNyVareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opretNyVareButtonActionPerformed
        resetVareInfoErrors();
        try {
            int max = dbhandler.getMaxVareNr();
            JDialog_LagerVare jDialog = new JDialog_LagerVare(main, true, dbhandler);
            jDialog.setVisible(true);
            resetVareInfo();
            int newMax = dbhandler.getMaxVareNr();
            if (newMax != max) {
                enterVareInfo(dbhandler.getVare(newMax));
                resetVareFilter();
                getFiltreretVareListe();
                opdaterVareLinjePanel();
            }
        } catch (SQLException ex) {
            vareInfoErrorLabel.setText("Problem med databasen, hold over denne besked for detaljer");
            vareInfoErrorLabel.setToolTipText(ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_opretNyVareButtonActionPerformed

    private void resetFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilterButtonActionPerformed
        resetVareFilter();
        getFiltreretVareListe();
        opdaterVareLinjePanel();
    }//GEN-LAST:event_resetFilterButtonActionPerformed

    private void købVareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_købVareButtonActionPerformed
        resetVareInfoErrors();
        if (!vareNrTextField.getText().equals("")) {
            try {
                int vare_nr = Integer.parseInt(vareNrTextField.getText());
                Vare vare = dbhandler.getVare(vare_nr);
                main.skiftcard(vare);
            } catch (SQLException ex) {
                vareInfoErrorLabel.setText("Problem med databasen, hold over denne besked for detaljer");
                vareInfoErrorLabel.setToolTipText(ex.getMessage());
            }
        } else {
            vareInfoErrorLabel.setText("Du skal først vælge en vare før du kan trykke køb.");
        }
    }//GEN-LAST:event_købVareButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dekorationLabel;
    private javax.swing.JTextField dekorationTextField;
    private javax.swing.JButton filtrerVarelistButton;
    private javax.swing.JLabel indkøbsPrisLabel;
    private javax.swing.JTextField indkøbsPrisTextField;
    private javax.swing.JButton købVareButton;
    private javax.swing.JLabel maxBreddeLabel;
    private javax.swing.JTextField maxBreddeTextField;
    private javax.swing.JLabel maxHøjdeLabel;
    private javax.swing.JTextField maxHøjdeTextField;
    private javax.swing.JLabel maxPrisLabel;
    private javax.swing.JTextField maxPrisTextField;
    private javax.swing.JTextField minBreddeTextField;
    private javax.swing.JTextField minHøjdeTextField;
    private javax.swing.JTextField minPrisTextField;
    private javax.swing.JLabel minimumBreddeLabel;
    private javax.swing.JLabel minimumHøjdeLabel;
    private javax.swing.JLabel minimumPrisLabel;
    private javax.swing.JButton opretNyVareButton;
    private javax.swing.JLabel overfladeLabel;
    private javax.swing.JTextField overfladeTextField;
    private javax.swing.JButton redigerVareButton;
    private javax.swing.JButton resetFilterButton;
    private javax.swing.JLabel salgsPrisLabel;
    private javax.swing.JTextField salgsPrisTextField;
    private javax.swing.JButton sletVareButton;
    private javax.swing.JLabel typeNavnLabel;
    private javax.swing.JTextField typeNavnTextField;
    private javax.swing.JLabel vareBreddeLabel;
    private javax.swing.JTextField vareBreddeTextField;
    private javax.swing.JLabel vareFilterErrorLabel;
    private javax.swing.JLabel vareFilterGruppeLabel;
    private javax.swing.JPanel vareFilterPanel;
    private javax.swing.JComboBox vareGruppeComboBox;
    private javax.swing.JLabel vareGruppeLabel;
    private javax.swing.JTextField vareGruppeTextField;
    private javax.swing.JLabel vareHøjdeLabel;
    private javax.swing.JTextField vareHøjdeTextField;
    private javax.swing.JLabel vareInfoErrorLabel;
    private javax.swing.JLabel vareInfoOverskriftLabel;
    private javax.swing.JLabel vareInfoOverskriftLabel1;
    private javax.swing.JPanel vareInfoPanel;
    private javax.swing.JPanel vareLinjePanel;
    private javax.swing.JScrollPane vareLinjeScrollPane;
    private javax.swing.JLabel vareNavnLabel;
    private javax.swing.JTextField vareNavnTextField;
    private javax.swing.JLabel vareNrLabel;
    private javax.swing.JTextField vareNrTextField;
    private javax.swing.JLabel vareOverskriftLabel1;
    private javax.swing.JComboBox vareStatusComboBox;
    private javax.swing.JLabel vareStatusFilterLabel;
    private javax.swing.JLabel vareStatusLabel;
    private javax.swing.JTextField vareStatusTextField;
    // End of variables declaration//GEN-END:variables

    public boolean visAcceptDialog(String message, String title) {
        boolean accept = false;
        String[] options = new String[]{"Ja", "Nej"};
        int reply = JOptionPane.showOptionDialog(this, message, title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (reply == JOptionPane.YES_OPTION) {
            accept = true;
        }
        return accept;
    }

    public final void opdaterVareLinjePanel() {
        vareLinjePanel.removeAll();
        vareLinjePanel.updateUI();
        for (int i = 0; i < vareListe.size(); i++) {
            vareLinjePanel.add(new Panel_LagerLinje(vareListe.get(i), this));
        }
    }

    public final void getFiltreretVareListe() {
        try {
            Varegruppe varegruppe = (Varegruppe) vareGruppeComboBox.getSelectedItem();
            vareListe = dbhandler.getFiltreretVareListe(
                    varegruppe.getGrp_nr(),
                    Integer.parseInt(minHøjdeTextField.getText()),
                    Integer.parseInt(maxHøjdeTextField.getText()),
                    Integer.parseInt(minBreddeTextField.getText()),
                    Integer.parseInt(maxBreddeTextField.getText()),
                    Double.parseDouble(minPrisTextField.getText()),
                    Double.parseDouble(maxPrisTextField.getText()),
                    vareStatusComboBox.getSelectedIndex());
        } catch (SQLException ex) {
            vareFilterErrorLabel.setText("Problem med databasen, hold over denne besked for detaljer");
            vareFilterErrorLabel.setToolTipText(ex.getLocalizedMessage());
        }
    }

    public void resetVareInfo() {
        vareNrTextField.setText("");
        vareNavnTextField.setText("");
        vareBreddeTextField.setText("");
        vareHøjdeTextField.setText("");
        indkøbsPrisTextField.setText("");
        salgsPrisTextField.setText("");
        overfladeTextField.setText("");
        typeNavnTextField.setText("");
        vareStatusTextField.setText("");
        dekorationTextField.setText("");
        vareGruppeTextField.setText("");
    }

    public void resetVareFilter() {
        minHøjdeTextField.setText("0");
        maxHøjdeTextField.setText("0");
        minBreddeTextField.setText("0");
        maxBreddeTextField.setText("0");
        minPrisTextField.setText("0.00");
        maxPrisTextField.setText("0.00");
        vareGruppeComboBox.setSelectedIndex(0);
        vareStatusComboBox.setSelectedIndex(0);
        resetVareFilterErrors();
    }

    public void enterVareInfo(Vare vare) {
        vareNrTextField.setText(vare.getVare_nr() + "");
        vareNavnTextField.setText(vare.getNavn());
        vareBreddeTextField.setText(vare.getBredde() + " cm");
        vareHøjdeTextField.setText(vare.getHøjde() + " cm");
        indkøbsPrisTextField.setText(Utility.formatDoubleToKr(vare.getIndkøbspris()));
        salgsPrisTextField.setText(Utility.formatDoubleToKr(vare.getSalgspris()));
        if (vare.getOverflade() == 0) {
            overfladeTextField.setText("");
        } else if (vare.getOverflade() == 1) {
            overfladeTextField.setText("Ru");
        } else {
            overfladeTextField.setText("Poleret");
        }
        if(vare.getVaretype()!=null){
        typeNavnTextField.setText(vare.getVaretype().getNavn());
        }
        vareStatusTextField.setText(vare.getVareStatusToString());
        dekorationTextField.setText(vare.getDekorationToString());
        vareGruppeTextField.setText(vare.getGruppe().toString());
    }

    public void resetVareInfoErrors() {
        vareInfoErrorLabel.setText("");
        vareInfoErrorLabel.setToolTipText("");
    }

    public void resetVareFilterErrors() {
        vareFilterErrorLabel.setText("");
        vareFilterErrorLabel.setToolTipText("");
        minimumPrisLabel.setForeground(Color.black);
        minimumBreddeLabel.setForeground(Color.black);
        minimumHøjdeLabel.setForeground(Color.black);
        maxPrisLabel.setForeground(Color.black);
        maxBreddeLabel.setForeground(Color.black);
        maxHøjdeLabel.setForeground(Color.black);
    }

    public boolean validerVareFilterInput() {
        boolean valid = true;
        resetVareFilterErrors();
        String error = "Fejl på følgende input: ";
        boolean isFirst = false;

        try {
            Integer.parseInt(minHøjdeTextField.getText());
        } catch (NumberFormatException ex) {
            minimumHøjdeLabel.setForeground(Color.red);
            error += minimumHøjdeLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Integer.parseInt(maxHøjdeTextField.getText());
        } catch (NumberFormatException ex) {
            maxHøjdeLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += maxHøjdeLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Integer.parseInt(minBreddeTextField.getText());
        } catch (NumberFormatException ex) {
            minimumBreddeLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += minimumBreddeLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Integer.parseInt(maxBreddeTextField.getText());
        } catch (NumberFormatException ex) {
            maxBreddeLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += maxBreddeLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Double.parseDouble(minPrisTextField.getText());
        } catch (NumberFormatException ex) {
            minimumPrisLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += minimumPrisLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Double.parseDouble(maxPrisTextField.getText());
        } catch (NumberFormatException ex) {
            maxPrisLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += maxPrisLabel.getText();
            valid = false;
        }

        if (!valid) {
            vareFilterErrorLabel.setText("Fejl i input, hold over denne besked for detaljer.");
            vareFilterErrorLabel.setToolTipText(error);
        }

        return valid;
    }
}
