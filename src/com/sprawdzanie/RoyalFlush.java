package com.sprawdzanie;

import com.taliakart.*;

import java.util.*;

public class RoyalFlush {

    private GUITalia guiTalia;

    private List<Karta> listPIK;
    private List<Karta> listTREFL;
    private List<Karta> listKARO;
    private List<Karta> listKIER;

    private List<Karta> listOfHighestFive;

    private List<Karta> handPlusTableCards;

    public RoyalFlush(GUITalia guiTalia) {
        this.guiTalia = guiTalia;
        
    }

    public void kartyRekaPlusStol(List<Karta> listaKartGracza, List<Karta> listaKartyFlop, List<Karta> listaKartyTurnOrRiver) {

        handPlusTableCards = new ArrayList<Karta>();

        handPlusTableCards.addAll(listaKartGracza);
        handPlusTableCards.addAll(listaKartyFlop);
        handPlusTableCards.addAll(listaKartyTurnOrRiver);

        Collections.sort(handPlusTableCards);
    }

    public void sprawdzanieRoyalFlush(List<Karta> listaKartyGracza) {

        listaKolorowKartyGracza(listaKartyGracza);

        listOfHighestFive = new ArrayList<Karta>();

        if (sprawdzOdDziesiatkiDoAsa(listPIK, listOfHighestFive)) {
            System.out.println("PIK KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if (sprawdzOdDziesiatkiDoAsa(listTREFL, listOfHighestFive)) {
            System.out.println("TREFL KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if (sprawdzOdDziesiatkiDoAsa(listKARO, listOfHighestFive)) {
            System.out.println("KARO KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if (sprawdzOdDziesiatkiDoAsa(listKIER, listOfHighestFive)) {
            System.out.println("KIER KROLEWSKI");
        }
    }

    public boolean sprawdzOdDziesiatkiDoAsa(List<Karta> listaKartyGracza, List<Karta> listaPieciuNajwyższychKart) {

        getFiveHighestCards(listaKartyGracza, listaPieciuNajwyższychKart);

        Collections.sort(listaPieciuNajwyższychKart);

        if (Arrays.asList(listaPieciuNajwyższychKart.get(0).getFigura()).contains(Figura.DZIESIATKA.getFigura()) &&
                Arrays.asList(listaPieciuNajwyższychKart.get(1).getFigura()).contains(Figura.WALET.getFigura()) &&
                Arrays.asList(listaPieciuNajwyższychKart.get(2).getFigura()).contains(Figura.DAMA.getFigura()) &&
                Arrays.asList(listaPieciuNajwyższychKart.get(3).getFigura()).contains(Figura.KROL.getFigura()) &&
                Arrays.asList(listaPieciuNajwyższychKart.get(4).getFigura()).contains(Figura.AS.getFigura())) {
            return true;
        }
        return false;
    }

    public void getFiveHighestCards(List<Karta> listaKartyGracza, List<Karta> listaPieciuNajwyższychKart) {

        for (int i = listaKartyGracza.size() - 1; i >= listaKartyGracza.size() - 5; i--) {
            listaPieciuNajwyższychKart.add(listaKartyGracza.get(i));
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

