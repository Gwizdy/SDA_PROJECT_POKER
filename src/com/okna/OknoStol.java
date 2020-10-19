package com.okna;

import com.baza.BazaGracze;
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

    private List<String> listaAvatarow;

    private int gracze;

    private int w1, w2, w3;
    private int a1, a2, a3;
    private int aw;


    public OknoStol(OknoGracze oknoGracze) {
        this.oknoGracze = oknoGracze;
        me = this;

        //new BazaGracze(me);

        windowGame = new JFrame("POKER Texas Holden Game");
        windowGame.setVisible(true);
        windowGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowGame.pack();
        windowGame.setSize(1000, 565);

        panelGame = new BackgroundPanelGame();
        panelGame.setLayout(null);

        dodanieGraczy();

        dodanieAvatara();

        rozdanieKart();

        windowGame.add(panelGame);
    }

    private void dodanieGraczy() {

        gracze = oknoGracze.getGracze();

        for (int i = 0; i < oknoGracze.getGracze(); i++) {

            label = new JLabel();
            label.setText(oknoGracze.getPlayer()[i].getText());

            if (i < 3) {
                label.setBounds(240 + w1, 360, 200, 100);
                w1 += 200;
            }
            if (i > 2 && i < 6) {
                label.setBounds(240 + w2, 68, 200, 100);
                w2 += 200;
            }
            if (i > 5) {
                label.setBounds(20 + w3, 150, 200, 100);
                w3 += 800;
            }

            label.setFont(new Font("Verdana", Font.BOLD, 24));
            label.setForeground(Color.WHITE);
            panelGame.add(label);
        }
    }

    private void dodanieAvatara() {

        listaAvatarow = new ArrayList<String>();

        aw = 1;

        while (aw <= 8) {
            listaAvatarow.add("avatar\\avatar" + aw + ".jpg");
            aw++;
        }

        for (int i = 0; i < oknoGracze.getGracze(); i++) {
            avatar = new JLabel();
            avatar.setIcon(new ImageIcon("avatar\\avatar" + i + ".jpg"));
            avatar.setLayout(null);
            if (i < 3) {
                avatar.setBounds(242 + a1, 420, 100, 100);
                a1 += 200;
            }
            if (i > 2 && i < 6) {
                avatar.setBounds(242 + a2, 14, 100, 100);
                a2 += 200;
            }
            if (i > 5) {
                avatar.setBounds(22 + a3, 97, 100, 100);
                a3 += 800;
            }
            panelGame.add(avatar);

        }
    }

    public void rozdanieKart() {

        new GUITalia(me);

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
