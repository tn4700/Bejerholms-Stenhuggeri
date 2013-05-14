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
public class Faktura {

    private String faktura_nr;
    private Timestamp faktureringsdato;
    private String vedrørende;
    private String betalingsbetingelser;
    private Timestamp sendt_dato;
    private String faktureringsadresse;
    private boolean fakturatype;
    private boolean betalingsstatus;
    private Ordre ordre;
    private Samarbejdspartner bedemand;

    public Faktura(String faktura_nr,
            Timestamp faktureringsdato,
            String vedrørende,
            String betalingsbetingelser,
            Timestamp sendt_dato,
            String faktureringsadresse,
            boolean fakturatype,
            boolean betalingsstatus,
            Ordre ordre,
            Samarbejdspartner bedemand) {
        
        this.faktura_nr = faktura_nr;
        this.faktureringsdato = faktureringsdato;
        this.vedrørende = vedrørende;
        this.betalingsbetingelser = betalingsbetingelser;
        this.sendt_dato = sendt_dato;
        this.faktureringsadresse = faktureringsadresse;
        this.fakturatype = fakturatype;
        this.betalingsstatus = betalingsstatus;
        this.ordre = ordre;
        this.bedemand = bedemand;
    }

    public Ordre getOrdre() {
        return ordre;
    }

    public void setOrdre(Ordre ordre) {
        this.ordre = ordre;
    }

    public Samarbejdspartner getBedemand() {
        return bedemand;
    }

    public void setBedemand(Samarbejdspartner bedemand) {
        this.bedemand = bedemand;
    }

    public String getFaktura_nr() {
        return faktura_nr;
    }

    public void setFaktura_nr(String faktura_nr) {
        this.faktura_nr = faktura_nr;
    }

    public Timestamp getFaktureringsdato() {
        return faktureringsdato;
    }

    public void setFaktureringsdato(Timestamp faktureringsdato) {
        this.faktureringsdato = faktureringsdato;
    }

    public String getVedrørende() {
        return vedrørende;
    }

    public void setVedrørende(String vedrørende) {
        this.vedrørende = vedrørende;
    }

    public String getBetalingsbetingelser() {
        return betalingsbetingelser;
    }

    public void setBetalingsbetingelser(String betalingsbetingelser) {
        this.betalingsbetingelser = betalingsbetingelser;
    }

    public Timestamp getSendt_dato() {
        return sendt_dato;
    }

    public void setSendt_dato(Timestamp sendt_dato) {
        this.sendt_dato = sendt_dato;
    }

    public String getFaktureringsadresse() {
        return faktureringsadresse;
    }

    public void setFaktureringsadresse(String faktureringsadresse) {
        this.faktureringsadresse = faktureringsadresse;
    }

    public boolean isFakturatype() {
        return fakturatype;
    }

    public void setFakturatype(boolean fakturatype) {
        this.fakturatype = fakturatype;
    }

    public boolean isBetalingsstatus() {
        return betalingsstatus;
    }

    public void setBetalingsstatus(boolean betalingsstatus) {
        this.betalingsstatus = betalingsstatus;
    }
}
