package com.baza;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BazaOdczyt {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/Poker";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "PASSWORD";

    private Statement stmt;
    Connection conn;

    private JTable tabela;

    public BazaOdczyt() {

        showTable("wygrana");
    }

    private void showTable(String tableName) {

        tabela = new JTable();

        tabela.setOpaque(false);
        ((DefaultTableCellRenderer) tabela.getDefaultRenderer(Object.class)).setOpaque(false);
        tabela.setFont(new Font("Arial", Font.BOLD, 16));
        tabela.setBounds(1030, 20, 322, 300);
        tabela.setRowHeight(30);

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

            Object[] nazwa = new Object[]{"Nick", "Wygrana rozdania", "Układ kart"};
            defaultTableModel.addRow(nazwa);

            Object[] wiersz = new Object[columCounter];

            while (rs.next()) {
                for (int i = 0; i < columCounter; i++) {
                    wiersz[i] = rs.getObject(i + 1);
                }

                defaultTableModel.addRow(wiersz);
            }

            tabela.setModel(defaultTableModel);

            for (int i = 0; i < columCounter; i++) {
                tabela.getColumnModel().getColumn(i).setCellRenderer(new TextCenter());
            }

            tabela.getColumnModel().getColumn(0).setWidth(107);
            tabela.getColumnModel().getColumn(1).setWidth(108);
            tabela.getColumnModel().getColumn(2).setWidth(107);

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