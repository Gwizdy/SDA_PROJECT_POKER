package com.taliakart;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUITalia {

    private Talia taliaGUI;
//    private Kolor kolor;
//    private Figura figura;
    private List<String> listaObrazkow;


    public GUITalia() {

        Random rand = new Random(); //stworzony w celu testow czy sie zgadza


        taliaGUI = new Talia();
        List<Karta> talia = taliaGUI.getTalia();

        int r = rand.nextInt(talia.size());
        System.out.println(r); //wypisany random int
        System.out.println(talia.get(r)); //randomowo wybierany obiekt Karta

        listaObrazkow = new ArrayList<String>(); //lista z filepath
        for (Kolor k : Kolor.values()){
            for (Figura f: Figura.values()){
                listaObrazkow.add("images\\" + f.getFigura() + "_" + k.getWartosc() + ".jpg");
            }
        }
        System.out.println(listaObrazkow.get(r)); // test sciezki z plikiem


        JFrame window = new JFrame("Test GUI");
        JPanel testPanel = new JPanel();
        JLabel testLabel = new JLabel();

        testPanel.setLayout(null);

        testLabel.setIcon(new ImageIcon(listaObrazkow.get(r)));//generowany obraz z losowego int
        testLabel.setBounds(200,200,41,63);

        testPanel.add(testLabel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(testPanel);
        window.setSize(600,600);
        window.setVisible(true);


    }

    //usuwanie z listy przy pozniejszym dobieraniu reki
    public void usunZTalii(int liczba, List list){
        list.remove(liczba);
    }

    public Talia getTaliaGUI() {
        return taliaGUI;
    }

    public List<String> getListaObrazkow() {
        return listaObrazkow;
    }
}
