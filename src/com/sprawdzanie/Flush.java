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
    private List<Karta> tempListOfFlush;

    private int liczbaGry;

    public Flush() {

    }

    public int sprawdzanieFlush(List<Karta> listaKartyGracza) {

        liczbaGry = 0;

        listaKolorowKartyGracza(listaKartyGracza);

        listOfHighestFive = new ArrayList<Karta>();

        if (checkIfFlush(listPIK, listOfHighestFive)) {
            liczbaGry = 6;
        }

        if (checkIfFlush(listTREFL, listOfHighestFive)) {
            liczbaGry = 6;
        }

        if (checkIfFlush(listKARO, listOfHighestFive)) {
            liczbaGry = 6;
        }

        if (checkIfFlush(listKIER, listOfHighestFive)) {
            liczbaGry = 6;
        }
        return liczbaGry;
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
            for (int i = listaKolorowKart.size() - 1; i > listaKolorowKart.size() - 6; i--) {
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

    public List<Karta> getFiveCardsFlush(List<Karta> listaKartGraczaDoSprawdzenia) {

        tempListOfFlush = new ArrayList<Karta>();

        listaKolorowKartyGracza(listaKartGraczaDoSprawdzenia);

        if (listPIK.size() >= 5) {
            getFiveHighestCards(listPIK,tempListOfFlush);
            return tempListOfFlush;
        }else if (listTREFL.size() >= 5){
            getFiveHighestCards(listTREFL,tempListOfFlush);
            return tempListOfFlush;
        }else if (listKARO.size() >= 5){
            getFiveHighestCards(listKARO,tempListOfFlush);
            return tempListOfFlush;
        }else if (listKIER.size() >= 5){
            getFiveHighestCards(listKIER,tempListOfFlush);
            return tempListOfFlush;
        }
        return null;
    }

    public List<Karta> getTempListOfFlush() {
        return tempListOfFlush;
    }

    public void setTempListOfFlush(List<Karta> tempListOfFlush) {
        this.tempListOfFlush = tempListOfFlush;
    }
}
