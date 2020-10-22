package com.taliakart;

import com.okna.OknoStol;
import com.sprawdzanie.RoyalFlush;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUITalia {

    private OknoStol oknoStol;

    private Talia taliaGUI;

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

    private GUITalia me;

    public GUITalia(OknoStol oknoStol) {
        this.oknoStol = oknoStol;
        me = this;

        iloscGraczy = oknoStol.getGracze();

        taliaGUI = new Talia();
        talia = taliaGUI.getTalia();

        listaKart();

        losowanieKart();

        rozdajFlop(talia);

        rozdajTurnOrRiver(talia);

        new RoyalFlush(me);

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

    public void losowanieKart() {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < oknoStol.getGracze(); j++) {

                r = rand.nextInt(talia.size());

                karty = new JLabel();
                karty.setIcon(new ImageIcon(listaObrazkow.get(r)));
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
                        if (j == 0)
                            listaPlayer1.add(talia.get(r));
                        if (j == 1)
                            listaPlayer2.add(talia.get(r));
                        if (j == 2)
                            listaPlayer3.add(talia.get(r));
                    }
                    if (j == 3) {
                        karty.setBounds(80, 230, 41, 63);
                        if (j == 3)
                            listaPlayer4.add(talia.get(r));
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(290 + k2_2, 150, 41, 63);
                        k2_2 += 200;
                        if (j == 4)
                            listaPlayer5.add(talia.get(r));
                        if (j == 5)
                            listaPlayer6.add(talia.get(r));
                        if (j == 6)
                            listaPlayer7.add(talia.get(r));
                    }
                    if (j == 7) {
                        karty.setBounds(890, 230, 41, 63);
                        if (j == 7)
                            listaPlayer8.add(talia.get(r));
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
            System.out.println();

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

        listaTurnOrRiver = new ArrayList<Karta>();

        rOut = rand.nextInt(list.size());

        usunZTalii(talia, rOut);
        usunZTalii(listaObrazkow, rOut);

        for (int i = 0; i < 2; i++) {

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

    public List<Karta> getListaPlayer1() {
        return listaPlayer1;
    }

    public void setListaPlayer1(List<Karta> listaPlayer1) {
        this.listaPlayer1 = listaPlayer1;
    }

    public List<Karta> getListaPlayer2() {
        return listaPlayer2;
    }

    public void setListaPlayer2(List<Karta> listaPlayer2) {
        this.listaPlayer2 = listaPlayer2;
    }

    public List<Karta> getListaPlayer3() {
        return listaPlayer3;
    }

    public void setListaPlayer3(List<Karta> listaPlayer3) {
        this.listaPlayer3 = listaPlayer3;
    }

    public List<Karta> getListaPlayer4() {
        return listaPlayer4;
    }

    public void setListaPlayer4(List<Karta> listaPlayer4) {
        this.listaPlayer4 = listaPlayer4;
    }

    public List<Karta> getListaPlayer5() {
        return listaPlayer5;
    }

    public void setListaPlayer5(List<Karta> listaPlayer5) {
        this.listaPlayer5 = listaPlayer5;
    }

    public List<Karta> getListaPlayer6() {
        return listaPlayer6;
    }

    public void setListaPlayer6(List<Karta> listaPlayer6) {
        this.listaPlayer6 = listaPlayer6;
    }

    public List<Karta> getListaPlayer7() {
        return listaPlayer7;
    }

    public void setListaPlayer7(List<Karta> listaPlayer7) {
        this.listaPlayer7 = listaPlayer7;
    }

    public List<Karta> getListaPlayer8() {
        return listaPlayer8;
    }

    public void setListaPlayer8(List<Karta> listaPlayer8) {
        this.listaPlayer8 = listaPlayer8;
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
}
