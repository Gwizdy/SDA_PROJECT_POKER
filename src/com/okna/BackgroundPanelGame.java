package com.okna;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackgroundPanelGame extends JPanel {

    private BufferedImage obrazekGame;

    public BackgroundPanelGame() {
        try {
            obrazekGame = ImageIO.read(new File("poker_table_2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D grafika = (Graphics2D) g;
        grafika.drawImage(obrazekGame, 0, 0, this);
    }

}
