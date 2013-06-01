/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Vare {

    private int vare_nr;
    private String navn;
    private int højde;
    private int bredde;
    private double indkøbspris;
    private double salgspris;
    private Varetype varetype;
    private int overflade; //0 - ingen, 1 - ru, 2 - poleret;
    private boolean dekoration;
    private Varegruppe gruppe;
    private int vareStatus;

    public Vare(int vare_nr,
            String navn,
            int højde,
            int bredde,
            double indkøbspris,
            double salgspris,
            Varetype varetype,
            int overflade,
            boolean dekoration,
            int vareStatus,
            Varegruppe gruppe) {

        this.vare_nr = vare_nr;
        this.navn = navn;
        this.højde = højde;
        this.bredde = bredde;
        this.indkøbspris = indkøbspris;
        this.salgspris = salgspris;
        this.varetype = varetype;
        this.overflade = overflade;
        this.dekoration = dekoration;
        this.vareStatus = vareStatus;
        this.gruppe = gruppe;
    }

    public int getVareStatus() {
        return vareStatus;
    }

    public void setVareStatus(int vareStatus) {
        this.vareStatus = vareStatus;
    }

    public int getVare_nr() {
        return vare_nr;
    }

    public void setVare_nr(int vare_nr) {
        this.vare_nr = vare_nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getHøjde() {
        return højde;
    }

    public void setHøjde(int højde) {
        this.højde = højde;
    }

    public int getBredde() {
        return bredde;
    }

    public void setBredde(int bredde) {
        this.bredde = bredde;
    }

    public double getIndkøbspris() {
        return indkøbspris;
    }

    public void setIndkøbspris(double indkøbspris) {
        this.indkøbspris = indkøbspris;
    }

    public double getSalgspris() {
        return salgspris;
    }

    public void setSalgspris(double salgspris) {
        this.salgspris = salgspris;
    }

    public Varetype getVaretype() {
        return varetype;
    }

    public void setVaretype(Varetype varetype) {
        this.varetype = varetype;
    }

    public int getOverflade() {
        return overflade;
    }

    public void setOverflade(int overflade) {
        this.overflade = overflade;
    }

    public boolean getDekoration() {
        return dekoration;
    }

    public void setDekoration(boolean dekoration) {
        this.dekoration = dekoration;
    }

    public Varegruppe getGruppe() {
        return gruppe;
    }

    public void setGruppe(Varegruppe gruppe) {
        this.gruppe = gruppe;
    }
    
    public String getDekorationToString(){
        String dekorationString = "Nej.";
        if(dekoration) {
            dekorationString = "Ja.";
        }
        return dekorationString;
    }
    
    public String getVareStatusToString(){
        String statusString = "Ugyldig status.";
        if(vareStatus==0){
        statusString = "Vare på lager.";
        } else         if(vareStatus==1){
        statusString = "Vare reserveret.";
        } else         if(vareStatus==2){
        statusString = "Vare solgt.";
        }
        return statusString;
    }

    @Override
    public String toString() {
        return vare_nr + ". " + navn +" "+salgspris;
    }
    
    
}
