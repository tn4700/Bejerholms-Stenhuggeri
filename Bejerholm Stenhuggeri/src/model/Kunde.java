/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Oliver
 */
public class Kunde {

    private String fornavn;
    private String efternavn;
    private String adresse;
    private int tlf;
    private Postnumre post_nr;

    public Kunde() {
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

    public Postnumre getPost_nr() {
        return post_nr;
    }

    public void setPost_nr(Postnumre post_nr) {
        this.post_nr = post_nr;
    }
}
