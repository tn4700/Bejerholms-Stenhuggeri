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
    ArrayList<Ordre> ordreList = new ArrayList();

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
    /* Boolean type
     True = Gravsten
     False = Alt andet
     */
//    public void opretOrdre(boolean ordretype, Timestamp leveringsdato, Timestamp afhentningsdato, String bemærkning, String leveringsadresse, String kirkegård, int afdeling, String afdødnavn, int række, int nummer, int plads_navne, boolean gravType, Kunde kunde){
//        
//        if(ordretype = true){
//            Ordre gravStenOrdre = new Ordre(ordretype, leveringsdato, afhentningsdato, bemærkning, leveringsadresse, kirkegård, afdeling, afdødnavn, række, nummer, plads_navne, gravType, kunde);
//            ordreList.add(gravStenOrdre);
//        }else{
//            Ordre normalOrdre = new Ordre(ordretype, leveringsdato, afhentningsdato, bemærkning, leveringsadresse, kunde);
//            ordreList.add(normalOrdre);
//        }
//            
//    }
}
