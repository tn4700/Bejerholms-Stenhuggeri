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
    private Provisionsseddel provisionsseddel;
    
    public Kontoudtog(int kontoudtog_nr, Timestamp dato, String vedrørende, Timestamp sendt_dato, Provisionsseddel provisionsseddel) {
        this.kontoudtog_nr = kontoudtog_nr;
        this.dato = dato;
        this.vedrørende = vedrørende;
        this.sendt_dato = sendt_dato;
        this.provisionsseddel = provisionsseddel;
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

    public Provisionsseddel getProvisionsseddel() {
        return provisionsseddel;
    }

    public void setProvisionsseddel(Provisionsseddel provisionsseddel) {
        this.provisionsseddel = provisionsseddel;
    }
}
