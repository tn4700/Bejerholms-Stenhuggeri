/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NiklasRenner
 */
public class Faktureringsadresse {
    
    private int id;
    private String adresse;
    private Postnummer post_nr;
    
    public Faktureringsadresse(int id, String adresse, Postnummer post_nr){
        this.id = id;
        this.adresse = adresse;
        this.post_nr = post_nr;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Postnummer getPost_nr() {
        return post_nr;
    }

    public void setPost_nr(Postnummer post_nr) {
        this.post_nr = post_nr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
