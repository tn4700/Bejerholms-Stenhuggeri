/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Provisionsseddel_linje {

    private int antal;
    private int linje_nr;
    private String beskrivelse;
    private double enhedspris;
    private double pris;
    private int provisions_nr;

    public Provisionsseddel_linje() {
        this.antal = antal;
        this.linje_nr = linje_nr;
        this.beskrivelse = beskrivelse;
        this.enhedspris = enhedspris;
        this.pris = pris;
        this.provisions_nr = provisions_nr;

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

    public double getEnhedspris() {
        return enhedspris;
    }

    public void setEnhedspris(double enhedspris) {
        this.enhedspris = enhedspris;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getProvisions_nr() {
        return provisions_nr;
    }

    public void setProvisions_nr(int provisions_nr) {
        this.provisions_nr = provisions_nr;
    }
}
