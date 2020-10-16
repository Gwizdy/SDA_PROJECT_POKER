package com.okna;

import javax.swing.*;

public class OknoGracze extends Ramka {

    private JPanel panelPlayers;

    private JTextField[] player;

    private int w1;
    private int w2;
    private int w3;
    private int h;

    public OknoGracze() {

        panelPlayers = new BackgroundPanel();
        panelPlayers.setLayout(null);

        player = new JTextField[7];

        w1 = 0;
        w2 = 0;
        w3 = 0;

        for (int i = 0; i < getLiczbaGraczy(); i++) {
            if (i < 3) {
                player[i].setBounds(350 + w1, 300, 120, 30);
                panelPlayers.add(player[i]);
                w1 += 140;
            }
            if (i >= 3 && i < 6) {
                player[i].setBounds(350 + w2, 350, 120, 30);
                panelPlayers.add(player[i]);
                w2 += 140;
            }
            if (i >= 6 && i < 9) {
                player[i].setBounds(350 + w3, 400, 120, 30);
                panelPlayers.add(player[i]);
                w3 += 140;
            }
        }
        getWindow().add(panelPlayers);

    }

    public JPanel getPanelPlayers() {
        return panelPlayers;
    }

    public void setPanelPlayers(JPanel panelPlayers) {
        this.panelPlayers = panelPlayers;
    }
}
