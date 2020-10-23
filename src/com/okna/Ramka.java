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

        button = new JButton(new ImageIcon("confirm.jpg"));

        button.setBounds(575, 350, 98, 41);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setBorder(null);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("") || textField.getText().charAt(0) < 50 || textField.getText().charAt(0) > 56 || textField.getText().length() > 1)
                    new OknoOstrzezenie();
                else {
                    setLiczbaGraczy(liczbaGraczy = Integer.parseInt(textField.getText()));
                    panel.removeAll();
                    new OknoGracze(me);
                    window.revalidate();
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

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public int getLiczbaGraczy() {
        return liczbaGraczy;
    }

    public void setLiczbaGraczy(int liczbaGraczy) {
        this.liczbaGraczy = liczbaGraczy;
    }
}
