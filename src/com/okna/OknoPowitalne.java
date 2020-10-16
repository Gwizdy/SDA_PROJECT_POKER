package com.okna;


import javax.swing.*;
import java.awt.event.*;

public class OknoPowitalne {

    private int liczbaGraczy = 0;

    private JFrame window;
    private JLabel backgroundLabel;
    private JLabel panelPlayers;
    private JButton buttonConfirm;
    private JTextField fieldHowManyPlayers;

    private JTextField pole1;
    private JTextField pole2;
    private JTextField pole3;
    private JTextField pole4;
    private JTextField pole5;
    private JTextField pole6;
    private JTextField pole7;
    private JTextField pole8;

    public void poleIPrzycisk() {

        buttonConfirm = new JButton(new ImageIcon("confirm.jpg"));
        buttonConfirm.setBounds(575, 350, 98, 41);
        buttonConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonConfirm.setVerticalAlignment(SwingConstants.CENTER);

        fieldHowManyPlayers = new JTextField();
        fieldHowManyPlayers.setText("Podaj liczbę graczy");
        fieldHowManyPlayers.setHorizontalAlignment(SwingConstants.CENTER);
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
        fieldHowManyPlayers.setBounds(540, 290, 160, 30);

        backgroundLabel = new JLabel(new ImageIcon("tlo.jpg"), JLabel.CENTER);
        backgroundLabel.setLayout(null);
        backgroundLabel.setOpaque(true);
        backgroundLabel.add(buttonConfirm);
        backgroundLabel.add(fieldHowManyPlayers);

        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fieldHowManyPlayers.getText().equals("") || fieldHowManyPlayers.getText().charAt(0) < 49 || fieldHowManyPlayers.getText().charAt(0) > 56 || fieldHowManyPlayers.getText().length() > 1)
                    new OknoOstrzezenie();
                else {
                    liczbaGraczy = Integer.parseInt(fieldHowManyPlayers.getText());
                    backgroundLabel.setVisible(false);
                    oknoGracze();
                    window.revalidate();
                    window.repaint();

                }
            }
        });
    }

    public OknoPowitalne() {

        window = new JFrame("POKER Texas Holden");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        poleIPrzycisk();

        window.add(backgroundLabel);
        window.setVisible(true);
        window.setSize(895, 519);
        window.setLocationRelativeTo(null); // wyświetlenie okna na środku ekranu monitora
    }

    public void oknoGracze() {
        panelPlayers = new JLabel(new ImageIcon("tlo.jpg"), JLabel.CENTER);
        window.add(panelPlayers);

        //if (liczbaGraczy == 1)


    }

    public int getLiczbaGraczy() {
        return liczbaGraczy;
    }

    public void setLiczbaGraczy(int liczbaGraczy) {
        this.liczbaGraczy = liczbaGraczy;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    public JLabel getBackgroundLabel() {
        return backgroundLabel;
    }

    public void setBackgroundLabel(JLabel backgroundLabel) {
        this.backgroundLabel = backgroundLabel;
    }

    public JButton getButtonConfirm() {
        return buttonConfirm;
    }

    public void setButtonConfirm(JButton buttonConfirm) {
        this.buttonConfirm = buttonConfirm;
    }

    public JTextField getFieldHowManyPlayers() {
        return fieldHowManyPlayers;
    }

    public void setFieldHowManyPlayers(JTextField fieldHowManyPlayers) {
        this.fieldHowManyPlayers = fieldHowManyPlayers;
    }
}
