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

    private List<Karta> tempListOfStraightFlush;

    private int liczbaGry;

    public StraightFlush() {

    }

    public int sprawdzanieIfStraightFlush(List<Karta> listaKartGraczaDoSprawdzenia) {

        liczbaGry = 0;

        listaKolorowKartyGracza(listaKartGraczaDoSprawdzenia);

        if (checkIfStraightFlush(listPIK)) {
            liczbaGry = 9;
        }
        if (checkIfStraightFlush(listTREFL)) {
            liczbaGry = 9;
        }
        if (checkIfStraightFlush(listKARO)) {
            liczbaGry = 9;
        }
        if (checkIfStraightFlush(listKIER)) {
            liczbaGry = 9;
        }
        return liczbaGry;
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

    public List<Karta> getFiveCardsStraightFlush(List<Karta> listaKartGraczaDoSprawdzenia) {

        tempListOfStraightFlush = new ArrayList<Karta>();

        listaKolorowKartyGracza(listaKartGraczaDoSprawdzenia);

        if (listPIK.size() >= 5) {

            Collections.sort(listPIK);

            for (int i = listPIK.size() - 1; i >= 4; i--) {
                if (listPIK.get(i).getFigura() == listPIK.get(i - 1).getFigura() + 1
                        && listPIK.get(i).getFigura() == listPIK.get(i - 2).getFigura() + 2
                        && listPIK.get(i).getFigura() == listPIK.get(i - 3).getFigura() + 3
                        && listPIK.get(i).getFigura() == listPIK.get(i - 4).getFigura() + 4) {

                    tempListOfStraightFlush.add(listPIK.get(i));
                    tempListOfStraightFlush.add(listPIK.get(i - 1));
                    tempListOfStraightFlush.add(listPIK.get(i - 2));
                    tempListOfStraightFlush.add(listPIK.get(i - 3));
                    tempListOfStraightFlush.add(listPIK.get(i - 4));

                    return tempListOfStraightFlush;
                }
            }
            if (Arrays.asList(listPIK.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(listPIK.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(listPIK.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(listPIK.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(listPIK.get(listPIK.size() - 1).getFigura()).contains(Figura.AS.getFigura())) {

                tempListOfStraightFlush.add(listPIK.get(0));
                tempListOfStraightFlush.add(listPIK.get(1));
                tempListOfStraightFlush.add(listPIK.get(2));
                tempListOfStraightFlush.add(listPIK.get(3));
                tempListOfStraightFlush.add(listPIK.get(listPIK.size() - 1));

                return tempListOfStraightFlush;
            }
        } else if (listTREFL.size() >= 5) {

            Collections.sort(listTREFL);

            for (int i = listTREFL.size() - 1; i >= 4; i--) {
                if (listTREFL.get(i).getFigura() == listTREFL.get(i - 1).getFigura() + 1
                        && listTREFL.get(i).getFigura() == listTREFL.get(i - 2).getFigura() + 2
                        && listTREFL.get(i).getFigura() == listTREFL.get(i - 3).getFigura() + 3
                        && listTREFL.get(i).getFigura() == listTREFL.get(i - 4).getFigura() + 4) {

                    tempListOfStraightFlush.add(listTREFL.get(i));
                    tempListOfStraightFlush.add(listTREFL.get(i - 1));
                    tempListOfStraightFlush.add(listTREFL.get(i - 2));
                    tempListOfStraightFlush.add(listTREFL.get(i - 3));
                    tempListOfStraightFlush.add(listTREFL.get(i - 4));

                    return tempListOfStraightFlush;
                }
            }

            if (Arrays.asList(listTREFL.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(listTREFL.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(listTREFL.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(listTREFL.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(listTREFL.get(listTREFL.size() - 1).getFigura()).contains(Figura.AS.getFigura())) {

                tempListOfStraightFlush.add(listTREFL.get(0));
                tempListOfStraightFlush.add(listTREFL.get(1));
                tempListOfStraightFlush.add(listTREFL.get(2));
                tempListOfStraightFlush.add(listTREFL.get(3));
                tempListOfStraightFlush.add(listTREFL.get(listTREFL.size() - 1));

                return tempListOfStraightFlush;
            }
        } else if (listKARO.size() >= 5) {

            Collections.sort(listKARO);

            for (int i = listKARO.size() - 1; i >= 4; i--) {
                if (listKARO.get(i).getFigura() == listKARO.get(i - 1).getFigura() + 1
                        && listKARO.get(i).getFigura() == listKARO.get(i - 2).getFigura() + 2
                        && listKARO.get(i).getFigura() == listKARO.get(i - 3).getFigura() + 3
                        && listKARO.get(i).getFigura() == listKARO.get(i - 4).getFigura() + 4) {

                    tempListOfStraightFlush.add(listKARO.get(i));
                    tempListOfStraightFlush.add(listKARO.get(i - 1));
                    tempListOfStraightFlush.add(listKARO.get(i - 2));
                    tempListOfStraightFlush.add(listKARO.get(i - 3));
                    tempListOfStraightFlush.add(listKARO.get(i - 4));

                    return tempListOfStraightFlush;
                }
            }
            if (Arrays.asList(listKARO.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(listKARO.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(listKARO.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(listKARO.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(listKARO.get(listKARO.size() - 1).getFigura()).contains(Figura.AS.getFigura())) {

                tempListOfStraightFlush.add(listKARO.get(0));
                tempListOfStraightFlush.add(listKARO.get(1));
                tempListOfStraightFlush.add(listKARO.get(2));
                tempListOfStraightFlush.add(listKARO.get(3));
                tempListOfStraightFlush.add(listKARO.get(listKARO.size() - 1));

                return tempListOfStraightFlush;
            }
        } else if (listKIER.size() >= 5) {

            Collections.sort(listKIER);

            for (int i = listKIER.size() - 1; i >= 4; i--) {
                if (listKIER.get(i).getFigura() == listKIER.get(i - 1).getFigura() + 1
                        && listKIER.get(i).getFigura() == listKIER.get(i - 2).getFigura() + 2
                        && listKIER.get(i).getFigura() == listKIER.get(i - 3).getFigura() + 3
                        && listKIER.get(i).getFigura() == listKIER.get(i - 4).getFigura() + 4) {

                    tempListOfStraightFlush.add(listKIER.get(i));
                    tempListOfStraightFlush.add(listKIER.get(i - 1));
                    tempListOfStraightFlush.add(listKIER.get(i - 2));
                    tempListOfStraightFlush.add(listKIER.get(i - 3));
                    tempListOfStraightFlush.add(listKIER.get(i - 4));

                    return tempListOfStraightFlush;
                }
            }
            if (Arrays.asList(listKIER.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(listKIER.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(listKIER.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(listKIER.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(listKIER.get(listKIER.size() - 1).getFigura()).contains(Figura.AS.getFigura())) {

                tempListOfStraightFlush.add(listKIER.get(0));
                tempListOfStraightFlush.add(listKIER.get(1));
                tempListOfStraightFlush.add(listKIER.get(2));
                tempListOfStraightFlush.add(listKIER.get(3));
                tempListOfStraightFlush.add(listKIER.get(listKIER.size() - 1));

                return tempListOfStraightFlush;
            }
        }
        return null;
    }

    public List<Karta> getTempListOfStraightFlush() {
        return tempListOfStraightFlush;
    }

    public void setTempListOfStraightFlush(List<Karta> tempListOfStraightFlush) {
        this.tempListOfStraightFlush = tempListOfStraightFlush;
    }
}
