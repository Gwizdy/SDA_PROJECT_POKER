package com.taliakart;

import java.util.ArrayList;
import java.util.List;

public class Talia {

    private List<Karta> talia = new ArrayList<Karta>();

    public Talia() {

        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                talia.add(new Karta(k, f));
            }
        }
        getTalia();
    }

//    public void stworzTalie() {
//        talia = new ArrayList<Karta>();
//        for (Kolor k : Kolor.values())
//            for (Figura f : Figura.values())
//                talia.add(new Karta(k, f));
//    }

    public List<Karta> getTalia(){
        return talia;
    }
//    public void wyswietlTalie() {
//        stworzTalie();
//        for (Karta k : talia)
//            System.out.println(k);
//
//    }

}