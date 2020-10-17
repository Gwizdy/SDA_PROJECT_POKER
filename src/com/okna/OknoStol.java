package com.okna;

import javax.swing.*;

public class OknoStol {

    private OknoGracze oknoGracze;

    private JFrame windowGame;
    private JPanel panelGame;


    public OknoStol(OknoGracze oknoGracze) {
        this.oknoGracze = oknoGracze;

        windowGame = new JFrame("POKER Texas Holden Game");
        windowGame.setVisible(true);
        windowGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowGame.pack();
        windowGame.setSize(1000,565);

        panelGame = new BackgroundPanelGame();

        windowGame.add(panelGame);
    }
}
