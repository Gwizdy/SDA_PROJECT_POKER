package com.okna;

import com.baza.BazaGracze;

import javax.swing.*;

public class OknoStol {

    private OknoGracze oknoGracze;

    private JFrame windowGame;
    private JPanel panelGame;
    private JLabel label;

    private OknoStol me;

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
        
        dodanieGraczy();

        windowGame.add(panelGame);
    }

    private void dodanieGraczy() {

        for (int i = 0; i < oknoGracze.getGracze(); i++) {
            label = new JLabel();
            label.setText(oknoGracze.getPlayer()[i].getText());
            label.setBounds(100, 100, 120, 100);
            System.out.println(oknoGracze.getPlayer()[i].getText());
            panelGame.add(label);
        }
    }
}
