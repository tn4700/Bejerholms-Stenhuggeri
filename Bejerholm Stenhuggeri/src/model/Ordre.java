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
public class Ordre {
    
    private int ordre_nr;
    private boolean ordretype;
    private Timestamp ordredato;
    private int ordrestatus;
    private Timestamp leveringsdato;
    private Timestamp afhentmningsdato;
    private String bemærkning;
    private String leveringsadresse;
    private String kirkegård;
    private int afdeling;
    private String afdødnavn;
    private int række;
    private int nummer;
    private int plads_navne;
    private boolean gravType;
    private Kunde kunde;
    
    public Ordre(){
        this.ordre_nr=ordre_nr;
        this.ordretype=ordretype;
        this.ordredato=ordredato;
        this.ordrestatus=ordrestatus;
        this.leveringsdato=leveringsdato;
        this.afhentmningsdato=afhentmningsdato;
        this.bemærkning=bemærkning;
        this.leveringsadresse=leveringsadresse;
        this.kirkegård=kirkegård;
        this.afdeling=afdeling;
        this.afdødnavn=afdødnavn;
        this.række=række;
        this.nummer=nummer;
        this.plads_navne=plads_navne;
        this.gravType=gravType;
        this.kunde=kunde;
    }

    public int getOrdre_nr() {
        return ordre_nr;
    }

    public void setOrdre_nr(int ordre_nr) {
        this.ordre_nr = ordre_nr;
    }

    public boolean isOrdretype() {
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

    public Timestamp getAfhentmningsdato() {
        return afhentmningsdato;
    }

    public void setAfhentmningsdato(Timestamp afhentmningsdato) {
        this.afhentmningsdato = afhentmningsdato;
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

    public boolean isGravType() {
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
}
