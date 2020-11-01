package com.rozgrywka;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanelGracza extends JPanel {

    private BufferedImage obrazekGracz;

    public BackgroundPanelGracza() {

        try {
            obrazekGracz = ImageIO.read(new File("BackgroundPanelGracza.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D grafika = (Graphics2D) g;
        grafika.drawImage(obrazekGracz, 0, 0, this);
    }
}
