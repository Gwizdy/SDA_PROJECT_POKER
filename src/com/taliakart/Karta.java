package com.taliakart;

public class Karta implements Comparable<Karta>{

    private Kolor kolor;
    private Figura figura;

    public Karta(Kolor kolor, Figura figura) {
        this.kolor = kolor;
        this.figura = figura;
    }

    public Kolor getKolor() {
        return kolor;
    }

    public void setKolor(Kolor kolor) {
        this.kolor = kolor;
    }

    public int getFigura() {
        return figura.getFigura();
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "[kolor= " + kolor + " figura= " + figura + "]";
    }

    @Override
    public int compareTo(Karta karta) {
        int compare = figura.compareTo(karta.figura);

        if (compare == 0){
            compare = kolor.compareTo(karta.kolor);

        }
        return compare;
    }
}