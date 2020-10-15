package com.taliakart;

import java.util.ArrayList;
import java.util.List;

public class Talia {

    private List<Karta> talia;

    public Talia() {
    }

    public void stworzTalie() {
        talia = new ArrayList<Karta>();
        for (Kolor k : Kolor.values())
            for (Figura f : Figura.values())
                talia.add(new Karta(k, f));
    }

    public void wyswietlTalie() {
        stworzTalie();
        for (Karta k : talia)
            System.out.println(k);

    }
}