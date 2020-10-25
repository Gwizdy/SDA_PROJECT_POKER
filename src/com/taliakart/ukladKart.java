package com.taliakart;

import java.util.*;

public class ukladKart {

    private List<Karta> rekaPlusStol;
    private List<Karta> rekaPlusStol2;

//    taliedotestowania
    private List<Karta> listOfHighestFive;
    private List<Karta> tempStraightList;
    private List<Karta> TESTOWATALIA;

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
        tempStraightList = new ArrayList<Karta>();
        TESTOWATALIA = new ArrayList<Karta>();
        TESTOWATALIA.add(new Karta(Kolor.KIER, Figura.OSEMKA));
        TESTOWATALIA.add(new Karta(Kolor.PIK, Figura.TROJKA));
        TESTOWATALIA.add(new Karta(Kolor.PIK, Figura.SZOSTKA));
        TESTOWATALIA.add(new Karta(Kolor.KARO, Figura.AS));
        TESTOWATALIA.add(new Karta(Kolor.PIK, Figura.CZWORKA));
        TESTOWATALIA.add(new Karta(Kolor.PIK, Figura.TROJKA));
        TESTOWATALIA.add(new Karta(Kolor.TREFL, Figura.SZOSTKA));
        TESTOWATALIA.add(new Karta(Kolor.TREFL, Figura.DWOJKA));


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

        if(checkIfDoublePair(TESTOWATALIA))
            System.out.println("PODWOJNA PARA");

        System.out.println("PIK " + listPIK.size() + "TREFL " + listTREFL.size() + "KARO " + listKARO.size() + "KIER " + listKIER.size());

    }

    public void checkIfStraightFlush(List<Karta> listaKartGraczaDoSprawdzenia){

        for (Karta k : listaKartGraczaDoSprawdzenia) {
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
        if(checkIfStraight(listPIK)){
            System.out.println("PIK POKER" + listPIK);
        }
        if(checkIfStraight(listTREFL)){
            System.out.println("TREFL POKER" + listTREFL);
        }
        if(checkIfStraight(listKARO)){
            System.out.println("KARO POKER" + listKARO);
        }
        if(checkIfStraight(listKIER)){
            System.out.println("KIER POKER" + listKIER);
        }
    }

    public boolean checkIfStraight(List<Karta> listaUnikalnychFigur){
                
        Collections.sort(listaUnikalnychFigur);


        if(listaUnikalnychFigur.size() >= 5) {
            for (int i = listaUnikalnychFigur.size() - 1; i >= 4; i--) {
                if (listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 1).getFigura() + 1
                        && listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 2).getFigura() + 2
                        && listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 3).getFigura() + 3
                        && listaUnikalnychFigur.get(i).getFigura() == listaUnikalnychFigur.get(i - 4).getFigura() + 4) {
                    return true;

                }
            }
            if(Arrays.asList(listaUnikalnychFigur.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(listaUnikalnychFigur.get(listaUnikalnychFigur.size()-1).getFigura()).contains(Figura.AS.getFigura())){
                return true;
            }
        }

        return false;
    }

    public void removeDuplicateFigures(List<Karta> listaKartGraczaDosprawdzenia, List<Karta> tempStraightList){

        Collections.sort(listaKartGraczaDosprawdzenia);

        tempStraightList.add(listaKartGraczaDosprawdzenia.get(0));

        for (int i = 0; i < listaKartGraczaDosprawdzenia.size()-1; i++){
            if(listaKartGraczaDosprawdzenia.get(i).getFigura() != listaKartGraczaDosprawdzenia.get(i+1).getFigura())
                tempStraightList.add(listaKartGraczaDosprawdzenia.get(i+1));
        }

    }

    public boolean checkIfThreeOfKind(List<Karta> listaKartGraczaDoSprawdzenia){
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size()-1 ; i>=2 ; i--){
            if(listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-1).getFigura() &&
            listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-2).getFigura()){
                return true;
            }
        }
        return false;
    }

    public boolean checkIfDoublePair(List<Karta> listaKartGraczaDoSprawdzenia){
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size()-1 ; i>=3 ; i--){
            if(listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-1).getFigura()){
                for (int j = i ;j>=1; j--){
                    if(listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j-1).getFigura()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkIfPair(List<Karta> listaKartGraczaDoSprawdzenia){
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size()-1 ; i>=1 ; i--){
            if(listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-1).getFigura()){
                return true;
            }
        }
        return false;
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
        if(listPIK.size() >=5 && sprawdzOdDziesiatkiDoAsa(listPIK, listOfHighestFive)){
            System.out.println("PIK KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if(listTREFL.size() >=5 && sprawdzOdDziesiatkiDoAsa(listTREFL,listOfHighestFive)){
            System.out.println("TREFL KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if(listKARO.size() >=5 && sprawdzOdDziesiatkiDoAsa(listKARO,listOfHighestFive)){
            System.out.println("KARO KROLEWSKI");
        }

        listOfHighestFive = new ArrayList<Karta>();
        if(listKIER.size() >=5 && sprawdzOdDziesiatkiDoAsa(listKIER,listOfHighestFive)){
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

