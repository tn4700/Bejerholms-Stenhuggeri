/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class Ordre {

    private String ordre_nr;
    private boolean ordretype;      //1 - ny sten, 0 - tilføjelse
    private Timestamp ordredato;
    private int ordrestatus;
    private Timestamp leveringsdato;
    private Timestamp afhentningsdato;
    private String bemærkning;
    private String leveringsadresse;
    private String kirkegård;
    private int afdeling;
    private String afdødnavn;
    private int række;
    private int nummer;
    private int plads_navne;
    private boolean gravType;       //1 - Kiste, 0 - Urne 
    private Kunde kunde;
    private ArrayList<Vare_linje> vare_linjeListe;

    public Ordre(String ordre_nr,
            boolean ordretype, 
            Timestamp leveringsdato, 
            Timestamp afhentningsdato, 
            String bemærkning, 
            String leveringsadresse, 
            String kirkegård, 
            int afdeling, 
            String afdødnavn, 
            int række, 
            int nummer, 
            int plads_navne, 
            boolean gravType,         
            Kunde kunde) {
        
        vare_linjeListe = new ArrayList();
        this.ordre_nr = ordre_nr;
        this.ordrestatus = ordrestatus;
        this.ordretype = ordretype;
        this.leveringsdato = leveringsdato;
        this.afhentningsdato = afhentningsdato;
        this.bemærkning = bemærkning;
        this.leveringsadresse = leveringsadresse;
        this.kirkegård = kirkegård;
        this.afdeling = afdeling;
        this.afdødnavn = afdødnavn;
        this.række = række;
        this.nummer = nummer;
        this.plads_navne = plads_navne;
        this.gravType = gravType;
        this.kunde = kunde;
    }
        
    public void addVare_linje(Vare_linje vare_linje){
            vare_linjeListe.add(vare_linje);
    }
    
    public ArrayList<Vare_linje> getVare_linjeListe() {
        return vare_linjeListe;
    }
    
    public void setVare_linjeListe(ArrayList<Vare_linje> vare_linjeListe) {
        this.vare_linjeListe = vare_linjeListe;
    }

    public String getOrdre_nr() {
        return ordre_nr;
    }

    public void setOrdre_nr(String ordre_nr) {
        this.ordre_nr = ordre_nr;
    }

    public boolean GetOrdretype() {
        return ordretype;
    }

    public void setOrdretype(boolean ordretype) {
        this.ordretype = ordretype;
    }

    public Timestamp getOrdredato() {
        return ordredato;
    }

    public void setOrdredato(Timestamp ordredato) {
        this.ordredato = ordredato;
    }

    public int getOrdrestatus() {
        return ordrestatus;
    }

    public void setOrdrestatus(int ordrestatus) {
        this.ordrestatus = ordrestatus;
    }

    public Timestamp getLeveringsdato() {
        return leveringsdato;
    }

    public void setLeveringsdato(Timestamp leveringsdato) {
        this.leveringsdato = leveringsdato;
    }

    public Timestamp getafhentningsdato() {
        return afhentningsdato;
    }

    public void setafhentningsdato(Timestamp afhentningsdato) {
        this.afhentningsdato = afhentningsdato;
    }

    public String getBemærkning() {
        return bemærkning;
    }

    public void setBemærkning(String bemærkning) {
        this.bemærkning = bemærkning;
    }

    public String getLeveringsadresse() {
        return leveringsadresse;
    }

    public void setLeveringsadresse(String leveringsadresse) {
        this.leveringsadresse = leveringsadresse;
    }

    public String getKirkegård() {
        return kirkegård;
    }

    public void setKirkegård(String kirkegård) {
        this.kirkegård = kirkegård;
    }

    public int getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(int afdeling) {
        this.afdeling = afdeling;
    }

    public String getAfdødnavn() {
        return afdødnavn;
    }

    public void setAfdødnavn(String afdødnavn) {
        this.afdødnavn = afdødnavn;
    }

    public int getRække() {
        return række;
    }

    public void setRække(int række) {
        this.række = række;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getPlads_navne() {
        return plads_navne;
    }

    public void setPlads_navne(int plads_navne) {
        this.plads_navne = plads_navne;
    }

    public boolean getGravType() {
        return gravType;
    }

    public void setGravType(boolean gravType) {
        this.gravType = gravType;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    
    public Timestamp getAfhentningsdato() {
        return afhentningsdato;
    }

    public void setAfhentningsdato(Timestamp afhentningsdato) {
        this.afhentningsdato = afhentningsdato;
    }

    @Override
    public String toString() {
        return "Ordre{" + "ordre_nr=" + ordre_nr + ", ordretype=" + ordretype + ", ordredato=" + ordredato + ", ordrestatus=" + ordrestatus + ", leveringsdato=" + leveringsdato + ", afhentningsdato=" + afhentningsdato + ", bemærkning=" + bemærkning + ", leveringsadresse=" + leveringsadresse + ", kirkegård=" + kirkegård + ", afdeling=" + afdeling + ", afdødnavn=" + afdødnavn + ", række=" + række + ", nummer=" + nummer + ", plads_navne=" + plads_navne + ", gravType=" + gravType + ", kunde=" + kunde + ", vare_linjeListe=" + vare_linjeListe + '}';
    }
    
}
