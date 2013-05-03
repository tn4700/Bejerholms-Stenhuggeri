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
    
}
