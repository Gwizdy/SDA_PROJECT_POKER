package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourOfKind {

    private Karta figura;

    private List<Karta> tempListOfFourOfKind;

    private int liczbaGry;

    public FourOfKind() {

    }

    public int sprawdzanieFourOfKind(List<Karta> listaKartyGracza) {

        liczbaGry = 0;

        if (checkIfFourOfKind(listaKartyGracza)) {
            liczbaGry = 8;
        }
        return liczbaGry;
    }

    public boolean checkIfFourOfKind(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = 0; i < listaKartGraczaDoSprawdzenia.size() - 4; i++) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 1).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 2).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 3).getFigura()) {
                figura = listaKartGraczaDoSprawdzenia.get(i);
                return true;
            }
        }
        return false;
    }

    public List<Karta> getFiveCardsFourOfKind(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfFourOfKind = new ArrayList<Karta>();

        for (int i = 0; i < listaKartGraczaDoSprawdzenia.size() - 3; i++) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 1).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 2).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 3).getFigura()) {

                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i));
                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 1));
                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 2));
                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 3));

                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i);

                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 1));

                return tempListOfFourOfKind;
            }
        }
        return null;
    }
//    public List<Karta> getFiveCardsFourOfKind(List<Karta> listaKartGraczaDoSprawdzenia) {
//
//        Collections.sort(listaKartGraczaDoSprawdzenia);
//
//        tempListOfFourOfKind = new ArrayList<Karta>();
//
//        for (int i = 0; i < listaKartGraczaDoSprawdzenia.size() - 4; i++) {
//            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 1).getFigura() &&
//                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 2).getFigura() &&
//                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 3).getFigura()) {
//
//                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i));
//                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 1));
//                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 2));
//                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 3));
//
//                listaKartGraczaDoSprawdzenia.remove(i);
//                listaKartGraczaDoSprawdzenia.remove(i + 1);
//                listaKartGraczaDoSprawdzenia.remove(i + 2);
//                listaKartGraczaDoSprawdzenia.remove(i + 3);
//
//                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 1));
//
//                return tempListOfFourOfKind;
//            }
//        }
//        return null;
//    }

    public List<Karta> getTempListOfFourOfKind() {
        return tempListOfFourOfKind;
    }

    public void setTempListOfFourOfKind(List<Karta> tempListOfFourOfKind) {
        this.tempListOfFourOfKind = tempListOfFourOfKind;
    }
}
