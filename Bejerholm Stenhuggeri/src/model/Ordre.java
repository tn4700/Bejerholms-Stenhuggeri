/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Utility;
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
    private Timestamp leveringsdato;
    private Timestamp afhentningsdato;
    private String bemærkning;
    private String bemærkning_ekstra;
    private String kirkegård;
    private int afdeling;
    private String afdødnavn;
    private int række;
    private int nummer;
    private boolean gravType;       //1 - Kiste, 0 - Urne 
    private Kunde kunde;
    private ArrayList<Vare_linje> vare_linjeListe;

    public Ordre(String ordre_nr,
            boolean ordretype,
            Timestamp ordredato,
            Timestamp leveringsdato,
            Timestamp afhentningsdato,
            String bemærkning,
            String bemærkning_ekstra,
            String kirkegård,
            int afdeling,
            String afdødnavn,
            int række,
            int nummer,
            boolean gravType,
            Kunde kunde,
            ArrayList<Vare_linje> vare_linjeListe) {
        
        if(vare_linjeListe!=null){
           this.vare_linjeListe = vare_linjeListe;
        } else {
           this.vare_linjeListe = new ArrayList(); 
        }
        this.ordre_nr = ordre_nr;
        this.ordretype = ordretype;
        this.ordredato = ordredato;
        if (leveringsdato != null) {
            this.leveringsdato = leveringsdato;
        } else {
            this.leveringsdato = Utility.getCurrentTime();
        }
        if (afhentningsdato != null) {
            this.afhentningsdato = afhentningsdato;
        } else {
            this.afhentningsdato = Utility.getCurrentTime();
        }
        this.bemærkning = bemærkning;
        this.bemærkning_ekstra = bemærkning_ekstra;
        this.kirkegård = kirkegård;
        this.afdeling = afdeling;
        this.afdødnavn = afdødnavn;
        this.række = række;
        this.nummer = nummer;
        this.gravType = gravType;
        this.kunde = kunde;
    }

    public Ordre(Kunde kunde, ArrayList<Vare_linje> valgtevarer) {
        ordre_nr = null;
        ordretype = true;
        this.ordredato = Utility.getCurrentTime();
        this.leveringsdato = Utility.getCurrentTime();
        this.afhentningsdato = Utility.getCurrentTime();
        bemærkning = null;
        bemærkning_ekstra = null;
        kirkegård = null;
        afdeling = 0;
        afdødnavn = null;
        række = 0;
        nummer = 0;
        gravType = false;
        this.kunde = kunde;
        this.vare_linjeListe = valgtevarer;
    }

    public void addVare_linje(Vare_linje vare_linje) {
        vare_linjeListe.add(vare_linje);
    }

    public ArrayList<Vare_linje> getVare_linjeListe() {
        return vare_linjeListe;
    }

    public void setVare_linjeListe(ArrayList<Vare_linje> vare_linjeListe) {
        this.vare_linjeListe = vare_linjeListe;
    }

    public String getBemærkning_ekstra() {
        return bemærkning_ekstra;
    }

    public void setBemærkning_ekstra(String bemærkning_ekstra) {
        this.bemærkning_ekstra = bemærkning_ekstra;
    }

    public String getOrdre_nr() {
        return ordre_nr;
    }

    public void setOrdre_nr(String ordre_nr) {
        this.ordre_nr = ordre_nr;
    }

    public boolean getOrdretype() {
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

    public double getTotal() {

        int antal = 0;
        double enhedsPris = 0;
        double pris = 0;
        double total = 0;

        for (int i = 0; i < vare_linjeListe.size(); i++) {

            if (vare_linjeListe.get(i).getVare() != null) {
                antal = 1;
                enhedsPris = vare_linjeListe.get(i).getVare().getSalgspris();
            } else if (vare_linjeListe.get(i).getInskription() != null) {
                antal = 0;
                for (int j = 0; j < vare_linjeListe.get(i).getInskription().getInskription_linje_liste().size(); j++) {
                    String characters = vare_linjeListe.get(i).getInskription().getInskription_linje_liste().get(j).getInskription().replaceAll(" ", "");
                    if (vare_linjeListe.get(i).getInskription().getInskription_linje_liste().get(j).getLinje_type() == 1) {
                        antal += characters.length();
                    }
                }
                enhedsPris = vare_linjeListe.get(i).getInskription().getTegntype().getPris_pr_tegn();
            } else if (vare_linjeListe.get(i).getTom_linje() != null) {
                antal = vare_linjeListe.get(i).getTom_linje().getAntal();
                enhedsPris = vare_linjeListe.get(i).getTom_linje().getPris();
            }
            pris = antal * enhedsPris;
            total += pris;
        }
        total += (total * 0.025);
        return total;
    }

    public double getSalgsMoms() {
        double salgsMoms = getTotal();
        salgsMoms = (salgsMoms * 0.25);
        return salgsMoms;
    }

    public double getTotalInklMoms() {
        double total = getTotal() + getSalgsMoms();
        return total;
    }
}
