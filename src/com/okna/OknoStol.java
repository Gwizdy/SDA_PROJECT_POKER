package com.okna;

import com.baza.BazaOdczyt;
import com.baza.BazaTruncate;
import com.rozgrywka.Gracz;
import com.sprawdzanie.Sprawdzenie;
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

    private BazaOdczyt bazaOdczyt;
    private BazaTruncate bazaTruncate;

    private OknoStol me;

    private Talia taliaGUI;

    private JFrame windowGame;

    private JPanel panelStart;
    private JPanel panelGame;

    private JButton przyciskStart;
    private JButton przyciskBetRaise;
    private JButton przyciskCheckCall;
    private JButton przyciskFold;
    private JButton przyciskPokazKarty;
    private JButton przyciskRozdajFlop;
    private JButton przyciskRozdajTurn;
    private JButton przyciskRozdajRiver;
    private JButton przyciskSprawdzam;
    private JButton przyciskRozdajPonownie;
    private JButton przyciskAllIn;

    private JTextField wyswietlaczZetonow;
    private JTextField stawkaGracza;
    private JTextField raiseField;
    private JTextField zetonyGracza;
    private JTextField poleZetonyWGrze;
    private JTextField imionaGraczy;

    private List<JTextField> wyswietlaczZetonowGracza;
    private List<JTextField> wyswietlaczStawkiGracza;

    private List<String> listaObrazkow;
    private List<String> listaObrazkow2;
    private List<Karta> talia;

    private Random rand = new Random();

    private List<JLabel> listaKarty;

    private JLabel karty;
    private JLabel kartyFlop;
    private JLabel kartyTurnOrRiver;
    private JLabel kartygracza1;
    private JLabel kartygracza2;
    private JLabel kartyNull;
    private JLabel dealer;

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
    private Gracz graczWidmo = new Gracz();

    private List<Gracz> listaRekaGraczy = new ArrayList<Gracz>();
    private List<Gracz> listaZetonowGraczy = new ArrayList<Gracz>();
    private List<Gracz> listaFoldow = new ArrayList<Gracz>();
    private List<Gracz> listaAllIn = new ArrayList<Gracz>();
    private List<Gracz> listaCzyWGrze = new ArrayList<Gracz>();

    private List<String> listaImionGraczy;

    private List<Karta> listaFlop;
    private List<Karta> listaTurnOrRiver;
    private List<Karta> handCards = new ArrayList<Karta>();

    private int pomoc, przejsciePoGraczach, minStawka, graczDealer, graczSmallBlind, graczBigBlind, blindValue, iloscGraczyWGrze, liczbaRund;
    private int rozdanieNaStole;
    private int gracze;
    private int k1_1, k1_2, k2_1, k2_2;
    private int r, r1, rOut, rTurnOrRiver;
    private int f;
    private int z1, z2, z3;
    private int s1, s2, s3;
    private int p1, p2, p3;
    private int licznik;

    public OknoStol(OknoGracze oknoGracze) {
        this.oknoGracze = oknoGracze;
        me = this;

        gracze = oknoGracze.getGracze();

        listaTurnOrRiver = new ArrayList<Karta>();
        taliaGUI = new Talia();
        talia = taliaGUI.getTalia();

        iloscGraczyWGrze = gracze;
        blindValue = 20;

        listaGraczeZetonyNaStart(listaZetonowGraczy);

        listaGraczeCzyWGrze(listaCzyWGrze);

        ustawienieFoldowGraczy(listaFoldow);

        ustawienieAllInGraczy(listaAllIn);

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

    public void dodanieTabeliZWYnikami() {

        bazaOdczyt = new BazaOdczyt();

        panelGame.add(bazaOdczyt.getTabela());

    }

    public void dodaniePanelaStartowego() {

        panelStart = new BackgroundPanelGame();
        panelStart.setLayout(null);

        dodaniePrzyciskuStart();

        panelStart.add(przyciskStart);

    }

    public void dodaniePrzyciskuStart() {

        bazaTruncate = new BazaTruncate();

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

        dodaniePolaZetonow();

        dodaniePolaStawkiGracza();

        dodaniePolaZetonowWGrze();

        dodanieWyswietleniaImionGraczy();

        dodanieDealera();

        dodanieTabeliZWYnikami();

    }

    public void dodaniePrzyciskowGracza() {

        dodaniePrzyciskuBetRaise();

        dodaniePrzyciskuAllIn();

        dodaniePrzyciskuCheckCall();

        dodaniePrzyciskuFold();

        dodanieWyswietlaczaZetonow();

        dodaniePolaStawkiRaise();

        panelGame.add(przyciskBetRaise);
        panelGame.add(przyciskAllIn);
        panelGame.add(przyciskCheckCall);
        panelGame.add(przyciskFold);
        panelGame.add(wyswietlaczZetonow);
        panelGame.add(raiseField);

    }

    public void dodanieDealera() {

        dealer = new JLabel();

        dealer.setIcon(new ImageIcon("images\\Dealer.jpg"));
        dealer.setLayout(null);

        if (graczDealer == 0) {
            dealer.setBounds(910, 472, 30, 30);
        } else if (graczDealer == 1) {
            dealer.setBounds(700, 472, 30, 30);
        } else if (graczDealer == 2) {
            dealer.setBounds(490, 472, 30, 30);
        } else if (graczDealer == 3) {
            dealer.setBounds(275, 237, 30, 30);
        } else if (graczDealer == 4) {
            dealer.setBounds(360, 228, 30, 30);
        } else if (graczDealer == 5) {
            dealer.setBounds(570, 228, 30, 30);
        } else if (graczDealer == 6) {
            dealer.setBounds(780, 228, 30, 30);
        } else if (graczDealer == 7) {
            dealer.setBounds(1135, 237, 30, 30);
        }

        panelGame.add(dealer);

    }

    public void dodaniePrzyciskuPokazKarty() {

        if (pomoc >= gracze) {
            pomoc = 0;
        }

        while (!listaFoldow.get(pomoc).isFoldGracza() || !listaAllIn.get(pomoc).isAllInGracza() || !listaCzyWGrze.get(pomoc).isCzyWGrze()) {

            pomoc += 1;

            if (pomoc == gracze) {
                pomoc = 0;
            }

            przejsciePoGraczach += 1;

            if (przejsciePoGraczach == gracze) {

                break;
            }
        }

        if (przejsciePoGraczach == gracze) {

            mechanizmRozgrywki();

        } else if (przejsciePoGraczach < gracze) {

            przyciskPokazKarty = new JButton("POKAŻ KARTY");

            przyciskPokazKarty.setFont(new Font("Arial", Font.BOLD, 16));
            przyciskPokazKarty.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));

            if (pomoc == 0 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(780, 670, 150, 50);
            } else if (pomoc == 1 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(570, 670, 150, 50);
            } else if (pomoc == 2 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(360, 670, 150, 50);
            } else if (pomoc == 3 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(140, 435, 150, 50);
            } else if (pomoc == 4 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(365, 7, 150, 50);
            } else if (pomoc == 5 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(575, 7, 150, 50);
            } else if (pomoc == 6 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(785, 7, 150, 50);
            } else if (pomoc == 7 && listaFoldow.get(pomoc).isFoldGracza() && listaAllIn.get(pomoc).isAllInGracza()) {
                przyciskPokazKarty.setBounds(1005, 435, 150, 50);
            }
            przyciskPokazKarty.setBorderPainted(true);
            przyciskPokazKarty.setContentAreaFilled(false);
            przyciskPokazKarty.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    panelGame.remove(przyciskPokazKarty);

                    listaKarty.get(pomoc).setVisible(false);
                    listaKarty.get(pomoc + gracze).setVisible(false);

                    dodaniePrzyciskowGracza();

                    wyswietlenieKartGracza(listaRekaGraczy);

                    panelGame.repaint();
                    panelGame.revalidate();
                }
            });
        }
    }

    public void dodanieWyswietleniaImionGraczy() {

        p1 = 0;
        p2 = 0;
        p3 = 0;

        listaImionGraczy = new ArrayList<String>();

        for (int i = 0; i < gracze; i++) {

            imionaGraczy = new JTextField();

            imionaGraczy.setVisible(true);
            imionaGraczy.setForeground(Color.white);
            imionaGraczy.setFont(new Font("Arial", Font.BOLD, 16));
            imionaGraczy.setHorizontalAlignment(SwingConstants.CENTER);
            imionaGraczy.setOpaque(false);

            if (i < 3) {
                imionaGraczy.setText(oknoGracze.getPlayer()[i].getText());
                imionaGraczy.setBounds(780 - p1, 505, 150, 20);
                p1 += 210;
                listaImionGraczy.add(oknoGracze.getPlayer()[i].getText());

            } else if (i == 3 || i == 7) {
                imionaGraczy.setText(oknoGracze.getPlayer()[i].getText());
                imionaGraczy.setBounds(140 + p2, 270, 150, 20);
                p2 += 865;
                listaImionGraczy.add(oknoGracze.getPlayer()[i].getText());

            } else if (i > 3 && i < 7) {
                imionaGraczy.setText(oknoGracze.getPlayer()[i].getText());
                imionaGraczy.setBounds(365 + p3, 205, 150, 20);
                p3 += 210;
                listaImionGraczy.add(oknoGracze.getPlayer()[i].getText());

            }

            panelGame.add(imionaGraczy);
        }
    }

    public void dodaniePolaStawkiGracza() {

        s1 = 0;
        s2 = 0;
        s3 = 0;

        wyswietlaczStawkiGracza = new ArrayList<JTextField>();

        for (int i = 0; i < gracze; i++) {

            stawkaGracza = new JTextField();
            stawkaGracza.setEditable(false);
            stawkaGracza.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            stawkaGracza.setFont(new Font("Arial", Font.BOLD, 8));
            stawkaGracza.setHorizontalAlignment(SwingConstants.CENTER);
            stawkaGracza.setOpaque(false);
            stawkaGracza.setForeground(Color.white);

            if (i < 3) {
                stawkaGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyStawkaGracza()));
                stawkaGracza.setBounds(820 - s1, 450, 70, 20);
                s1 += 210;

            } else if (i == 3 || i == 7) {
                stawkaGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyStawkaGracza()));
                stawkaGracza.setBounds(180 + s2, 215, 70, 20);
                s2 += 860;

            } else if (i > 3 && i < 7) {
                stawkaGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyStawkaGracza()));
                stawkaGracza.setBounds(410 + s3, 260, 70, 20);
                s3 += 210;

            }
            wyswietlaczStawkiGracza.add(stawkaGracza);

            panelGame.add(stawkaGracza);
        }
    }

    public void dodaniePolaZetonow() {

        z1 = 0;
        z2 = 0;
        z3 = 0;

        wyswietlaczZetonow = new JTextField();

        wyswietlaczZetonowGracza = new ArrayList<JTextField>();

        for (int i = 0; i < gracze; i++) {

            zetonyGracza = new JTextField();
            zetonyGracza.setEditable(false);
            zetonyGracza.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
            zetonyGracza.setFont(new Font("Arial", Font.BOLD, 16));
            zetonyGracza.setForeground(Color.white);
            zetonyGracza.setHorizontalAlignment(SwingConstants.CENTER);
            zetonyGracza.setOpaque(false);

            if (i < 3) {
                zetonyGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyPosiadane()));
                zetonyGracza.setBounds(805 - z1, 472, 100, 30);
                z1 += 210;

            } else if (i == 3 || i == 7) {
                zetonyGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyPosiadane()));
                zetonyGracza.setBounds(165 + z2, 237, 100, 30);
                z2 += 860;

            } else if (i > 3 && i < 7) {
                zetonyGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyPosiadane()));
                zetonyGracza.setBounds(395 + z3, 228, 100, 30);
                z3 += 210;

            }
            wyswietlaczZetonowGracza.add(zetonyGracza);

            panelGame.add(zetonyGracza);
        }

    }

    public void dodaniePolaZetonowWGrze() {

        poleZetonyWGrze = new JTextField();
        poleZetonyWGrze.setEditable(false);
        poleZetonyWGrze.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        poleZetonyWGrze.setFont(new Font("Arial", Font.BOLD, 16));
        poleZetonyWGrze.setHorizontalAlignment(SwingConstants.CENTER);
        poleZetonyWGrze.setBounds(630, 345, 100, 30);

        panelGame.add(poleZetonyWGrze);
    }

    public void dodaniePrzyciskuBetRaise() {

        przyciskBetRaise = new JButton("BET/RAISE");

        przyciskBetRaise.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskBetRaise.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskBetRaise.setBounds(1200, 650, 170, 50);
        przyciskBetRaise.setBorderPainted(true);
        przyciskBetRaise.setContentAreaFilled(false);
        przyciskBetRaise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!raiseField.getText().isEmpty() && Integer.parseInt(raiseField.getText()) != 0 &&
                            (Integer.parseInt(raiseField.getText()) < listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane()) &&
                            (Integer.parseInt(raiseField.getText()) + listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()) > minStawka &&
                            (Integer.parseInt(raiseField.getText())) < (listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane() + listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza())) {
                        listaZetonowGraczy.get(pomoc - 1).setZetonyPosiadane(listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane() - Integer.parseInt(raiseField.getText()));

                        listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + Integer.parseInt(raiseField.getText()));

                        wyswietlaczZetonowGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane()));

                        poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

                        listaZetonowGraczy.get(pomoc - 1).setZetonyStawkaGracza(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza() + Integer.parseInt(raiseField.getText()));

                        wyswietlaczStawkiGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()));

                        minStawka = listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza();

                        przejsciePoGraczach = 1;

                        mechanizmRozgrywki();

                    } else
                        new OknoOstrzezenieBetRaise();

                } catch (NumberFormatException ex) {

                    new OknoOstrzezenieBetRaise();

                }
            }
        });
    }

    public void dodaniePrzyciskuAllIn() {

        przyciskAllIn = new JButton("ALL IN");

        przyciskAllIn.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskAllIn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskAllIn.setBounds(1200, 580, 170, 50);
        przyciskAllIn.setBorderPainted(true);
        przyciskAllIn.setContentAreaFilled(false);
        przyciskAllIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane());

                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

                listaZetonowGraczy.get(pomoc - 1).setZetonyStawkaGracza(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza() + listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane());

                wyswietlaczStawkiGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()));

                listaZetonowGraczy.get(pomoc - 1).setZetonyPosiadane(0);

                wyswietlaczZetonowGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane()));


                if (listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza() > minStawka) {
                    minStawka = listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza();
                    przejsciePoGraczach = 1;
                }

                listaAllIn.get(pomoc - 1).setAllInGracza(false);

                mechanizmRozgrywki();

            }
        });

    }

    public void dodaniePrzyciskuCheckCall() {

        przyciskCheckCall = new JButton("CHECK/CALL");

        przyciskCheckCall.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskCheckCall.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskCheckCall.setBounds(1200, 510, 170, 50);
        przyciskCheckCall.setBorderPainted(true);
        przyciskCheckCall.setContentAreaFilled(false);
        przyciskCheckCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza() == minStawka) {

                    mechanizmRozgrywki();

                } else {
                    try {
                        if (listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane() + listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza() > minStawka) {

                            listaZetonowGraczy.get(pomoc - 1).setZetonyPosiadane(listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane() - (minStawka - listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()));

                            listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + (minStawka - listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()));

                            wyswietlaczZetonowGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane()));

                            poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

                            listaZetonowGraczy.get(pomoc - 1).setZetonyStawkaGracza(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza() + (minStawka - listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()));

                            wyswietlaczStawkiGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()));

                            mechanizmRozgrywki();

                        } else
                            new OknoOstrzezenieCheckCall();
                    } catch (NumberFormatException ex) {

                        new OknoOstrzezenieCheckCall();

                    }
                }
            }
        });
    }

    public void dodaniePrzyciskuFold() {

        przyciskFold = new JButton("FOLD");

        przyciskFold.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskFold.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskFold.setBounds(1200, 440, 170, 50);
        przyciskFold.setBorderPainted(true);
        przyciskFold.setContentAreaFilled(false);
        przyciskFold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaFoldow.get(pomoc - 1).setFoldGracza(false);

                listaKarty.get(pomoc - 1).setIcon(null);
                listaKarty.get(gracze + pomoc - 1).setIcon(null);

                mechanizmRozgrywki();

            }
        });
    }

    public void dodanieWyswietlaczaZetonow() {

        wyswietlaczZetonow = new JTextField();

        wyswietlaczZetonow.setBounds(1200, 370, 170, 50);
        wyswietlaczZetonow.setEditable(false);
        wyswietlaczZetonow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        wyswietlaczZetonow.setFont(new Font("Arial", Font.BOLD, 16));
        wyswietlaczZetonow.setHorizontalAlignment(SwingConstants.CENTER);

        if (pomoc == 0) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyPosiadane()));
        } else if (pomoc == 1) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(1).getZetonyPosiadane()));
        } else if (pomoc == 2) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(2).getZetonyPosiadane()));
        } else if (pomoc == 3) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(3).getZetonyPosiadane()));
        } else if (pomoc == 4) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(4).getZetonyPosiadane()));
        } else if (pomoc == 5) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(5).getZetonyPosiadane()));
        } else if (pomoc == 6) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(6).getZetonyPosiadane()));
        } else if (pomoc == 7) {
            wyswietlaczZetonow.setText(String.valueOf(listaZetonowGraczy.get(7).getZetonyPosiadane()));
        }

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

    public void dodaniePrzyciskuRozdajFlop() {

        przyciskRozdajFlop = new JButton("ROZDAJ FLOP");
        przyciskRozdajFlop.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskRozdajFlop.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskRozdajFlop.setBounds(1200, 650, 170, 50);
        przyciskRozdajFlop.setBorderPainted(true);
        przyciskRozdajFlop.setContentAreaFilled(false);
        przyciskRozdajFlop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rozdajFlop(talia);

                panelGame.remove(przyciskRozdajFlop);

                dodaniePrzyciskuPokazKarty();

                int tempPokazywanieKart = 0;

                for (int i = 0; i < gracze; i++) {
                    if (listaFoldow.get(i).isFoldGracza() && listaAllIn.get(i).isAllInGracza() && listaCzyWGrze.get(i).isCzyWGrze()) {
                        tempPokazywanieKart++;
                    }
                }
                if (tempPokazywanieKart > 0) {
                    panelGame.add(przyciskPokazKarty);
                } else {
                    panelGame.remove(przyciskPokazKarty);
                }

                panelGame.repaint();

            }
        });
    }

    public void dodaniePrzyciskuRozdajTurn() {

        przyciskRozdajTurn = new JButton("ROZDAJ TURN");

        przyciskRozdajTurn.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskRozdajTurn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskRozdajTurn.setBounds(1200, 650, 170, 50);
        przyciskRozdajTurn.setBorderPainted(true);
        przyciskRozdajTurn.setContentAreaFilled(false);
        przyciskRozdajTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rozdajTurnOrRiver(talia);

                panelGame.remove(przyciskRozdajTurn);

                dodaniePrzyciskuPokazKarty();

                int tempPokazywanieKart = 0;

                for (int i = 0; i < gracze; i++) {
                    if (listaFoldow.get(i).isFoldGracza() && listaAllIn.get(i).isAllInGracza() && listaCzyWGrze.get(i).isCzyWGrze()) {
                        tempPokazywanieKart++;
                    }
                }
                if (tempPokazywanieKart > 0) {
                    panelGame.add(przyciskPokazKarty);
                } else {
                    panelGame.remove(przyciskPokazKarty);
                }

                panelGame.repaint();

            }
        });
    }

    public void dodaniePrzyciskuRozdajRiver() {

        przyciskRozdajRiver = new JButton("ROZDAJ RIVER");

        przyciskRozdajRiver.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskRozdajRiver.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskRozdajRiver.setBounds(1200, 650, 170, 50);
        przyciskRozdajRiver.setBorderPainted(true);
        przyciskRozdajRiver.setContentAreaFilled(false);
        przyciskRozdajRiver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                rozdajTurnOrRiver(talia);

                panelGame.remove(przyciskRozdajRiver);

                dodaniePrzyciskuPokazKarty();

                int tempPokazywanieKart = 0;

                for (int i = 0; i < gracze; i++) {
                    if (listaFoldow.get(i).isFoldGracza() && listaAllIn.get(i).isAllInGracza() && listaCzyWGrze.get(i).isCzyWGrze()) {
                        tempPokazywanieKart++;
                    }
                }
                if (tempPokazywanieKart > 0) {
                    panelGame.add(przyciskPokazKarty);
                }


                panelGame.repaint();

            }
        });
    }

    public void dodaniePrzyciskuSprawdzam() {

        przyciskSprawdzam = new JButton("SPRAWDŹ KARTY");

        przyciskSprawdzam.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskSprawdzam.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskSprawdzam.setBounds(1200, 650, 170, 50);
        przyciskSprawdzam.setBorderPainted(true);
        przyciskSprawdzam.setContentAreaFilled(false);
        przyciskSprawdzam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelGame.remove(przyciskSprawdzam);

                for (int i = 0; i < gracze; i++) {
                    if (listaFoldow.get(i).isFoldGracza() == true) {

                        pomoc = i;

                        listaKarty.get(pomoc).setVisible(false);
                        listaKarty.get(pomoc + gracze).setVisible(false);

                        wyswietlenieKartGracza(listaRekaGraczy);
                    }
                }

                new Sprawdzenie(me);

                panelGame.repaint();

                licznik = 0;

                for (int i = 0; i < gracze; i++) {
                    if (listaZetonowGraczy.get(i).getZetonyPosiadane() == 0) {
                        licznik += 1;
                    }
                }

                if (licznik < gracze - 1) {

                    dodaniePrzyciskuRozdajPonownie();

                    panelGame.add(przyciskRozdajPonownie);

                    for (int i = 0; i < gracze; i++) {
                        if (listaZetonowGraczy.get(i).getZetonyPosiadane() == 0 && listaCzyWGrze.get(i).isCzyWGrze()) {
                            listaCzyWGrze.get(i).setCzyWGrze(false);
                            iloscGraczyWGrze -= 1;
                        }
                    }

                    panelGame.repaint();

                } else {

                    new Sprawdzenie(me);

                    windowGame.dispose();
                }
            }
        });
    }

    public void dodaniePrzyciskuRozdajPonownie() {

        przyciskRozdajPonownie = new JButton("ROZDAJ KARTY");

        przyciskRozdajPonownie.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskRozdajPonownie.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskRozdajPonownie.setBounds(1200, 650, 170, 50);
        przyciskRozdajPonownie.setBorderPainted(true);
        przyciskRozdajPonownie.setContentAreaFilled(false);
        przyciskRozdajPonownie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                listaObrazkow.removeAll(listaObrazkow);
                listaObrazkow2.removeAll(listaObrazkow2);
                listaFlop.removeAll(listaFlop);
                listaTurnOrRiver.removeAll(listaTurnOrRiver);
                listaPlayer1.removeAll(listaPlayer1);
                listaPlayer2.removeAll(listaPlayer2);
                listaPlayer3.removeAll(listaPlayer3);
                listaPlayer4.removeAll(listaPlayer4);
                listaPlayer5.removeAll(listaPlayer5);
                listaPlayer6.removeAll(listaPlayer6);
                listaPlayer7.removeAll(listaPlayer7);
                listaPlayer8.removeAll(listaPlayer8);
                listaKarty.removeAll(listaKarty);
                listaRekaGraczy.removeAll(listaRekaGraczy);
                talia.removeAll(talia);

                for (int i = 0; i < listaFoldow.size(); i++) {
                    listaFoldow.get(i).setFoldGracza(true);
                    listaZetonowGraczy.get(i).setZetonyStawkaGracza(0);
                    listaAllIn.get(i).setAllInGracza(true);
                }

                for (int i = 0; i < gracze; i++) {
                    if (!listaCzyWGrze.get(i).isCzyWGrze()) {
                        listaCzyWGrze.get(i).setCzyWGrze(false);
                        listaFoldow.get(i).setFoldGracza(false);
                        listaZetonowGraczy.get(i).setZetonyStawkaGracza(0);
                    }
                }

                przejsciePoGraczach = 0;

                rozdanieNaStole = 0;

                graczDealer += 1;

                f = 0;

                minStawka = 0;

                panelGame.removeAll();

                panelGame.repaint();

                taliaGUI = new Talia();
                talia = taliaGUI.getTalia();

                liczbaRund += 1;
                if (liczbaRund == 2) {
                    blindValue = blindValue * 2;
                    liczbaRund = 0;
                }
                dodanieTabeliZWYnikami();

                rozdanieKart();

                dodanieDealera();

                dodaniePolaZetonowWGrze();

                dodaniePolaZetonow();

                dodaniePolaStawkiGracza();

                dodanieWyswietleniaImionGraczy();

                panelGame.add(dealer);
                panelGame.add(poleZetonyWGrze);
                panelGame.add(przyciskPokazKarty);
                panelGame.add(imionaGraczy);
                panelGame.repaint();

            }
        });

    }

    public void usunPrzyciskiPokazRewers() {

        przyciskBetRaise.setVisible(false);
        przyciskAllIn.setVisible(false);
        przyciskCheckCall.setVisible(false);
        przyciskFold.setVisible(false);
        wyswietlaczZetonow.setVisible(false);
        raiseField.setVisible(false);

        panelGame.remove(kartygracza1);
        panelGame.remove(kartygracza2);

        listaKarty.get(pomoc - 1).setVisible(true);
        listaKarty.get(pomoc + gracze - 1).setVisible(true);

    }

    public void mechanizmRozgrywki() {

        if (przejsciePoGraczach < gracze) {
            while (!listaFoldow.get(pomoc).isFoldGracza() || !listaAllIn.get(pomoc).isAllInGracza() || !listaCzyWGrze.get(pomoc).isCzyWGrze()) {

                usunPrzyciskiPokazRewers();

                pomoc += 1;

                przejsciePoGraczach += 1;

            }
        }
        if (przejsciePoGraczach < gracze) {

            usunPrzyciskiPokazRewers();

            if (pomoc == gracze) {
                pomoc = 0;
            }


            dodaniePrzyciskuPokazKarty();

            int tempPokazywanieKart = 0;

            for (int i = 0; i < gracze; i++) {
                if (listaFoldow.get(i).isFoldGracza() && listaAllIn.get(i).isAllInGracza() && listaCzyWGrze.get(i).isCzyWGrze()) {
                    tempPokazywanieKart++;
                }
            }
            if (tempPokazywanieKart > 0 && przejsciePoGraczach != 0) {

                panelGame.add(przyciskPokazKarty);
            }

            panelGame.repaint();

        } else if (przejsciePoGraczach == gracze) {

            if (rozdanieNaStole == 0) {

                usunPrzyciskiPokazRewers();

                dodaniePrzyciskuRozdajFlop();

                panelGame.add(przyciskRozdajFlop);

                panelGame.repaint();

                rozdanieNaStole += 1;

                pomoc = graczDealer + 1;

                przejsciePoGraczach = 0;

            } else if (rozdanieNaStole == 1) {

                usunPrzyciskiPokazRewers();

                dodaniePrzyciskuRozdajTurn();

                panelGame.add(przyciskRozdajTurn);

                panelGame.repaint();

                rozdanieNaStole += 1;

                pomoc = graczDealer + 1;


                przejsciePoGraczach = 0;

            } else if (rozdanieNaStole == 2) {

                usunPrzyciskiPokazRewers();

                dodaniePrzyciskuRozdajRiver();

                panelGame.add(przyciskRozdajRiver);

                panelGame.repaint();

                rozdanieNaStole += 1;

                pomoc = graczDealer + 1;


                przejsciePoGraczach = 0;

            } else {

                usunPrzyciskiPokazRewers();

                dodaniePrzyciskuSprawdzam();

                panelGame.add(przyciskSprawdzam);

                panelGame.repaint();

                pomoc = 0;

                przejsciePoGraczach = 0;

            }
        }
    }

    public void ustawienieFoldowGraczy(List<Gracz> listaFoldow) {

        listaFoldow.add(gracz1);
        listaFoldow.add(gracz2);
        listaFoldow.add(gracz3);
        listaFoldow.add(gracz4);
        listaFoldow.add(gracz5);
        listaFoldow.add(gracz6);
        listaFoldow.add(gracz7);
        listaFoldow.add(gracz8);
        listaFoldow.add(graczWidmo);

        for (int i = 0; i < listaFoldow.size(); i++) {
            listaFoldow.get(i).setFoldGracza(true);
        }
    }

    public void ustawienieAllInGraczy(List<Gracz> listaAllIn) {

        listaAllIn.add(gracz1);
        listaAllIn.add(gracz2);
        listaAllIn.add(gracz3);
        listaAllIn.add(gracz4);
        listaAllIn.add(gracz5);
        listaAllIn.add(gracz6);
        listaAllIn.add(gracz7);
        listaAllIn.add(gracz8);
        listaAllIn.add(graczWidmo);

        for (int i = 0; i < listaAllIn.size(); i++) {
            listaAllIn.get(i).setAllInGracza(true);
        }
    }

    public void listaGraczeZetonyNaStart(List<Gracz> listaGraczyZetonyNaStart) {

        listaGraczyZetonyNaStart.add(gracz1);
        listaGraczyZetonyNaStart.add(gracz2);
        listaGraczyZetonyNaStart.add(gracz3);
        listaGraczyZetonyNaStart.add(gracz4);
        listaGraczyZetonyNaStart.add(gracz5);
        listaGraczyZetonyNaStart.add(gracz6);
        listaGraczyZetonyNaStart.add(gracz7);
        listaGraczyZetonyNaStart.add(gracz8);
        listaGraczyZetonyNaStart.add(graczWidmo);


        for (int i = 0; i < listaGraczyZetonyNaStart.size(); i++) {
            listaGraczyZetonyNaStart.get(i).setZetonyPosiadane(1000);
        }
    }

    public void listaGraczeCzyWGrze(List<Gracz> listaGraczyCzyWGrze) {

        listaGraczyCzyWGrze.add(gracz1);
        listaGraczyCzyWGrze.add(gracz2);
        listaGraczyCzyWGrze.add(gracz3);
        listaGraczyCzyWGrze.add(gracz4);
        listaGraczyCzyWGrze.add(gracz5);
        listaGraczyCzyWGrze.add(gracz6);
        listaGraczyCzyWGrze.add(gracz7);
        listaGraczyCzyWGrze.add(gracz8);
        listaGraczyCzyWGrze.add(graczWidmo);

        for (int i = 0; i < listaGraczyCzyWGrze.size(); i++) {
            listaGraczyCzyWGrze.get(i).setCzyWGrze(true);
        }
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

        listaKarty = new ArrayList<JLabel>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < liczbaGraczy; j++) {

                if (listaCzyWGrze.get(j).isCzyWGrze()) {

                    r = rand.nextInt(talia.size());

                    karty = new JLabel();

                    karty.setIcon(new ImageIcon("images\\Red_Back2.jpg"));
                    karty.setLayout(null);

                    if (i == 0) {
                        if (j < 3) {
                            karty.setBounds(780 - k1_1, 530, 90, 137);
                            k1_1 += 210;
                            if (j == 0) {
                                listaPlayer1.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                            if (j == 1) {
                                listaPlayer2.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                            if (j == 2) {
                                listaPlayer3.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                        }
                        if (j == 3) {
                            karty.setBounds(140, 295, 90, 137);
                            if (j == 3) {
                                listaPlayer4.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                        }
                        if (j > 3 && j < 7) {
                            karty.setBounds(365 + k2_1, 60, 90, 137);
                            k2_1 += 210;
                            if (j == 4) {
                                listaPlayer5.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                            if (j == 5) {
                                listaPlayer6.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                            if (j == 6) {
                                listaPlayer7.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                        }
                        if (j == 7) {
                            karty.setBounds(1005, 295, 90, 137);
                            if (j == 7) {
                                listaPlayer8.add(talia.get(r));
                                listaKarty.add(karty);
                            }
                        }
                    }
                    if (i == 1) {
                        if (j < 3) {
                            karty.setBounds(840 - k1_2, 530, 90, 137);
                            k1_2 += 210;
                            if (j == 0) {
                                listaPlayer1.add(talia.get(r));
                                gracz1.setKartyReka(listaPlayer1);
                                listaRekaGraczy.add(gracz1);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 1" + (gracz1.getKartyReka()));
                            }
                            if (j == 1) {
                                listaPlayer2.add(talia.get(r));
                                gracz2.setKartyReka(listaPlayer2);
                                listaRekaGraczy.add(gracz2);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 2" + (gracz2.getKartyReka()));
                            }
                            if (j == 2) {
                                listaPlayer3.add(talia.get(r));
                                gracz3.setKartyReka(listaPlayer3);
                                listaRekaGraczy.add(gracz3);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 3" + (gracz3.getKartyReka()));
                            }
                        }
                        if (j == 3) {
                            karty.setBounds(200, 295, 90, 137);
                            if (j == 3) {
                                listaPlayer4.add(talia.get(r));
                                gracz4.setKartyReka(listaPlayer4);
                                listaRekaGraczy.add(gracz4);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 4" + (gracz4.getKartyReka()));
                            }
                        }
                        if (j > 3 && j < 7) {
                            karty.setBounds(425 + k2_2, 60, 90, 137);
                            k2_2 += 210;
                            if (j == 4) {
                                listaPlayer5.add(talia.get(r));
                                gracz5.setKartyReka(listaPlayer5);
                                listaRekaGraczy.add(gracz5);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 5" + (gracz5.getKartyReka()));
                            }
                            if (j == 5) {
                                listaPlayer6.add(talia.get(r));
                                gracz6.setKartyReka(listaPlayer6);
                                listaRekaGraczy.add(gracz6);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 6" + (gracz6.getKartyReka()));
                            }
                            if (j == 6) {
                                listaPlayer7.add(talia.get(r));
                                gracz7.setKartyReka(listaPlayer7);
                                listaRekaGraczy.add(gracz7);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 7" + (gracz7.getKartyReka()));
                            }
                        }
                        if (j == 7) {
                            karty.setBounds(1065, 295, 90, 137);
                            if (j == 7) {
                                listaPlayer8.add(talia.get(r));
                                gracz8.setKartyReka(listaPlayer8);
                                listaRekaGraczy.add(gracz8);
                                listaKarty.add(karty);
                                System.out.println("GRACZ 8" + gracz8.getKartyReka());
                            }
                        }
                    }
                    usunZTalii(talia, r);
                    usunZTalii(listaObrazkow, r);

                    panelGame.add(karty);

                } else {
                    if (!listaCzyWGrze.get(j).isCzyWGrze()) {

                        karty = new JLabel();

                        kartyNull = new JLabel();

                        karty.setIcon(new ImageIcon("images\\Red_Back2.jpg"));
                        karty.setLayout(null);

                        kartyNull.setLayout(null);

                        if (i == 0) {
                            if (j < 3) {
                                karty.setBounds(780 - k1_1, 530, 90, 137);
                                k1_1 += 210;
                                if (j == 0) {
                                    listaPlayer1.add(null);
                                    listaKarty.add(kartyNull);
                                }
                                if (j == 1) {
                                    listaPlayer2.add(null);
                                    listaKarty.add(kartyNull);
                                }
                                if (j == 2) {
                                    listaPlayer3.add(null);
                                    listaKarty.add(kartyNull);
                                }
                            }
                            if (j == 3) {
                                karty.setBounds(140, 295, 90, 137);
                                if (j == 3) {
                                    listaPlayer4.add(null);
                                    listaKarty.add(kartyNull);
                                }
                            }
                            if (j > 3 && j < 7) {
                                karty.setBounds(365 + k2_1, 60, 90, 137);
                                k2_1 += 210;
                                if (j == 4) {
                                    listaPlayer5.add(null);
                                    listaKarty.add(kartyNull);
                                }
                                if (j == 5) {
                                    listaPlayer6.add(null);
                                    listaKarty.add(kartyNull);
                                }
                                if (j == 6) {
                                    listaPlayer7.add(null);
                                    listaKarty.add(kartyNull);
                                }
                            }
                            if (j == 7) {
                                karty.setBounds(1005, 295, 90, 137);
                                if (j == 7) {
                                    listaPlayer8.add(talia.get(r));
                                    listaKarty.add(kartyNull);
                                }
                            }
                        }
                        if (i == 1) {
                            if (j < 3) {
                                karty.setBounds(840 - k1_2, 530, 90, 137);
                                k1_2 += 210;
                                if (j == 0) {
                                    listaPlayer1.add(null);
                                    gracz1.setKartyReka(listaPlayer1);
                                    listaRekaGraczy.add(gracz1);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 1" + (gracz1.getKartyReka()));
                                }
                                if (j == 1) {
                                    listaPlayer2.add(null);
                                    gracz2.setKartyReka(listaPlayer2);
                                    listaRekaGraczy.add(gracz2);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 2" + (gracz2.getKartyReka()));
                                }
                                if (j == 2) {
                                    listaPlayer3.add(null);
                                    gracz3.setKartyReka(listaPlayer3);
                                    listaRekaGraczy.add(gracz3);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 3" + (gracz3.getKartyReka()));
                                }
                            }
                            if (j == 3) {
                                karty.setBounds(200, 295, 90, 137);
                                if (j == 3) {
                                    listaPlayer4.add(null);
                                    gracz4.setKartyReka(listaPlayer4);
                                    listaRekaGraczy.add(gracz4);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 4" + (gracz4.getKartyReka()));
                                }
                            }
                            if (j > 3 && j < 7) {
                                karty.setBounds(425 + k2_2, 60, 90, 137);
                                k2_2 += 210;
                                if (j == 4) {
                                    listaPlayer5.add(null);
                                    gracz5.setKartyReka(listaPlayer5);
                                    listaRekaGraczy.add(gracz5);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 5" + (gracz5.getKartyReka()));
                                }
                                if (j == 5) {
                                    listaPlayer6.add(null);
                                    gracz6.setKartyReka(listaPlayer6);
                                    listaRekaGraczy.add(gracz6);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 6" + (gracz6.getKartyReka()));
                                }
                                if (j == 6) {
                                    listaPlayer7.add(null);
                                    gracz7.setKartyReka(listaPlayer7);
                                    listaRekaGraczy.add(gracz7);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 7" + (gracz7.getKartyReka()));
                                }
                            }
                            if (j == 7) {
                                karty.setBounds(1065, 295, 90, 137);
                                if (j == 7) {
                                    listaPlayer8.add(null);
                                    gracz8.setKartyReka(listaPlayer8);
                                    listaRekaGraczy.add(gracz8);
                                    listaKarty.add(kartyNull);
                                    System.out.println("GRACZ 8" + gracz8.getKartyReka());
                                }
                            }
                        }
                        panelGame.add(kartyNull);
                    }

                }
            }
        }
        k1_1 = 0;
        k1_2 = 0;
        k2_1 = 0;
        k2_2 = 0;
    }

    public void rozdanieKart() {

        listaKart();

        losowanieKart(gracze);

        dealerSmallBigBlind();

        dodaniePrzyciskuPokazKarty();

        panelGame.add(przyciskPokazKarty);

        panelGame.repaint();

    }

    public void wyswietlenieKartGracza(List<Gracz> listaGraczy) {

        int pozycja = 0;

        listaObrazkow2 = new ArrayList<String>();

        handCards.addAll(listaGraczy.get(pomoc).getKartyReka());

        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                listaObrazkow2.add("imagesHandView\\" + f.getFigura() + "_" + k.getWartosc() + ".jpg");
                if ((handCards.get(0).getFigura() == f.getFigura()) && (handCards.get(0).getKolor().getWartosc() == k.getWartosc())) {
                    kartygracza1 = new JLabel();
                    kartygracza1.setLayout(null);
                    kartygracza1.setIcon(new ImageIcon(listaObrazkow2.get(pozycja)));
                    if (pomoc == 0) {
                        kartygracza1.setBounds(780, 530, 90, 137);
                    } else if (pomoc == 1) {
                        kartygracza1.setBounds(570, 530, 90, 137);
                    } else if (pomoc == 2) {
                        kartygracza1.setBounds(360, 530, 90, 137);
                    } else if (pomoc == 3) {
                        kartygracza1.setBounds(140, 295, 90, 137);
                    } else if (pomoc == 4) {
                        kartygracza1.setBounds(365, 65, 90, 137);
                    } else if (pomoc == 5) {
                        kartygracza1.setBounds(575, 65, 90, 137);
                    } else if (pomoc == 6) {
                        kartygracza1.setBounds(785, 65, 90, 137);
                    } else if (pomoc == 7) {
                        kartygracza1.setBounds(1005, 295, 90, 137);
                    }
                    panelGame.add(kartygracza1);
                }
                pozycja += 1;
            }
        }


        pozycja = 0;


        for (Kolor k : Kolor.values()) {
            for (Figura f : Figura.values()) {
                listaObrazkow2.add("imagesHandView\\" + f.getFigura() + "_" + k.getWartosc() + ".jpg");
                if ((handCards.get(1).getFigura() == f.getFigura()) && (handCards.get(1).getKolor().getWartosc() == k.getWartosc())) {
                    kartygracza2 = new JLabel();
                    kartygracza2.setLayout(null);
                    kartygracza2.setIcon(new ImageIcon(listaObrazkow2.get(pozycja)));
                    if (pomoc == 0) {
                        kartygracza2.setBounds(840, 530, 90, 137);
                    } else if (pomoc == 1) {
                        kartygracza2.setBounds(630, 530, 90, 137);
                    } else if (pomoc == 2) {
                        kartygracza2.setBounds(420, 530, 90, 137);
                    } else if (pomoc == 3) {
                        kartygracza2.setBounds(200, 295, 90, 137);
                    } else if (pomoc == 4) {
                        kartygracza2.setBounds(425, 65, 90, 137);
                    } else if (pomoc == 5) {
                        kartygracza2.setBounds(635, 65, 90, 137);
                    } else if (pomoc == 6) {
                        kartygracza2.setBounds(845, 65, 90, 137);
                    } else if (pomoc == 7) {
                        kartygracza2.setBounds(1065, 295, 90, 137);
                    }
                    panelGame.add(kartygracza2);
                }
                pozycja += 1;
            }
        }
        pomoc += 1;
        przejsciePoGraczach += 1;

        handCards.removeAll(handCards);

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
            kartyFlop.setBounds(320 + f, 290, 90, 137);

            f += 100;

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
            kartyTurnOrRiver.setBounds(450 + f, 290, 90, 137);

            f += 100;

            listaTurnOrRiver.add(talia.get(rTurnOrRiver));

            usunZTalii(talia, rTurnOrRiver);
            usunZTalii(listaObrazkow, rTurnOrRiver);

            panelGame.add(kartyTurnOrRiver);
        }
    }

    public void dealerSmallBigBlind() {

        if (iloscGraczyWGrze > 2) {
            if (graczDealer == gracze) {
                graczDealer = 0;
            }
            while (!listaCzyWGrze.get(graczDealer).isCzyWGrze()) {
                graczDealer++;
                if (graczDealer == gracze) {
                    graczDealer = 0;
                }
            }

            graczSmallBlind = graczDealer + 1;
            if (graczSmallBlind >= gracze) {
                graczSmallBlind = 0;
            }
            while (!listaCzyWGrze.get(graczSmallBlind).isCzyWGrze()) {
                graczSmallBlind++;
                if (graczSmallBlind == gracze) {
                    graczSmallBlind = 0;
                }
            }

            if (listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane() > blindValue / 2) {

                listaZetonowGraczy.get(graczSmallBlind).setZetonyPosiadane(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane() - blindValue / 2);

                wyswietlaczZetonowGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane()));

                listaZetonowGraczy.get(graczSmallBlind).setZetonyStawkaGracza(blindValue / 2);

                wyswietlaczStawkiGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza()));

                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza());

                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

            } else if (listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane() <= blindValue / 2) {

                listaZetonowGraczy.get(graczSmallBlind).setZetonyStawkaGracza(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane());

                wyswietlaczStawkiGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza()));

                listaZetonowGraczy.get(graczSmallBlind).setZetonyPosiadane(0);

                wyswietlaczZetonowGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane()));

                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza());

                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

                listaAllIn.get(graczSmallBlind).setAllInGracza(false);
            }

            graczBigBlind = graczSmallBlind + 1;

            if (graczBigBlind >= gracze) {
                graczBigBlind = 0;
            }
            while (!listaCzyWGrze.get(graczBigBlind).isCzyWGrze()) {

                graczBigBlind++;

                if (graczBigBlind == gracze) {
                    graczBigBlind = 0;
                }
            }

            if (listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane() > blindValue) {

                listaZetonowGraczy.get(graczBigBlind).setZetonyPosiadane(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane() - blindValue);
                wyswietlaczZetonowGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane()));
                listaZetonowGraczy.get(graczBigBlind).setZetonyStawkaGracza(blindValue);
                wyswietlaczStawkiGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza()));
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza());
                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

            } else if (listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane() <= blindValue) {

                listaZetonowGraczy.get(graczBigBlind).setZetonyStawkaGracza(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane());
                wyswietlaczStawkiGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza()));
                listaZetonowGraczy.get(graczBigBlind).setZetonyPosiadane(0);
                wyswietlaczZetonowGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane()));
                listaAllIn.get(graczBigBlind).setAllInGracza(false);
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza());
                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));
            }

            minStawka = blindValue;
            pomoc = graczBigBlind + 1;

            while (!listaCzyWGrze.get(pomoc).isCzyWGrze()) {
                pomoc++;
                if (pomoc == gracze) {
                    pomoc = 0;
                }
            }
        } else if (iloscGraczyWGrze == 2) {
            if (graczDealer >= gracze) {
                graczDealer = 0;
            }
            while (!listaCzyWGrze.get(graczDealer).isCzyWGrze()) {
                graczDealer++;
                if (graczDealer == gracze) {
                    graczDealer = 0;
                }
            }
            graczSmallBlind = graczDealer;
            pomoc = graczDealer;

            if (listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane() > blindValue / 2) {

                listaZetonowGraczy.get(graczSmallBlind).setZetonyPosiadane(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane() - blindValue / 2);
                wyswietlaczZetonowGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane()));
                listaZetonowGraczy.get(graczSmallBlind).setZetonyStawkaGracza(blindValue / 2);
                wyswietlaczStawkiGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza()));
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza());
                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

            } else if (listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane() <= blindValue / 2) {

                listaZetonowGraczy.get(graczSmallBlind).setZetonyStawkaGracza(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane());
                wyswietlaczStawkiGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza()));
                listaZetonowGraczy.get(graczSmallBlind).setZetonyPosiadane(0);
                wyswietlaczZetonowGracza.get(graczSmallBlind).setText(String.valueOf(listaZetonowGraczy.get(graczSmallBlind).getZetonyPosiadane()));
                listaAllIn.get(graczSmallBlind).setAllInGracza(false);
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczSmallBlind).getZetonyStawkaGracza());
                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

            }
            graczBigBlind = graczSmallBlind + 1;

            if (graczBigBlind >= gracze) {
                graczBigBlind = 0;
            }
            while (!listaCzyWGrze.get(graczBigBlind).isCzyWGrze()) {

                graczBigBlind++;

                if (graczBigBlind == gracze) {
                    graczBigBlind = 0;
                }
            }
            if (listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane() > blindValue) {

                listaZetonowGraczy.get(graczBigBlind).setZetonyPosiadane(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane() - blindValue);
                wyswietlaczZetonowGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane()));
                listaZetonowGraczy.get(graczBigBlind).setZetonyStawkaGracza(blindValue);
                wyswietlaczStawkiGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza()));
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza());
                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

            } else if (listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane() <= blindValue) {

                listaZetonowGraczy.get(graczBigBlind).setZetonyStawkaGracza(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane());
                wyswietlaczStawkiGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza()));
                listaZetonowGraczy.get(graczBigBlind).setZetonyPosiadane(0);
                wyswietlaczZetonowGracza.get(graczBigBlind).setText(String.valueOf(listaZetonowGraczy.get(graczBigBlind).getZetonyPosiadane()));
                listaAllIn.get(graczBigBlind).setAllInGracza(false);
                listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + listaZetonowGraczy.get(graczBigBlind).getZetonyStawkaGracza());
                poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));
            }

            minStawka = blindValue;
        }
    }

    public List<Gracz> getListaRekaGraczy() {
        return listaRekaGraczy;
    }

    public int getGracze() {
        return gracze;
    }

    public List<Karta> getListaFlop() {
        return listaFlop;
    }

    public List<Karta> getListaTurnOrRiver() {
        return listaTurnOrRiver;
    }

    public List<Gracz> getListaFoldow() {
        return listaFoldow;
    }

    public List<Gracz> getListaZetonowGraczy() {
        return listaZetonowGraczy;
    }

    public int getLicznik() {
        return licznik;
    }

    public List<String> getListaImionGraczy() {
        return listaImionGraczy;
    }

    public JTextField getImionaGraczy() {
        return imionaGraczy;
    }

    public JPanel getPanelGame() {
        return panelGame;
    }
}