package com.okna;

import javax.swing.*;

public class OknoOstrzezenieGracz {

    JFrame window;

    public OknoOstrzezenieGracz() {
        window = new JFrame();
        JOptionPane.showMessageDialog(window, "Pola nie mogą być puste oraz nazwy muszą się różnić", "Alert", JOptionPane.WARNING_MESSAGE);
    }
}
