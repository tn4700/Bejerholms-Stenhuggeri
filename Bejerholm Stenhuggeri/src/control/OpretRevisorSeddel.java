/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Oliver
 */
public class OpretRevisorSeddel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBConnection db = null;
        // TODO code application logic here
        try {
            db = new DBConnection("localhost", "3306", "bejerholmstenhuggeri", "root", "root");

        } catch (Exception ex) {
            System.out.println("fejl: " + ex);
        }
       
    }
}
