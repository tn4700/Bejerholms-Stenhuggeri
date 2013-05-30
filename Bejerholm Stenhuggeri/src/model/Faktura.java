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
    private Timestamp sendt_dato;
    private String faktureringsadresse;
    private boolean fakturatype; //True = bedemand, false = normal
    private boolean betalingsstatus; // True = betalt, false = ikke betalt
    private Ordre ordre;
    private Samarbejdspartner bedemand;
    private Provisionsseddel provisionsseddel;

    public Faktura(String faktura_nr,
            Timestamp faktureringsdato,
            String vedrørende,
            Timestamp sendt_dato,
            String faktureringsadresse,
            boolean fakturatype,
            boolean betalingsstatus,
            Ordre ordre,
            Samarbejdspartner bedemand,
            Provisionsseddel provisionsseddel) {

        this.faktura_nr = faktura_nr;
        this.faktureringsdato = faktureringsdato;
        this.vedrørende = vedrørende;
        this.sendt_dato = sendt_dato;
        this.faktureringsadresse = faktureringsadresse;
        this.fakturatype = fakturatype;
        this.betalingsstatus = betalingsstatus;
        this.ordre = ordre;
        this.bedemand = bedemand;
        this.provisionsseddel = provisionsseddel;
    }

    public Provisionsseddel getProvisionsseddel() {
        return provisionsseddel;
    }

    public void setProvisionsseddel(Provisionsseddel provisionsseddel) {
        this.provisionsseddel = provisionsseddel;
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

    public boolean getFakturatype() {
        return fakturatype;
    }

    public void setFakturatype(boolean fakturatype) {
        this.fakturatype = fakturatype;
    }

    public boolean getBetalingsstatus() {
        return betalingsstatus;
    }

    public void setBetalingsstatus(boolean betalingsstatus) {
        this.betalingsstatus = betalingsstatus;
    }

    @Override
    public String toString() {
        return "Faktura{" + "faktura_nr=" + faktura_nr + ", faktureringsdato=" + faktureringsdato + ", vedr\u00f8rende=" + vedrørende + ", sendt_dato=" + sendt_dato + ", faktureringsadresse=" + faktureringsadresse + ", fakturatype=" + fakturatype + ", betalingsstatus=" + betalingsstatus + ", ordre=" + ordre + ", bedemand=" + bedemand + ", provisionsseddel=" + provisionsseddel + '}';
    }
/**
 * Denne metode opretter et kontoudtog ud fra en faktura og returner derefter 
 * kontoudtog objektet
 * @param oprettetdato Et Timestamp med hvornår kontoudtoget er oprettet
 * @return  Returner et kontoudtog objekt
 */
    //public Kontoudtog opretKontoudtog(Timestamp oprettetdato) {
        // Mangler at lave så den oprettet med et nyt kontoudtog nummer. 
        //Kontoudtog kontoudtog = new Kontoudtog(123, oprettetdato, "13", null, this);
       
        
       //return kontoudtog;
    //}


    
}
