package com.taliakart;

public class Karta {
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
        return "Karta [kolor=" + kolor + ", figura=" + figura + "]";
    }

}