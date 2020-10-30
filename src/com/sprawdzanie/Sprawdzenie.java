package com.sprawdzanie;

import com.taliakart.GUITalia;
import com.taliakart.Karta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprawdzenie {

    private GUITalia guiTalia;
    private RoyalFlush royalFlush = new RoyalFlush();
    private StraightFlush straightFlush = new StraightFlush();
    private FourOfKind fourOfKind = new FourOfKind();
    private FullHouse fullHouse = new FullHouse();
    private Flush flush = new Flush();
    private Streigh streigh = new Streigh();
    private ThreeOfAKind threeOfAKind = new ThreeOfAKind();
    private TwoPairs twoPairs = new TwoPairs();
    private OnePair onePair = new OnePair();
    private HightCard hightCard = new HightCard();

    private List<Karta> handPlusTableCards;

    private List<Karta> listaPomocnicza;

    private List<String> listaGraczyRoyalFlush;
    private List<String> listaGraczyStraightFlush;
    private List<String> listaGraczyFourOfKind;
    private List<String> listaGraczyFullHouse;
    private List<String> listaGraczyFlush;
    private List<String> listaGraczyStraigh;
    private List<String> listaGraczyThreeOfKind;
    private List<String> listaGraczyTwoPairs;
    private List<String> listaGraczyOnePair;
    private List<String> listaGraczyHighCards;


    private List<List<Karta>> listalistKartyRoyalFlush;
    private List<List<Karta>> listalistKartyStraightFlush;
    private List<List<Karta>> listalistKartyFourOfKind;
    private List<List<Karta>> listalistKartyFullHouse;
    private List<List<Karta>> listalistKartyFlush;
    private List<List<Karta>> listalistKartyStraigh;
    private List<List<Karta>> listalistKartyThreeOfKind;
    private List<List<Karta>> listalistKartyTwoPairs;
    private List<List<Karta>> listalistKartyOnePair;
    private List<List<Karta>> listalistKartyHighCards;

    private int liczba;
    private int liczbaPomocnicza;
    private String gracz;
    private String gracz1;


    public Sprawdzenie(GUITalia guiTalia) {
        this.guiTalia = guiTalia;

        liczba = 0;

        listaPomocnicza = new ArrayList<Karta>();

        listaGraczyRoyalFlush = new ArrayList<String>();
        listaGraczyStraightFlush = new ArrayList<String>();
        listaGraczyFourOfKind = new ArrayList<String>();
        listaGraczyFullHouse = new ArrayList<String>();
        listaGraczyFlush = new ArrayList<String>();
        listaGraczyStraigh = new ArrayList<String>();
        listaGraczyThreeOfKind = new ArrayList<String>();
        listaGraczyTwoPairs = new ArrayList<String>();
        listaGraczyOnePair = new ArrayList<String>();
        listaGraczyHighCards = new ArrayList<String>();

        listalistKartyRoyalFlush = new ArrayList<List<Karta>>();
        listalistKartyStraightFlush = new ArrayList<List<Karta>>();
        listalistKartyFourOfKind = new ArrayList<List<Karta>>();
        listalistKartyFullHouse = new ArrayList<List<Karta>>();
        listalistKartyFlush = new ArrayList<List<Karta>>();
        listalistKartyStraigh = new ArrayList<List<Karta>>();
        listalistKartyThreeOfKind = new ArrayList<List<Karta>>();
        listalistKartyTwoPairs = new ArrayList<List<Karta>>();
        listalistKartyOnePair = new ArrayList<List<Karta>>();
        listalistKartyHighCards = new ArrayList<List<Karta>>();

        for (int i = 0; i < guiTalia.getIloscGraczy(); i++) {

            kartyRekaPlusStol(guiTalia.getListPlayerCards(), guiTalia.getListaFlop(), guiTalia.getListaTurnOrRiver());

            if (royalFlush.sprawdzanieRoyalFlush(handPlusTableCards) == 10) {
                liczbaPomocnicza = 10;
            } else if (straightFlush.sprawdzanieIfStraightFlush(handPlusTableCards) == 9) {
                liczbaPomocnicza = 9;
                straightFlush.getFiveCardsStraightFlush(handPlusTableCards);
            } else if (fourOfKind.sprawdzanieFourOfKind(handPlusTableCards) == 8) {
                liczbaPomocnicza = 8;
                fourOfKind.getFiveCardsFourOfKind(handPlusTableCards);
            } else if (fullHouse.sprawdzanieFullHouse(handPlusTableCards) == 7) {
                liczbaPomocnicza = 7;
                fullHouse.getFiveCardsFullHouse(handPlusTableCards);
            } else if (flush.sprawdzanieFlush(handPlusTableCards) == 6) {
                liczbaPomocnicza = 6;
                flush.getFiveCardsFlush(handPlusTableCards);
            } else if (streigh.sprawdzanieIfStreigh(handPlusTableCards) == 5) {
                liczbaPomocnicza = 5;
                streigh.getFiveCardsStreigh(handPlusTableCards);
            } else if (threeOfAKind.sprawdzanieThreeOfAKind(handPlusTableCards) == 4) {
                liczbaPomocnicza = 4;
                threeOfAKind.getFiveCardsThreeOfKind(handPlusTableCards);
            } else if (twoPairs.sprawdzanieTwoPairs(handPlusTableCards) == 3) {
                liczbaPomocnicza = 3;
                twoPairs.getFiveCardsTwoPairs(handPlusTableCards);
            } else if (onePair.sprawdzanieOnePair(handPlusTableCards) == 2) {
                liczbaPomocnicza = 2;
                onePair.getFiveCardsOnePair(handPlusTableCards);
            } else if (hightCard.sprawdzanieHighCard(handPlusTableCards) == 1) {
                liczbaPomocnicza = 1;
                hightCard.getFiveCardsHighCard(handPlusTableCards);
            }
            if (liczba < liczbaPomocnicza) {

                liczba = liczbaPomocnicza;

                gracz = "Player " + (i + 1);

                listaPomocnicza.removeAll(listaPomocnicza);

                if (liczbaPomocnicza == 10) {
                    listaPomocnicza.addAll(royalFlush.getTempListOfRoyalFlush());
                } else if (liczbaPomocnicza == 9) {
                    listaPomocnicza.addAll(straightFlush.getTempListOfStraightFlush());
                } else if (liczbaPomocnicza == 8) {
                    listaPomocnicza.addAll(fourOfKind.getTempListOfFourOfKind());
                } else if (liczbaPomocnicza == 7) {
                    listaPomocnicza.addAll(fullHouse.getTempListOfFullHouse());
                } else if (liczbaPomocnicza == 6) {
                    listaPomocnicza.addAll(flush.getTempListOfFlush());
                } else if (liczbaPomocnicza == 5) {
                    listaPomocnicza.addAll(streigh.getTempListOfStreigh());
                } else if (liczbaPomocnicza == 4) {
                    listaPomocnicza.addAll(threeOfAKind.getTempListOfThreeOfKind());
                } else if (liczbaPomocnicza == 3) {
                    listaPomocnicza.addAll(twoPairs.getTempListOfTwoPairs());
                } else if (liczbaPomocnicza == 2) {
                    listaPomocnicza.addAll(onePair.getTempListOfOnePair());
                } else if (liczbaPomocnicza == 1) {
                    listaPomocnicza.addAll(hightCard.getTempListOfHighCard());
                }
            } else if (liczba == liczbaPomocnicza) {

                gracz1 = "Player " + (i + 1);

                if (liczbaPomocnicza == 10) {
                    if (compareCards(royalFlush.getTempListOfRoyalFlush(), listaPomocnicza) == 2) {

                        listaGraczyRoyalFlush.removeAll(listaGraczyRoyalFlush);
                        listalistKartyRoyalFlush.removeAll(listalistKartyRoyalFlush);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(royalFlush.getTempListOfRoyalFlush());
                    } else if (compareCards(royalFlush.getTempListOfRoyalFlush(), listaPomocnicza) == 0) {

                        listaGraczyRoyalFlush.add(gracz1);
                        listalistKartyRoyalFlush.add(royalFlush.getTempListOfRoyalFlush());
                    }
                } else if (liczbaPomocnicza == 9) {
                    if (compareCards(straightFlush.getTempListOfStraightFlush(), listaPomocnicza) == 2) {

                        listaGraczyStraightFlush.removeAll(listaGraczyStraightFlush);
                        listalistKartyStraightFlush.removeAll(listalistKartyStraightFlush);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(straightFlush.getTempListOfStraightFlush());

                    } else if (compareCards(straightFlush.getTempListOfStraightFlush(), listaPomocnicza) == 0) {

                        listaGraczyStraightFlush.add(gracz1);
                        listalistKartyStraightFlush.add(straightFlush.getTempListOfStraightFlush());
                    }
                } else if (liczbaPomocnicza == 8) {
                    if (compareCards(fourOfKind.getTempListOfFourOfKind(), listaPomocnicza) == 2) {

                        listaGraczyFourOfKind.removeAll(listaGraczyFourOfKind);
                        listalistKartyFourOfKind.removeAll(listalistKartyFourOfKind);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(fourOfKind.getTempListOfFourOfKind());

                    } else if (compareCards(fourOfKind.getTempListOfFourOfKind(), listaPomocnicza) == 0){

                        listaGraczyFourOfKind.add(gracz1);
                        listalistKartyFourOfKind.add(fourOfKind.getTempListOfFourOfKind());
                    }
                } else if (liczbaPomocnicza == 7) {
                    if (compareCards(fullHouse.getTempListOfFullHouse(), listaPomocnicza) == 2) {

                        listaGraczyFullHouse.removeAll(listaGraczyFullHouse);
                        listalistKartyFullHouse.removeAll(listalistKartyFullHouse);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(fullHouse.getTempListOfFullHouse());

                    } else if(compareCards(fullHouse.getTempListOfFullHouse(), listaPomocnicza) == 0){

                        listaGraczyFullHouse.add(gracz1);
                        listalistKartyFullHouse.add(fullHouse.getTempListOfFullHouse());
                    }
                } else if (liczbaPomocnicza == 6) {
                    if (compareCards(flush.getTempListOfFlush(), listaPomocnicza) == 2) {

                        listaGraczyFlush.removeAll(listaGraczyFlush);
                        listalistKartyFlush.removeAll(listalistKartyFlush);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(flush.getTempListOfFlush());

                    } else if (compareCards(flush.getTempListOfFlush(), listaPomocnicza) == 0){

                        listaGraczyFlush.add(gracz1);
                        listalistKartyFlush.add(flush.getTempListOfFlush());
                    }
                } else if (liczbaPomocnicza == 5) {

                    if (compareCards(streigh.getTempListOfStreigh(), listaPomocnicza) == 2) {

                        listaGraczyStraigh.removeAll(listaGraczyStraigh);
                        listalistKartyStraigh.removeAll(listalistKartyStraigh);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(streigh.getTempListOfStreigh());

                    } else if (compareCards(streigh.getTempListOfStreigh(), listaPomocnicza) == 0) {

                        listaGraczyStraigh.add(gracz1);
                        listalistKartyStraigh.add(streigh.getTempListOfStreigh());
                    }
                } else if (liczbaPomocnicza == 4) {
                    if(compareCards(threeOfAKind.getTempListOfThreeOfKind(),listaPomocnicza) == 2){

                        listaGraczyThreeOfKind.removeAll(listaGraczyThreeOfKind);
                        listalistKartyThreeOfKind.removeAll(listalistKartyThreeOfKind);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(threeOfAKind.getTempListOfThreeOfKind());
                    } else if(compareCards(threeOfAKind.getTempListOfThreeOfKind(),listaPomocnicza) == 0){

                        listaGraczyThreeOfKind.add(gracz1);
                        listalistKartyThreeOfKind.add(threeOfAKind.getTempListOfThreeOfKind());
                    }
                } else if (liczbaPomocnicza == 3) {
                    if(compareCards(twoPairs.getTempListOfTwoPairs(),listaPomocnicza) == 2){

                        listaGraczyTwoPairs.removeAll(listaGraczyTwoPairs);
                        listalistKartyTwoPairs.removeAll(listalistKartyTwoPairs);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(twoPairs.getTempListOfTwoPairs());
                    } else if (compareCards(twoPairs.getTempListOfTwoPairs(),listaPomocnicza) == 0){

                        listaGraczyTwoPairs.add(gracz1);
                        listalistKartyTwoPairs.add(twoPairs.getTempListOfTwoPairs());
                    }
                } else if (liczbaPomocnicza == 2) {
                    if(compareCards(onePair.getTempListOfOnePair(),listaPomocnicza) == 2){

                        listaGraczyOnePair.removeAll(listaGraczyOnePair);
                        listalistKartyOnePair.removeAll(listalistKartyOnePair);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(onePair.getTempListOfOnePair());
                    } else if (compareCards(onePair.getTempListOfOnePair(),listaPomocnicza) == 0){

                        listaGraczyOnePair.add(gracz1);
                        listalistKartyOnePair.add(onePair.getTempListOfOnePair());
                    }
                } else if (liczbaPomocnicza == 1) {
                    if(compareCards(hightCard.getTempListOfHighCard(),listaPomocnicza) == 2){

                        listaGraczyHighCards.removeAll(listaGraczyHighCards);
                        listalistKartyHighCards.removeAll(listalistKartyHighCards);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(hightCard.getTempListOfHighCard());
                    }else if (compareCards(hightCard.getTempListOfHighCard(),listaPomocnicza) == 0){

                        listaGraczyHighCards.add(gracz1);
                        listalistKartyHighCards.add(hightCard.getTempListOfHighCard());
                    }
                }
            }
        }

        System.out.println("Wygrał " + gracz + " z kartami:" + listaPomocnicza);
    }

    public List<Karta> kartyRekaPlusStol(List<List<Karta>> listaGraczy, List<Karta> listaKartyFlop, List<Karta> listaKartyTurnOrRiver) {

        List<Karta> gracz = listaGraczy.get(0);

        handPlusTableCards = new ArrayList<Karta>();

        for (int i = 0; i < gracz.size(); i++) {
            handPlusTableCards.add(gracz.get(i));
        }

        listaGraczy.remove(0);

        handPlusTableCards.addAll(listaKartyFlop);
        handPlusTableCards.addAll(listaKartyTurnOrRiver);

        Collections.sort(handPlusTableCards);

        return handPlusTableCards;
    }

    public int compareCards(List<Karta> aktualnyUkladKart, List<Karta> pomocniczyUkladKart) {

        for (int i = 0; i < aktualnyUkladKart.size(); i++) {
            if (aktualnyUkladKart.get(i).getFigura() > pomocniczyUkladKart.get(i).getFigura()) {
                return 2;
            } else if (pomocniczyUkladKart.get(i).getFigura() > aktualnyUkladKart.get(i).getFigura()) {
                return 1;
            }
        }
        return 0;
    }

}
