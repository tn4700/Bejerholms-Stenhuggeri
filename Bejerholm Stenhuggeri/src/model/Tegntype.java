/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Tegntype {

    private String navn;
    private double pris_pr_tegn;
    private int id;

    public Tegntype(String navn, double pris_pr_tegn, int id) {
        this.navn = navn;
        this.pris_pr_tegn = pris_pr_tegn;
        this.id = id;

    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris_pr_tegn() {
        return pris_pr_tegn;
    }

    public void setPris_pr_tegn(double pris_pr_tegn) {
        this.pris_pr_tegn = pris_pr_tegn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
