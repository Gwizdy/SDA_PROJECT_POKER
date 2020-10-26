package com.sprawdzanie;

import com.taliakart.Figura;
import com.taliakart.Karta;
import com.taliakart.Kolor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StraightFlush {

    private List<Karta> listPIK;
    private List<Karta> listTREFL;
    private List<Karta> listKARO;
    private List<Karta> listKIER;

    public StraightFlush() {

    }

    public void sprawdzanieIfStraightFlush(List<Karta> listaKartGraczaDoSprawdzenia) {

        listaKolorowKartyGracza(listaKartGraczaDoSprawdzenia);

        if (checkIfStraightFlush(listPIK)) {
            System.out.println("STRAIGHT FLUSH" + listPIK);
        }
        if (checkIfStraightFlush(listTREFL)) {
            System.out.println("STRAIGHT FLUSH" + listTREFL);
        }
        if (checkIfStraightFlush(listKARO)) {
            System.out.println("STRAIGHT FLUSH" + listKARO);
        }
        if (checkIfStraightFlush(listKIER)) {
            System.out.println("STRAIGHT FLUSH" + listKIER);
        }
    }

    public boolean checkIfStraightFlush(List<Karta> listaUnikalnychFigur) {

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

    public void listaKolorowKartyGracza(List<Karta> listaKartyGracza) {

        listPIK = new ArrayList<Karta>();
        listTREFL = new ArrayList<Karta>();
        listKARO = new ArrayList<Karta>();
        listKIER = new ArrayList<Karta>();

        for (Karta k : listaKartyGracza) {
            if (k.getKolor().equals(Kolor.PIK)) {
                listPIK.add(k);
            } else if (k.getKolor().equals(Kolor.TREFL)) {
                listTREFL.add(k);
            } else if (k.getKolor().equals(Kolor.KARO)) {
                listKARO.add(k);
            } else if (k.getKolor().equals(Kolor.KIER)) {
                listKIER.add(k);
            }
        }
    }

}
