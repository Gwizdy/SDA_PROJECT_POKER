package com.taliakart;

import com.okna.OknoGracze;
import com.okna.OknoStol;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUITalia {

    private OknoStol oknoStol;

    private Talia taliaGUI;

    private List<String> listaObrazkow;
    private List<Karta> talia;

    private Random rand;

    private JLabel karty;

    private int k1_1, k1_2, k2_1, k2_2, k3_1, k3_2;
    private int r;

    public GUITalia(OknoStol oknoStol) {
        this.oknoStol = oknoStol;

        taliaGUI = new Talia();
        talia = taliaGUI.getTalia();

        listaKart();

        losowanieKart();
    }

    public void losowanieKart() {

        rand = new Random();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < oknoStol.getGracze(); j++) {

                r = rand.nextInt(talia.size());

                karty = new JLabel();
                karty.setIcon(new ImageIcon(listaObrazkow.get(r)));
                karty.setLayout(null);

                System.out.println(new ImageIcon(listaObrazkow.get(r)));

                if (i == 0) {
                    if (j < 3) {
                        karty.setBounds(240 + k1_1, 320, 41, 63);
                        k1_1 += 200;
                    }
                    if (j > 2 && j < 6) {
                        karty.setBounds(240 + k2_1, 150, 41, 63);
                        k2_1 += 200;
                    }
                    if (j > 5) {
                        karty.setBounds(30 + k3_1, 230, 41, 63);
                        k3_1 += 810;
                    }
                }
                if (i == 1) {
                    if (j < 3) {
                        karty.setBounds(290 + k1_2, 320, 41, 63);
                        k1_2 += 200;
                    }
                    if (j > 2 && j < 6) {
                        karty.setBounds(290 + k2_2, 150, 41, 63);
                        k2_2 += 200;
                    }
                    if (j > 5) {
                        karty.setBounds(80 + k3_2, 230, 41, 63);
                        k3_2 += 810;
                    }
                }
                usunZTalii(r, talia);
                oknoStol.getPanelGame().add(karty);
                System.out.println("Rozmiar talii " + talia.size());
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
        list.remove(liczba);
    }

    //rozdanie trzech pierwszych kart na stole, nie robilem petli dla latwiejszego dostepu
    public void rozdajFlop(List list){
        rand = new Random();
        int rOut = rand.nextInt(list.size());
        list.remove(rOut);

        int r1 = rand.nextInt(list.size());
        list.get(r1);
        list.remove(r1);
        int r2 = rand.nextInt(list.size());
        list.get(r2);
        list.remove(r2);
        int r3 = rand.nextInt(list.size());
        list.get(r3);
        list.remove(r3);

    }

    //rozdanie 4 i 5 karty
    public void rozdajTurnorRiver(List list){
        rand = new Random();
        int rOut = rand.nextInt(list.size());
        list.remove(rOut);

        int rTurnOrRiver = rand.nextInt(list.size());
        list.get(rTurnOrRiver);
        list.remove(rTurnOrRiver);
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
