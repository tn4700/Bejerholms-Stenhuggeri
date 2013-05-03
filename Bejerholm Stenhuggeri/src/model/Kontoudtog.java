/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Martin
 */
public class Kontoudtog {
    private int kontoudtog_nr;
    private Timestamp dato;
    private String vedrørende;
    private Timestamp sendt_dato;
    private Faktura faktura_nr;
    
    public Kontoudtog(){
        this.kontoudtog_nr = kontoudtog_nr;
        this.dato=dato;
        this.vedrørende = vedrørende;
        this.sendt_dato = sendt_dato;
        this.faktura_nr = faktura_nr;
    }

    public int getKontoudtog_nr() {
        return kontoudtog_nr;
    }

    public void setKontoudtog_nr(int kontoudtog_nr) {
        this.kontoudtog_nr = kontoudtog_nr;
    }

    public Timestamp getDato() {
        return dato;
    }

    public void setDato(Timestamp dato) {
        this.dato = dato;
    }

    public String getVedrørende() {
        return vedrørende;
    }

    public void setVedrørende(String vedrørende) {
        this.vedrørende = vedrørende;
    }

    public Timestamp getSendt_dato() {
        return sendt_dato;
    }

    public void setSendt_dato(Timestamp sendt_dato) {
        this.sendt_dato = sendt_dato;
    }

    public Faktura getFaktura_nr() {
        return faktura_nr;
    }

    public void setFaktura_nr(Faktura faktura_nr) {
        this.faktura_nr = faktura_nr;
    }
}
