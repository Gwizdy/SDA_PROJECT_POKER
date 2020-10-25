package com.sprawdzanie;

import com.taliakart.GUITalia;
import com.taliakart.Karta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprawdzenie {

    private GUITalia guiTalia;
    private RoyalFlush royalFlush = new RoyalFlush();
    private FourOfKind fourOfKind = new FourOfKind();
    private FullHouse fullHouse = new FullHouse();

    private List<Karta> handPlusTableCards;

    public Sprawdzenie(GUITalia guiTalia) {
        this.guiTalia = guiTalia;

        for (int i = 0; i < guiTalia.getIloscGraczy(); i++) {

            kartyRekaPlusStol(guiTalia.getListPlayerCards(), guiTalia.getListaFlop(), guiTalia.getListaTurnOrRiver());

            royalFlush.sprawdzanieRoyalFlush(handPlusTableCards);

            fourOfKind.sprawdzanieFourOfKind(handPlusTableCards);

            fullHouse.sprawdzanieFullHouse(handPlusTableCards);
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
