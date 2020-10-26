package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.Collections;
import java.util.List;

public class ThreeOfAKind {

    public ThreeOfAKind() {

    }

    public void sprawdzanieThreeOfAKind(List<Karta> listaKartyGracza) {

        if (checkIfThreeOfKind(listaKartyGracza)) {
            System.out.println("Three of a kind");
        }
    }

    public boolean checkIfThreeOfKind(List<Karta> listaKartGraczaDoSprawdzenia) {
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i >= 2; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 2).getFigura()) {
                return true;
            }
        }
        return false;
    }
}
