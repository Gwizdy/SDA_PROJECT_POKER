package com.taliakart;


import javax.swing.*;
import java.awt.event.*;

public class OknoPowitalne {

    private int liczbaGraczy = 0;

    JFrame window;
    JLabel backgroundLabel;
    JLabel welcomeText;
    JButton buttonConfirm;
    JTextField fieldHowManyPlayers;

    public OknoPowitalne() {

        window = new JFrame("POKER Texas Holden");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonConfirm = new JButton(new ImageIcon("confirm.jpg"));
        buttonConfirm.setBounds(360, 250, 98, 41);
        buttonConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonConfirm.setHorizontalTextPosition(SwingConstants.CENTER);

        fieldHowManyPlayers = new JTextField("Podaj liczbę graczy");
        fieldHowManyPlayers.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1)
                    fieldHowManyPlayers.setText("");
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
        fieldHowManyPlayers.setBounds(340, 200, 140, 20);

        welcomeText = new JLabel("WELCOME TO \n TEXAS HOLDEN POKER");

        backgroundLabel = new JLabel(new ImageIcon("tlo.jpg"), JLabel.CENTER);
        backgroundLabel.setLayout(null);
        backgroundLabel.setOpaque(true);
        backgroundLabel.add(buttonConfirm);
        backgroundLabel.add(fieldHowManyPlayers);

        window.add(backgroundLabel);

        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fieldHowManyPlayers.getText().equals(""))
                    new OknoOstrzezenie();
                else {
                    liczbaGraczy = Integer.parseInt(fieldHowManyPlayers.getText());
                    if (liczbaGraczy == 0) {
                        new OknoOstrzezenie();
                    } else
                        System.out.println();
                    //  new OknoZGraczami();
                }
            }
        });
        window.setVisible(true);
        window.setSize(626, 365);
        window.setLocationRelativeTo(null); // wyświetlenie okna na środku ekranu monitora
    }

}
