package com.okna;

import javax.swing.*;

public class OknoOstrzezenieBetRaise {

    JFrame window;

    public OknoOstrzezenieBetRaise() {
        window = new JFrame();
        JOptionPane.showMessageDialog(window, "Pole musi zawierać liczbę większą od 0, mniejszą niź posiadana iloś żetonów", "Alert", JOptionPane.WARNING_MESSAGE);
    }
}
