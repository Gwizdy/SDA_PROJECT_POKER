package com.okna;

import javax.swing.*;

public class OknoOstrzezenieBetRaise {

    JFrame window;

    public OknoOstrzezenieBetRaise() {
        window = new JFrame();
        JOptionPane.showMessageDialog(window, "Pole musi zawierać liczbę większą od 0, mniejszą niź posiadana ilość żetonów \n stawka musi byc wieksza niz stawka poprzednich graczy i mniejsza niz maksymalna ilosc zetonow", "Alert", JOptionPane.WARNING_MESSAGE);
    }
}
