package com.baza;

import com.okna.OknoStol;

import java.sql.*;

public class BazaGracze {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/Poker";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "ANDpig1906!@";

    private OknoStol oknoStol;

    public BazaGracze(OknoStol oknoStol) {
        this.oknoStol = oknoStol;

        try {
            Class.forName(JDBC_DRIVER); //ładujemy sterownik z którego korzystamy

            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD); //stworzenie referencji connection

            Statement statement = connection.createStatement(); // tworzy jednokrotne połączenie

            String query = "SELECT COUNT(*) FROM GRACZE";
            ResultSet rs1 = statement.executeQuery(query);

            rs1.next();
            int i = rs1.getInt("count");
            System.out.println(i);


            String sql = "INSERT INTO PRACOWNICY (id_gracze, nick)" +
                    "VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setInt(1, ++i);
//            preparedStatement.setString(2, imie1);
//            preparedStatement.executeUpdate();
            //executeQuery do SELECT
            //execute do CREATE i DROP
            //executeUpdate do INSERT i UPDATE

//            String query1 = "SELECT * FROM PRACOWNICY"; // zapytanie
//            ResultSet rs = statement.executeQuery(query1); // set do zarządzania zbiorem, kluczem wartości będący elementami zwracanymi
//
//            while (rs.next()) {
//                String imie = rs.getString("imie");
//                String nazwisko = rs.getString("nazwisko");
//                int wiek = rs.getInt("wiek");
//                String plec = rs.getString("plec");
//                System.out.printf("Imie: %s\t Nazwisko: %s\t Wiek: %d\t Płeć: %s\n", imie, nazwisko, wiek, plec);
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
