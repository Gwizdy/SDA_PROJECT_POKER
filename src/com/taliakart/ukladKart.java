package com.taliakart;

import java.util.*;

public class ukladKart {

    private List<Karta> rekaPlusStol;
    private List<Karta> taliaDoTestu;
    private Talia taliaDoPrzypisaniaTestu;
    Random rand;

//    Do Testu
//    int liczPik;
//    int liczTrefl;
//    int liczKaro;
//    int liczKier;

    private List<Karta> listPIK;
    private List<Karta> listTREFL;
    private List<Karta> listKARO;
    private List<Karta> listKIER;


    public ukladKart() {
        rekaPlusStol = new ArrayList<Karta>();
        taliaDoPrzypisaniaTestu = new Talia();
        rand = new Random();

        listPIK = new ArrayList<Karta>();
        listTREFL = new ArrayList<Karta>();
        listKARO = new ArrayList<Karta>();
        listKIER = new ArrayList<Karta>();

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


        for (Karta k : rekaPlusStol) {
            System.out.println(k.getKolor());
//            if (k.getKolor().equals(Kolor.KARO)) {
//                liczKaro++;
//            }
        }
        sprawdzUkladPokerKrolewski(taliaDoTestu);
        System.out.println("PIK " + listPIK.size() + "TREFL " + listTREFL.size() + "KARO " + listKARO.size() + "KIER " + listKIER.size());
        System.out.println(rekaPlusStol.get(0).getFigura() + " " + Figura.valueOf("TROJKA")); // to sie nie rowna, trzeba zrobic tak
                                                                                                // by z Karty.getFigura przyrownalo do danej figury

    }

    public void sprawdzUkladPokerKrolewski(List<Karta> listaKartDoSprawdzenia){
        Karta kTest = null;
        for (Karta k : listaKartDoSprawdzenia) {
            if(k.getKolor().equals(Kolor.PIK)){
                listPIK.add(k);
            }else if(k.getKolor().equals(Kolor.TREFL)){
                listTREFL.add(k);
            }else if(k.getKolor().equals(Kolor.KARO)){
                listKARO.add(k);
            }else if(k.getKolor().equals(Kolor.KIER)){
                listKIER.add(k);
            }
        }


    }

//    public void sprawdzUkladKolorTest(List<Karta> rekaPlusStol){
//    for (Karta k : rekaPlusStol) {
//        if(k.getKolor().equals(Kolor.PIK)){
//            liczPik++;
//        }else if(k.getKolor().equals(Kolor.TREFL)){
//            liczTrefl++;
//        }else if(k.getKolor().equals(Kolor.KARO)){
//            liczKaro++;
//        }else if(k.getKolor().equals(Kolor.KIER)){
//            liczKier++;
//        }
//    }


}

