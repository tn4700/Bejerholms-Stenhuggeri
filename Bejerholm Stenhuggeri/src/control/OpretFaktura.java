/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import model.Faktura;

/**
 *
 * @author NiklasRenner
 */
public class OpretFaktura {

    private Faktura faktura;
    private int sideTal;

    public OpretFaktura(Faktura faktura) {
        sideTal = 0;
        this.faktura = faktura;
        faktura.getOrdre()
    }

    public void genererFaktura(String filNavn) {
        Document doc = new Document();
        PdfWriter docWriter = null;
    }
}
