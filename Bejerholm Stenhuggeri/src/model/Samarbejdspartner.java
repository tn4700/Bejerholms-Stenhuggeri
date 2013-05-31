/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Samarbejdspartner {

    private String firmanavn;
    private String adresse;
    private int tlf;
    private int cvr_nr;
    private int registrerings_nr;
    private String konto_nr;
    private String bank;
    private Postnummer post_nr;

    public Samarbejdspartner(String firmanavn,String adresse,int tlf,int cvr_nr,int registrerings_nr,String konto_nr,String bank,Postnummer post_nr) {
        this.firmanavn = firmanavn;
        this.adresse = adresse;
        this.tlf = tlf;
        this.cvr_nr = cvr_nr;
        this.registrerings_nr = registrerings_nr;
        this.konto_nr = get10CharKontoNr(konto_nr);
        this.bank = bank;
        this.post_nr = post_nr;

    }

    public String getFirmanavn() {
        return firmanavn;
    }

    public void setFirmanavn(String firmanavn) {
        this.firmanavn = firmanavn;
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

    public int getCvr_nr() {
        return cvr_nr;
    }

    public void setCvr_nr(int cvr_nr) {
        this.cvr_nr = cvr_nr;
    }

    public int getRegistrerings_nr() {
        return registrerings_nr;
    }

    public void setRegistrerings_nr(int registrerings_nr) {
        this.registrerings_nr = registrerings_nr;
    }

    public String getKonto_nr() {
        return konto_nr;
    }

    public void setKonto_nr(String konto_nr) {
        this.konto_nr = get10CharKontoNr(konto_nr);
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Postnummer getPost_nr() {
        return post_nr;
    }

    public void setPost_nr(Postnummer post_nr) {
        this.post_nr = post_nr;
    }
    
    public final String get10CharKontoNr(String konto_nr){
        for (int i = 0; i < (10-konto_nr.length()); i++) {
            konto_nr = "0" + konto_nr;
        }
        return konto_nr;
    }
}
