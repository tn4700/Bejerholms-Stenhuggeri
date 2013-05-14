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
    private float indkøbspris;
    private float salgspris;
    private String typenavn;
    private String overflade;
    private boolean dekoration;
    private Vare_linje grp_nr;

    public Vare(int vare_nr,
            String navn,
            int højde,
            int bredde,
            float indkøbspris,
            float salgspris,
            String typenavn,
            String overflade,
            boolean dekoration,
            Vare_linje grp_nr) {

        this.vare_nr = vare_nr;
        this.navn = navn;
        this.højde = højde;
        this.bredde = bredde;
        this.indkøbspris = indkøbspris;
        this.salgspris = salgspris;
        this.typenavn = typenavn;
        this.overflade = overflade;
        this.dekoration = dekoration;
        this.grp_nr = grp_nr;
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

    public float getIndkøbspris() {
        return indkøbspris;
    }

    public void setIndkøbspris(float indkøbspris) {
        this.indkøbspris = indkøbspris;
    }

    public float getSalgspris() {
        return salgspris;
    }

    public void setSalgspris(float salgspris) {
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

    public Vare_linje getGrp_nr() {
        return grp_nr;
    }

    public void setGrp_nr(Vare_linje grp_nr) {
        this.grp_nr = grp_nr;
    }
}
