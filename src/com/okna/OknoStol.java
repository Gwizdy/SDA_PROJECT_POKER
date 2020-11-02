package com.okna;

import com.rozgrywka.RozgrywkaTest;
import com.taliakart.GUITalia;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OknoStol {

    private OknoGracze oknoGracze;

    private OknoStol me;

    private JFrame windowGame;
    private JPanel panelGame;

    private JLabel label;
    private JLabel avatar;
    private JLabel zetony;

    private List<String> listaAvatarow;

    private int gracze;

    private int w1, w2;
    private int a1, a2;
    private int k1, k2;
    private int aw;


    public OknoStol(OknoGracze oknoGracze) {
        this.oknoGracze = oknoGracze;
        me = this;

        //new BazaGracze(me);

        nowaRamka();

        rozdanieKart();

    }

    public void nowaRamka() {

        windowGame = new JFrame("POKER Texas Holden Game");
        windowGame.setVisible(true);
        windowGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowGame.pack();
        windowGame.setSize(1000, 565);

        panelGame = new BackgroundPanelGame();
        panelGame.setLayout(null);

        dodanieGraczy(oknoGracze.getGracze());

        dodanieAvatara(oknoGracze.getGracze());

        dodanieZetonow(oknoGracze.getGracze());

        windowGame.add(panelGame);
    }

    private void dodanieGraczy(int liczbaGraczy) {

        gracze = liczbaGraczy;

        for (int i = 0; i < gracze; i++) {

            label = new JLabel();
            label.setText(oknoGracze.getPlayer()[i].getText());

            if (i < 3) {
                label.setBounds(640 - w1, 360, 200, 100);
                w1 += 200;
            }
            if (i == 3) {
                label.setBounds(20, 150, 200, 100);
            }
            if (i > 3 && i < 7) {
                label.setBounds(240 + w2, 68, 200, 100);
                w2 += 200;
            }
            if (i == 7) {
                label.setBounds(820, 150, 200, 100);
            }

            label.setFont(new Font("Verdana", Font.BOLD, 24));
            label.setForeground(Color.WHITE);

            panelGame.add(label);
        }

    }

    private void dodanieAvatara(int liczbaGraczy) {

        listaAvatarow = new ArrayList<String>();

        aw = 1;

        while (aw <= 8) {
            listaAvatarow.add("avatar\\avatar" + aw + ".jpg");
            aw++;
        }

        for (int i = 0; i < liczbaGraczy; i++) {

            avatar = new JLabel();
            avatar.setIcon(new ImageIcon("avatar\\avatar" + i + ".jpg"));
            avatar.setLayout(null);

            if (i < 3) {
                avatar.setBounds(642 - a1, 420, 100, 100);
                a1 += 200;
            }
            if (i == 3) {
                avatar.setBounds(22, 97, 100, 100);
            }
            if (i > 3 && i < 7) {
                avatar.setBounds(242 + a2, 14, 100, 100);
                a2 += 200;
            }
            if (i == 7) {
                avatar.setBounds(822, 97, 100, 100);
            }
            panelGame.add(avatar);
        }
    }

    public void dodanieZetonow(int liczbaGraczy) {

        for (int i = 0; i < liczbaGraczy; i++) {

            zetony = new JLabel();
            zetony.setIcon(new ImageIcon("images\\zetony.jpg"));
            zetony.setLayout(null);

            if (i < 3) {
                zetony.setBounds(725 - k1, 462, 41, 63);
                k1 += 200;
            }
            if (i == 3) {
                zetony.setBounds(105, 140, 41, 63);
            }
            if (i > 3 && i < 7) {
                zetony.setBounds(334 + k2, 166, 41, 63);
                k2 += 200;
            }
            if (i == 7) {
                zetony.setBounds(905, 140, 41, 63);
            }
            panelGame.add(zetony);
        }
    }

    public void rozdanieKart() {

        new RozgrywkaTest(me);

    }

    public JFrame getWindowGame() {
        return windowGame;
    }

    public void setWindowGame(JFrame windowGame) {
        this.windowGame = windowGame;
    }

    public JPanel getPanelGame() {
        return panelGame;
    }

    public void setPanelGame(JPanel panelGame) {
        this.panelGame = panelGame;
    }

    public int getGracze() {
        return gracze;
    }

    public void setGracze(int gracze) {
        this.gracze = gracze;
    }
}
