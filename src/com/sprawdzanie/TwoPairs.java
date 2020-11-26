package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TwoPairs {

    private List<Karta> tempListOfTwoPairs;

    private int liczbaGry;

    public TwoPairs() {

    }

    public int sprawdzanieTwoPairs(List<Karta> listaKartyGracza) {

        liczbaGry = 0;

        if (checkIfDoublePair(listaKartyGracza)) {
            liczbaGry = 3;
        }
        return liczbaGry;
    }

    public boolean checkIfDoublePair(List<Karta> listaKartGraczaDoSprawdzenia) {
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i >= 3; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura()) {
                for (int j = i - 2; j >= 1; j--) {
                    if (listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 1).getFigura()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public List<Karta> getFiveCardsTwoPairs(List<Karta> listaKartGraczaDoSprawdzenia) {
        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfTwoPairs = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i >= 3; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura()) {
                for (int j = i - 2; j >= 1; j--) {
                    if (listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 1).getFigura()) {

                        tempListOfTwoPairs.add(listaKartGraczaDoSprawdzenia.get(i));
                        tempListOfTwoPairs.add(listaKartGraczaDoSprawdzenia.get(i - 1));
                        tempListOfTwoPairs.add(listaKartGraczaDoSprawdzenia.get(j));
                        tempListOfTwoPairs.add(listaKartGraczaDoSprawdzenia.get(j - 1));

                        listaKartGraczaDoSprawdzenia.remove(i);
                        listaKartGraczaDoSprawdzenia.remove(i - 1);
                        listaKartGraczaDoSprawdzenia.remove(j);
                        listaKartGraczaDoSprawdzenia.remove(j - 1);

                        tempListOfTwoPairs.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 1));

                        return tempListOfTwoPairs;
                    }
                }
            }
        }
        return null;
    }

    public List<Karta> getTempListOfTwoPairs() {
        return tempListOfTwoPairs;
    }

}
