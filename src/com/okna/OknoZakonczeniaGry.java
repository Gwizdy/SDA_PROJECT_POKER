package com.okna;

import com.sprawdzanie.Sprawdzenie;

import javax.swing.*;
import java.awt.*;

public class OknoZakonczeniaGry {

    private OknoStol oknoStol;

    private Sprawdzenie sprawdzenie;

    private JFrame window;
    private JPanel panel;
    private JTextArea tekstArea;

    public OknoZakonczeniaGry(Sprawdzenie sprawdzenie) {
        this.sprawdzenie = sprawdzenie;

        dodanieOkna();

    }

    public void dodanieOkna() {

        window = new JFrame("POKER Texas Holden - Zakończenie gry");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();

        dodaniePanela();

        window.add(panel);
        window.setSize(600, 400);
    }

    public void dodaniePanela() {

        panel = new BackgroundZakonczenieGry();

        dodaniePolaTekstowego();

        panel.setLayout(null);
        panel.add(tekstArea);

    }

    public void dodaniePolaTekstowego() {

        tekstArea = new JTextArea();

        tekstArea.setFont(new Font("Arial", Font.BOLD, 26));
        tekstArea.setBorder(BorderFactory.createEmptyBorder());
        tekstArea.setEditable(false);
        tekstArea.setOpaque(false);
        tekstArea.setText("GRATULACJE!!!\r\n Wygrał gracz " + sprawdzenie.getGracz());
        tekstArea.setBounds(190, 50, 250, 200);


    }
}
