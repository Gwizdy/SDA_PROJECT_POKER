package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OnePair {

    private List<Karta> tempListOfOnePair;

    private int liczbaGry;

    public OnePair() {

    }

    public int sprawdzanieOnePair(List<Karta> listaKartyGracza) {

        liczbaGry = 0;

        if (checkIfOnePair(listaKartyGracza)) {
            liczbaGry = 2;
        }
        return liczbaGry;
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

    public List<Karta> getFiveCardsOnePair(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfOnePair = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i >= 1; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura()) {

                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(i));
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(i - 1));

                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i - 1);

                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 1));
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 2));
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 3));

                return tempListOfOnePair;
            }
        }
        return null;
    }

    public List<Karta> getTempListOfOnePair() {
        return tempListOfOnePair;
    }

    public void setTempListOfOnePair(List<Karta> tempListOfOnePair) {
        this.tempListOfOnePair = tempListOfOnePair;
    }
}
