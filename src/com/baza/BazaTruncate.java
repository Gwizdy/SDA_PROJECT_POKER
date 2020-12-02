package com.baza;

import java.sql.*;

public class BazaTruncate {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/Poker";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "PASSWORD";

    private Statement stmt;
    Connection conn;

    public BazaTruncate() {
        truncateTable("wygrana");
    }

    private void connectToDb() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER); // załadowanie sterownika

        conn = DriverManager.getConnection(URL, LOGIN, PASSWORD); //wyszukał bazę

        stmt = conn.createStatement(); //nawiązanie sesji
    }

    private void disconnectDB() throws SQLException {
        stmt.close();
        conn.close();
    }

    private void truncateTable(String tableName){

        String query = "TRUNCATE " + tableName + ";";

        try {
            connectToDb();

            stmt.executeUpdate(query); // wykonujemy połączenie

            disconnectDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver error " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error " + e.getMessage());
        }
    }
}
