package com.okna;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundZakonczenieGry extends JPanel {

    private BufferedImage obrazekZakonczenie;

    public BackgroundZakonczenieGry() {
        try {
            obrazekZakonczenie = ImageIO.read(new File("images\\BackgroundZakonczenieGry.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D grafika = (Graphics2D) g;
        grafika.drawImage(obrazekZakonczenie, 0, 0, this);
    }
}
