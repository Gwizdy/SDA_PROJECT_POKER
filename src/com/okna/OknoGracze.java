package com.okna;

import javax.swing.*;

public class OknoGracze {

    private Ramka ramka;

    private JPanel panelPlayers;

    private JTextField[] player;

    private int w1;
    private int w2;
    private int w3;

    private int gracze;

    public OknoGracze(Ramka ramka) {
        this.ramka = ramka;

        panelPlayers = new BackgroundPanel();
        panelPlayers.setLayout(null);

        player = new JTextField[ramka.getLiczbaGraczy()];

        w1 = 0;
        w2 = 0;
        w3 = 0;

        for (int i = 0; i < ramka.getLiczbaGraczy(); i++) {
            if (i < 3) {
                player[i] = new JTextField("Podaj nick");
                player[i].setBounds(400 + w1, 280, 120, 30);
                panelPlayers.add(player[i]);
                w1 += 140;
            }
            if (i >= 3 && i < 6) {
                player[i] = new JTextField("Podaj nick");
                player[i].setBounds(400 + w2, 330, 120, 30);
                panelPlayers.add(player[i]);
                w2 += 140;
            }
            if (i >= 6 && i < 8) {
                player[i] = new JTextField("Podaj nick");
                player[i].setBounds(400 + w3, 380, 120, 30);
                panelPlayers.add(player[i]);
                w3 += 140;
            }
        }
        ramka.getWindow().add(panelPlayers);

    }
}
