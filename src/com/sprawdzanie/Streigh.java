package com.sprawdzanie;

import com.taliakart.Figura;
import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Streigh {

    private List<Karta> tempStreighList;

    public Streigh() {

    }

    public void sprawdzanieIfStreigh(List<Karta> listaKartGraczaDoSprawdzenia) {

        removeDuplicateFigures(listaKartGraczaDoSprawdzenia);

        if (checkIfStreigh(tempStreighList)) {
            System.out.println("STREIGH");
        }
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

}
