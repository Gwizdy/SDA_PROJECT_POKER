package com.okna;

import javax.swing.*;

public class OknoOstrzezenieCheckCall {

    JFrame window;

    public OknoOstrzezenieCheckCall() {
        window = new JFrame();
        JOptionPane.showMessageDialog(window, "Nie masz wystarczajaco zetonow aby sprawdzic gracza", "Alert", JOptionPane.WARNING_MESSAGE);
    }
}
