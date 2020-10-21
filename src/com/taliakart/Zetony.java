package com.taliakart;

import com.okna.OknoStol;

import javax.swing.*;

public class Zetony {

    private OknoStol oknoStol;

    private JLabel zetony;

    private int k1, k2;

    public Zetony(OknoStol oknoStol) {
        this.oknoStol = oknoStol;

        dodanieZetonow();

    }

    public void dodanieZetonow() {

        for (int i = 0; i < oknoStol.getGracze(); i++) {

            zetony = new JLabel();
            zetony.setIcon(new ImageIcon("images\\zetony.jpg"));
            zetony.setLayout(null);

            if (i < 3) {
                zetony.setBounds(840 - k1, 320, 41, 63);
                k1 += 200;
            }
            if (i == 3) {
                zetony.setBounds(30, 230, 41, 63);
            }
            if (i > 3 && i < 7) {
                zetony.setBounds(240 + k2, 150, 41, 63);
                k2 += 200;
            }
            if (i == 7) {
                zetony.setBounds(840, 230, 41, 63);
            }
        }
        oknoStol.getPanelGame().add(zetony);
    }

}




