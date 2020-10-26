package com.sprawdzanie;

import com.taliakart.*;

import java.util.*;

public class RoyalFlush {

    private List<Karta> listPIK;
    private List<Karta> listTREFL;
    private List<Karta> listKARO;
    private List<Karta> listKIER;

    private List<Karta> listOfHighestFive;

    public RoyalFlush() {

    }

    public void sprawdzanieRoyalFlush(List<Karta> listaKartyGracza) {

        listaKolorowKartyGracza(listaKartyGracza);

        listOfHighestFive = new ArrayList<Karta>();

        if (checkIfRoyalFlush(listPIK, listOfHighestFive)) {
            System.out.println("PIK KROLEWSKI");
        }

        if (checkIfRoyalFlush(listTREFL, listOfHighestFive)) {
            System.out.println("TREFL KROLEWSKI");
        }

        if (checkIfRoyalFlush(listKARO, listOfHighestFive)) {
            System.out.println("KARO KROLEWSKI");
        }

        if (checkIfRoyalFlush(listKIER, listOfHighestFive)) {
            System.out.println("KIER KROLEWSKI");
        }
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
            for (int i = listaKolorowKart.size() - 1; i >= listaKolorowKart.size() - 5; i--) {
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

}

