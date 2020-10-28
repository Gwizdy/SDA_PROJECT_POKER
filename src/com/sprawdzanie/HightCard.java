package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HightCard {

    private List<Karta> tempListOfHighCard;

    public HightCard() {

    }

    public int sprawdzanieHighCard(List<Karta> listaKartyGracza) {

        if (checkIfHightCard(listaKartyGracza)) {
            return 1;
        }
        return 0;
    }

    public boolean checkIfHightCard(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        int licznik = 0;

        for (int i = 0; i < listaKartGraczaDoSprawdzenia.size() - 1; i++) {
            for (int j = i + 1; j < listaKartGraczaDoSprawdzenia.size(); j++) {
                if (listaKartGraczaDoSprawdzenia.get(i).getFigura() != listaKartGraczaDoSprawdzenia.get(j).getFigura()) {
                    licznik += 1;
                }
            }
        }
        if (licznik == 21) {
            return true;
        } else
            return false;
    }

    public List<Karta> getFiveCardsHighCard(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfHighCard = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i > 1; i--) {
            tempListOfHighCard.add(listaKartGraczaDoSprawdzenia.get(i));
        }
        return tempListOfHighCard;
    }

    public List<Karta> getTempListOfHighCard() {
        return tempListOfHighCard;
    }

    public void setTempListOfHighCard(List<Karta> tempListOfHighCard) {
        this.tempListOfHighCard = tempListOfHighCard;
    }
}
