package com.taliakart;

import javax.swing.*;

public class GUITalia {

    private Talia talia;

    public GUITalia(Talia talia) {
        this.talia = talia;
        talia.getTalia();
        System.out.println(talia);

        JFrame window = new JFrame("Test GUI");
        JPanel testPanel = new JPanel();
        JLabel testLabel = new JLabel();

        testPanel.setLayout(null);

        testLabel.setIcon(new ImageIcon("C:\\Users\\Wojciech\\Desktop\\poker tables\\BulkResizePhotos\\2S.jpg"));
        testLabel.setBounds(200,200,50,50);

        testPanel.add(testLabel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(testPanel);
        window.setSize(600,600);
        window.setVisible(true);



    }
}
