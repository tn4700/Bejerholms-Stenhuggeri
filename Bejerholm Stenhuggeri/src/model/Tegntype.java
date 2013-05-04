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
    private float pris_pr_tegn;
    private int id;

    public Tegntype() {
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

    public float getPris_pr_tegn() {
        return pris_pr_tegn;
    }

    public void setPris_pr_tegn(float pris_pr_tegn) {
        this.pris_pr_tegn = pris_pr_tegn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
