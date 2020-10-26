package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.Collections;
import java.util.List;

public class OnePair {

    public OnePair() {

    }

    public void sprawdzanieOnePair(List<Karta> listaKartyGracza) {

        if (checkIfOnePair(listaKartyGracza)) {
            System.out.println("One Pair");
        }
    }


    public boolean checkIfOnePair(List<Karta> listaKartGraczaDoSprawdzenia) {
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i >= 1; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura()) {
                return true;
            }
        }
        return false;
    }
}
