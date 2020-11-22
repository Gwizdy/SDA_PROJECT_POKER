package com.okna;

import com.sprawdzanie.Sprawdzenie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoZakonczeniaGry {

    private OknoStol oknoStol;

    private Sprawdzenie sprawdzenie;

    private JFrame window;
    private JPanel panel;
    private JTextArea tekstArea;

    private JButton zakonczenieGry;

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

        dodaniePrzyciskuZakonczeniaGry();

        panel.setLayout(null);
        panel.add(tekstArea);
        panel.add(zakonczenieGry);

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

    public void dodaniePrzyciskuZakonczeniaGry() {

        zakonczenieGry = new JButton("ZAKONCZ GRĘ");

        zakonczenieGry.setFont(new Font("Arial", Font.BOLD, 16));
        zakonczenieGry.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        zakonczenieGry.setBounds(205, 250, 170, 50);
        zakonczenieGry.setBorderPainted(true);
        zakonczenieGry.setContentAreaFilled(false);
        zakonczenieGry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });
    }
}
