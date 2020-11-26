package com.okna;

import javax.swing.*;

public class OknoOstrzezenieGracz {

    JFrame window;

    public OknoOstrzezenieGracz() {
        window = new JFrame();
        JOptionPane.showMessageDialog(window, "Pola nie mogą być puste, nazwy muszą się różnić \n oraz nie mogą przekraczać 20 znaków", "Alert", JOptionPane.WARNING_MESSAGE);
    }
}
