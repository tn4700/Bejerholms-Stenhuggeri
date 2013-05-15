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
    private String typenavn;
    private String overflade;
    private boolean dekoration;
    private Varegruppe gruppe;

    public Vare(int vare_nr,
            String navn,
            int højde,
            int bredde,
            double indkøbspris,
            double salgspris,
            String typenavn,
            String overflade,
            boolean dekoration,
            Varegruppe gruppe) {

        this.vare_nr = vare_nr;
        this.navn = navn;
        this.højde = højde;
        this.bredde = bredde;
        this.indkøbspris = indkøbspris;
        this.salgspris = salgspris;
        this.typenavn = typenavn;
        this.overflade = overflade;
        this.dekoration = dekoration;
        this.gruppe = gruppe;
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

    public String getTypenavn() {
        return typenavn;
    }

    public void setTypenavn(String typenavn) {
        this.typenavn = typenavn;
    }

    public String getOverflade() {
        return overflade;
    }

    public void setOverflade(String overflade) {
        this.overflade = overflade;
    }

    public boolean isDekoration() {
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

    @Override
    public String toString() {
        return "Vare{" + "vare_nr=" + vare_nr + ", navn=" + navn + ", h\u00f8jde=" + højde + ", bredde=" + bredde + ", indk\u00f8bspris=" + indkøbspris + ", salgspris=" + salgspris + ", typenavn=" + typenavn + ", overflade=" + overflade + ", dekoration=" + dekoration + ", gruppe=" + gruppe + '}';
    }
    
    
}
