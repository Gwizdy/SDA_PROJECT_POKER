package com.sprawdzanie;

import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullHouse {

    private List<Karta> tempListOfFullHouse;

    private int liczbaGry;

    public FullHouse() {

    }

    public int sprawdzanieFullHouse(List<Karta> listaKartyGracza) {

        liczbaGry = 0;

        if (checkIfFullHouse(listaKartyGracza)) {
            liczbaGry = 7;
        }
        return liczbaGry;
    }

    public boolean checkIfFullHouse(List<Karta> listaKartyGracza) {

        Collections.sort(listaKartyGracza);

        for (int i = listaKartyGracza.size() - 1; i > 3; i--) {
            if (listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 1).getFigura() &&
                    listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 2).getFigura()) {
                for (int j = i - 3; j > 0; j--) {
                    if (listaKartyGracza.get(j).getFigura() == listaKartyGracza.get(j - 1).getFigura()) {
                        return true;
                    }
                }
            }
        }
        for (int i = listaKartyGracza.size() - 1; i > 3; i--) {
            if (listaKartyGracza.get(i).getFigura() == listaKartyGracza.get(i - 1).getFigura()) {
                for (int j = i - 2; j > 1; j--) {
                    if (listaKartyGracza.get(j).getFigura() == listaKartyGracza.get(j - 1).getFigura() &&
                            listaKartyGracza.get(j).getFigura() == listaKartyGracza.get(j - 2).getFigura()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Karta> getFiveCardsFullHouse(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfFullHouse = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i > 3; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 2).getFigura()) {
                for (int j = i - 3; j > 0; j--) {
                    if (listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 1).getFigura()) {

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i - 1));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i - 2));

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j - 1));

                        return tempListOfFullHouse;
                    }
                }
            }
        }
        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i > 3; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura()) {
                for (int j = i - 2; j > 1; j--) {
                    if (listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 1).getFigura() &&
                            listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 2).getFigura()) {

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j - 1));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j - 2));

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i - 1));
                        
                        return tempListOfFullHouse;
                    }
                }
            }
        }
        return null;
    }

    public List<Karta> getTempListOfFullHouse() {
        return tempListOfFullHouse;
    }

    public void setTempListOfFullHouse(List<Karta> tempListOfFullHouse) {
        this.tempListOfFullHouse = tempListOfFullHouse;
    }
}
