package com.taliakart;

public enum Figura {
    DWOJKA(2), TROJKA(3), CZWORKA(4), PIATKA(5), SZOSTKA(6), SIODEMKA(7), OSEMKA(8), DZIEWIATKA(9), DZIESIATKA(10),
    WALET(11), DAMA(12), KROL(13), AS(14);

    private int figura;

    private Figura(int figura) {
        this.figura = figura;
    }

    public int getFigura() {
        return this.figura;
    }
}
