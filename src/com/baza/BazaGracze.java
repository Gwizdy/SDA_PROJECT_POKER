package com.baza;

import com.okna.OknoGracze;

import java.sql.*;

public class BazaGracze {

    OknoGracze oknoGracze;

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/Poker";

    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "ANDpig1906!@";

    private Statement stmt;
    Connection conn;

    public BazaGracze(OknoGracze oknoGracze) {
        this.oknoGracze = oknoGracze;

        try {
            connectToDb();
            addRecordToDb();
            disconnectDB();
            showTable("gracze");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver error " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error " + e.getMessage());
        }
    }

    private void addRecordToDb() throws SQLException {

        for (int k = 0; k < oknoGracze.getGracze(); k++) {

            String query = "select count(*) from gracze";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            int i = rs.getInt("count");

            String record = "insert into gracze (id_gracze, nick)" +
                    "values (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(record);

            preparedStatement.setInt(1, ++i);
            preparedStatement.setString(2, oknoGracze.getPlayer()[k].getText());

            preparedStatement.executeUpdate();
        }
    }

    private void showTable(String tableName) {

        String query = "SELECT * FROM " + tableName + ";";

        try {
            connectToDb();

            ResultSet rs = stmt.executeQuery(query); // wykonujemy połączenie

            while (rs.next()) {
                ResultSetMetaData rsmd = rs.getMetaData(); // klasa do przechowywania danych
                int columCounter = rsmd.getColumnCount(); // sprawdzamy liczbę kolumn

                StringBuilder result = new StringBuilder();

                for (int i = 1; i <= columCounter; i++)
                    result = result.append(rsmd.getColumnName(i) + ":" + rs.getString(i) + "\t");
                result.append("\n");
                System.out.println(result.toString());
            }
            disconnectDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver error " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error " + e.getMessage());
        }
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
}