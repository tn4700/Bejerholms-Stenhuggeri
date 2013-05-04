/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Kontoudtog_linje {

    private int antal;
    private int linje_nr;
    private String beskrivelse;
    private float pris;
    private int kontoudtog_nr;

    public Kontoudtog_linje() {
        this.antal = antal;
        this.linje_nr = linje_nr;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.kontoudtog_nr = kontoudtog_nr;

    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getLinje_nr() {
        return linje_nr;
    }

    public void setLinje_nr(int linje_nr) {
        this.linje_nr = linje_nr;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public float getPris() {
        return pris;
    }

    public void setPris(float pris) {
        this.pris = pris;
    }

    public int getKontoudtog_nr() {
        return kontoudtog_nr;
    }

    public void setKontoudtog_nr(int kontoudtog_nr) {
        this.kontoudtog_nr = kontoudtog_nr;
    }
}
