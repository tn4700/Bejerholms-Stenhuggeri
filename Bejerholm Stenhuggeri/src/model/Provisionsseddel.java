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
public class Provisionsseddel {

    private int provisions_nr;
    private Timestamp dato;
    private String vedrørende;
    private String overførelsesbetingelser;
    private Faktura faktura;

    public Provisionsseddel(int provisions_nr,Timestamp dato,String vedrørende,String overførelsesbetingelser,Faktura faktura) {
        this.provisions_nr = provisions_nr;
        this.dato = dato;
        this.vedrørende = vedrørende;
        this.overførelsesbetingelser = overførelsesbetingelser;
        this.faktura = faktura;
    }

    public int getProvisions_nr() {
        return provisions_nr;
    }

    public void setProvisions_nr(int provisions_nr) {
        this.provisions_nr = provisions_nr;
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

    public String getOverførelsesbetingelser() {
        return overførelsesbetingelser;
    }

    public void setOverførelsesbetingelser(String overførelsesbetingelser) {
        this.overførelsesbetingelser = overførelsesbetingelser;
    }

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

   
}
