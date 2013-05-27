/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Tom_linje {

    private String navn;
    private double pris;
    private int antal;
    private int id;

    public Tom_linje(String navn, double pris, int antal, int id) {
        this.navn = navn;
        this.pris = pris;
        this.antal = antal;
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
    
    public double getSamletPris(){
        return antal * pris;
    }
    
}
