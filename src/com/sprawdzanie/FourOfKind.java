package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.Collections;
import java.util.List;

public class FourOfKind {

    private Karta figura;

    public FourOfKind() {

    }

    public void sprawdzanieFourOfKind(List<Karta> listaKartyGracza) {

        if (szukanieCzterechJednakowychKart(listaKartyGracza)) {
            System.out.println("Kareta");
        } else {
            System.out.println("Brak karety");
        }

    }

    public boolean szukanieCzterechJednakowychKart(List<Karta> listaKartyGracza) {

        sortowanieKartGracza(listaKartyGracza);

        for (int i = 0; i < listaKartyGracza.size() - 3; i++) {
            if (listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i + 1).getFigura() &&
                    listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i + 2).getFigura() &&
                    listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i + 3).getFigura()) {
                return true;
            }
            if (true) {
                figura = listaKartyGracza.get(i);
            }
        }
        return false;
    }

    public void sortowanieKartGracza(List<Karta> listaKartyGracza) {

        Collections.sort(listaKartyGracza);
    }

}
