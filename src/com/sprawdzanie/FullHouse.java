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

        boolean sprawdzenie = false;

        for (int i = listaKartyGracza.size() - 1; i > 3; i--) {
            if (listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 1).getFigura() &&
                    listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 2).getFigura()) {
                for (int j = i - 3; j > 0; j--) {
                    if (listaKartyGracza.get(j).getFigura() == listaKartyGracza.get(j - 1).getFigura()) {
                        sprawdzenie = true;
                        return true;
                    }
                }
            }
        }
        if (sprawdzenie == false) {
            for (int i = listaKartyGracza.size() - 1; i > 3; i--) {
                if (listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 1).getFigura()) {
                    for (int j = i - 2; j > 1; j--) {
                        if (listaKartyGracza.get(j).getFigura() == listaKartyGracza.get(j - 1).getFigura() &&
                                listaKartyGracza.get(j).getFigura() == listaKartyGracza.get(j - 2).getFigura()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
}
