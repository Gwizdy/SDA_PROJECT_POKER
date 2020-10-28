package com.sprawdzanie;

import com.taliakart.Figura;
import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Streigh {

    private List<Karta> tempStreighList;

    private List<Karta> tempListOfStreigh;

    private int liczbaGry;

    public Streigh() {

    }

    public int sprawdzanieIfStreigh(List<Karta> listaKartGraczaDoSprawdzenia) {

        liczbaGry = 0;

        removeDuplicateFigures(listaKartGraczaDoSprawdzenia);

        if (checkIfStreigh(tempStreighList)) {
            liczbaGry = 5;
        }
        return liczbaGry;
    }

    public boolean checkIfStreigh(List<Karta> listaUnikalnychFigur) {

        Collections.sort(listaUnikalnychFigur);

        if (listaUnikalnychFigur.size() >= 5) {
            for (int i = listaUnikalnychFigur.size() - 1; i >= 4; i--) {
                if (listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 1).getFigura() + 1
                        && listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 2).getFigura() + 2
                        && listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 3).getFigura() + 3
                        && listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 4).getFigura() + 4) {
                    return true;
                }
            }
            if (Arrays.asList(listaUnikalnychFigur.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(listaUnikalnychFigur.size() - 1).getFigura()).contains(Figura.AS.getFigura())) {
                return true;
            }
        }
        return false;
    }


    public List<Karta> removeDuplicateFigures(List<Karta> listaKartGraczaDosprawdzenia) {

        tempStreighList = new ArrayList<Karta>();

        Collections.sort(listaKartGraczaDosprawdzenia);

        tempStreighList.add(listaKartGraczaDosprawdzenia.get(0));

        for (int i = 0; i < listaKartGraczaDosprawdzenia.size() - 1; i++) {
            if (listaKartGraczaDosprawdzenia.get(i).getFigura() != listaKartGraczaDosprawdzenia.get(i + 1).getFigura())
                tempStreighList.add(listaKartGraczaDosprawdzenia.get(i + 1));
        }
        return tempStreighList;
    }

    public List<Karta> getFiveCardsStreigh(List<Karta> listaKartGraczaDoSprawdzenia) {

        tempListOfStreigh = new ArrayList<Karta>();

        removeDuplicateFigures(listaKartGraczaDoSprawdzenia);

        Collections.sort(tempStreighList);

        if (tempStreighList.size() >= 5) {
            for (int i = tempStreighList.size() - 1; i >= 4; i--) {
                if (tempStreighList.get(i).getFigura() == tempStreighList.get(i - 1).getFigura() + 1
                        && tempStreighList.get(i).getFigura() == tempStreighList.get(i - 2).getFigura() + 2
                        && tempStreighList.get(i).getFigura() == tempStreighList.get(i - 3).getFigura() + 3
                        && tempStreighList.get(i).getFigura() == tempStreighList.get(i - 4).getFigura() + 4) {

                    tempListOfStreigh.add(tempStreighList.get(i));
                    tempListOfStreigh.add(tempStreighList.get(i - 1));
                    tempListOfStreigh.add(tempStreighList.get(i - 2));
                    tempListOfStreigh.add(tempStreighList.get(i - 3));
                    tempListOfStreigh.add(tempStreighList.get(i - 4));

                    return tempListOfStreigh;
                }
            }
            if (Arrays.asList(tempStreighList.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(tempStreighList.size() - 1).getFigura()).contains(Figura.AS.getFigura())) {

                tempListOfStreigh.add(tempStreighList.get(0));
                tempListOfStreigh.add(tempStreighList.get(1));
                tempListOfStreigh.add(tempStreighList.get(2));
                tempListOfStreigh.add(tempStreighList.get(3));
                tempListOfStreigh.add(tempStreighList.get(tempStreighList.size() - 1));

                return tempListOfStreigh;
            }
        }
        return null;
    }

    public List<Karta> getTempListOfStreigh() {
        return tempListOfStreigh;
    }

    public void setTempListOfStreigh(List<Karta> tempListOfStreigh) {
        this.tempListOfStreigh = tempListOfStreigh;
    }
}
