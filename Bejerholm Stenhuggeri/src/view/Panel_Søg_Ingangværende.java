/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DatabaseObjectHandler;
import model.Faktura;
import util.Utility;
import model.Ordre;

/**
 *
 * @author T
 */
public class Panel_Søg_Ingangværende extends javax.swing.JPanel {

    private Faktura faktura;
    private DatabaseObjectHandler dbhandler;
    private Panel_Søg panel;
    private Ordre ordre;
    boolean valgttype; 
    // true = faktura
    //  false = ordre

    /**
     * Creates new form Panel_Søg_Faktura
     */
    public Panel_Søg_Ingangværende(Faktura faktura, DatabaseObjectHandler dbhandler, Panel_Søg panel) {
        valgttype = true;
        this.dbhandler = dbhandler;
        this.faktura = faktura;
        this.panel = panel;
        initComponents();
        jLabel_tekst1.setText("Faktureringsdato:");
        jLabel_tekst2.setText("Sendt dato:");
        jLabel_fakturanr.setText("Faktura nr : " + faktura.getFaktura_nr());
        jLabel_vistekst1.setText(Utility.formatTimestampToString(faktura.getFaktureringsdato()));
        jLabel_Vistekst2.setText(Utility.formatTimestampToString(faktura.getSendt_dato()));

    }

    public Panel_Søg_Ingangværende(Ordre ordre, DatabaseObjectHandler dbhandler, Panel_Søg panel) {
        valgttype = false;
        this.dbhandler = dbhandler;
        this.ordre = ordre;
        this.panel = panel;
        initComponents();
        setBackground(new java.awt.Color(211, 255, 216));
        jButton3.setText("Se Ordre");

        jLabel_fakturanr.setText("Ordre nr: " + ordre.getOrdre_nr());
        jLabel_tekst2.setText("");
        jLabel_Vistekst2.setText("");
        jLabel_tekst1.setText("Kunde navn");
        jLabel_vistekst1.setText(ordre.getKunde().getFornavn() + " " + ordre.getKunde().getEfternavn());


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_fakturanr = new javax.swing.JLabel();
        jLabel_tekst1 = new javax.swing.JLabel();
        jLabel_tekst2 = new javax.swing.JLabel();
        jLabel_vistekst1 = new javax.swing.JLabel();
        jLabel_Vistekst2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 240, 240));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setMinimumSize(new java.awt.Dimension(376, 74));
        setPreferredSize(new java.awt.Dimension(376, 74));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_fakturanr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_fakturanr.setText("Faktura nr:");
        add(jLabel_fakturanr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, -1));

        jLabel_tekst1.setText("[vistekst1]");
        add(jLabel_tekst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, -1));

        jLabel_tekst2.setText("[vistekst2]");
        add(jLabel_tekst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, -1));

        jLabel_vistekst1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_vistekst1.setText("jLabel1");
        add(jLabel_vistekst1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 80, -1));

        jLabel_Vistekst2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Vistekst2.setText("jLabel2");
        add(jLabel_Vistekst2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 80, -1));

        jButton3.setText("Se faktura");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (valgttype) {
             JDialog_SøgFaktura visfaktura = new JDialog_SøgFaktura(null, true, dbhandler, faktura);
             visfaktura.setVisible(true);
        } else {
            JDialog_SøgOrdre visordre = new JDialog_SøgOrdre(null, true, dbhandler, ordre);
            visordre.setVisible(true);
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel_Vistekst2;
    private javax.swing.JLabel jLabel_fakturanr;
    private javax.swing.JLabel jLabel_tekst1;
    private javax.swing.JLabel jLabel_tekst2;
    private javax.swing.JLabel jLabel_vistekst1;
    // End of variables declaration//GEN-END:variables
}
