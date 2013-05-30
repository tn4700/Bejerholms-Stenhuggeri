/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DatabaseObjectHandler;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Vare;
import model.Varegruppe;

/**
 *
 * @author NiklasRenner
 */
public class JDialog_OpretVare extends javax.swing.JDialog {

    private Boolean dialogType;
    private ArrayList<Varegruppe> vareGruppeListe;
    private Vare vare;
    private DatabaseObjectHandler dbhandler;

    /**
     * Creates new form JDialog_OpretVare
     */
    public JDialog_OpretVare(java.awt.Frame parent, boolean modal, DatabaseObjectHandler dbhandler) {
        super(parent, modal);
        dialogType = true;
        this.dbhandler = dbhandler;
        this.setLocationRelativeTo(parent);
        this.setTitle("Opret vare");
        initComponents();
        fyldGruppeListe();
    }

    public JDialog_OpretVare(java.awt.Frame parent, boolean modal, DatabaseObjectHandler dbhandler, Vare vare) {
        super(parent, modal);
        dialogType = false;
        this.setLocationRelativeTo(parent);
        this.setTitle("Rediger vare");
        this.dbhandler = dbhandler;
        this.vare = vare;
        initComponents();
        enterInfo(vare);
        fyldGruppeListe();
        vælgVareGruppeComboBox.setSelectedIndex(vare.getGruppe().getGrp_nr() - 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vareInfoOverskriftLabel1 = new javax.swing.JLabel();
        vareInfoPanel = new javax.swing.JPanel();
        annullerButton = new javax.swing.JButton();
        opretVareButton = new javax.swing.JButton();
        vareHøjdeLabel = new javax.swing.JLabel();
        vareNavnLabel = new javax.swing.JLabel();
        vareBreddeLabel = new javax.swing.JLabel();
        indkøbsPrisLabel = new javax.swing.JLabel();
        typeNavnLabel = new javax.swing.JLabel();
        salgsPrisLabel = new javax.swing.JLabel();
        overfladeLabel = new javax.swing.JLabel();
        vareHøjdeTextField = new javax.swing.JTextField();
        vareNavnTextField = new javax.swing.JTextField();
        vareBreddeTextField = new javax.swing.JTextField();
        indkøbsPrisTextField = new javax.swing.JTextField();
        typeNavnTextField = new javax.swing.JTextField();
        salgsPrisTextField = new javax.swing.JTextField();
        vareStatusLabel = new javax.swing.JLabel();
        dekorationLabel = new javax.swing.JLabel();
        vareGruppeLabel = new javax.swing.JLabel();
        vælgVareGruppeComboBox = new javax.swing.JComboBox();
        overFladeComboBox = new javax.swing.JComboBox();
        dekorationComboBox = new javax.swing.JComboBox();
        vareStatusComboBox = new javax.swing.JComboBox();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        vareInfoOverskriftLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vareInfoOverskriftLabel1.setText("Vareinfo");
        vareInfoOverskriftLabel1.setToolTipText("lol");

        vareInfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vareInfoPanel.setOpaque(false);

        annullerButton.setText("Annuller");
        annullerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annullerButtonActionPerformed(evt);
            }
        });

        opretVareButton.setText("Bekræft ");
        opretVareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opretVareButtonActionPerformed(evt);
            }
        });

        vareHøjdeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareHøjdeLabel.setText("Højde");

        vareNavnLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareNavnLabel.setText("Vare navn");

        vareBreddeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareBreddeLabel.setText("Bredde");

        indkøbsPrisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        indkøbsPrisLabel.setText("Købspris");

        typeNavnLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typeNavnLabel.setText("Typenavn");

        salgsPrisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        salgsPrisLabel.setText("Salgspris");

        overfladeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        overfladeLabel.setText("Overflade");

        vareHøjdeTextField.setText("0");

        vareBreddeTextField.setText("0");

        indkøbsPrisTextField.setText("0.00");

        salgsPrisTextField.setText("0.00");

        vareStatusLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareStatusLabel.setText("Varestatus");

        dekorationLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dekorationLabel.setText("Dekoration");

        vareGruppeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vareGruppeLabel.setText("Vare grp.");

        overFladeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Ru", "Poleret" }));

        dekorationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ja", "Nej" }));

        vareStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "På lager", "Reserveret", "Solgt" }));

        javax.swing.GroupLayout vareInfoPanelLayout = new javax.swing.GroupLayout(vareInfoPanel);
        vareInfoPanel.setLayout(vareInfoPanelLayout);
        vareInfoPanelLayout.setHorizontalGroup(
            vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vareInfoPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vareInfoPanelLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(annullerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opretVareButton))
                    .addGroup(vareInfoPanelLayout.createSequentialGroup()
                        .addComponent(typeNavnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(typeNavnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vareInfoPanelLayout.createSequentialGroup()
                        .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salgsPrisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vareStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(salgsPrisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vareStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(vareInfoPanelLayout.createSequentialGroup()
                        .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(vareInfoPanelLayout.createSequentialGroup()
                                .addComponent(vareGruppeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(vælgVareGruppeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vareInfoPanelLayout.createSequentialGroup()
                                .addComponent(indkøbsPrisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(indkøbsPrisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vareInfoPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vareHøjdeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(vareHøjdeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(vareInfoPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(vareBreddeLabel)
                                    .addComponent(overfladeLabel)
                                    .addComponent(dekorationLabel))
                                .addGap(18, 18, 18)
                                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(overFladeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vareBreddeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dekorationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(vareInfoPanelLayout.createSequentialGroup()
                        .addComponent(vareNavnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vareNavnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        vareInfoPanelLayout.setVerticalGroup(
            vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vareInfoPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vareNavnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vareNavnLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vælgVareGruppeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vareHøjdeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vareHøjdeLabel)
                    .addComponent(vareGruppeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(indkøbsPrisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(indkøbsPrisLabel))
                    .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vareBreddeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vareBreddeLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salgsPrisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overFladeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overfladeLabel)
                    .addComponent(salgsPrisLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vareStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vareStatusLabel))
                    .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dekorationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dekorationLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeNavnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeNavnLabel))
                .addGap(12, 12, 12)
                .addGroup(vareInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opretVareButton)
                    .addComponent(annullerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vareInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(vareInfoOverskriftLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vareInfoOverskriftLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vareInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void annullerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annullerButtonActionPerformed
        boolean accept = confirmDialog("Er du sikker på at du vil annullere?", "Annuller ændring");
        if (accept) {
            this.dispose();
        }
    }//GEN-LAST:event_annullerButtonActionPerformed

    private void opretVareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opretVareButtonActionPerformed
        if (validerInput()) {
            if (dialogType) {
                try {
                    vare = new Vare(0, null, 0, 0, 0, 0, null, null, false, 0, null);
                    setVare();
                    String message = "Er du sikker på at du vil oprette varen '" + vare.getNavn().replace("\\", "") + "'?";
                    boolean accept = confirmDialog(message, "Bekræft oprettelse");
                    if (accept) {
                        dbhandler.createVare(vare);
                        this.dispose();
                    }
                } catch (SQLException ex) {
                    errorLabel.setText("Problem med databasen, hold over den besked for detaljer");
                    errorLabel.setToolTipText(ex.getLocalizedMessage());
                }
            } else {
                String message = "Er du sikker på at du vil redigere varen '" + vare.getNavn().replace("\\", "") + "'?";
                boolean accept = confirmDialog(message, "Bekræft redigering");
                if (accept) {
                    setVare();
                    try {
                        dbhandler.editVare(vare);
                        this.dispose();
                    } catch (SQLException ex) {
                        errorLabel.setText("Problem med databasen, hold over den besked for detaljer");
                        errorLabel.setToolTipText(ex.getLocalizedMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_opretVareButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annullerButton;
    private javax.swing.JComboBox dekorationComboBox;
    private javax.swing.JLabel dekorationLabel;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel indkøbsPrisLabel;
    private javax.swing.JTextField indkøbsPrisTextField;
    private javax.swing.JButton opretVareButton;
    private javax.swing.JComboBox overFladeComboBox;
    private javax.swing.JLabel overfladeLabel;
    private javax.swing.JLabel salgsPrisLabel;
    private javax.swing.JTextField salgsPrisTextField;
    private javax.swing.JLabel typeNavnLabel;
    private javax.swing.JTextField typeNavnTextField;
    private javax.swing.JLabel vareBreddeLabel;
    private javax.swing.JTextField vareBreddeTextField;
    private javax.swing.JLabel vareGruppeLabel;
    private javax.swing.JLabel vareHøjdeLabel;
    private javax.swing.JTextField vareHøjdeTextField;
    private javax.swing.JLabel vareInfoOverskriftLabel1;
    private javax.swing.JPanel vareInfoPanel;
    private javax.swing.JLabel vareNavnLabel;
    private javax.swing.JTextField vareNavnTextField;
    private javax.swing.JComboBox vareStatusComboBox;
    private javax.swing.JLabel vareStatusLabel;
    private javax.swing.JComboBox vælgVareGruppeComboBox;
    // End of variables declaration//GEN-END:variables

    public boolean confirmDialog(String message, String title) {
        boolean accept = false;
        String[] options = new String[]{"Ja", "Nej"};
        int reply = JOptionPane.showOptionDialog(this, message, title, JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        if (reply == JOptionPane.YES_OPTION) {
            accept = true;
        }
        return accept;
    }

    public final void enterInfo(Vare vare) {
        vareNavnTextField.setText(vare.getNavn());
        vareBreddeTextField.setText(vare.getBredde() + "");
        vareHøjdeTextField.setText(vare.getHøjde() + "");
        indkøbsPrisTextField.setText(vare.getIndkøbspris() + "");
        salgsPrisTextField.setText(vare.getSalgspris() + "");
        //Vi kunne ikke nå at lave overflade om til boolean og vores input er kontrolleret 
        //så der er kun Ru og Poleret overflade med mindre der er nogle der laver om i databasen
        if (vare.getOverflade() == null || vare.getOverflade().equals("")) {
            overFladeComboBox.setSelectedIndex(0);
        } else if (vare.getOverflade().startsWith("R")) {
            overFladeComboBox.setSelectedIndex(1);
        } else {
            overFladeComboBox.setSelectedIndex(2);
        }
        typeNavnTextField.setText(vare.getTypenavn());
        vareStatusComboBox.setSelectedIndex(vare.getVareStatus());
        if (vare.getDekoration()) {
            dekorationComboBox.setSelectedIndex(0);
        } else {
            dekorationComboBox.setSelectedIndex(1);
        }
    }

    public void setVare() {
        vare.setNavn(vareNavnTextField.getText().trim().replace("'", "\\'"));
        vare.setIndkøbspris(Double.parseDouble(indkøbsPrisTextField.getText()));
        vare.setSalgspris(Double.parseDouble(salgsPrisTextField.getText()));
        vare.setBredde(Integer.parseInt(vareBreddeTextField.getText()));
        vare.setHøjde(Integer.parseInt(vareHøjdeTextField.getText()));
        if (typeNavnTextField.getText().equals("")) {
            vare.setTypenavn("");
        } else {
            vare.setTypenavn(typeNavnTextField.getText().trim().replace("'", "\\'"));
        }
        vare.setVareStatus(vareStatusComboBox.getSelectedIndex());
        if (dekorationComboBox.getSelectedIndex() == 0) {
            vare.setDekoration(true);
        } else {
            vare.setDekoration(false);
        }
        vare.setGruppe((Varegruppe) vælgVareGruppeComboBox.getSelectedItem());
        if (overFladeComboBox.getSelectedIndex() == 0) {
            vare.setOverflade("");
        } else if (overFladeComboBox.getSelectedIndex() == 1) {
            vare.setOverflade("Ru");
        } else if (overFladeComboBox.getSelectedIndex() == 2) {
            vare.setOverflade("Poleret");
        }
    }

    public final void fyldGruppeListe() {
        try {
            vareGruppeListe = dbhandler.getVaregruppeListe();
            for (int i = 0; i < vareGruppeListe.size(); i++) {
                vælgVareGruppeComboBox.addItem(vareGruppeListe.get(i));
            }
        } catch (SQLException ex) {
            errorLabel.setText("Problem med databasen, hold over den besked for detaljer");
            errorLabel.setToolTipText(ex.getLocalizedMessage());
        }
    }

    public void resetLabels() {
        vareNavnLabel.setForeground(Color.black);
        vareBreddeLabel.setForeground(Color.black);
        vareHøjdeLabel.setForeground(Color.black);
        indkøbsPrisLabel.setForeground(Color.black);
        salgsPrisLabel.setForeground(Color.black);
        errorLabel.setText("");
    }

    public String validerString(String string) {
        String newString = string.replace("\\", "");
        return newString;
    }

    public boolean validerInput() {
        boolean valid = true;
        resetLabels();
        String error = "Fejl på følgende input: ";
        boolean isFirst = false;

        if (vareNavnTextField.getText().equals("")) {
            vareNavnLabel.setForeground(Color.red);
            error += vareNavnLabel.getText();
            valid = false;
            isFirst = true;
        } else {
            String old = vareNavnTextField.getText();
            String news = validerString(vareNavnTextField.getText().trim());
            if (!old.equals(news)) {
                vareNavnTextField.setText(validerString(vareNavnTextField.getText().trim()));
                error += vareNavnLabel.getText() + "(Fjernet specialtegn)";
                valid = false;
                isFirst = true;
            }
        }
        try {
            Integer.parseInt(vareBreddeTextField.getText());
        } catch (NumberFormatException ex) {
            vareBreddeLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += vareBreddeLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Integer.parseInt(vareHøjdeTextField.getText());
        } catch (NumberFormatException ex) {
            vareHøjdeLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += vareHøjdeLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Double.parseDouble(indkøbsPrisTextField.getText());
        } catch (NumberFormatException ex) {
            indkøbsPrisLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += indkøbsPrisLabel.getText();
            isFirst = true;
            valid = false;
        }
        try {
            Double.parseDouble(salgsPrisTextField.getText());
        } catch (NumberFormatException ex) {
            salgsPrisLabel.setForeground(Color.red);
            if (isFirst) {
                error += ", ";
            }
            error += salgsPrisLabel.getText();
            valid = false;
            isFirst = true;
        }
        if (!typeNavnTextField.getText().equals("")) {
            String old = typeNavnTextField.getText();
            String news = validerString(typeNavnTextField.getText().trim());
            if (!old.equals(news)) {
                typeNavnTextField.setText(validerString(typeNavnTextField.getText().trim()));
                if (isFirst) {
                    error += ", ";
                }
                error += typeNavnLabel.getText() + "(Fjernet specialtegn)";
                valid = false;
            }
        }
        if (!valid) {
            errorLabel.setText("Fejl i input, hold over denne besked for detaljer.");
            errorLabel.setToolTipText(error);
        }

        return valid;
    }
}
