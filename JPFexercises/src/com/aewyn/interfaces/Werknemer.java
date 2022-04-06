package com.aewyn.interfaces;

public class Werknemer implements Kost{
    String naam;
    double wedde;

    public Werknemer(String naam, double wedde){
        this.naam = naam;
        this.wedde = wedde;
    }

    public String getNaam() {
        return naam;
    }

    public double getWedde() {
        return wedde;
    }

    @Override
    public double bedragKost() {
        return wedde;
    }

    @Override
    public boolean personeelsKost() {
        return true;
    }

    @Override
    public String toString(){
        return naam + ";" + wedde;
    }
}
