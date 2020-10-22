package com.taliakart;

import java.util.*;

public class ukladKart {

    private List<Karta> rekaPlusStol;
    private List<Karta> rekaPlusStol2;

    private List<Karta> listOfHighestFive;

    private List<List<Karta>> listaRakPlusStol; //deklaracja listy listy

    private List<Karta> taliaDoTestu;
    private Talia taliaDoPrzypisaniaTestu;
    Random rand;


    private List<Karta> listPIK;
    private List<Karta> listTREFL;
    private List<Karta> listKARO;
    private List<Karta> listKIER;


    public ukladKart() {
        rekaPlusStol = new ArrayList<Karta>();
        rekaPlusStol2 = new ArrayList<Karta>();
        taliaDoPrzypisaniaTestu = new Talia();
        rand = new Random();

        listOfHighestFive = new ArrayList<Karta>();

        listaRakPlusStol = new ArrayList<List<Karta>>(); // inicjacja listy list


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

        /*LISTA W LISCIE

        for (int i = 0; i<7;i++){
            int r = rand.nextInt(taliaDoTestu.size());
            rekaPlusStol2.add(taliaDoTestu.get(r));
            taliaDoTestu.remove(taliaDoTestu.get(r));
        }

        listaRakPlusStol.add(rekaPlusStol);
        listaRakPlusStol.add(rekaPlusStol2);

        System.out.println("LISTA RAK PLUS STOL" + listaRakPlusStol.get(0).get(0) + " " + listaRakPlusStol.get(1));

         */

//        System.out.println("wylosowana reka" + rekaPlusStol);
//        System.out.println("wylosowana reka2" + rekaPlusStol2);
//        System.out.println("pozostala talia" + taliaDoTestu);

//        Collections.shuffle(taliaDoTestu);
//        System.out.println("potasowana pozostala talia" + taliaDoTestu);
        Collections.sort(taliaDoTestu);
        System.out.println("poukladana po tasowaniu talia" + taliaDoTestu);

        Collections.sort(rekaPlusStol);
        System.out.println("potasowana reka " + rekaPlusStol);

        sprawdzUkladPokerKrolewski(taliaDoTestu); // tutaj wpisalem pozostala talie kart,by sprawdzic czy dziala
                                                    // (wieksza talia wieksza prawdopodobnienstwo)

        System.out.println("PIK " + listPIK.size() + "TREFL " + listTREFL.size() + "KARO " + listKARO.size() + "KIER " + listKIER.size());

    }

    public void sprawdzUkladPokerKrolewski(List<Karta> listaKartDoSprawdzenia){
        listOfHighestFive = new ArrayList<Karta>();
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
        if(sprawdzOdDziesiatkiDoAsa(listPIK, listOfHighestFive)){
            System.out.println("PIK KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if(sprawdzOdDziesiatkiDoAsa(listTREFL,listOfHighestFive)){
            System.out.println("TREFL KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if(sprawdzOdDziesiatkiDoAsa(listKARO,listOfHighestFive)){
            System.out.println("KARO KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if(sprawdzOdDziesiatkiDoAsa(listKIER,listOfHighestFive)){
            System.out.println("KIER KROLEWSKI");
        }

    }

    public boolean sprawdzOdDziesiatkiDoAsa(List<Karta> fromList, List<Karta> listOfFive){
        getFiveHighestCards(fromList, listOfFive);
        Collections.sort(listOfFive);
        if (Arrays.asList(listOfFive.get(0).getFigura()).contains(Figura.DZIESIATKA.getFigura()) &&
                Arrays.asList(listOfFive.get(1).getFigura()).contains(Figura.WALET.getFigura()) &&
                Arrays.asList(listOfFive.get(2).getFigura()).contains(Figura.DAMA.getFigura()) &&
                Arrays.asList(listOfFive.get(3).getFigura()).contains(Figura.KROL.getFigura()) &&
                Arrays.asList(listOfFive.get(4).getFigura()).contains(Figura.AS.getFigura())){
            return true;
        }
        return false;
    }

    public void getFiveHighestCards (List<Karta> fromList, List<Karta> listOfFive){

        for (int i = fromList.size()-1; i>=fromList.size()-5; i--){
            listOfFive.add(fromList.get(i));
        }
    }

}

