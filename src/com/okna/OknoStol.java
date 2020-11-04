package com.okna;

import com.rozgrywka.Gracz;
import com.taliakart.Figura;
import com.taliakart.Karta;
import com.taliakart.Kolor;
import com.taliakart.Talia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OknoStol {

    private OknoGracze oknoGracze;

    private OknoStol me;

    private JFrame windowGame;
    private JPanel panelStart;
    private JPanel panelGame;

    private JButton przyciskStart;
    private JButton przyciskBetRaise;
    private JButton przyciskCheckCall;
    private JButton przyciskFold;
    private JButton przyciskPokazKarty;

    private JTextField wyswietlaczZetonow;
    private JTextField raiseField;

    private int gracze;

    private Talia taliaGUI;

    private List<String> listaObrazkow;
    private List<Karta> talia;

    private Random rand = new Random();

    private JLabel karty;
    private JLabel kartyFlop;
    private JLabel kartyTurnOrRiver;

    private int k1_1, k1_2, k2_1, k2_2;
    private int r, r1, rOut, rTurnOrRiver;
    private int f;

    private List<Karta> listaPlayer1 = new ArrayList<Karta>();
    private List<Karta> listaPlayer2 = new ArrayList<Karta>();
    private List<Karta> listaPlayer3 = new ArrayList<Karta>();
    private List<Karta> listaPlayer4 = new ArrayList<Karta>();
    private List<Karta> listaPlayer5 = new ArrayList<Karta>();
    private List<Karta> listaPlayer6 = new ArrayList<Karta>();
    private List<Karta> listaPlayer7 = new ArrayList<Karta>();
    private List<Karta> listaPlayer8 = new ArrayList<Karta>();

    private Gracz gracz1 = new Gracz();
    private Gracz gracz2 = new Gracz();
    private Gracz gracz3 = new Gracz();
    private Gracz gracz4 = new Gracz();
    private Gracz gracz5 = new Gracz();
    private Gracz gracz6 = new Gracz();
    private Gracz gracz7 = new Gracz();
    private Gracz gracz8 = new Gracz();

    private List<Gracz> listaRekaGraczy = new ArrayList<Gracz>();

    private List<List<Karta>> listPlayerCards = new ArrayList<List<Karta>>();

    private List<Karta> listaFlop;
    private List<Karta> listaTurnOrRiver;


    public OknoStol(OknoGracze oknoGracze) {
        this.oknoGracze = oknoGracze;
        me = this;

        gracze = oknoGracze.getGracze();

        listaTurnOrRiver = new ArrayList<Karta>();
        taliaGUI = new Talia();
        talia = taliaGUI.getTalia();

        //new BazaGracze(me);

        nowaRamka();

    }

    public void nowaRamka() {

        windowGame = new JFrame("POKER Texas Holden Game");
        windowGame.setVisible(true);
        windowGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowGame.pack();
        windowGame.setSize(1400, 760);

        dodaniePanelaStartowego();

        windowGame.add(panelStart);
    }

    public void dodaniePanelaStartowego() {

        panelStart = new BackgroundPanelGame();
        panelStart.setLayout(null);

        dodaniePrzyciskuStart();

        panelStart.add(przyciskStart);

    }

    public void dodaniePrzyciskuStart() {

        przyciskStart = new JButton("ROZDAJ KARTY");
        przyciskStart.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskStart.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskStart.setBounds(1200, 650, 170, 50);
        przyciskStart.setBorderPainted(true);
        przyciskStart.setContentAreaFilled(false);
        przyciskStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowGame.remove(panelStart);

                dodaniePanelaGame();

                rozdanieKart();

                windowGame.add(panelGame);
                windowGame.revalidate();

            }
        });
    }

    public void dodaniePanelaGame() {

        panelGame = new BackgroundPanelGame();
        panelGame.setLayout(null);

        dodaniePrzyciskuPokazKarty();

        panelGame.add(przyciskPokazKarty);
    }

    public void dodaniePrzyciskuPokazKarty() {

        przyciskPokazKarty = new JButton("POKAŻ KARTY");

        przyciskPokazKarty.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskPokazKarty.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskPokazKarty.setBounds(780, 670, 150, 50);
        przyciskPokazKarty.setBorderPainted(true);
        przyciskPokazKarty.setContentAreaFilled(false);
        przyciskPokazKarty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                przyciskPokazKarty.setVisible(false);

                dodaniePrzyciskowGracza();

                panelGame.repaint();
                windowGame.revalidate();
            }
        });
    }

    public void dodaniePrzyciskowGracza() {

        dodaniePrzyciskuBetRaise();

        dodaniePrzyciskuCheckCall();

        dodaniePrzyciskuFold();

        dodanieWyswietlaczaZetonow();

        dodaniePolaStawkiRaise();

        panelGame.add(przyciskBetRaise);
        panelGame.add(przyciskCheckCall);
        panelGame.add(przyciskFold);
        panelGame.add(wyswietlaczZetonow);
        panelGame.add(raiseField);

    }


    public void dodaniePrzyciskuBetRaise() {

        przyciskBetRaise = new JButton("BET/RAISE");

        przyciskBetRaise.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskBetRaise.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskBetRaise.setBounds(1200, 650, 170, 50);
        przyciskBetRaise.setBorderPainted(true);
        przyciskBetRaise.setContentAreaFilled(false);

    }

    public void dodaniePrzyciskuCheckCall() {

        przyciskCheckCall = new JButton("CHECK/CALL");

        przyciskCheckCall.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskCheckCall.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskCheckCall.setBounds(1200, 580, 170, 50);
        przyciskCheckCall.setBorderPainted(true);
        przyciskCheckCall.setContentAreaFilled(false);

    }

    public void dodaniePrzyciskuFold() {

        przyciskFold = new JButton("FOLD");

        przyciskFold.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskFold.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskFold.setBounds(1200, 510, 170, 50);
        przyciskFold.setBorderPainted(true);
        przyciskFold.setContentAreaFilled(false);

    }

    public void dodanieWyswietlaczaZetonow() {

        wyswietlaczZetonow = new JTextField();

        wyswietlaczZetonow.setBounds(1200, 440, 170, 50);
        wyswietlaczZetonow.setEditable(false);
        wyswietlaczZetonow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        wyswietlaczZetonow.setFont(new Font("Arial", Font.BOLD, 16));
        wyswietlaczZetonow.setHorizontalAlignment(SwingConstants.CENTER);

    }

    public void dodaniePolaStawkiRaise() {

        raiseField = new JTextField();

        raiseField.setText("Podbicie stawki");
        raiseField.setFont(new Font("Arial", Font.BOLD, 16));
        raiseField.setBounds(1010, 650, 170, 50);
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

    public void usunZTalii(List list, int liczba) {

        list.remove(list.get(liczba));
    }

    public void listaKart() {

        listaObrazkow = new ArrayList<String>();

        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                listaObrazkow.add("imagesHandView\\" + f.getFigura() + "_" + k.getWartosc() + ".jpg");
            }
        }
    }

    public void losowanieKart(int liczbaGraczy) {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < liczbaGraczy; j++) {

                r = rand.nextInt(talia.size());

                karty = new JLabel();
                karty.setIcon(new ImageIcon("Red_Back2.jpg"));
                karty.setLayout(null);

                if (i == 0) {
                    if (j < 3) {
                        karty.setBounds(780 - k1_1, 520, 90, 137);
                        k1_1 += 210;
                        if (j == 0)
                            listaPlayer1.add(talia.get(r));
                        if (j == 1)
                            listaPlayer2.add(talia.get(r));
                        if (j == 2)
                            listaPlayer3.add(talia.get(r));
                    }
                    if (j == 3) {
                        karty.setBounds(140, 285, 90, 137);
                        if (j == 3)
                            listaPlayer4.add(talia.get(r));
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(365 + k2_1, 55, 90, 137);
                        k2_1 += 210;
                        if (j == 4)
                            listaPlayer5.add(talia.get(r));
                        if (j == 5)
                            listaPlayer6.add(talia.get(r));
                        if (j == 6)
                            listaPlayer7.add(talia.get(r));
                    }
                    if (j == 7) {
                        karty.setBounds(1005, 285, 90, 137);
                        if (j == 7)
                            listaPlayer8.add(talia.get(r));
                    }
                }
                if (i == 1) {
                    if (j < 3) {
                        karty.setBounds(840 - k1_2, 520, 90, 137);
                        k1_2 += 210;
                        if (j == 0) {
                            listaPlayer1.add(talia.get(r));
                            gracz1.setKartyReka(listaPlayer1);
                            listaRekaGraczy.add(gracz1);
                            System.out.println("GRACZ 1" + (gracz1.getKartyReka()));
                        }
                        if (j == 1) {
                            listaPlayer2.add(talia.get(r));
                            gracz2.setKartyReka(listaPlayer2);
                            listaRekaGraczy.add(gracz2);
                            System.out.println("GRACZ 2" + (gracz2.getKartyReka()));

                        }
                        if (j == 2) {
                            listaPlayer3.add(talia.get(r));
                            gracz3.setKartyReka(listaPlayer3);
                            listaRekaGraczy.add(gracz3);
                            System.out.println("GRACZ 3" + (gracz3.getKartyReka()));

                        }
                    }
                    if (j == 3) {
                        karty.setBounds(200, 285, 90, 137);
                        if (j == 3) {
                            listaPlayer4.add(talia.get(r));
                            gracz4.setKartyReka(listaPlayer4);
                            listaRekaGraczy.add(gracz4);
                            System.out.println("GRACZ 4" + (gracz4.getKartyReka()));

                        }
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(425 + k2_2, 55, 90, 137);
                        k2_2 += 210;
                        if (j == 4) {
                            listaPlayer5.add(talia.get(r));
                            gracz5.setKartyReka(listaPlayer5);
                            listaRekaGraczy.add(gracz5);
                            System.out.println("GRACZ 5" + (gracz5.getKartyReka()));

                        }
                        if (j == 5) {
                            listaPlayer6.add(talia.get(r));
                            gracz6.setKartyReka(listaPlayer6);
                            listaRekaGraczy.add(gracz6);
                            System.out.println("GRACZ 6" + (gracz6.getKartyReka()));

                        }
                        if (j == 6) {
                            listaPlayer7.add(talia.get(r));
                            gracz7.setKartyReka(listaPlayer7);
                            listaRekaGraczy.add(gracz7);
                            System.out.println("GRACZ 7" + (gracz7.getKartyReka()));

                        }
                    }
                    if (j == 7) {
                        karty.setBounds(1065, 285, 90, 137);
                        if (j == 7) {
                            listaPlayer8.add(talia.get(r));
                            gracz8.setKartyReka(listaPlayer8);
                            listaRekaGraczy.add(gracz8);
                            System.out.println("GRACZ 8" + gracz8.getKartyReka());

                        }
                    }
                }
                usunZTalii(talia, r);
                usunZTalii(listaObrazkow, r);

                panelGame.add(karty);
            }
        }
    }

    public void rozdajFlop(List list) {

        listaFlop = new ArrayList<Karta>();

        rOut = rand.nextInt(list.size());

        usunZTalii(talia, rOut);
        usunZTalii(listaObrazkow, rOut);

        for (int i = 0; i < 3; i++) {

            r1 = rand.nextInt(list.size());

            kartyFlop = new JLabel();
            kartyFlop.setIcon(new ImageIcon(listaObrazkow.get(r1)));
            kartyFlop.setLayout(null);
            kartyFlop.setBounds(380 + f, 231, 90, 137);

            f += 50;

            listaFlop.add(talia.get(r1));

            usunZTalii(talia, r1);
            usunZTalii(listaObrazkow, r1);

            panelGame.add(kartyFlop);
        }
    }

    public void rozdajTurnOrRiver(List list) {


        rOut = rand.nextInt(list.size());

        usunZTalii(talia, rOut);
        usunZTalii(listaObrazkow, rOut);

        for (int i = 0; i < 1; i++) {

            rTurnOrRiver = rand.nextInt(list.size());

            kartyTurnOrRiver = new JLabel();
            kartyTurnOrRiver.setIcon(new ImageIcon(listaObrazkow.get(rTurnOrRiver)));
            kartyTurnOrRiver.setLayout(null);
            kartyTurnOrRiver.setBounds(380 + f, 231, 90, 137);

            f += 50;

            listaTurnOrRiver.add(talia.get(rTurnOrRiver));

            usunZTalii(talia, rTurnOrRiver);
            usunZTalii(listaObrazkow, rTurnOrRiver);

            panelGame.add(kartyTurnOrRiver);
        }
    }


    public void rozdanieKart() {

        listaKart();

        losowanieKart(gracze);

        //new RozgrywkaTest(me);

    }

    public JFrame getWindowGame() {
        return windowGame;
    }

    public void setWindowGame(JFrame windowGame) {
        this.windowGame = windowGame;
    }

    public int getGracze() {
        return gracze;
    }

    public void setGracze(int gracze) {
        this.gracze = gracze;
    }

    public JPanel getPanelStart() {
        return panelStart;
    }

    public void setPanelStart(JPanel panelStart) {
        this.panelStart = panelStart;
    }

    public JPanel getPanelGame() {
        return panelGame;
    }

    public void setPanelGame(JPanel panelGame) {
        this.panelGame = panelGame;
    }
}
