package com.okna;

import javax.swing.*;

public class OknoOstrzezenieNazwa {

    JFrame window;

    public OknoOstrzezenieNazwa() {
        window = new JFrame();
        JOptionPane.showMessageDialog(window, "Nazwy muszą się różnić", "Alert", JOptionPane.WARNING_MESSAGE);
    }
}
