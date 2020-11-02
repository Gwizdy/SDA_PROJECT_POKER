package com.rozgrywka;

import com.sprawdzanie.Sprawdzenie;
import com.taliakart.GUITalia;
import com.taliakart.Karta;
import com.taliakart.Talia;

import java.util.List;

public class Rozgrywka {

    private GUITalia guiTalia;
    private Talia taliaGUI;

    private Sprawdzenie sprawdzenie;

    public Rozgrywka(GUITalia guiTalia) {
        this.guiTalia = guiTalia;

        // small blind - drugi gracz

        // big blind - trzeci gracz


        guiTalia.losowanieKart(guiTalia.getIloscGraczy());

        // pierwsza licytacja, zaczyna gracz po big blind

        guiTalia.rozdajFlop(guiTalia.getTalia()); // +3 karty

        // druga licytacja, zaczyna gracz siedzący na lewo od rozdającego

        guiTalia.rozdajTurnOrRiver(guiTalia.getTalia()); // +1 karta

        // trzecia runda licytacji, zaczyna gracz siedzący na lewo od rozdającego

        guiTalia.rozdajTurnOrRiver(guiTalia.getTalia());

        // czwarta runda licytacji i sprawdzenie

        //new Sprawdzenie(me);

    }
}
