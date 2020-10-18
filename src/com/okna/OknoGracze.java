package com.okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OknoGracze {

    private Ramka ramka;

    private OknoGracze me;

    private JPanel panelPlayers;
    private JButton button;

    private JTextField[] player;

    private int w1;
    private int w2;
    private int w3;

    private int gracze;

    private boolean dobrePuste = true;
    private boolean dobreNazwa = true;

    public OknoGracze(Ramka ramka) {
        this.ramka = ramka;
        me = this;

        gracze = ramka.getLiczbaGraczy();
        panelPlayers = new BackgroundPanel();
        panelPlayers.setLayout(null);

        player = new JTextField[gracze];

        w1 = 0;
        w2 = 0;
        w3 = 0;

        for (int i = 0; i < gracze; i++) {
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
        for (int i = 0; i < gracze; i++) {
            int finalI1 = i;
            player[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 1)
                        player[finalI1].setText("");
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        button = new JButton(new ImageIcon("confirm.jpg"));
        button.setBounds(550, 440, 98, 41);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < gracze; i++) {
                    if (player[i].getText().equals("")) {
                        dobrePuste = false;
                        new OknoOstrzezenieGracz();
                    } else
                        dobrePuste = true;
                }
                if (dobrePuste == true) {
                    for (int i = 0; i < gracze - 1; i++) {
                        for (int j = i + 1; j < ramka.getLiczbaGraczy(); j++) {
                            if (player[i].getText().equals(player[j].getText())) {
                                dobreNazwa = false;
                                new OknoOstrzezenieNazwa();
                            } else
                                dobreNazwa = true;
                        }
                    }
                }

                if (dobrePuste == true && dobreNazwa == true)
                    ramka.getWindow().dispose();
                    new OknoStol(me);

            }
        });

        panelPlayers.add(button);
        ramka.getWindow().add(panelPlayers);
    }

    public int getGracze() {
        return gracze;
    }

    public void setGracze(int gracze) {
        this.gracze = gracze;
    }

    public JTextField[] getPlayer() {
        return player;
    }

    public void setPlayer(JTextField[] player) {
        this.player = player;
    }
}
