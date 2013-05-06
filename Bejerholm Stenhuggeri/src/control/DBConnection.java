/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;

/**
 *
 * @author Anette Stidsing
 */
public class DBConnection {

    private Connection conn;
    private Statement stmt;
    private String user;
    private String pw;
    private String host;
    private String port;
    private String dbNavn;
    private boolean connected;

    public DBConnection(String db_host, String db_port, String db_name, String db_user, String db_pw) throws SQLException, ClassNotFoundException {

        this.host = db_host;
        this.port = db_port;
        this.dbNavn = db_name;
        this.user = db_user;
        this.pw = db_pw;
        connect();
    }

    public final boolean connect() {
        boolean connecting = true;
        String connString = "jdbc:mysql://" + host + ":" + port + "/" + dbNavn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connString, user, pw);
            stmt = conn.createStatement();
        } catch (Exception ex) {
            connecting = false;
        }
        connected = connecting;
        return connecting;
    }

    public ResultSet getData(String getdata) throws SQLException {
        ResultSet rs = stmt.executeQuery(getdata);
        return rs;
    }

    public void setData(String getdata) throws SQLException {
        stmt.executeUpdate(getdata);
    }

    public void endQuery() throws SQLException {
        try {
            conn.close();
        } catch (Exception ex) {
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbNavn() {
        return dbNavn;
    }

    public void setDbNavn(String dbNavn) {
        this.dbNavn = dbNavn;
    }

    public boolean isConnected() {
        return connected;
    }
}