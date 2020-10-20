package com.taliakart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ukladKart {

    private List<Karta> rekaPlusStol;
    private List<Karta> taliaDoTestu;
    private Talia taliaDoPrzypisaniaTestu;
    Random rand;

    public ukladKart() {
        rekaPlusStol = new ArrayList<Karta>();
        taliaDoPrzypisaniaTestu = new Talia();
        rand = new Random();

        taliaDoTestu = taliaDoPrzypisaniaTestu.getTalia();

        //symulacja losowania kart z reki + stolu
        for (int i = 0; i<7;i++){
            int r = rand.nextInt(taliaDoTestu.size());
            rekaPlusStol.add(taliaDoTestu.get(r));
            taliaDoTestu.remove(taliaDoTestu.get(r));
        }

        System.out.println("wylosowana reka" + rekaPlusStol);
        System.out.println("pozostala talia" + taliaDoTestu);

        Collections.shuffle(taliaDoTestu);
        System.out.println("potasowana pozostala talia" + taliaDoTestu);
        Collections.sort(taliaDoTestu);
        System.out.println("poukladana po tasowaniu talia" + taliaDoTestu);

        Collections.sort(rekaPlusStol);
        System.out.println("potasowana reka " + rekaPlusStol);

    }


}
