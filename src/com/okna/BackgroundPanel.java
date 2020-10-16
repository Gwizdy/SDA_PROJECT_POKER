package com.okna;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanel extends JPanel {

    private BufferedImage obrazek;

    public BackgroundPanel() {
        try {
            obrazek = ImageIO.read(new File("tlo.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D grafika = (Graphics2D) g;
        grafika.drawImage(obrazek, 0, 0, this);
    }

}
