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
    private Faktura faktura;

    public Provisionsseddel(int provisions_nr, Timestamp dato, Faktura faktura) {
        this.provisions_nr = provisions_nr;
        this.dato = dato;
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

    public Faktura getFaktura() {
        return faktura;
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }

   
}
