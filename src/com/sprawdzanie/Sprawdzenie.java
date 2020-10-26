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

    public Sprawdzenie(GUITalia guiTalia) {
        this.guiTalia = guiTalia;

        for (int i = 0; i < guiTalia.getIloscGraczy(); i++) {
            System.out.println("Player " + (i + 1));

            kartyRekaPlusStol(guiTalia.getListPlayerCards(), guiTalia.getListaFlop(), guiTalia.getListaTurnOrRiver());

            royalFlush.sprawdzanieRoyalFlush(handPlusTableCards);

            straightFlush.sprawdzanieIfStraightFlush(handPlusTableCards);

            fourOfKind.sprawdzanieFourOfKind(handPlusTableCards);

            fullHouse.sprawdzanieFullHouse(handPlusTableCards);

            flush.sprawdzanieFlush(handPlusTableCards);

            streigh.sprawdzanieIfStreigh(handPlusTableCards);

            threeOfAKind.sprawdzanieThreeOfAKind(handPlusTableCards);

            twoPairs.sprawdzanieTwoPairs(handPlusTableCards);

            onePair.sprawdzanieOnePair(handPlusTableCards);

            hightCard.sprawdzanieHighCard(handPlusTableCards);
        }
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


}
