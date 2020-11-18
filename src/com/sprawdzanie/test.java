package com.sprawdzanie;


import com.okna.OknoStol;
import com.rozgrywka.Gracz;
import com.taliakart.Figura;
import com.taliakart.Karta;
import com.taliakart.Kolor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {

    private OknoStol oknoStol;
    private test me;

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

    private List<Integer> listaGraczyRoyalFlush;
    private List<Integer> listaGraczyStraightFlush;
    private List<Integer> listaGraczyFourOfKind;
    private List<Integer> listaGraczyFullHouse;
    private List<Integer> listaGraczyFlush;
    private List<Integer> listaGraczyStraigh;
    private List<Integer> listaGraczyThreeOfKind;
    private List<Integer> listaGraczyTwoPairs;
    private List<Integer> listaGraczyOnePair;
    private List<Integer> listaGraczyHighCards;

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

    private List<Gracz> testGracze;

    private int liczba;
    private int liczbaPomocnicza;
    private int numerGraczyDoSprawdzenia;
    private int gracz;
    private int gracz1;

    private List<Karta> TESTOWATALIA;
    private List<Karta> TESTOWATALIA2;
    private List<Karta> TESTOWATALIA3;
    private List<Karta> TESTOWATALIA4;
    private List<Karta> TESTOWATALIA5;
    private List<Karta> TESTOWATALIA6;
    private List<Karta> TESTOWATALIA7;
    private List<Karta> TESTOWATALIA8;

    private List<Gracz> listaZetonowGraczy = new ArrayList<Gracz>();
    private List<Gracz> listaRekaGraczy = new ArrayList<Gracz>();
    private Gracz gracz0 = new Gracz();
    private Gracz gracz2 = new Gracz();
    private Gracz gracz3 = new Gracz();
    private Gracz gracz4 = new Gracz();
    private Gracz gracz5 = new Gracz();
    private Gracz gracz6 = new Gracz();
    private Gracz gracz7 = new Gracz();
    private Gracz gracz8 = new Gracz();

    private List<Karta> listaFlop;
    private List<Karta> listaTurnOrRiver;

    public test() {
        this.oknoStol = oknoStol;
        me = this;

        TESTOWATALIA = new ArrayList<Karta>();
        TESTOWATALIA2 = new ArrayList<Karta>();
        TESTOWATALIA3 = new ArrayList<Karta>();
        TESTOWATALIA4 = new ArrayList<Karta>();
        TESTOWATALIA5 = new ArrayList<Karta>();
        TESTOWATALIA6 = new ArrayList<Karta>();
        TESTOWATALIA7 = new ArrayList<Karta>();
        TESTOWATALIA8 = new ArrayList<Karta>();
        TESTOWATALIA.add(new Karta(Kolor.KIER, Figura.DAMA));
        TESTOWATALIA.add(new Karta(Kolor.KIER, Figura.DWOJKA));
        TESTOWATALIA2.add(new Karta(Kolor.KARO, Figura.DAMA));
        TESTOWATALIA2.add(new Karta(Kolor.KARO, Figura.OSEMKA));
        TESTOWATALIA3.add(new Karta(Kolor.PIK, Figura.DAMA));
        TESTOWATALIA3.add(new Karta(Kolor.KIER, Figura.PIATKA));
        TESTOWATALIA4.add(new Karta(Kolor.PIK, Figura.CZWORKA));
        TESTOWATALIA4.add(new Karta(Kolor.TREFL, Figura.TROJKA));
        TESTOWATALIA5.add(new Karta(Kolor.PIK, Figura.DZIESIATKA));
        TESTOWATALIA5.add(new Karta(Kolor.TREFL, Figura.OSEMKA));
        TESTOWATALIA6.add(new Karta(Kolor.PIK, Figura.DWOJKA));
        TESTOWATALIA6.add(new Karta(Kolor.KARO, Figura.TROJKA));
        TESTOWATALIA7.add(new Karta(Kolor.KIER, Figura.CZWORKA));
        TESTOWATALIA7.add(new Karta(Kolor.PIK, Figura.OSEMKA));
        TESTOWATALIA8.add(new Karta(Kolor.KARO, Figura.CZWORKA));
        TESTOWATALIA8.add(new Karta(Kolor.KIER, Figura.WALET));

        gracz0.setKartyReka(TESTOWATALIA);
        gracz2.setKartyReka(TESTOWATALIA2);
        gracz3.setKartyReka(TESTOWATALIA3);
        gracz4.setKartyReka(TESTOWATALIA4);
        gracz5.setKartyReka(TESTOWATALIA5);
        gracz6.setKartyReka(TESTOWATALIA6);
        gracz7.setKartyReka(TESTOWATALIA7);
        gracz8.setKartyReka(TESTOWATALIA8);

        listaRekaGraczy.add(gracz0);
        listaRekaGraczy.add(gracz2);
        listaRekaGraczy.add(gracz3);
        listaRekaGraczy.add(gracz4);
        listaRekaGraczy.add(gracz5);
        listaRekaGraczy.add(gracz6);
        listaRekaGraczy.add(gracz7);
        listaRekaGraczy.add(gracz8);

        listaFlop = new ArrayList<Karta>();
        listaTurnOrRiver = new ArrayList<Karta>();

        listaFlop.add(new Karta(Kolor.TREFL, Figura.DAMA));
        listaFlop.add(new Karta(Kolor.PIK, Figura.KROL));
        listaFlop.add(new Karta(Kolor.KIER, Figura.KROL));

        listaTurnOrRiver.add(new Karta(Kolor.KARO, Figura.PIATKA));
        listaTurnOrRiver.add(new Karta(Kolor.TREFL, Figura.WALET));

        listaZetonowGraczy.add(gracz0);
        listaZetonowGraczy.add(gracz2);
        listaZetonowGraczy.add(gracz3);
        listaZetonowGraczy.add(gracz4);
        listaZetonowGraczy.add(gracz5);
        listaZetonowGraczy.add(gracz6);
        listaZetonowGraczy.add(gracz7);
        listaZetonowGraczy.add(gracz8);

        listaZetonowGraczy.get(0).setZetonyStawkaGracza(300);
        listaZetonowGraczy.get(1).setZetonyStawkaGracza(300);
        listaZetonowGraczy.get(2).setZetonyStawkaGracza(300);
        listaZetonowGraczy.get(3).setZetonyStawkaGracza(300);
        listaZetonowGraczy.get(4).setZetonyStawkaGracza(300);
        listaZetonowGraczy.get(5).setZetonyStawkaGracza(300);
        listaZetonowGraczy.get(6).setZetonyStawkaGracza(300);
        listaZetonowGraczy.get(7).setZetonyStawkaGracza(300);

        listaZetonowGraczy.get(0).setZetonyWGrze(2400);

        listaZetonowGraczy.get(0).setZetonyPosiadane(1000);
        listaZetonowGraczy.get(1).setZetonyPosiadane(1000);
        listaZetonowGraczy.get(2).setZetonyPosiadane(1000);
        listaZetonowGraczy.get(3).setZetonyPosiadane(1000);
        listaZetonowGraczy.get(4).setZetonyPosiadane(1000);
        listaZetonowGraczy.get(5).setZetonyPosiadane(1000);
        listaZetonowGraczy.get(6).setZetonyPosiadane(1000);
        listaZetonowGraczy.get(7).setZetonyPosiadane(1000);

        deklaracja();

        sprawdzanieWyniku();

    }

    public void deklaracja() {

        liczba = 0;

        testGracze = new ArrayList<Gracz>(listaRekaGraczy);

        listaPomocnicza = new ArrayList<Karta>();

        listaGraczyRoyalFlush = new ArrayList<Integer>();
        listaGraczyStraightFlush = new ArrayList<Integer>();
        listaGraczyFourOfKind = new ArrayList<Integer>();
        listaGraczyFullHouse = new ArrayList<Integer>();
        listaGraczyFlush = new ArrayList<Integer>();
        listaGraczyStraigh = new ArrayList<Integer>();
        listaGraczyThreeOfKind = new ArrayList<Integer>();
        listaGraczyTwoPairs = new ArrayList<Integer>();
        listaGraczyOnePair = new ArrayList<Integer>();
        listaGraczyHighCards = new ArrayList<Integer>();

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

    }

    public void sprawdzanieWyniku() {

        for (int i = 0; i < 8; i++) {

//            if (oknoStol.getListaFoldow().get(i).isFoldGracza() || oknoStol.getListaFoldow().get(i).isFoldGracza() && (oknoStol.getListaZetonowGraczy().get(i).getZetonyPosiadane() != 0 ||
            //           oknoStol.getListaZetonowGraczy().get(i).getZetonyStawkaGracza() != 0)) {
            numerGraczyDoSprawdzenia = i;

//                kartyRekaPlusStol(oknoStol.getListaRekaGraczy(), oknoStol.getListaFlop(), oknoStol.getListaTurnOrRiver());

            kartyRekaPlusStol(listaRekaGraczy, listaFlop, listaTurnOrRiver);

            if (royalFlush.sprawdzanieRoyalFlush(handPlusTableCards) == 10) {
                liczbaPomocnicza = 10;
                royalFlush.getFiveCardsRoyalFlush(handPlusTableCards);
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

                gracz = i + 1;

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

                gracz1 = i + 1;

                if (liczbaPomocnicza == 10) {
                    if (compareCards(royalFlush.getTempListOfRoyalFlush(), listaPomocnicza) == 2) {

                        listaGraczyRoyalFlush.removeAll(listaGraczyRoyalFlush);
                        listalistKartyRoyalFlush.removeAll(listalistKartyRoyalFlush);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(royalFlush.getTempListOfRoyalFlush());

                        gracz = gracz1;

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

                        gracz = gracz1;

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

                        gracz = gracz1;

                    } else if (compareCards(fourOfKind.getTempListOfFourOfKind(), listaPomocnicza) == 0) {

                        listaGraczyFourOfKind.add(gracz1);
                        listalistKartyFourOfKind.add(fourOfKind.getTempListOfFourOfKind());
                    }
                } else if (liczbaPomocnicza == 7) {
                    if (compareCards(fullHouse.getTempListOfFullHouse(), listaPomocnicza) == 2) {

                        listaGraczyFullHouse.removeAll(listaGraczyFullHouse);
                        listalistKartyFullHouse.removeAll(listalistKartyFullHouse);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(fullHouse.getTempListOfFullHouse());

                        gracz = gracz1;

                    } else if (compareCards(fullHouse.getTempListOfFullHouse(), listaPomocnicza) == 0) {

                        listaGraczyFullHouse.add(gracz1);
                        listalistKartyFullHouse.add(fullHouse.getTempListOfFullHouse());
                    }
                } else if (liczbaPomocnicza == 6) {
                    if (compareCards(flush.getTempListOfFlush(), listaPomocnicza) == 2) {

                        listaGraczyFlush.removeAll(listaGraczyFlush);
                        listalistKartyFlush.removeAll(listalistKartyFlush);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(flush.getTempListOfFlush());

                        gracz = gracz1;

                    } else if (compareCards(flush.getTempListOfFlush(), listaPomocnicza) == 0) {

                        listaGraczyFlush.add(gracz1);
                        listalistKartyFlush.add(flush.getTempListOfFlush());
                    }
                } else if (liczbaPomocnicza == 5) {

                    if (compareCards(streigh.getTempListOfStreigh(), listaPomocnicza) == 2) {

                        listaGraczyStraigh.removeAll(listaGraczyStraigh);
                        listalistKartyStraigh.removeAll(listalistKartyStraigh);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(streigh.getTempListOfStreigh());

                        gracz = gracz1;

                    } else if (compareCards(streigh.getTempListOfStreigh(), listaPomocnicza) == 0) {

                        listaGraczyStraigh.add(gracz1);
                        listalistKartyStraigh.add(streigh.getTempListOfStreigh());
                    }
                } else if (liczbaPomocnicza == 4) {
                    if (compareCards(threeOfAKind.getTempListOfThreeOfKind(), listaPomocnicza) == 2) {

                        listaGraczyThreeOfKind.removeAll(listaGraczyThreeOfKind);
                        listalistKartyThreeOfKind.removeAll(listalistKartyThreeOfKind);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(threeOfAKind.getTempListOfThreeOfKind());

                        gracz = gracz1;

                    } else if (compareCards(threeOfAKind.getTempListOfThreeOfKind(), listaPomocnicza) == 0) {

                        listaGraczyThreeOfKind.add(gracz1);
                        listalistKartyThreeOfKind.add(threeOfAKind.getTempListOfThreeOfKind());
                    }
                } else if (liczbaPomocnicza == 3) {
                    if (compareCards(twoPairs.getTempListOfTwoPairs(), listaPomocnicza) == 2) {

                        listaGraczyTwoPairs.removeAll(listaGraczyTwoPairs);
                        listalistKartyTwoPairs.removeAll(listalistKartyTwoPairs);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(twoPairs.getTempListOfTwoPairs());

                        gracz = gracz1;

                    } else if (compareCards(twoPairs.getTempListOfTwoPairs(), listaPomocnicza) == 0) {

                        listaGraczyTwoPairs.add(gracz1);
                        listalistKartyTwoPairs.add(twoPairs.getTempListOfTwoPairs());
                    }
                } else if (liczbaPomocnicza == 2) {
                    if (compareCards(onePair.getTempListOfOnePair(), listaPomocnicza) == 2) {

                        listaGraczyOnePair.removeAll(listaGraczyOnePair);
                        listalistKartyOnePair.removeAll(listalistKartyOnePair);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(onePair.getTempListOfOnePair());

                        gracz = gracz1;

                    } else if (compareCards(onePair.getTempListOfOnePair(), listaPomocnicza) == 0) {

                        listaGraczyOnePair.add(gracz1);
                        listalistKartyOnePair.add(onePair.getTempListOfOnePair());
                    }
                } else if (liczbaPomocnicza == 1) {
                    if (compareCards(hightCard.getTempListOfHighCard(), listaPomocnicza) == 2) {

                        listaGraczyHighCards.removeAll(listaGraczyHighCards);
                        listalistKartyHighCards.removeAll(listalistKartyHighCards);

                        listaPomocnicza.removeAll(listaPomocnicza);
                        listaPomocnicza.addAll(hightCard.getTempListOfHighCard());

                        gracz = gracz1;

                    } else if (compareCards(hightCard.getTempListOfHighCard(), listaPomocnicza) == 0) {

                        listaGraczyHighCards.add(gracz1);
                        listalistKartyHighCards.add(hightCard.getTempListOfHighCard());
                    }
                }
            }
        }
        //  }


//        if (oknoStol.getLicznik() >= oknoStol.getGracze() - 1) {
//
//          //  new OknoZakonczeniaGry(me);
//
//        } else {

        ogloszenieWyniku(liczba);

        //    }

    }

    public List<Karta> kartyRekaPlusStol(List<Gracz> listaGraczy, List<Karta> listaKartyFlop, List<Karta> listaKartyTurnOrRiver) {

        handPlusTableCards = new ArrayList<Karta>();
        //  handPlusTableCards.addAll(testGracze.get(numerGraczyDoSprawdzenia).getKartyReka());
        handPlusTableCards.addAll(listaRekaGraczy.get(numerGraczyDoSprawdzenia).getKartyReka());
        System.out.println(listaRekaGraczy.get(numerGraczyDoSprawdzenia).getKartyReka());

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

    public void ogloszenieWyniku(int liczba) {

        if (liczba == 10) {
            if (listaGraczyRoyalFlush.isEmpty()) {
                System.out.println("Poker Królewski. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Poker Królewski. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyRoyalFlush.size(); i++) {
                    System.out.println(listaGraczyRoyalFlush.get(i) + " z kartami " + listalistKartyRoyalFlush.get(i));
                }
            }
        } else if (liczba == 9) {
            if (listaGraczyStraightFlush.isEmpty()) {
                System.out.println("Poker. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Poker. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyStraightFlush.size(); i++) {
                    System.out.println(listaGraczyStraightFlush.get(i) + " z kartami " + listalistKartyStraightFlush.get(i));
                }
            }
        } else if (liczba == 8) {
            if (listaGraczyFourOfKind.isEmpty()) {
                System.out.println("Kareta. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Kareta. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyFourOfKind.size(); i++) {
                    System.out.println(listaGraczyFourOfKind.get(i) + " z kartami " + listalistKartyFourOfKind.get(i));
                }
            }
        } else if (liczba == 7) {
            if (listaGraczyFullHouse.isEmpty()) {
                System.out.println("Full. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Full. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyFullHouse.size(); i++) {
                    System.out.println(listaGraczyFullHouse.get(i) + " z kartami " + listalistKartyFullHouse.get(i));
                }
            }
        } else if (liczba == 6) {
            if (listaGraczyFlush.isEmpty()) {
                System.out.println("Kolor. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Kolor. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyFlush.size(); i++) {
                    System.out.println(listaGraczyFlush.get(i) + " z kartami " + listalistKartyFlush.get(i));
                }
            }
        } else if (liczba == 5) {
            if (listaGraczyStraigh.isEmpty()) {
                System.out.println("Strit. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Strit. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyStraigh.size(); i++) {
                    System.out.println(listaGraczyStraigh.get(i) + " z kartami " + listalistKartyStraigh.get(i));
                }
            }
        } else if (liczba == 4) {
            if (listaGraczyThreeOfKind.isEmpty()) {
                System.out.println("Trójka. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Trójka. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyThreeOfKind.size(); i++) {
                    System.out.println(listaGraczyThreeOfKind.get(i) + " z kartami " + listalistKartyThreeOfKind.get(i));
                }
            }
        } else if (liczba == 3) {
            if (listaGraczyTwoPairs.isEmpty()) {
                System.out.println("Dwie pary. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Dwie pary. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyTwoPairs.size(); i++) {
                    System.out.println(listaGraczyTwoPairs.get(i) + " z kartami " + listalistKartyTwoPairs.get(i));
                }
            }
        } else if (liczba == 2) {
            if (listaGraczyOnePair.isEmpty()) {
                System.out.println("Jedna para. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Jedna para. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyOnePair.size(); i++) {
                    System.out.println(listaGraczyOnePair.get(i) + " z kartami " + listalistKartyOnePair.get(i));
                }
            }
        } else if (liczba == 1) {
            if (listaGraczyHighCards.isEmpty()) {
                System.out.println("Wysoka karta. Wygrał gracz " + gracz + " z kartami:" + listaPomocnicza);
            } else {
                System.out.println("Wysoka karta. Remis.");
                System.out.println("Gracz " + gracz + " z kartami " + listaPomocnicza);
                for (int i = 0; i < listaGraczyHighCards.size(); i++) {
                    System.out.println(listaGraczyHighCards.get(i) + " z kartami " + listalistKartyHighCards.get(i));
                }
            }
        }

        przypisanieWygranej();
    }

    public void obliczeniaWygranejJedenGracz() {

        int sprawdzenie = listaZetonowGraczy.get(gracz - 1).getZetonyStawkaGracza();

        for (int i = 0; i < 8; i++) {
            if (sprawdzenie >= listaZetonowGraczy.get(i).getZetonyStawkaGracza() && i != (gracz - 1) && listaZetonowGraczy.get(i).isCzyWGrze()) {

                listaZetonowGraczy.get(gracz - 1).setZetonyStawkaGracza(listaZetonowGraczy.get(gracz - 1).getZetonyStawkaGracza() + listaZetonowGraczy.get(i).getZetonyStawkaGracza());
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() - listaZetonowGraczy.get(i).getZetonyStawkaGracza());
                listaZetonowGraczy.get(i).setZetonyStawkaGracza(0);

            } else if (sprawdzenie < listaZetonowGraczy.get(i).getZetonyStawkaGracza() && i != (gracz - 1) && oknoStol.getListaZetonowGraczy().get(i).isCzyWGrze()) {

                listaZetonowGraczy.get(gracz - 1).setZetonyStawkaGracza(listaZetonowGraczy.get(gracz - 1).getZetonyStawkaGracza() + sprawdzenie);
                listaZetonowGraczy.get(i).setZetonyStawkaGracza(listaZetonowGraczy.get(i).getZetonyStawkaGracza() - sprawdzenie);
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() - (listaZetonowGraczy.get(i).getZetonyStawkaGracza() + sprawdzenie));
                listaZetonowGraczy.get(i).setZetonyPosiadane(listaZetonowGraczy.get(i).getZetonyPosiadane() + listaZetonowGraczy.get(i).getZetonyStawkaGracza());
                listaZetonowGraczy.get(i).setZetonyStawkaGracza(0);
            }
        }
        listaZetonowGraczy.get(gracz - 1).setZetonyPosiadane(listaZetonowGraczy.get(gracz - 1).getZetonyPosiadane() + listaZetonowGraczy.get(gracz - 1).getZetonyStawkaGracza());
        listaZetonowGraczy.get(gracz - 1).setZetonyStawkaGracza(0);
        listaZetonowGraczy.get(0).setZetonyWGrze(0);

    }

    public void obliczeniaWygranejWieluGraczy(List listaWygrywajaca) {

        System.out.println("ŻETONY W GRZE");
        System.out.println(listaZetonowGraczy.get(0).getZetonyWGrze());
        System.out.println("==========================================");
        System.out.println("PRZED");
        System.out.println(listaZetonowGraczy.get(0).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(1).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(2).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(3).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(4).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(5).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(6).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(7).getZetonyPosiadane());

        int iloscGraczyWygrywajacych = listaWygrywajaca.size() + 1;

        listaZetonowGraczy.get(gracz - 1).setZetonyPosiadane(listaZetonowGraczy.get(gracz - 1).getZetonyPosiadane() + listaZetonowGraczy.get(gracz - 1).getZetonyStawkaGracza());
        System.out.println("=========GRACZ 0==============");
        System.out.println(listaZetonowGraczy.get(gracz - 1).getZetonyPosiadane());
        listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() - listaZetonowGraczy.get(gracz - 1).getZetonyStawkaGracza());
        System.out.println(listaZetonowGraczy.get(0).getZetonyWGrze());
        listaZetonowGraczy.get(gracz - 1).setZetonyStawkaGracza(0);
        System.out.println(listaZetonowGraczy.get(gracz - 1).getZetonyStawkaGracza());
        System.out.println("==============================");
        System.out.println(listaWygrywajaca.size());
        System.out.println("==============================");

        for (int i = 0; i < listaWygrywajaca.size(); i++) {

            System.out.println("============ GRACZ " + (i + 2) + " ======================");
            listaZetonowGraczy.get(i + 1).setZetonyPosiadane(listaZetonowGraczy.get(i + 1).getZetonyPosiadane() + listaZetonowGraczy.get(i + 1).getZetonyStawkaGracza());
            System.out.println(listaZetonowGraczy.get(i + 1).getZetonyPosiadane());
            listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() - listaZetonowGraczy.get(i + 1).getZetonyStawkaGracza());
            System.out.println(listaZetonowGraczy.get(0).getZetonyWGrze());
            listaZetonowGraczy.get(i + 1).setZetonyStawkaGracza(0);
            System.out.println(listaZetonowGraczy.get(i + 1).getZetonyStawkaGracza());
            System.out.println("=============================");
        }
        System.out.println(listaZetonowGraczy.get(0).getZetonyWGrze());

        if (listaZetonowGraczy.get(0).getZetonyWGrze() > 0) {
            listaZetonowGraczy.get(gracz - 1).setZetonyPosiadane(listaZetonowGraczy.get(gracz - 1).getZetonyPosiadane() + (listaZetonowGraczy.get(0).getZetonyWGrze() / iloscGraczyWygrywajacych));
        } else {
            listaZetonowGraczy.get(gracz - 1).setZetonyPosiadane(listaZetonowGraczy.get(gracz - 1).getZetonyPosiadane());
        }
        for (int i = 0; i < listaWygrywajaca.size(); i++) {
            if (listaZetonowGraczy.get(0).getZetonyWGrze() > 0) {
                listaZetonowGraczy.get(i + 1).setZetonyPosiadane(listaZetonowGraczy.get(i + 1).getZetonyPosiadane() + (listaZetonowGraczy.get(0).getZetonyWGrze() / iloscGraczyWygrywajacych));
            } else {
                listaZetonowGraczy.get(i + 1).setZetonyPosiadane(listaZetonowGraczy.get(i + 1).getZetonyPosiadane());
            }
        }
        System.out.println("==============================================");
        System.out.println("PO");
        System.out.println(listaZetonowGraczy.get(0).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(1).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(2).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(3).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(4).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(5).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(6).getZetonyPosiadane());
        System.out.println(listaZetonowGraczy.get(7).getZetonyPosiadane());

    }

    public void przypisanieWygranej() {

        if (liczba == 10) {
            if (listaGraczyRoyalFlush.isEmpty()) {
                System.out.println("Jeden gracz");
                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");
                obliczeniaWygranejWieluGraczy(listaGraczyRoyalFlush);

            }
        } else if (liczba == 9) {
            if (listaGraczyStraightFlush.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyStraightFlush);
            }
        } else if (liczba == 8) {
            if (listaGraczyFourOfKind.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyFourOfKind);

            }
        } else if (liczba == 7) {
            if (listaGraczyFullHouse.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyFullHouse);

            }
        } else if (liczba == 6) {
            if (listaGraczyFlush.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyFlush);

            }
        } else if (liczba == 5) {
            if (listaGraczyStraigh.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyStraigh);

            }
        } else if (liczba == 4) {
            if (listaGraczyThreeOfKind.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyThreeOfKind);

            }
        } else if (liczba == 3) {
            if (listaGraczyTwoPairs.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyTwoPairs);

            }
        } else if (liczba == 2) {
            if (listaGraczyOnePair.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyOnePair);

            }
        } else if (liczba == 1) {
            if (listaGraczyHighCards.isEmpty()) {
                System.out.println("Jeden gracz");

                obliczeniaWygranejJedenGracz();

            } else {
                System.out.println("Wielu garczy");

                obliczeniaWygranejWieluGraczy(listaGraczyHighCards);

            }
        }
    }

    public int getGracz() {
        return gracz;
    }

    public void setGracz(int gracz) {
        this.gracz = gracz;
    }
}
