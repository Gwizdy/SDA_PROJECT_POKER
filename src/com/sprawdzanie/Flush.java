package com.sprawdzanie;

import com.taliakart.Karta;
import com.taliakart.Kolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flush {

    private List<Karta> listPIK;
    private List<Karta> listTREFL;
    private List<Karta> listKARO;
    private List<Karta> listKIER;

    private List<Karta> listOfHighestFive;

    public Flush() {

    }

    public void sprawdzanieFlush(List<Karta> listaKartyGracza) {

        listaKolorowKartyGracza(listaKartyGracza);

        listOfHighestFive = new ArrayList<Karta>();

        if (checkIfFlush(listPIK, listOfHighestFive)) {
            System.out.println("PIK FLUSH");
        }

        if (checkIfFlush(listTREFL, listOfHighestFive)) {
            System.out.println("TREFL FLUSH");
        }

        if (checkIfFlush(listKARO, listOfHighestFive)) {
            System.out.println("KARO FLUSH");
        }

        if (checkIfFlush(listKIER, listOfHighestFive)) {
            System.out.println("KIER FLUSH");
        }
    }

    public boolean checkIfFlush(List<Karta> listaKolorowKart, List<Karta> listOfHighestFive) {

        getFiveHighestCards(listaKolorowKart, listOfHighestFive);

        Collections.sort(listOfHighestFive);

        if (listOfHighestFive.size() == 5) {
            return true;
        }
        return false;
    }

    public void getFiveHighestCards(List<Karta> listaKolorowKart, List<Karta> listOfHighestFive) {

        Collections.sort(listaKolorowKart);

        if (listaKolorowKart.size() >= 5) {
            for (int i = listaKolorowKart.size() - 1; i > 3; i--) {
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
