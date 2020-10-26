package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.List;

public class FullHouse {

    public FullHouse() {

    }

    public void sprawdzanieFullHouse(List<Karta> listaKartyGracza) {

        if (checkIfFullHouse(listaKartyGracza)) {
            System.out.println("Full House");
        }
    }

    private boolean checkIfFullHouse(List<Karta> listaKartyGracza) {

        for (int i = listaKartyGracza.size() - 1; i > 3; i--) {
            if (listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 1).getFigura() &&
                    listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 2).getFigura()) {
                for (int j = i - 3; j > 0; j--) {
                    if (listaKartyGracza.get(j).getFigura() == listaKartyGracza.get(j - 1).getFigura()) {
                        return true;
                    }
                }
            }
        }
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
        return false;
    }

}
