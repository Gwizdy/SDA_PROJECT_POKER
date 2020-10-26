package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.Collections;
import java.util.List;

public class HightCard {

    private Karta highestCard;

    public HightCard() {

    }

    public void sprawdzanieHighCard(List<Karta> listaKartyGracza) {

        if (checkIfHightCard(listaKartyGracza)) {
            System.out.println("High Card" + highestCard);
        }
    }

    public boolean checkIfHightCard(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        int licznik = 0;

        for (int i = 0; i < listaKartGraczaDoSprawdzenia.size() - 1; i++) {
            for (int j = i + 1; j < listaKartGraczaDoSprawdzenia.size() ; j++) {
                if (listaKartGraczaDoSprawdzenia.get(i).getFigura() != listaKartGraczaDoSprawdzenia.get(j).getFigura()) {
                    licznik += 1;
                }
            }
        }
        if (licznik == 21) {
            highestCard = listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 1);
            return true;
        } else
            return false;
    }

}
