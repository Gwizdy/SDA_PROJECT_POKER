package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.List;

public class FullHouse {

    public FullHouse() {

    }

    public void sprawdzanieFullHouse(List<Karta> listaKartyGracza) {

        if (szukanieTrzechIDwochJednakowychKart(listaKartyGracza)) {
            System.out.println("Full House");
        } else {
            System.out.println("Brak Full House");
        }

    }

    private boolean szukanieTrzechIDwochJednakowychKart(List<Karta> listaKartyGracza) {

        return false;
    }
}
