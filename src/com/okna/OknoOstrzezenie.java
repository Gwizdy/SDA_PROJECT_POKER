package com.okna;

import javax.swing.*;

public class OknoOstrzezenie {

    JFrame window;

    public OknoOstrzezenie() {
        window = new JFrame();
        JOptionPane.showMessageDialog(window, "Podaj liczbę graczy od 1 do 8 !", "Alert", JOptionPane.WARNING_MESSAGE);
    }

}
