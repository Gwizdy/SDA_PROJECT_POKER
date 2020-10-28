package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeOfAKind {

    private List<Karta> tempListOfThreeOfKind;

    private int liczbaGry;

    public ThreeOfAKind() {

    }

    public int sprawdzanieThreeOfAKind(List<Karta> listaKartyGracza) {

        liczbaGry = 0;

        if (checkIfThreeOfKind(listaKartyGracza)) {
            liczbaGry = 4;
        }
        return liczbaGry;
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

    public List<Karta> getFiveCardsThreeOfKind(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfThreeOfKind = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i >= 2; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 2).getFigura()) {
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(i));
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(i - 1));
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(i - 2));

                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i - 1);
                listaKartGraczaDoSprawdzenia.remove(i - 2);
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 1));
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 2));

                return tempListOfThreeOfKind;
            }
        }
        return null;
    }

    public List<Karta> getTempListOfThreeOfKind() {
        return tempListOfThreeOfKind;
    }

    public void setTempListOfThreeOfKind(List<Karta> tempListOfThreeOfKind) {
        this.tempListOfThreeOfKind = tempListOfThreeOfKind;
    }
}
