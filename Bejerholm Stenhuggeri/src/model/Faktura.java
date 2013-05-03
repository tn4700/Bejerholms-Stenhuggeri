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
   private int faktura_nr;
   private Timestamp faktureringsdato;
   private String vedrørende;
   private String betalingsbetingelser;
   private Timestamp sendt_dato;
   private String faktureringsadresse;
   private boolean fakturatype;
   private boolean betalingsstatus;
   private int ordre_nr;
   private int bedemand_cvr;
   
  private Faktura(){
      this.faktura_nr = faktura_nr;
      this.faktureringsdato = faktureringsdato;
      this.vedrørende = vedrørende;
      this.betalingsbetingelser = betalingsbetingelser;
      this.sendt_dato = sendt_dato;
      this. faktureringsadresse = faktureringsadresse;
      this.fakturatype = fakturatype;
      this.betalingsstatus = betalingsstatus;
      this.ordre_nr = ordre_nr;
      this.bedemand_cvr = bedemand_cvr;
  }

    public int getFaktura_nr() {
        return faktura_nr;
    }

    public void setFaktura_nr(int faktura_nr) {
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

    public int getOrdre_nr() {
        return ordre_nr;
    }

    public void setOrdre_nr(int ordre_nr) {
        this.ordre_nr = ordre_nr;
    }

    public int getBedemand_cvr() {
        return bedemand_cvr;
    }

    public void setBedemand_cvr(int bedemand_cvr) {
        this.bedemand_cvr = bedemand_cvr;
    }
    
}
