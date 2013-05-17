/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;


/**
 *
 * @author Oliver
 */
public class Kunde {

    private String fornavn;
    private String efternavn;
    private String adresse;
    private int tlf;
    private Postnummer post_nr;

    public Kunde(String fornavn, String efternavn, String adresse, int tlf, Postnummer post_nr) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresse = adresse;
        this.tlf = tlf;
        this.post_nr = post_nr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public Postnummer getPost_nr() {
        return post_nr;
    }

    public void setPost_nr(Postnummer post_nr) {
        this.post_nr = post_nr;
    }

    @Override
    public String toString() {
        return "Kunde{" + "fornavn=" + fornavn + ", efternavn=" + efternavn + ", adresse=" + adresse + ", tlf=" + tlf + ", post_nr=" + post_nr + "}";
    }
}
