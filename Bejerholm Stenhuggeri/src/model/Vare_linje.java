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
    private String ordre_nr;
    private Vare vare;
    private Inskription inskription;
    private Tom_linje tom_linje;

    public Vare_linje(int linje_nr, String ordre_nr, Vare vare, Inskription inskription, Tom_linje tom_linje) {
        this.linje_nr = linje_nr;
        this.ordre_nr = ordre_nr;
        this.vare = vare;
        this.inskription = inskription;
        this.tom_linje = tom_linje;
    }

    public int getLinje_nr() {
        return linje_nr;
    }

    public void setLinje_nr(int linje_nr) {
        this.linje_nr = linje_nr;
    }

    public String getOrdre_nr() {
        return ordre_nr;
    }

    public void setOrdre_nr(String ordre_nr) {
        this.ordre_nr = ordre_nr;
    }

    public Vare getVare() {
        return vare;
    }

    public void setVare(Vare vare) {
        this.vare = vare;
    }

    public Inskription getInskription() {
        return inskription;
    }

    public void setInskription(Inskription inskription) {
        this.inskription= inskription;
    }

    public Tom_linje getTom_linje() {
        return tom_linje;
    }

    public void setTom_linje(Tom_linje tom_linje) {
        this.tom_linje = tom_linje;
    }

    @Override
    public String toString() {
        return "Vare_linje{" + "linje_nr=" + linje_nr + ", ordre_nr=" + ordre_nr + ", vare=" + vare + ", inskription=" + inskription + ", tom_linje=" + tom_linje + '}';
    }
    
    
}
