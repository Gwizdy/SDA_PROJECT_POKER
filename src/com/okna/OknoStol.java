package com.okna;

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

    private JTextField wyswietlaczZetonow;
    private JTextField raiseField;

    private List<String> listaObrazkow;
    private List<String> listaObrazkow2;
    private List<Karta> talia;

    private Random rand = new Random();

    private List<JLabel> listakarty;

    private JLabel karty;
    private JLabel kartyFlop;
    private JLabel kartyTurnOrRiver;
    private JLabel kartygracza1;
    private JLabel kartygracza2;

    private List<Karta> listaPlayer1 = new ArrayList<Karta>();
    private List<Karta> listaPlayer2 = new ArrayList<Karta>();
    private List<Karta> listaPlayer3 = new ArrayList<Karta>();
    private List<Karta> listaPlayer4 = new ArrayList<Karta>();
    private List<Karta> listaPlayer5 = new ArrayList<Karta>();
    private List<Karta> listaPlayer6 = new ArrayList<Karta>();
    private List<Karta> listaPlayer7 = new ArrayList<Karta>();
    private List<Karta> listaPlayer8 = new ArrayList<Karta>();

    private List<List<Karta>> listPlayerCards = new ArrayList<List<Karta>>();

    private Gracz gracz1 = new Gracz();
    private Gracz gracz2 = new Gracz();
    private Gracz gracz3 = new Gracz();
    private Gracz gracz4 = new Gracz();
    private Gracz gracz5 = new Gracz();
    private Gracz gracz6 = new Gracz();
    private Gracz gracz7 = new Gracz();
    private Gracz gracz8 = new Gracz();

    private List<Gracz> listaRekaGraczy = new ArrayList<Gracz>();

    private List<Karta> listaFlop;
    private List<Karta> listaTurnOrRiver;
    private List<Karta> handCards = new ArrayList<Karta>();

    private int pomoc;
    private int rozdanieNaStole;
    private int gracze;
    private int k1_1, k1_2, k2_1, k2_2;
    private int r, r1, rOut, rTurnOrRiver;
    private int f;

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

    public void dodaniePrzyciskuPokazKarty() {

        przyciskPokazKarty = new JButton("POKAŻ KARTY");

        przyciskPokazKarty.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskPokazKarty.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        if (pomoc == 0) {
            przyciskPokazKarty.setBounds(780, 670, 150, 50);
        } else if (pomoc == 1) {
            przyciskPokazKarty.setBounds(570, 670, 150, 50);
        } else if (pomoc == 2) {
            przyciskPokazKarty.setBounds(360, 670, 150, 50);
        } else if (pomoc == 3) {
            przyciskPokazKarty.setBounds(140, 435, 150, 50);
        } else if (pomoc == 4) {
            przyciskPokazKarty.setBounds(365, 7, 150, 50);
        } else if (pomoc == 5) {
            przyciskPokazKarty.setBounds(575, 7, 150, 50);
        } else if (pomoc == 6) {
            przyciskPokazKarty.setBounds(785, 7, 150, 50);
        } else if (pomoc == 7) {
            przyciskPokazKarty.setBounds(1005, 435, 150, 50);
        }
        przyciskPokazKarty.setBorderPainted(true);
        przyciskPokazKarty.setContentAreaFilled(false);
        przyciskPokazKarty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelGame.remove(przyciskPokazKarty);

                listakarty.get(pomoc).setVisible(false);
                listakarty.get(pomoc + gracze).setVisible(false);

                dodaniePrzyciskowGracza();

                wyswietlenieKartGracza(listaRekaGraczy);

                panelGame.repaint();
                panelGame.revalidate();
            }
        });
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
        przyciskFold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pomoc < gracze) {

                    usunPrzyciskiPokazRewers();

                    dodaniePrzyciskuPokazKarty();

                    panelGame.add(przyciskPokazKarty);

                    panelGame.repaint();

                } else if (pomoc == gracze) {

                    if (rozdanieNaStole == 0) {

                        System.out.println(pomoc + " fuck :)" + rozdanieNaStole);

                        usunPrzyciskiPokazRewers();

                        dodaniePrzyciskuRozdajFlop();

                        panelGame.add(przyciskRozdajFlop);

                        pomoc = 0;

                        panelGame.repaint();

                        rozdanieNaStole += 1;

                    } else if (rozdanieNaStole == 1) {

                        System.out.println(pomoc + "turn" + rozdanieNaStole);

                        usunPrzyciskiPokazRewers();

                        dodaniePrzyciskuRozdajTurn();

                        panelGame.add(przyciskRozdajTurn);

                        panelGame.repaint();

                        rozdanieNaStole += 1;

                        pomoc = 0;

                    } else if (rozdanieNaStole == 2) {

                        System.out.println(pomoc + "river" + rozdanieNaStole);

                        usunPrzyciskiPokazRewers();

                        dodaniePrzyciskuRozdajRiver();

                        panelGame.add(przyciskRozdajRiver);

                        panelGame.repaint();

                        rozdanieNaStole += 1;

                        pomoc = 0;

                    } else {

                        usunPrzyciskiPokazRewers();

                        dodaniePrzyciskuSprawdzam();

                        panelGame.add(przyciskSprawdzam);

                        panelGame.repaint();

                        pomoc = 0;
                    }
                } else {

                    panelGame.revalidate();

                    System.out.println("to był ostatni gracz");
                }

            }
        });

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

                panelGame.add(przyciskPokazKarty);

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

                panelGame.add(przyciskPokazKarty);

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

                panelGame.add(przyciskPokazKarty);

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

                pomoc = 0;

                for (int i = 0 ; i < gracze; i++){
                    listakarty.get(pomoc).setVisible(false);
                    listakarty.get(pomoc + gracze).setVisible(false);

                    wyswietlenieKartGracza(listaRekaGraczy);

                }

                new Sprawdzenie(me);

                panelGame.repaint();

            }
        });
    }

    public void usunPrzyciskiPokazRewers() {

        przyciskBetRaise.setVisible(false);
        przyciskCheckCall.setVisible(false);
        przyciskFold.setVisible(false);
        wyswietlaczZetonow.setVisible(false);
        raiseField.setVisible(false);

        panelGame.remove(kartygracza1);
        panelGame.remove(kartygracza2);

        listakarty.get(pomoc - 1).setVisible(true);
        listakarty.get(pomoc + gracze - 1).setVisible(true);

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

        listakarty = new ArrayList<JLabel>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < liczbaGraczy; j++) {

                r = rand.nextInt(talia.size());

                karty = new JLabel();
                karty.setIcon(new ImageIcon("Red_Back2.jpg"));
                karty.setLayout(null);

                if (i == 0) {
                    if (j < 3) {
                        karty.setBounds(780 - k1_1, 530, 90, 137);
                        k1_1 += 210;
                        if (j == 0) {
                            listaPlayer1.add(talia.get(r));
                            listakarty.add(karty);
                        }
                        if (j == 1) {
                            listaPlayer2.add(talia.get(r));
                            listakarty.add(karty);
                        }
                        if (j == 2) {
                            listaPlayer3.add(talia.get(r));
                            listakarty.add(karty);
                        }
                    }
                    if (j == 3) {
                        karty.setBounds(140, 295, 90, 137);
                        if (j == 3) {
                            listaPlayer4.add(talia.get(r));
                            listakarty.add(karty);
                        }
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(365 + k2_1, 65, 90, 137);
                        k2_1 += 210;
                        if (j == 4) {
                            listaPlayer5.add(talia.get(r));
                            listakarty.add(karty);
                        }
                        if (j == 5) {
                            listaPlayer6.add(talia.get(r));
                            listakarty.add(karty);
                        }
                        if (j == 6) {
                            listaPlayer7.add(talia.get(r));
                            listakarty.add(karty);
                        }
                    }
                    if (j == 7) {
                        karty.setBounds(1005, 295, 90, 137);
                        if (j == 7) {
                            listaPlayer8.add(talia.get(r));
                            listakarty.add(karty);
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
                            listakarty.add(karty);
                            System.out.println("GRACZ 1" + (gracz1.getKartyReka()));
                        }
                        if (j == 1) {
                            listaPlayer2.add(talia.get(r));
                            gracz2.setKartyReka(listaPlayer2);
                            listaRekaGraczy.add(gracz2);
                            listakarty.add(karty);
                            System.out.println("GRACZ 2" + (gracz2.getKartyReka()));

                        }
                        if (j == 2) {
                            listaPlayer3.add(talia.get(r));
                            gracz3.setKartyReka(listaPlayer3);
                            listaRekaGraczy.add(gracz3);
                            listakarty.add(karty);
                            System.out.println("GRACZ 3" + (gracz3.getKartyReka()));

                        }
                    }
                    if (j == 3) {
                        karty.setBounds(200, 295, 90, 137);
                        if (j == 3) {
                            listaPlayer4.add(talia.get(r));
                            gracz4.setKartyReka(listaPlayer4);
                            listaRekaGraczy.add(gracz4);
                            listakarty.add(karty);
                            System.out.println("GRACZ 4" + (gracz4.getKartyReka()));

                        }
                    }
                    if (j > 3 && j < 7) {
                        karty.setBounds(425 + k2_2, 65, 90, 137);
                        k2_2 += 210;
                        if (j == 4) {
                            listaPlayer5.add(talia.get(r));
                            gracz5.setKartyReka(listaPlayer5);
                            listaRekaGraczy.add(gracz5);
                            listakarty.add(karty);
                            System.out.println("GRACZ 5" + (gracz5.getKartyReka()));

                        }
                        if (j == 5) {
                            listaPlayer6.add(talia.get(r));
                            gracz6.setKartyReka(listaPlayer6);
                            listaRekaGraczy.add(gracz6);
                            listakarty.add(karty);
                            System.out.println("GRACZ 6" + (gracz6.getKartyReka()));

                        }
                        if (j == 6) {
                            listaPlayer7.add(talia.get(r));
                            gracz7.setKartyReka(listaPlayer7);
                            listaRekaGraczy.add(gracz7);
                            listakarty.add(karty);
                            System.out.println("GRACZ 7" + (gracz7.getKartyReka()));

                        }
                    }
                    if (j == 7) {
                        karty.setBounds(1065, 295, 90, 137);
                        if (j == 7) {
                            listaPlayer8.add(talia.get(r));
                            gracz8.setKartyReka(listaPlayer8);
                            listaRekaGraczy.add(gracz8);
                            listakarty.add(karty);
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

    public void rozdanieKart() {

        listaKart();

        losowanieKart(gracze);

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

        handCards.removeAll(handCards);
        pomoc += 1;

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
            kartyFlop.setBounds(390 + f, 290, 90, 137);

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
            kartyTurnOrRiver.setBounds(390 + f, 290, 90, 137);

            f += 100;

            listaTurnOrRiver.add(talia.get(rTurnOrRiver));

            usunZTalii(talia, rTurnOrRiver);
            usunZTalii(listaObrazkow, rTurnOrRiver);

            panelGame.add(kartyTurnOrRiver);
        }
    }

    public List<Gracz> getListaRekaGraczy() {
        return listaRekaGraczy;
    }

    public void setListaRekaGraczy(List<Gracz> listaRekaGraczy) {
        this.listaRekaGraczy = listaRekaGraczy;
    }

    public int getGracze() {
        return gracze;
    }

    public void setGracze(int gracze) {
        this.gracze = gracze;
    }

    public List<Karta> getListaFlop() {
        return listaFlop;
    }

    public void setListaFlop(List<Karta> listaFlop) {
        this.listaFlop = listaFlop;
    }

    public List<Karta> getListaTurnOrRiver() {
        return listaTurnOrRiver;
    }

    public void setListaTurnOrRiver(List<Karta> listaTurnOrRiver) {
        this.listaTurnOrRiver = listaTurnOrRiver;
    }
}
