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

    private int liczba;
    private int liczbaPomocnicza;
    private String gracz;

    public Sprawdzenie(GUITalia guiTalia) {
        this.guiTalia = guiTalia;

        liczba = 0;

        listaPomocnicza = new ArrayList<Karta>();

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
                if (liczbaPomocnicza == 9) {
                    ifCardsEquals(straightFlush,listaPomocnicza);
                    //tutaj porównanie dwóch Pokerów i zwrócenie większego do listy pomocniczej
                } else if (liczbaPomocnicza == 8) {
                    //tutaj porównanie dwóch karet i zwrócenie większej do listy pomocniczej
                } else if (liczbaPomocnicza == 7) {
                    //tutaj porównanie dwóch Full i zwrócenie większego do listy pomocniczej
                } else if (liczbaPomocnicza == 6) {
                    // tutaj porównanie dwóch kolorów i zwrócenie większego do listy pomocniczej
                } else if (liczbaPomocnicza == 5) {
                    // tutaj porównanie dwóch stritów i zwrócenie większego do listy pomocniczej
                } else if (liczbaPomocnicza == 4) {
                    // tutaj porównanie dwóch trójek i zwrócenie do listy pomocniczej całej piątki kart
                } else if (liczbaPomocnicza == 3) {
                    // tutaj porównanie dwóch par i zwrócenie wygrywającej do listy pomocniczej
                } else if (liczbaPomocnicza == 2) {
                    // tutaj porównanie pojedynczych par i zwrócenie wygrywającej do listy pomocniczej
                } else if (liczbaPomocnicza == 1) {
                    // tutaj porównanie najwyższych kart i zwrócenie ich do listy pomocniczej
                }
            }
        }

        System.out.println("Wygrał " + gracz + " z kartami:" + listaPomocnicza);
    }

    public List<Karta> kartyRekaPlusStol
            (List<List<Karta>> listaGraczy, List<Karta> listaKartyFlop, List<Karta> listaKartyTurnOrRiver) {

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

    public List<Karta> ifCardsEquals(List<Karta> aktualnyUkladKart,List<Karta> pomocniczyUkladKart) {

        for(int i = 0 ; i<aktualnyUkladKart.size(); i++){
            if(aktualnyUkladKart.get(i).getFigura() > pomocniczyUkladKart.get(i).getFigura()){
                return aktualnyUkladKart;
            }else if (pomocniczyUkladKart.get(i).getFigura() > aktualnyUkladKart.get(i).getFigura()){
                return pomocniczyUkladKart;
            }
        }
        return aktualnyUkladKart;
    }


}
