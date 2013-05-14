/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Varegruppe {

    private int grp_nr;
    private String navn;

    public Varegruppe(int grp_nr, String navn) {
        this.grp_nr = grp_nr;
        this.navn = navn;
    }

    public int getGrp_nr() {
        return grp_nr;
    }

    public void setGrp_nr(int grp_nr) {
        this.grp_nr = grp_nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
