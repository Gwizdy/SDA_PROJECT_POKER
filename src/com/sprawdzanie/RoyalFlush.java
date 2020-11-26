package com.sprawdzanie;

import com.taliakart.*;

import java.util.*;

public class RoyalFlush {

    private List<Karta> listPIK;
    private List<Karta> listTREFL;
    private List<Karta> listKARO;
    private List<Karta> listKIER;

    private List<Karta> listOfHighestFive;
    private List<Karta> tempListOfRoyalFlush;

    private int liczbaGry;

    public RoyalFlush() {

    }

    public int sprawdzanieRoyalFlush(List<Karta> listaKartyGracza) {

        liczbaGry = 0;

        listaKolorowKartyGracza(listaKartyGracza);

        listOfHighestFive = new ArrayList<Karta>();

        if (checkIfRoyalFlush(listPIK, listOfHighestFive)) {
            liczbaGry = 10;
        }

        if (checkIfRoyalFlush(listTREFL, listOfHighestFive)) {
            liczbaGry = 10;
        }

        if (checkIfRoyalFlush(listKARO, listOfHighestFive)) {
            liczbaGry = 10;
        }

        if (checkIfRoyalFlush(listKIER, listOfHighestFive)) {
            liczbaGry = 10;
        }
        return liczbaGry;
    }

    public boolean checkIfRoyalFlush(List<Karta> listaKolorowKart, List<Karta> listOfHighestFive) {

        getFiveHighestCards(listaKolorowKart, listOfHighestFive);

        Collections.sort(listOfHighestFive);

        if (listOfHighestFive.size() == 5) {
            if (Arrays.asList(listOfHighestFive.get(0).getFigura()).contains(Figura.DZIESIATKA.getFigura()) &&
                    Arrays.asList(listOfHighestFive.get(1).getFigura()).contains(Figura.WALET.getFigura()) &&
                    Arrays.asList(listOfHighestFive.get(2).getFigura()).contains(Figura.DAMA.getFigura()) &&
                    Arrays.asList(listOfHighestFive.get(3).getFigura()).contains(Figura.KROL.getFigura()) &&
                    Arrays.asList(listOfHighestFive.get(4).getFigura()).contains(Figura.AS.getFigura())) {
                return true;
            }
        }
        return false;
    }

    public void getFiveHighestCards(List<Karta> listaKolorowKart, List<Karta> listOfHighestFive) {

        Collections.sort(listaKolorowKart);

        if (listaKolorowKart.size() >= 5) {
            for (int i = listaKolorowKart.size() - 1; i > listaKolorowKart.size()-6; i--) {
                listOfHighestFive.add(listaKolorowKart.get(i));
            }
        }
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

    public List<Karta> getFiveCardsRoyalFlush(List<Karta> listaKartGraczaDoSprawdzenia) {

        tempListOfRoyalFlush = new ArrayList<Karta>();

        listaKolorowKartyGracza(listaKartGraczaDoSprawdzenia);

        if (listPIK.size() >= 5) {
            getFiveHighestCards(listPIK, tempListOfRoyalFlush);

            Collections.sort(tempListOfRoyalFlush);

            if (tempListOfRoyalFlush.size() == 5) {
                if (Arrays.asList(tempListOfRoyalFlush.get(0).getFigura()).contains(Figura.DZIESIATKA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(1).getFigura()).contains(Figura.WALET.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(2).getFigura()).contains(Figura.DAMA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(3).getFigura()).contains(Figura.KROL.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(4).getFigura()).contains(Figura.AS.getFigura())) {
                    return tempListOfRoyalFlush;
                }
            }
        }else if (listTREFL.size() >= 5){
            getFiveHighestCards(listTREFL, tempListOfRoyalFlush);

            Collections.sort(tempListOfRoyalFlush);

            if (tempListOfRoyalFlush.size() == 5) {
                if (Arrays.asList(tempListOfRoyalFlush.get(0).getFigura()).contains(Figura.DZIESIATKA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(1).getFigura()).contains(Figura.WALET.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(2).getFigura()).contains(Figura.DAMA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(3).getFigura()).contains(Figura.KROL.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(4).getFigura()).contains(Figura.AS.getFigura())) {
                    return tempListOfRoyalFlush;
                }
            }
        }else if (listKARO.size() >= 5){
            getFiveHighestCards(listKARO, tempListOfRoyalFlush);

            Collections.sort(tempListOfRoyalFlush);

            if (tempListOfRoyalFlush.size() == 5) {
                if (Arrays.asList(tempListOfRoyalFlush.get(0).getFigura()).contains(Figura.DZIESIATKA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(1).getFigura()).contains(Figura.WALET.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(2).getFigura()).contains(Figura.DAMA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(3).getFigura()).contains(Figura.KROL.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(4).getFigura()).contains(Figura.AS.getFigura())) {
                    return tempListOfRoyalFlush;
                }
            }
        }else if (listKIER.size() >= 5){
            getFiveHighestCards(listKIER, tempListOfRoyalFlush);

            Collections.sort(tempListOfRoyalFlush);

            if (tempListOfRoyalFlush.size() == 5) {
                if (Arrays.asList(tempListOfRoyalFlush.get(0).getFigura()).contains(Figura.DZIESIATKA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(1).getFigura()).contains(Figura.WALET.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(2).getFigura()).contains(Figura.DAMA.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(3).getFigura()).contains(Figura.KROL.getFigura()) &&
                        Arrays.asList(tempListOfRoyalFlush.get(4).getFigura()).contains(Figura.AS.getFigura())) {
                    return tempListOfRoyalFlush;
                }
            }
        }
        return null;
    }

    public List<Karta> getTempListOfRoyalFlush() {
        return tempListOfRoyalFlush;
    }

}

