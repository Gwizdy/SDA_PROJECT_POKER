package com.taliakart;

public class Talia {

    private Karta[] talia;

    {
        talia = new Karta[52];
    }

    public Talia() {
        int i = 0;

        for (Kolor k : Kolor.values())
            for (Figura f : Figura.values())
                talia[i++] = new Karta(k, f);
    }

    public void wyswietlTalie() {

        for (Karta k : talia)
            System.out.println(k);

    }
}