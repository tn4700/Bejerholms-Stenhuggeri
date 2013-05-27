/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Utility;
import java.sql.Timestamp;

/**
 *
 * @author Martin
 */
public class Kontoudtog {

    private String kontoudtog_nr;
    private Timestamp dato;
    private Timestamp sendt_dato;

    public Kontoudtog(String kontoudtog_nr, Timestamp dato, Timestamp sendt_dato) {
        this.kontoudtog_nr = kontoudtog_nr;
        if (dato != null) {
            this.dato = dato;
        } else {
            this.dato = Utility.getCurrentTime();
        }
        this.sendt_dato = sendt_dato;
    }

    public String getKontoudtog_nr() {
        return kontoudtog_nr;
    }

    public void setKontoudtog_nr(String kontoudtog_nr) {
        this.kontoudtog_nr = kontoudtog_nr;
    }

    public Timestamp getDato() {
        return dato;
    }

    public void setDato(Timestamp dato) {
        this.dato = dato;
    }

    public Timestamp getSendt_dato() {
        return sendt_dato;
    }

    public void setSendt_dato(Timestamp sendt_dato) {
        this.sendt_dato = sendt_dato;
    }
}
