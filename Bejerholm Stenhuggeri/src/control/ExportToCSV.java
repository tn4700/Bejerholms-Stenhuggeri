/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ExportToCSV {

    public final static void export(DBConnection db) throws IOException, SQLException{

            Writer out;            
            //Henter alle tables i db
            ResultSet res = db.getData("SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = 'bejerholmstenhuggeri'");
            //Forbereder List af table navne
            List<String> tableNameList = new ArrayList<>();
            while (res.next()) {
                tableNameList.add(res.getString(1));
            }
            //Stien hvor man gemmer filerne hen til
            String filename = "C:/CSVfiler/";
            File file = new File(filename);
            if (!file.exists()) {
                file.mkdir();
                System.out.println("'" + filename + "' fandtes ikke og blev oprettet");
            }
            //Tager iterativt for hver table som lager data og gemmer på en .csv fil
            for (String tableName : tableNameList) {
                //Tager alle data fra table
                res = db.getData("select * from bejerholmstenhuggeri." + tableName);
                //colunm count er nødvendig da tabeller er dynamisk og skal kende antalet af tabeller
                int columnCount = getColumnCount(res);

                    File filepath = new File(filename + "" + tableName + ".csv");
                    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath.toString()), "ISO-8859-1"));
                    //Den her loop sætter navn på column på toppen af filen, kan udkommenteres hvis det ikke er nødvendigt. 
                    for (int i = 1; i <= columnCount; i++) {
                        out.append(res.getMetaData().getColumnName(i));
                        out.append(", ");

                    }
                    out.append(System.getProperty("line.separator"));

                    while (res.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            //Converter alt til string og derefter gemmer
                            if (res.getObject(i) != null) {
                                String data = res.getObject(i).toString();
                                out.append(data);
                                out.append(", ");
                            } else {
                                String data = "null";
                                out.append(data);
                                out.append(", ");
                            }
                        }
                        //Ny linje indtastes efter hver række
                        out.append(System.getProperty("line.separator"));
                    }
                    out.flush();
                    out.close();
            }
    }
    
    //For at få antallet af rækker i et result set
    public static int getRowCount(ResultSet res) throws SQLException {
        res.last();
        int numberOfRows = res.getRow();
        res.beforeFirst();
        return numberOfRows;
    }
    
    //For ikke at få column i et result set
    public static int getColumnCount(ResultSet res) throws SQLException {
        return res.getMetaData().getColumnCount();
    }
    
}