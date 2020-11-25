package com.baza;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;

public class BazaOdczyt {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/Poker";

    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "ANDpig1906!@";

    private Statement stmt;
    Connection conn;

    private JTable tabela;


    public BazaOdczyt() {

        showTable("wygrana");
    }

    private void showTable(String tableName) {

        tabela = new JTable();

        tabela.setOpaque(false);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setFont(new Font("Arial", Font.BOLD, 14));
        tabela.setBounds(1100, 20, 270, 300);

        String query = "SELECT imie, wygrana, uklad_kart FROM wygrana ORDER BY wygrana DESC LIMIT 5;";


        try {
            connectToDb();

            DefaultTableModel defaultTableModel = new DefaultTableModel();
            ResultSet rs = stmt.executeQuery(query); // wykonujemy połączenie

            ResultSetMetaData rsmd = rs.getMetaData(); // klasa do przechowywania danych
            int columCounter = rsmd.getColumnCount(); // sprawdzamy liczbę kolumn


            for (int i = 1; i <= columCounter; i++) {
                defaultTableModel.addColumn(rsmd.getColumnLabel(columCounter));
            }

            Object[] nazwa = new Object[]{"Nick", "Wygrana", "Układ kart"};

            defaultTableModel.addRow(nazwa);

            Object[] wiersz = new Object[columCounter];

            while (rs.next()) {
                for (int i = 0; i < columCounter; i++) {
                    wiersz[i] = rs.getObject(i + 1);
                }

                defaultTableModel.addRow(wiersz);
            }

            tabela.setModel(defaultTableModel);

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

    public JTable getTabela() {
        return tabela;
    }
}