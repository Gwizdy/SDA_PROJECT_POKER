package com.rozgrywka;

import com.okna.OknoStol;
import com.sprawdzanie.Sprawdzenie;
import com.taliakart.Figura;
import com.taliakart.Karta;
import com.taliakart.Kolor;
import com.taliakart.Talia;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RozgrywkaTest {

    private OknoStol oknoStol;

    private Talia taliaGUI;
    private RozgrywkaTest me;

    private List<String> listaObrazkow;
    private List<Karta> talia;

    private List<Karta> listaPlayer1 = new ArrayList<Karta>();
    private List<Karta> listaPlayer2 = new ArrayList<Karta>();
    private List<Karta> listaPlayer3 = new ArrayList<Karta>();
    private List<Karta> listaPlayer4 = new ArrayList<Karta>();
    private List<Karta> listaPlayer5 = new ArrayList<Karta>();
    private List<Karta> listaPlayer6 = new ArrayList<Karta>();
    private List<Karta> listaPlayer7 = new ArrayList<Karta>();
    private List<Karta> listaPlayer8 = new ArrayList<Karta>();

    private Gracz gracz1 = new Gracz();
    private Gracz gracz2 = new Gracz();
    private Gracz gracz3 = new Gracz();
    private Gracz gracz4 = new Gracz();
    private Gracz gracz5 = new Gracz();
    private Gracz gracz6 = new Gracz();
    private Gracz gracz7 = new Gracz();
    private Gracz gracz8 = new Gracz();

    private List<Gracz> listaRekaGraczy = new ArrayList<Gracz>();

    private List<List<Karta>> listPlayerCards = new ArrayList<List<Karta>>();

    private List<Karta> listaFlop;
    private List<Karta> listaTurnOrRiver;

    private Random rand = new Random();

    private JLabel karty;
    private JLabel kartyFlop;
    private JLabel kartyTurnOrRiver;

    private int k1_1, k1_2, k2_1, k2_2;
    private int r, r1, rOut, rTurnOrRiver;
    private int f;
    private int iloscGraczy;

    private List<Gracz> listaGraczy;

    private boolean startFlop = false;

    public void setStartFlop(boolean startFlop) {
        this.startFlop = startFlop;
    }

    public RozgrywkaTest(OknoStol oknoStol) {
        this.oknoStol = oknoStol;
        me = this;

        listaTurnOrRiver = new ArrayList<Karta>();
        iloscGraczy = oknoStol.getGracze();

        taliaGUI = new Talia();
        talia = taliaGUI.getTalia();

        listaKart();

        // small blind - drugi gracz

        // big blind - trzeci gracz

        losowanieKart(getIloscGraczy());

        listaGraczy = new ArrayList<Gracz>(getListaRekaGraczy());

        new OknoKartGracza(me);

        // pierwsza licytacja, zaczyna gracz po big blind

        rozdajFlop(getTalia()); // +3 karty

        System.out.println("Flop");


        // druga licytacja, zaczyna gracz siedzący na lewo od rozdającego

        rozdajTurnOrRiver(getTalia()); // +1 karta


        // trzecia runda licytacji, zaczyna gracz siedzący na lewo od rozdającego

        rozdajTurnOrRiver(getTalia());


        // czwarta runda licytacji i sprawdzenie

        new Sprawdzenie(me);
    }

    public void usunZTalii(List list, int liczba) {

        list.remove(list.get(liczba));
    }

    public void listaKart() {

        listaObrazkow = new ArrayList<String>(); //lista z filepath

        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                listaObrazkow.add("images\\" + f.getFigura() + "_" + k.getWartosc() + ".jpg");
            }
        }
    }

    public void losowanieKart(int liczbaGraczy) {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < liczbaGraczy; j++) {

                r = rand.nextInt(talia.size());

                karty = new JLabel();
                karty.setIcon(new ImageIcon("Red_Back.jpg"));
                karty.setLayout(null);

                if (i == 0) {
                    if (j < 3) {
                        karty.setBounds(640 - k1_1, 320, 41, 63);
                        k1_1 += 200;
                        if (j == 0)
                            listaPlayer1.add(talia.get(r));
                        if (j == 1)
                            listaPlayer2.add(talia.get(r));
                        if (j == 2)
                            listaPlayer3.add(talia.get(r));
                    }
                    if (j == 3) {
                        karty.setBounds(30, 230, 41, 63);
                        if (j == 3)
                            listaPlayer4.add(talia.get(r));
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(240 + k2_1, 150, 41, 63);
                        k2_1 += 200;
                        if (j == 4)
                            listaPlayer5.add(talia.get(r));
                        if (j == 5)
                            listaPlayer6.add(talia.get(r));
                        if (j == 6)
                            listaPlayer7.add(talia.get(r));
                    }
                    if (j == 7) {
                        karty.setBounds(840, 230, 41, 63);
                        if (j == 7)
                            listaPlayer8.add(talia.get(r));
                    }
                }
                if (i == 1) {
                    if (j < 3) {
                        karty.setBounds(690 - k1_2, 320, 41, 63);
                        k1_2 += 200;
                        if (j == 0) {
                            listaPlayer1.add(talia.get(r));
                            gracz1.setKartyReka(listaPlayer1);
                            listaRekaGraczy.add(gracz1);
                            System.out.println("GRACZ 1" + (gracz1.getKartyReka()));
                        }
                        if (j == 1) {
                            listaPlayer2.add(talia.get(r));
                            gracz2.setKartyReka(listaPlayer2);
                            listaRekaGraczy.add(gracz2);
                            System.out.println("GRACZ 2" + (gracz2.getKartyReka()));

                        }
                        if (j == 2) {
                            listaPlayer3.add(talia.get(r));
                            gracz3.setKartyReka(listaPlayer3);
                            listaRekaGraczy.add(gracz3);
                            System.out.println("GRACZ 3" + (gracz3.getKartyReka()));

                        }
                    }
                    if (j == 3) {
                        karty.setBounds(80, 230, 41, 63);
                        if (j == 3) {
                            listaPlayer4.add(talia.get(r));
                            gracz4.setKartyReka(listaPlayer4);
                            listaRekaGraczy.add(gracz4);
                            System.out.println("GRACZ 4" + (gracz4.getKartyReka()));

                        }
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(290 + k2_2, 150, 41, 63);
                        k2_2 += 200;
                        if (j == 4) {
                            listaPlayer5.add(talia.get(r));
                            gracz5.setKartyReka(listaPlayer5);
                            listaRekaGraczy.add(gracz5);
                            System.out.println("GRACZ 5" + (gracz5.getKartyReka()));

                        }
                        if (j == 5) {
                            listaPlayer6.add(talia.get(r));
                            gracz6.setKartyReka(listaPlayer6);
                            listaRekaGraczy.add(gracz6);
                            System.out.println("GRACZ 6" + (gracz6.getKartyReka()));

                        }
                        if (j == 6) {
                            listaPlayer7.add(talia.get(r));
                            gracz7.setKartyReka(listaPlayer7);
                            listaRekaGraczy.add(gracz7);
                            System.out.println("GRACZ 7" + (gracz7.getKartyReka()));

                        }
                    }
                    if (j == 7) {
                        karty.setBounds(890, 230, 41, 63);
                        if (j == 7) {
                            listaPlayer8.add(talia.get(r));
                            gracz8.setKartyReka(listaPlayer8);
                            listaRekaGraczy.add(gracz8);
                            System.out.println("GRACZ 8" + gracz8.getKartyReka());

                        }
                    }
                }
                usunZTalii(talia, r);
                usunZTalii(listaObrazkow, r);

                oknoStol.getPanelGame().add(karty);
            }
        }
    }

    public void rozdajFlop(List list) {

        listaFlop = new ArrayList<Karta>();

        rOut = rand.nextInt(list.size());

        usunZTalii(talia, rOut);
        usunZTalii(listaObrazkow, rOut);

        for (int i = 0; i < 3; i++) {

            r1 = rand.nextInt(list.size());

            kartyFlop = new JLabel();
            kartyFlop.setIcon(new ImageIcon(listaObrazkow.get(r1)));
            kartyFlop.setLayout(null);
            kartyFlop.setBounds(380 + f, 231, 41, 63);

            f += 50;

            listaFlop.add(talia.get(r1));

            usunZTalii(talia, r1);
            usunZTalii(listaObrazkow, r1);

            oknoStol.getPanelGame().add(kartyFlop);
        }
    }

    public void rozdajTurnOrRiver(List list) {

//        listaTurnOrRiver = new ArrayList<Karta>();

        rOut = rand.nextInt(list.size());

        usunZTalii(talia, rOut);
        usunZTalii(listaObrazkow, rOut);

        for (int i = 0; i < 1; i++) {

            rTurnOrRiver = rand.nextInt(list.size());

            kartyTurnOrRiver = new JLabel();
            kartyTurnOrRiver.setIcon(new ImageIcon(listaObrazkow.get(rTurnOrRiver)));
            kartyTurnOrRiver.setLayout(null);
            kartyTurnOrRiver.setBounds(380 + f, 231, 41, 63);

            f += 50;

            listaTurnOrRiver.add(talia.get(rTurnOrRiver));

            usunZTalii(talia, rTurnOrRiver);
            usunZTalii(listaObrazkow, rTurnOrRiver);

            oknoStol.getPanelGame().add(kartyTurnOrRiver);
        }
    }

    public List<Karta> getTalia() {
        return talia;
    }

    public void setTalia(List<Karta> talia) {
        this.talia = talia;
    }

    public Talia getTaliaGUI() {
        return taliaGUI;
    }

    public List<String> getListaObrazkow() {
        return listaObrazkow;
    }

    public JLabel getKarty() {
        return karty;
    }

    public void setKarty(JLabel karty) {
        this.karty = karty;
    }

    public int getIloscGraczy() {
        return iloscGraczy;
    }

    public void setIloscGraczy(int iloscGraczy) {
        this.iloscGraczy = iloscGraczy;
    }

    public List<Karta> getListaFlop() {
        return listaFlop;
    }

    public void setListaFlop(List<Karta> listaFlop) {
        this.listaFlop = listaFlop;
    }

    public List<Karta> getListaTurnOrRiver() {
        return listaTurnOrRiver;
    }

    public void setListaTurnOrRiver(List<Karta> listaTurnOrRiver) {
        this.listaTurnOrRiver = listaTurnOrRiver;
    }

    public List<List<Karta>> getListPlayerCards() {
        return listPlayerCards;
    }

    public void setListPlayerCards(List<List<Karta>> listPlayerCards) {
        this.listPlayerCards = listPlayerCards;
    }

    public Gracz getGracz1() {
        return gracz1;
    }

    public void setGracz1(Gracz gracz1) {
        this.gracz1 = gracz1;
    }

    public Gracz getGracz2() {
        return gracz2;
    }

    public void setGracz2(Gracz gracz2) {
        this.gracz2 = gracz2;
    }

    public Gracz getGracz3() {
        return gracz3;
    }

    public void setGracz3(Gracz gracz3) {
        this.gracz3 = gracz3;
    }

    public Gracz getGracz4() {
        return gracz4;
    }

    public void setGracz4(Gracz gracz4) {
        this.gracz4 = gracz4;
    }

    public Gracz getGracz5() {
        return gracz5;
    }

    public void setGracz5(Gracz gracz5) {
        this.gracz5 = gracz5;
    }

    public Gracz getGracz6() {
        return gracz6;
    }

    public void setGracz6(Gracz gracz6) {
        this.gracz6 = gracz6;
    }

    public Gracz getGracz7() {
        return gracz7;
    }

    public void setGracz7(Gracz gracz7) {
        this.gracz7 = gracz7;
    }

    public Gracz getGracz8() {
        return gracz8;
    }

    public void setGracz8(Gracz gracz8) {
        this.gracz8 = gracz8;
    }

    public List<Gracz> getListaRekaGraczy() {
        return listaRekaGraczy;
    }

    public void setListaRekaGraczy(List<Gracz> listaRekaGraczy) {
        this.listaRekaGraczy = listaRekaGraczy;
    }

    public List<Gracz> getListaGraczy() {
        return listaGraczy;
    }

    public void setListaGraczy(List<Gracz> listaGraczy) {
        this.listaGraczy = listaGraczy;
    }
}

