/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Martin
 */
public class Postnummer {

    private int post_nr;
    private String byNavn;

    public Postnummer(int post_nr, String byNavn) {
        this.post_nr = post_nr;
        this.byNavn = byNavn;
    }

    public int getPost_nr() {
        return post_nr;
    }

    public void setPost_nr(int post_nr) {
        this.post_nr = post_nr;
    }

    public String getByNavn() {
        return byNavn;
    }

    public void setByNavn(String byNavn) {
        this.byNavn = byNavn;
    }
    
    @Override
    public String toString() {
        return post_nr + " " + byNavn;
    }
}
