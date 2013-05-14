/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Faktura;

/**
 *
 * @author NiklasRenner
 */
public class FilTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Faktura faktura = new Faktura();
        OpretFaktura opretFaktura = new OpretFaktura(faktura);
        opretFaktura.genererFaktura("test.pdf");
        
    }
}
