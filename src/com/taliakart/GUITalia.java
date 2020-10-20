package com.taliakart;

import com.okna.OknoGracze;
import com.okna.OknoStol;
import com.okna.Ramka;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUITalia {

    private OknoStol oknoStol;

    private Talia taliaGUI;

    private List<String> listaObrazkow;
    private List<Karta> talia;

    private Random rand = new Random();;

    private JLabel karty;
    private JLabel kartyFlop;
    private JLabel kartyTurnOrRiver;

    private int k1_1, k1_2, k2_1, k2_2;
    private int r, r1, rOut, rTurnOrRiver;
    private int f;

    public GUITalia(OknoStol oknoStol) {
        this.oknoStol = oknoStol;

        taliaGUI = new Talia();
        talia = taliaGUI.getTalia();

        listaKart();

        losowanieKart();
        System.out.println(talia.size());
        rozdajFlop(talia);
        System.out.println(talia.size());
        rozdajTurnorRiver(talia);
        System.out.println(talia.size());
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
                    }
                    if (j == 3) {
                        karty.setBounds(30, 230, 41, 63);
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(240 + k2_1, 150, 41, 63);
                        k2_1 += 200;
                    }
                    if (j == 7) {
                        karty.setBounds(840, 230, 41, 63);
                    }
                }
                if (i == 1) {
                    if (j < 3) {
                        karty.setBounds(690 - k1_2, 320, 41, 63);
                        k1_2 += 200;
                    }
                    if (j == 3) {
                        karty.setBounds(80, 230, 41, 63);
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(290 + k2_2, 150, 41, 63);
                        k2_2 += 200;
                    }
                    if (j == 7) {
                        karty.setBounds(890, 230, 41, 63);
                    }
                }
                usunZTalii(r, talia);
                usunZTalii(r, listaObrazkow);
                oknoStol.getPanelGame().add(karty);
            }
        }
    }

    public void listaKart() {

        listaObrazkow = new ArrayList<String>(); //lista z filepath

        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                listaObrazkow.add("images\\" + f.getFigura() + "_" + k.getWartosc() + ".jpg");
            }
        }

    }

    //usuwanie z listy przy pozniejszym dobieraniu reki
    public void usunZTalii(int liczba, List list) {

        list.remove(list.get(liczba));
    }

    //rozdanie trzech pierwszych kart na stole, nie robilem petli dla latwiejszego dostepu
    public void rozdajFlop(List list) {

        rOut = rand.nextInt(list.size());

        list.remove(list.get(rOut));
        listaObrazkow.remove(listaObrazkow.get(rOut));

        for (int i = 0; i < 3; i++) {

            r1 = rand.nextInt(list.size());

            kartyFlop = new JLabel();
            kartyFlop.setIcon(new ImageIcon(listaObrazkow.get(r1)));
            kartyFlop.setLayout(null);
            kartyFlop.setBounds(380 + f, 231, 41, 63);

            f += 50;

            list.remove(list.get(r1));
            listaObrazkow.remove(listaObrazkow.get(r1));

            oknoStol.getPanelGame().add(kartyFlop);
        }
    }

    //rozdanie 4 i 5 karty
    public void rozdajTurnorRiver(List list) {

        rOut = rand.nextInt(list.size());

        list.remove(list.get(rOut));
        listaObrazkow.remove(listaObrazkow.get(rOut));

        for (int i = 0; i < 2; i++) {

            rTurnOrRiver = rand.nextInt(list.size());

            kartyTurnOrRiver = new JLabel();
            kartyTurnOrRiver.setIcon(new ImageIcon(listaObrazkow.get(r1)));
            kartyTurnOrRiver.setLayout(null);
            kartyTurnOrRiver.setBounds(380 + f, 231, 41, 63);

            f += 50;

            list.remove(list.get(rTurnOrRiver));
            listaObrazkow.remove(listaObrazkow.get(rTurnOrRiver));

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
}
