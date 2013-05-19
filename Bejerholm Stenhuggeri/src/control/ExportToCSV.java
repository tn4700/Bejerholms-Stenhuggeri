/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ExportToCSV {

    public static void main(String[] args) {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/";
        String db = "bejerholmstenhuggeri";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "2335";
        FileWriter fw;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, pass);
            Statement st = con.createStatement();
            //Henter alle tables i db
            ResultSet res = st.executeQuery("SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = 'bejerholmstenhuggeri'");
            //Forbereder List af table navne
            List<String> tableNameList = new ArrayList<String>();
            while (res.next()) {
                tableNameList.add(res.getString(1));
            }
            //Stien hvor man gemmer filerne hen til (i skal oprette CSVfiler mappe i c drevet -hvis i kan noget smart her er i velkommen til det)
            String filename = "C:/CSVfiler/";
            //Tager iterativt for hver table som lager data og gemmer på en .csv fil
            for (String tableName : tableNameList) {
                int k = 0;
                int j = 1;
                System.out.println(tableName);
                List<String> columnsNameList = new ArrayList<String>();
                //Tager alle data fra table
                res = st.executeQuery("select * from bejerholmstenhuggeri." + tableName);
                //colunm count er nødvendig da tabeller er dynamisk og skal kende antalet af tabeller
                int columnCount = getColumnCount(res);

                try {
                    fw = new FileWriter(filename + "" + tableName + ".csv");
                    //Den her loop sætter navn på column på toppen af filen, kan udkommenteres hvis det ikke er nødvendigt. 
                    for (int i = 1; i <= columnCount; i++) {
                        fw.append(res.getMetaData().getColumnName(i));
                        fw.append(",");

                    }
                    fw.append(System.getProperty("line.separator"));

                    while (res.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            //Converter alt til string og derefter gemmer
                            if (res.getObject(i) != null) {
                                String data = res.getObject(i).toString();
                                fw.append(data);
                                fw.append(",");
                            } else {
                                String data = "null";
                                fw.append(data);
                                fw.append(",");
                            }
                        }
                        //Ny linje indtastes efter hver række
                        fw.append(System.getProperty("line.separator"));
                    }
                    fw.flush();
                    fw.close();
                } catch (IOException ioe) {
                    //autogenereret catch block
                    ioe.printStackTrace();
                }
            }
            con.close();
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Could not load JDBC driver");
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            System.err.println("SQLException information");
            sqle.printStackTrace();
        }
    }
    //For at få antallet af rækker i et result set
    public static int getRowCount(ResultSet res) throws SQLException {
        res.last();
        int numberOfRows = res.getRow();
        res.beforeFirst();
        return numberOfRows;
    }
    //For ikke at få colum i et result set
    public static int getColumnCount(ResultSet res) throws SQLException {
        return res.getMetaData().getColumnCount();
    }
}