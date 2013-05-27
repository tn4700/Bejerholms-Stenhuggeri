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

    private String provisions_nr;
    private Timestamp dato;
    private Kontoudtog kontoudtog;

    public Provisionsseddel(String provisions_nr, Timestamp dato, Kontoudtog kontoudtog) {
        this.provisions_nr = provisions_nr;
        this.dato = dato;
        this.kontoudtog = kontoudtog;
    }

    public String getProvisions_nr() {
        return provisions_nr;
    }

    public void setProvisions_nr(String provisions_nr) {
        this.provisions_nr = provisions_nr;
    }

    public Timestamp getDato() {
        return dato;
    }

    public void setDato(Timestamp dato) {
        this.dato = dato;
    }

    public Kontoudtog getKontoudtog() {
        return kontoudtog;
    }

    public void setKontoudtog(Kontoudtog kontoudtog) {
        this.kontoudtog = kontoudtog;
    }
}
