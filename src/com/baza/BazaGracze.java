package com.baza;

import com.okna.OknoStol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class BazaGracze {

    OknoStol oknoStol;

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/Pracownicy";

    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "ANDpig1906!@";

    private Statement stmt;
    Connection conn;

    private String imie = "";
    private String nazwisko = "";
    private int wiek = 0;
    private String plec = "";
    private int id_number = 0;
    private int id_number_edit = 0;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public BazaGracze(OknoStol oknoStol) {
        this.oknoStol = oknoStol;

        try {
            connectToDb();
            showTable("Pracownicy");
            System.out.println("Co chcesz zrobić?");
            System.out.println("1 - dodanie rekordu; 2 - usunięcie rekordu; 3 - wyświetlenie rekordu; 4 - znalezienie rekordu");
            int number = Integer.parseInt(reader.readLine());
            if (number == 1) {
                System.out.println("Podaj imię");
                imie = reader.readLine();
                System.out.println("Podaj nazwisko:");
                nazwisko = reader.readLine();
                System.out.println("Podaj wiek");
                wiek = Integer.parseInt(reader.readLine());
                System.out.println("Podaj płeć");
                plec = reader.readLine();
                addRecordToDb();
                showTable("Pracownicy");
            } else if (number == 2) {
                System.out.println("Który rekord chcesz usunąć?");
                id_number = Integer.parseInt(reader.readLine());
                removeRecordDb();
                showTable("Pracownicy");
            } else if (number == 3) {
                System.out.println("Który rekord chcesz wyświetlić?");
                id_number = Integer.parseInt(reader.readLine());
                showRecordDb();
            } else if (number == 4) {
                System.out.println("Który rekord chcesz edytować?");
                id_number = Integer.parseInt(reader.readLine());
                showRecordDb();
                System.out.println("Co chcesz zmienić: 1 - imie; 2 - nazwisko; 3 - wiek; 4 - płeć");
                id_number_edit = Integer.parseInt(reader.readLine());
                editRecordDb();
                showRecordDb();
            }
            disconnectDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver error " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
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
            //disconnectDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver error " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL error " + e.getMessage());
        }
    }

    private void addRecordToDb() throws SQLException {

        String query = "SELECT COUNT(*) FROM PRACOWNICY";
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int i = rs.getInt("COUNT");

        String record = "INSERT INTO PRACOWNICY (id_pracownicy, imie, nazwisko, wiek, plec)" +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(record);

        preparedStatement.setInt(1, ++i);
        preparedStatement.setString(2, imie);
        preparedStatement.setString(3, nazwisko);
        preparedStatement.setInt(4, wiek);
        preparedStatement.setString(5, plec);
        preparedStatement.executeUpdate();
    }

    private void removeRecordDb() throws SQLException {
        String query = "DELETE FROM PRACOWNICY WHERE ID_PRACOWNICY = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(query);

        preparedStatement.setInt(1, id_number);
        preparedStatement.executeUpdate();
    }

    private void showRecordDb() throws SQLException {

        String query = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNICY = " + id_number + ";";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData(); // klasa do przechowywania danych
            int columCounter = rsmd.getColumnCount(); // sprawdzamy liczbę kolumn

            StringBuilder result = new StringBuilder();

            for (int i = 1; i <= columCounter; i++)
                result = result.append(rsmd.getColumnName(i) + ":" + rs.getString(i) + "\t");
            result.append("\n");
            System.out.println(result.toString());
        }
    }

    private void editRecordDb() throws SQLException, IOException {
        if (id_number_edit == 1) {

            System.out.println("Wprowadź nowe imię: ");
            imie = reader.readLine();

            String query = "UPDATE PRACOWNICY SET IMIE = ? WHERE ID_PRACOWNICY = " + id_number + ";";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, imie);
            preparedStatement.executeUpdate();

        } else if (id_number_edit == 2) {

            System.out.println("Wprowadź nowe nazwisko: ");
            nazwisko = reader.readLine();

            String query = "UPDATE PRACOWNICY SET NAZWISKO = ? WHERE ID_PRACOWNICY = " + id_number + ";";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, nazwisko);
            preparedStatement.executeUpdate();

        } else if (id_number_edit == 3) {

            System.out.println("Wprowadź nowy wiek: ");
            wiek = Integer.parseInt(reader.readLine());

            String query = "UPDATE PRACOWNICY SET WIEK = ? WHERE ID_PRACOWNICY = " + id_number + ";";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setInt(1, wiek);
            preparedStatement.executeUpdate();

        } else if (id_number_edit == 4) {

            System.out.println("Wprowadź nową płeć: ");
            plec = reader.readLine();

            String query = "UPDATE PRACOWNICY SET PLEC = ? WHERE ID_PRACOWNICY = " + id_number + ";";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, plec);
            preparedStatement.executeUpdate();

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