/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Utility;
import model.Vare;

/**
 *
 * @author NiklasRenner
 */
public class Panel_LagerLinje extends javax.swing.JPanel {

    private Vare vare;
    private Panel_Lager panel_lager;
    /**
     * Creates new form Panel_LagerLinje
     */
    public Panel_LagerLinje(Vare vare, Panel_Lager panel_lager) {
        this.vare = vare;
        this.panel_lager = panel_lager;
        initComponents();
        int antal = 0;
        if(vare.getVareStatus()==0){
            antal = 1;
        }
        vareNavnLabel.setText(antal + " x " + vare.getNavn());
        vareDimensionLabel.setText(vare.getHøjde() + "x" + vare.getBredde());
        varePrisLabel.setText(Utility.formatDoubleToKr(vare.getSalgspris()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vareNavnLabel = new javax.swing.JLabel();
        vareDimensionLabel = new javax.swing.JLabel();
        varePrisLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 50));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vareNavnLabel.setText("navn");
        jPanel1.add(vareNavnLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        vareDimensionLabel.setText("dimensioner");
        jPanel1.add(vareDimensionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, -1));

        varePrisLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        varePrisLabel.setText("pris");
        jPanel1.add(varePrisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 90, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        panel_lager.enterInfo(vare);
    }//GEN-LAST:event_jPanel1MouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel vareDimensionLabel;
    private javax.swing.JLabel vareNavnLabel;
    private javax.swing.JLabel varePrisLabel;
    // End of variables declaration//GEN-END:variables
}