package com.okna;

import com.baza.BazaGracze;

import javax.swing.*;
import java.awt.*;

public class OknoStol {

    private OknoGracze oknoGracze;

    private JFrame windowGame;
    private JPanel panelGame;
    private JLabel label;

    private OknoStol me;

    private int w1, w2, w3;


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

        windowGame.add(panelGame);
    }

    private void dodanieGraczy() {

        for (int i = 0; i < oknoGracze.getGracze(); i++) {
            label = new JLabel();
            label.setText(oknoGracze.getPlayer()[i].getText());
            if (i < 3) {
                label.setBounds(240 + w1, 360, 150, 100);
                w1 += 200;
            }
            if (i > 2 && i < 6)
                label.setBounds(100, 100, 150, 100);
            if (i > 5)
                label.setBounds(100, 100, 120, 100);
            label.setFont(new Font("Verdana", Font.BOLD, 28));
            label.setForeground(Color.WHITE);
            System.out.println(oknoGracze.getPlayer()[i].getText());
            panelGame.add(label);
        }
    }
}
