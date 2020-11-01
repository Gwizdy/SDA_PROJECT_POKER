package com.rozgrywka;

import com.taliakart.Figura;
import com.taliakart.GUITalia;
import com.taliakart.Karta;
import com.taliakart.Kolor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class OknoKartGracza {

    private GUITalia guiTalia;

    private List<String> listaObrazkow;

    private JFrame window;

    private JPanel panel;

    private JButton bet;
    private JButton fold;
    private JButton call;
    private JButton raise;
    private JButton check;
    private JButton allIn;

    private JTextField raiseField;
    private JTextField wyswietlaczZetonow;

    private JLabel kartygracza;

    private List<Karta> handCards;

    public OknoKartGracza() {

        listaKart();

        dodanieOkna();

    }

    public void dodanieOkna() {

        window = new JFrame("Karty Gracza");
        window.setVisible(true);
        window.pack();

        dodaniePanela();

        window.add(panel);
        window.setSize(690, 390);

    }

    public void dodaniePanela() {

        panel = new BackgroundPanelGracza();

        panel.setLayout(null);

        dodanieWyswietlaczaZetonow();

        dodaniePrzyciskuBet();

        dodaniePrzyciskuFold();

        dodaniePrzyciskuCall();

        dodaniePrzyciskuRaise();

        dodaniePolaStawkiRaise();

        dodaniePrzyciskuCheck();

        dodaniePrzyciskuAllIn();

        setWyswietlaczZetonow("1000");

        wyswietlenieKartGracza(0);

        panel.add(wyswietlaczZetonow);
        panel.add(bet);
        panel.add(fold);
        panel.add(call);
        panel.add(raise);
        panel.add(raiseField);
        panel.add(check);
        panel.add(allIn);
        panel.add(kartygracza);
    }

    public void dodanieWyswietlaczaZetonow() {

        wyswietlaczZetonow = new JTextField();

        wyswietlaczZetonow.setBounds(400, 30, 115, 31);
        wyswietlaczZetonow.setEditable(false);
        wyswietlaczZetonow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        wyswietlaczZetonow.setFont(new Font("Arial", Font.BOLD, 14));
        wyswietlaczZetonow.setHorizontalAlignment(SwingConstants.CENTER);

    }

    public void dodaniePrzyciskuBet() {

        bet = new JButton("BET");

        bet.setFont(new Font("Arial", Font.BOLD, 16));
        bet.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        bet.setBounds(400, 70, 115, 31);
        bet.setBorderPainted(true);
        bet.setContentAreaFilled(false);
        bet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public void dodaniePrzyciskuFold() {

        fold = new JButton("FOLD");

        fold.setFont(new Font("Arial", Font.BOLD, 16));
        fold.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        fold.setBounds(400, 110, 115, 31);
        fold.setBorderPainted(true);
        fold.setContentAreaFilled(false);

    }

    public void dodaniePrzyciskuCall() {

        call = new JButton("CALL");

        call.setFont(new Font("Arial", Font.BOLD, 16));
        call.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        call.setBounds(400, 150, 115, 31);
        call.setBorderPainted(true);
        call.setContentAreaFilled(false);

    }

    public void dodaniePrzyciskuRaise() {

        raise = new JButton("RAISE");

        raise.setFont(new Font("Arial", Font.BOLD, 16));
        raise.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        raise.setBounds(400, 190, 115, 31);
        raise.setBorderPainted(true);
        raise.setContentAreaFilled(false);

    }

    public void dodaniePrzyciskuCheck() {

        check = new JButton("CHECK");

        check.setFont(new Font("Arial", Font.BOLD, 16));
        check.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        check.setBounds(400, 230, 115, 31);
        check.setBorderPainted(true);
        check.setContentAreaFilled(false);

    }

    public void dodaniePrzyciskuAllIn() {

        allIn = new JButton("ALL IN");

        allIn.setFont(new Font("Arial", Font.BOLD, 16));
        allIn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        allIn.setBounds(400, 270, 115, 31);
        allIn.setBorderPainted(true);
        allIn.setContentAreaFilled(false);

    }

    public void dodaniePolaStawkiRaise() {

        raiseField = new JTextField();

        raiseField.setText("Podbicie stawki");
        raiseField.setBounds(520, 190, 115, 31);
        raiseField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        raiseField.setHorizontalAlignment(SwingConstants.CENTER);
        raiseField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1)
                    raiseField.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getButton() == 1)
                    raiseField.setText("");
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void listaKart() {

        listaObrazkow = new ArrayList<String>(); //lista z filepath

        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                listaObrazkow.add("images\\" + f.getFigura() + "_" + k.getWartosc() + ".jpg");
            }
        }
    }

    public void wyswietlenieKartGracza(int numerGracza) {

        kartygracza = new JLabel();

        List<Karta> testoweKarty = new ArrayList<Karta>();
        testoweKarty.add(new Karta(Kolor.KIER, Figura.AS));
        testoweKarty.add(new Karta(Kolor.TREFL, Figura.KROL));

        handCards = new ArrayList<Karta>(testoweKarty);
        //handCards = new ArrayList<Karta>(guiTalia.getListPlayerCards().get(numerGracza));

        kartygracza.setBounds(100, 100, 100, 100);
        kartygracza.setIcon(new ImageIcon(listaObrazkow.get(1)));
        kartygracza.setLayout(null);

        System.out.println(handCards);

    }

    public JTextField getWyswietlaczZetonow() {
        return wyswietlaczZetonow;
    }

    public void setWyswietlaczZetonow(String liczba) {
        wyswietlaczZetonow.setText(liczba);
    }
}
