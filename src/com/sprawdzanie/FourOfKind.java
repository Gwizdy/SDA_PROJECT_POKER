package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.Collections;
import java.util.List;

public class FourOfKind {

    private Karta figura;

    public FourOfKind() {

    }

    public void sprawdzanieFourOfKind(List<Karta> listaKartyGracza) {

        if (checkIfFourOfKind(listaKartyGracza)) {
            System.out.println("Kareta " + figura);
        }
    }

    public boolean checkIfFourOfKind(List<Karta> listaKartyGracza) {

        Collections.sort(listaKartyGracza);

        for (int i = 0; i < listaKartyGracza.size() - 3; i++) {
            if (listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i + 1).getFigura() &&
                    listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i + 2).getFigura() &&
                    listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i + 3).getFigura()) {
                figura = listaKartyGracza.get(i);
                return true;
            }
        }
        return false;
    }

}
