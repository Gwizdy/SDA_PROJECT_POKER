package com.taliakart;

import java.util.*;

public class ukladKart {

    private List<Karta> rekaPlusStol;
    private List<Karta> rekaPlusStol2;

//    taliedotestowania
    private List<Karta> listOfHighestFive;
    private List<Karta> tempStraightList;
    private List<Karta> tempListOfFlush;
    private List<Karta> tempListOfOnePair;
    private List<Karta> tempListOfThreeOfKind;
    private List<Karta> tempListOfFourOfKind;
    private List<Karta> tempListOfFullHouse;
    private List<Karta> tempListOfStraightFlush;
    private List<Karta> tempListOfRoyalFlush;
    private List<Karta> tempListOfStreigh;
    private List<Karta> tempStreighList;
    private List<Karta> tempListOfHighCard;



    private List<Karta> TESTOWATALIA;
    private List<Karta> tempList;

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
        TESTOWATALIA.add(new Karta(Kolor.KIER, Figura.AS));
        TESTOWATALIA.add(new Karta(Kolor.TREFL, Figura.SIODEMKA));
        TESTOWATALIA.add(new Karta(Kolor.KIER, Figura.DWOJKA));
        TESTOWATALIA.add(new Karta(Kolor.KARO, Figura.WALET));
//        TESTOWATALIA.add(new Karta(Kolor.KARO, Figura.SZOSTKA));
        TESTOWATALIA.add(new Karta(Kolor.KIER, Figura.PIATKA));
        TESTOWATALIA.add(new Karta(Kolor.PIK, Figura.CZWORKA));
        TESTOWATALIA.add(new Karta(Kolor.TREFL, Figura.TROJKA));

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

//        System.out.println("wylosowana reka" + rekaPlusStol);
//        System.out.println("wylosowana reka2" + rekaPlusStol2);
//        System.out.println("pozostala talia" + taliaDoTestu);

//        Collections.shuffle(taliaDoTestu);
//        System.out.println("potasowana pozostala talia" + taliaDoTestu);
        Collections.sort(taliaDoTestu);
        System.out.println("poukladana po tasowaniu talia" + taliaDoTestu);

        Collections.sort(rekaPlusStol);
        System.out.println("potasowana reka " + rekaPlusStol);

        Collections.sort(TESTOWATALIA);
        System.out.println(TESTOWATALIA);

        if(getFiveCardsHighCard(TESTOWATALIA) != null)
            System.out.println("HIGH CARDS" + tempListOfHighCard);


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

    public List<Karta> getFiveCardsThreeOfKind(List<Karta> listaKartGraczaDoSprawdzenia){
        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfThreeOfKind = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size()-1 ; i>=2 ; i--){
            if(listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-1).getFigura() &&
            listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-2).getFigura()){
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(i));
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(i-1));
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(i-2));

                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i-1);
                listaKartGraczaDoSprawdzenia.remove(i-2);
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size()-1));
                tempListOfThreeOfKind.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size()-2));

                return tempListOfThreeOfKind;
            }
        }
        return null;
    }


    public boolean checkIfDoublePair(List<Karta> listaKartGraczaDoSprawdzenia){
        Collections.sort(listaKartGraczaDoSprawdzenia);

        for (int i = listaKartGraczaDoSprawdzenia.size()-1 ; i>=3 ; i--){
            if(listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-1).getFigura()){
                for (int j = i-2 ;j>=1; j--){
                    if(listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j-1).getFigura()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Karta> getDoublePair(List<Karta> listaKartGraczaDoSprawdzenia){
        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempList = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size()-1 ; i>=3 ; i--){
            if(listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-1).getFigura()){
                for (int j = i-2 ;j>=1; j--){
                    if(listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j-1).getFigura()){
                        tempList.add(listaKartGraczaDoSprawdzenia.get(i));
                        tempList.add(listaKartGraczaDoSprawdzenia.get(i-1));
                        tempList.add(listaKartGraczaDoSprawdzenia.get(j));
                        tempList.add(listaKartGraczaDoSprawdzenia.get(j-1));

                        listaKartGraczaDoSprawdzenia.remove(i);
                        listaKartGraczaDoSprawdzenia.remove(i-1);
                        listaKartGraczaDoSprawdzenia.remove(j);
                        listaKartGraczaDoSprawdzenia.remove(j-1);
                        tempList.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size()-1));

                        return tempList;
                    }
                }
            }
        }
        return null;
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


    public void getFiveHighestCards(List<Karta> listaKolorowKart, List<Karta> listOfHighestFive) {

        Collections.sort(listaKolorowKart);

        if (listaKolorowKart.size() >= 5) {
            for (int i = listaKolorowKart.size() - 1; i > listaKolorowKart.size()-6; i--) {
                listOfHighestFive.add(listaKolorowKart.get(i));
            }
        }
    }

    public void listaKolorowKartyGracza(List<Karta> listaKartyGracza) {

        listPIK = new ArrayList<Karta>();
        listTREFL = new ArrayList<Karta>();
        listKARO = new ArrayList<Karta>();
        listKIER = new ArrayList<Karta>();

        for (Karta k : listaKartyGracza) {
            if (k.getKolor().equals(Kolor.PIK)) {
                listPIK.add(k);
            } else if (k.getKolor().equals(Kolor.TREFL)) {
                listTREFL.add(k);
            } else if (k.getKolor().equals(Kolor.KARO)) {
                listKARO.add(k);
            } else if (k.getKolor().equals(Kolor.KIER)) {
                listKIER.add(k);
            }
        }
    }

    public List<Karta> getFiveCardsFlush(List<Karta> listaKartyGracza) {

        tempListOfFlush = new ArrayList<Karta>();

        listaKolorowKartyGracza(listaKartyGracza);

        if (listPIK.size() >= 5) {
            getFiveHighestCards(listPIK,tempListOfFlush);
            return tempListOfFlush;
        }else if (listTREFL.size() >= 5){
            getFiveHighestCards(listTREFL,tempListOfFlush);
            return tempListOfFlush;
        }else if (listKARO.size() >= 5){
            getFiveHighestCards(listKARO,tempListOfFlush);
            return tempListOfFlush;
        }else if (listKIER.size() >= 5){
            getFiveHighestCards(listKIER,tempListOfFlush);
            return tempListOfFlush;
        }
        return null;
    }

    public List<Karta> getOnePair(List<Karta> listaKartGraczaDoSprawdzenia){
        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfOnePair = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size()-1 ; i>=1 ; i--){
            if(listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i-1).getFigura()){
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(i));
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(i-1));


                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i-1);
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size()-1));
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size()-2));
                tempListOfOnePair.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size()-3));

                return tempListOfOnePair;
            }
        }
        return null;
    }

    public List<Karta> getFiveCardsFourOfKind(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfFourOfKind = new ArrayList<Karta>();

        for (int i = 0; i < listaKartGraczaDoSprawdzenia.size() - 3; i++) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 1).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 2).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i + 3).getFigura()) {

                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i));
                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 1));
                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 2));
                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(i + 3));

                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i);
                listaKartGraczaDoSprawdzenia.remove(i);

                tempListOfFourOfKind.add(listaKartGraczaDoSprawdzenia.get(listaKartGraczaDoSprawdzenia.size() - 1));

                return tempListOfFourOfKind;
            }
        }
        return null;
    }

    public List<Karta> getFiveCardsFullHouse(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfFullHouse = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i > 3; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura() &&
                    listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 2).getFigura()) {
                for (int j = i - 3; j > 0; j--) {
                    if (listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 1).getFigura()) {

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i - 1));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i - 2));

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j - 1));

                        return tempListOfFullHouse;
                    }
                }
            }
        }
        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i > 3; i--) {
            if (listaKartGraczaDoSprawdzenia.get(i).getFigura() == listaKartGraczaDoSprawdzenia.get(i - 1).getFigura()) {
                for (int j = i - 2; j > 1; j--) {
                    if (listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 1).getFigura() &&
                            listaKartGraczaDoSprawdzenia.get(j).getFigura() == listaKartGraczaDoSprawdzenia.get(j - 2).getFigura()) {

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j - 1));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(j - 2));

                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i));
                        tempListOfFullHouse.add(listaKartGraczaDoSprawdzenia.get(i - 1));

                        return tempListOfFullHouse;
                    }
                }
            }
        }
        return null;
    }

    public List<Karta> removeDuplicateFigures(List<Karta> listaKartGraczaDosprawdzenia) {

        tempStreighList = new ArrayList<Karta>();

        Collections.sort(listaKartGraczaDosprawdzenia);

        tempStreighList.add(listaKartGraczaDosprawdzenia.get(0));

        for (int i = 0; i < listaKartGraczaDosprawdzenia.size() - 1; i++) {
            if (listaKartGraczaDosprawdzenia.get(i).getFigura() != listaKartGraczaDosprawdzenia.get(i + 1).getFigura())
                tempStreighList.add(listaKartGraczaDosprawdzenia.get(i + 1));
        }
        return tempStreighList;
    }

    public List<Karta> getFiveCardsStreigh(List<Karta> listaKartGraczaDoSprawdzenia) {

        tempListOfStreigh = new ArrayList<Karta>();

        removeDuplicateFigures(listaKartGraczaDoSprawdzenia);

        Collections.sort(tempStreighList);

        if (tempStreighList.size() >= 5) {
            for (int i = tempStreighList.size() - 1; i >= 4; i--) {
                if (tempStreighList.get(i).getFigura() == tempStreighList.get(i - 1).getFigura() + 1
                        && tempStreighList.get(i).getFigura() == tempStreighList.get(i - 2).getFigura() + 2
                        && tempStreighList.get(i).getFigura() == tempStreighList.get(i - 3).getFigura() + 3
                        && tempStreighList.get(i).getFigura() == tempStreighList.get(i - 4).getFigura() + 4) {

                    tempListOfStreigh.add(tempStreighList.get(i));
                    tempListOfStreigh.add(tempStreighList.get(i - 1));
                    tempListOfStreigh.add(tempStreighList.get(i - 2));
                    tempListOfStreigh.add(tempStreighList.get(i - 3));
                    tempListOfStreigh.add(tempStreighList.get(i - 4));

                    return tempListOfStreigh;
                }
            }
            if (Arrays.asList(tempStreighList.get(0).getFigura()).contains(Figura.DWOJKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(1).getFigura()).contains(Figura.TROJKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(2).getFigura()).contains(Figura.CZWORKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(3).getFigura()).contains(Figura.PIATKA.getFigura()) &&
                    Arrays.asList(tempStreighList.get(tempStreighList.size() - 1).getFigura()).contains(Figura.AS.getFigura())) {

                tempListOfStreigh.add(tempStreighList.get(0));
                tempListOfStreigh.add(tempStreighList.get(1));
                tempListOfStreigh.add(tempStreighList.get(2));
                tempListOfStreigh.add(tempStreighList.get(3));
                tempListOfStreigh.add(tempStreighList.get(tempStreighList.size() - 1));

                return tempListOfStreigh;
            }
        }
        return null;
    }

    public List<Karta> getFiveCardsHighCard(List<Karta> listaKartGraczaDoSprawdzenia) {

        Collections.sort(listaKartGraczaDoSprawdzenia);

        tempListOfHighCard = new ArrayList<Karta>();

        for (int i = listaKartGraczaDoSprawdzenia.size() - 1; i > 1; i--) {
            tempListOfHighCard.add(listaKartGraczaDoSprawdzenia.get(i));
        }
        return tempListOfHighCard;
    }

}

