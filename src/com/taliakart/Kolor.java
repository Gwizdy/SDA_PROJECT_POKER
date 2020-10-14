package com.taliakart;

public enum Kolor {
    PIK(1), TREFL(2), KARO(3), KIER(4);

    private int wartosc;

    private Kolor(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getWartosc() {
        return this.wartosc;
    }
}
