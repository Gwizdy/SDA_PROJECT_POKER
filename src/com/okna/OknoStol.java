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
    private JButton przyciskRozdajPonownie;

    private JTextField wyswietlaczZetonow;
    private JTextField stawkaGracza;
    private JTextField raiseField;
    private JTextField zetonyGracza;
    private JTextField poleZetonyWGrze;

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
    private List<Gracz> listaZetonowGraczy = new ArrayList<Gracz>();
    private List<Gracz> listaFoldOrAllIn = new ArrayList<Gracz>();

    private List<Karta> listaFlop;
    private List<Karta> listaTurnOrRiver;
    private List<Karta> handCards = new ArrayList<Karta>();

    private int pomoc, przejsciePoGraczach;
    private int rozdanieNaStole;
    private int gracze;
    private int k1_1, k1_2, k2_1, k2_2;
    private int r, r1, rOut, rTurnOrRiver;
    private int f;
    private int z1, z2, z3;
    private int s1, s2, s3;

    private boolean rozdanieSkonczone;

    public OknoStol(OknoGracze oknoGracze) {
        this.oknoGracze = oknoGracze;
        me = this;

        gracze = oknoGracze.getGracze();

        listaTurnOrRiver = new ArrayList<Karta>();
        taliaGUI = new Talia();
        talia = taliaGUI.getTalia();

        listaGraczeZetonyNaStart(listaZetonowGraczy);
        listaGraczeFoldOrAllin(listaFoldOrAllIn); // na poczatku rozgrywki Fold i AllIn na 0

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

        rozdanieSkonczone = false;

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

        dodaniePolaZetonow();

        dodaniePolaStawkiGracza();

        dodaniePolaZetonowWGrze();

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

        while(listaFoldOrAllIn.get(pomoc).getFoldCheck() && pomoc < gracze){
            pomoc+=1;
            przejsciePoGraczach+=1;
        }
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

                listaKarty.get(pomoc).setVisible(false);
                listaKarty.get(pomoc + gracze).setVisible(false);

                dodaniePrzyciskowGracza();

                wyswietlenieKartGracza(listaRekaGraczy);

                panelGame.repaint();
                panelGame.revalidate();
            }
        });
    }

    public void dodaniePolaStawkiGracza() {

        s1 = 0;
        s2 = 0;
        s3 = 0;

        stawkaGracza = new JTextField();
        wyswietlaczStawkiGracza = new ArrayList<JTextField>();

        for (int i = 0; i < gracze; i++) {

            stawkaGracza = new JTextField();
            stawkaGracza.setEditable(false);
            stawkaGracza.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            stawkaGracza.setFont(new Font("Arial", Font.BOLD, 8));
            stawkaGracza.setHorizontalAlignment(SwingConstants.CENTER);

            if (i < 3) {
                stawkaGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyStawkaGracza()));
                stawkaGracza.setBounds(820 - s1, 465, 70, 20);
                s1 += 210;

            } else if (i == 3 || i == 7) {
                stawkaGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyStawkaGracza()));
                stawkaGracza.setBounds(180 + s2, 235, 70, 20);
                s2 += 860;

            } else if (i > 3 && i < 7) {
                stawkaGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyStawkaGracza()));
                stawkaGracza.setBounds(410 + s3, 245, 70, 20);
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
            zetonyGracza.setHorizontalAlignment(SwingConstants.CENTER);

            if (i < 3) {
                zetonyGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyPosiadane()));
                zetonyGracza.setBounds(805 - z1, 490, 100, 30);
                z1 += 210;

            } else if (i == 3 || i == 7) {
                zetonyGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyPosiadane()));
                zetonyGracza.setBounds(165 + z2, 260, 100, 30);
                z2 += 860;

            } else if (i > 3 && i < 7) {
                zetonyGracza.setText(String.valueOf(listaZetonowGraczy.get(i).getZetonyPosiadane()));
                zetonyGracza.setBounds(395 + z3, 210, 100, 30);
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

                usunPrzyciskiPokazRewers();

                try {
                    if (!raiseField.getText().isEmpty() && Integer.parseInt(raiseField.getText()) != 0 && (Integer.parseInt(raiseField.getText()) < listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane())) {

                        listaZetonowGraczy.get(pomoc - 1).setZetonyPosiadane(listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane() - Integer.parseInt(raiseField.getText()));

                        listaZetonowGraczy.get(0).setZetonyWGrze(listaZetonowGraczy.get(0).getZetonyWGrze() + Integer.parseInt(raiseField.getText()));

                        wyswietlaczZetonowGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyPosiadane()));

                        poleZetonyWGrze.setText(String.valueOf(listaZetonowGraczy.get(0).getZetonyWGrze()));

                        listaZetonowGraczy.get(pomoc - 1).setZetonyStawkaGracza(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza() + Integer.parseInt(raiseField.getText()));

                        wyswietlaczStawkiGracza.get(pomoc - 1).setText(String.valueOf(listaZetonowGraczy.get(pomoc - 1).getZetonyStawkaGracza()));

                        mechanizmRozgrywki();

                    } else
                        new OknoOstrzezenieBetRaise();

                } catch (NumberFormatException ex) {

                    new OknoOstrzezenieBetRaise();

                }
            }
        });

    }

    public void dodaniePrzyciskuCheckCall() {

        przyciskCheckCall = new JButton("CHECK/CALL");

        przyciskCheckCall.setFont(new Font("Arial", Font.BOLD, 16));
        przyciskCheckCall.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        przyciskCheckCall.setBounds(1200, 580, 170, 50);
        przyciskCheckCall.setBorderPainted(true);
        przyciskCheckCall.setContentAreaFilled(false);
        przyciskCheckCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                usunPrzyciskiPokazRewers();
                mechanizmRozgrywki();

            }
        });

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

                usunPrzyciskiPokazRewers();

                listaFoldOrAllIn.get(pomoc-1).setFoldCheck(true);
                mechanizmRozgrywki();

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

                panelGame.remove(przyciskSprawdzam);

                pomoc = 0;

                for (int i = 0; i < gracze; i++) {

                    listaKarty.get(pomoc).setVisible(false);
                    listaKarty.get(pomoc + gracze).setVisible(false);

                    wyswietlenieKartGracza(listaRekaGraczy);

                }

                dodaniePrzyciskuRozdajPonownie();

                panelGame.add(przyciskRozdajPonownie);

                for (int i = 0 ; i <gracze; i++){
                    System.out.println(i + " " + listaFoldOrAllIn.get(i).getFoldCheck());
                }

                new Sprawdzenie(me);

                panelGame.repaint();

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

                for (int i = 0; i < listaFoldOrAllIn.size(); i++) {
                    listaFoldOrAllIn.get(i).setFoldCheck(false);
                }

                for (int i = 0; i < listaFoldOrAllIn.size(); i++) {
                    listaFoldOrAllIn.get(i).setAllInCheck(false);
                }

                pomoc = 0;

                przejsciePoGraczach = 0;

                rozdanieNaStole = 0;

                f = 0;

                rozdanieSkonczone = false;

                panelGame.removeAll();
                panelGame.repaint();

                taliaGUI = new Talia();
                talia = taliaGUI.getTalia();

                rozdanieKart();

                dodaniePrzyciskuPokazKarty();

                dodaniePolaZetonowWGrze();

                dodaniePolaZetonow();

                panelGame.add(poleZetonyWGrze);
                panelGame.add(przyciskPokazKarty);
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

        listaKarty.get(pomoc - 1).setVisible(true);
        listaKarty.get(pomoc + gracze - 1).setVisible(true);

    }

    public void mechanizmRozgrywki() {

        while(listaFoldOrAllIn.get(pomoc).getFoldCheck() && przejsciePoGraczach<gracze){

            pomoc += 1;
            przejsciePoGraczach +=1;

            if(rozdanieNaStole == 3 && przejsciePoGraczach == gracze){

                usunPrzyciskiPokazRewers();

                dodaniePrzyciskuSprawdzam();

                rozdanieSkonczone = true;

                panelGame.add(przyciskSprawdzam);

                panelGame.repaint();

            }

            if (pomoc == gracze) {
                pomoc = 1;
            }
        }

        if(!listaFoldOrAllIn.get(pomoc).getFoldCheck() && !rozdanieSkonczone){
            if (przejsciePoGraczach < gracze) {

//                usunPrzyciskiPokazRewers();

                dodaniePrzyciskuPokazKarty();

                panelGame.add(przyciskPokazKarty);

                if (pomoc == gracze) {
                    pomoc = 0;
                }

                panelGame.repaint();

            } else if (przejsciePoGraczach == gracze) {

                if (rozdanieNaStole == 0) {

                    usunPrzyciskiPokazRewers();

                    dodaniePrzyciskuRozdajFlop();

                    panelGame.add(przyciskRozdajFlop);

                    panelGame.repaint();

                    rozdanieNaStole += 1;

                    pomoc = 0;

                    przejsciePoGraczach = 0;

                } else if (rozdanieNaStole == 1) {

                    System.out.println(pomoc + "turn" + rozdanieNaStole);

                    usunPrzyciskiPokazRewers();

                    dodaniePrzyciskuRozdajTurn();

                    panelGame.add(przyciskRozdajTurn);

                    panelGame.repaint();

                    rozdanieNaStole += 1;

                    pomoc = 0;

                    przejsciePoGraczach = 0;

                } else if (rozdanieNaStole == 2) {

                    System.out.println(pomoc + "river" + rozdanieNaStole);

                    usunPrzyciskiPokazRewers();

                    dodaniePrzyciskuRozdajRiver();

                    panelGame.add(przyciskRozdajRiver);

                    panelGame.repaint();

                    rozdanieNaStole += 1;

                    pomoc = 0;

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
    }

    public void listaGraczeFoldOrAllin(List<Gracz> listaGraczyFoldOrAllIn) {

        listaFoldOrAllIn.add(gracz1);
        listaFoldOrAllIn.add(gracz2);
        listaFoldOrAllIn.add(gracz3);
        listaFoldOrAllIn.add(gracz4);
        listaFoldOrAllIn.add(gracz5);
        listaFoldOrAllIn.add(gracz6);
        listaFoldOrAllIn.add(gracz7);
        listaFoldOrAllIn.add(gracz8);

        for (int i = 0; i < listaGraczyFoldOrAllIn.size(); i++) {
            listaFoldOrAllIn.get(i).setFoldCheck(false);
        }

        for (int i = 0; i < listaGraczyFoldOrAllIn.size(); i++) {
            listaFoldOrAllIn.get(i).setAllInCheck(false);
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

        for (int i = 0; i < listaGraczyZetonyNaStart.size(); i++) {
            listaGraczyZetonyNaStart.get(i).setZetonyPosiadane(1000);
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
                        karty.setBounds(365 + k2_1, 65, 90, 137);
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
                        karty.setBounds(425 + k2_2, 65, 90, 137);
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
        przejsciePoGraczach += 1;
        System.out.println(pomoc);
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
