package com.rozgrywka;

import com.taliakart.Karta;

import java.util.List;

public class Gracz {

    private int zetonyWGrze;
    private int zetonyPosiadane;
    private int zetonyStawkaGracza;

    private List<Karta> kartyReka;

    public Gracz() {

    }

    public int getZetonyWGrze() {
        return zetonyWGrze;
    }

    public void setZetonyWGrze(int zetonyWGrze) {
        this.zetonyWGrze = zetonyWGrze;
    }

    public int getZetonyPosiadane() {
        return zetonyPosiadane;
    }

    public void setZetonyPosiadane(int zetonyPosiadane) {
        this.zetonyPosiadane = zetonyPosiadane;
    }

    public List<Karta> getKartyReka() {
        return kartyReka;
    }

    public void setKartyReka(List<Karta> kartyReka) {
        this.kartyReka = kartyReka;
    }

    public int getZetonyStawkaGracza() {
        return zetonyStawkaGracza;
    }

    public void setZetonyStawkaGracza(int zetonyStawkaGracza) {
        this.zetonyStawkaGracza = zetonyStawkaGracza;
    }
}
