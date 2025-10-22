package com.lucaemanuele.scimmia2.model;

/*
Class which describes the composition of a deck
*/
public class DeckDescription {
    private int numberDraw2;
    private int numberDraw4;
    private int numberSkip;
    private int numberSwap;

    public DeckDescription(int numberDraw2, int numberDraw4, int numberSkip, int numberSwap) {
        this.numberDraw2 = numberDraw2;
        this.numberDraw4 = numberDraw4;
        this.numberSkip = numberSkip;
        this.numberSwap = numberSwap;
    }

    /*
    Getter and setter
    */
    public int getNumberDraw2() {
        return numberDraw2;
    }

    public void setNumberDraw2(int numberDraw2) {
        this.numberDraw2 = numberDraw2;
    }

    public int getNumberDraw4() {
        return numberDraw4;
    }

    public void setNumberDraw4(int numberDraw4) {
        this.numberDraw4 = numberDraw4;
    }

    public int getNumberSkip() {
        return numberSkip;
    }

    public void setNumberSkip(int numberSkip) {
        this.numberSkip = numberSkip;
    }

    public int getNumberSwap() {
        return numberSwap;
    }

    public void setNumberSwap(int numberSwap) {
        this.numberSwap = numberSwap;
    }
    
    
}
