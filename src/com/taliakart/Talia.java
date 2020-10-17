package com.taliakart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Talia {

    private List<Karta> talia = new ArrayList<Karta>();
    private Random losujKarte;


    public Talia() {

        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                talia.add(new Karta(k, f));
            }
        }

        losujKarte = new Random();
    }

//    public void stworzTalie() {
//        talia = new ArrayList<Karta>();
//        for (Kolor k : Kolor.values())
//            for (Figura f : Figura.values())
//                talia.add(new Karta(k, f));
//    }

//    public void pokazLosowaKarte() {
//        if(talia.size() > 1){
//            Karta pobierzKarte = talia.get(losujKarte.nextInt(talia.size()));
//            System.out.println(pobierzKarte);
//        }
//    }
//
//    public void iteracjaTalii(){
//        System.out.println("Iteracja talii");
//        for (Karta k : talia){
//            System.out.println(k);
//        }
//    }

    public List<Karta> getTalia() {
        return talia;
    }


}