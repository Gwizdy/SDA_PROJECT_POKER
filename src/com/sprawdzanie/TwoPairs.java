package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.Collections;
import java.util.List;

public class TwoPairs {

    public TwoPairs() {

    }

    public void sprawdzanieTwoPairs(List<Karta> listaKartyGracza) {

        if (checkIfDoublePair(listaKartyGracza)) {
            System.out.println("Two Pairs");
        }
    }

    public boolean checkIfDoublePair(List<Karta> listaKartGraczaDoSprawdzenia) {
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i >= 3; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura()) {
                for (int j = i; j >= 1; j--) {
                    if (listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 1).getFigura()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
