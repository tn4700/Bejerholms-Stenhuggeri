/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Vare_linje {

    private int linje_nr;
    private int ordre_nr;
    private Vare_linje vare_nr;
    private Inskription inskription_id;
    private Tom_linje tom_linje;

    public Vare_linje(int linje_nr, int ordre_nr, Vare_linje vare_nr, Inskription inskription_id, Tom_linje tom_linje) {
        this.linje_nr = linje_nr;
        this.ordre_nr = ordre_nr;
        this.vare_nr = vare_nr;
        this.inskription_id = inskription_id;
        this.tom_linje = tom_linje;
    }
    
    public void vælgVare(Vare vælgv){
        
    }

    public int getLinje_nr() {
        return linje_nr;
    }

    public void setLinje_nr(int linje_nr) {
        this.linje_nr = linje_nr;
    }

    public int getOrdre_nr() {
        return ordre_nr;
    }

    public void setOrdre_nr(int ordre_nr) {
        this.ordre_nr = ordre_nr;
    }

    public Vare_linje getVare_nr() {
        return vare_nr;
    }

    public void setVare_nr(Vare_linje vare_nr) {
        this.vare_nr = vare_nr;
    }

    public Inskription getInskription_id() {
        return inskription_id;
    }

    public void setInskription_id(Inskription inskription_id) {
        this.inskription_id = inskription_id;
    }

    public Tom_linje getTom_linje_id() {
        return tom_linje;
    }

    public void setTom_linje_id(Tom_linje tom_linje_id) {
        this.tom_linje = tom_linje_id;
    }
}
