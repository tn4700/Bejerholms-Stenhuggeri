/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NiklasRenner
 */
public class Kirkegård {
    
    private int id;
    private String navn;
    
    public Kirkegård(int id, String navn){
        this.id = id;
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
