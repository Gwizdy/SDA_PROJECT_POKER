package com.okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ramka {

    private JFrame window;
    private JPanel panel;
    private JButton button;
    private JTextField textField;

    private Ramka me;

    private int liczbaGraczy;

    public Ramka() {
        me = this;

        dodanieRamki();
    }

    public void dodanieRamki() {
        window = new JFrame("POKER Texas Holden");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();

        dodaniePanela();

        window.add(panel);
        window.setSize(910, 555);
    }

    public void dodaniePanela() {

        panel = new BackgroundPanel();

        dodaniePrzycisku();

        dodaniePolaTekstowego();

        panel.setLayout(null);
        panel.add(button);
        panel.add(textField);
    }

    public void dodaniePrzycisku() {

        button = new JButton(new ImageIcon("images\\confirm.jpg"));

        button.setBounds(575, 350, 98, 41);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setBorder(null);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!textField.getText().equals("") && Integer.parseInt(textField.getText()) > 1 && Integer.parseInt(textField.getText()) < 9 && textField.getText().length() == 1) {

                        setLiczbaGraczy(liczbaGraczy = Integer.parseInt(textField.getText()));

                        panel.removeAll();

                        new OknoGracze(me);

                        window.revalidate();

                    } else {

                        new OknoOstrzezenie();

                    }
                } catch (NumberFormatException ex) {

                    new OknoOstrzezenie();

                }
            }
        });
    }

    public void dodaniePolaTekstowego() {

        textField = new JTextField();

        textField.setText("Podaj liczbę graczy");
        textField.setBounds(540, 290, 160, 30);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1)
                    textField.setText("");
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


    public JFrame getWindow() {
        return window;
    }

    public int getLiczbaGraczy() {
        return liczbaGraczy;
    }

    public void setLiczbaGraczy(int liczbaGraczy) {
        this.liczbaGraczy = liczbaGraczy;
    }
}
