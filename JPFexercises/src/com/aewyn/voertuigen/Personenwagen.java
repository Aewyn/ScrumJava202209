package com.aewyn.voertuigen;

public class Personenwagen extends Voertuig implements Vervuiler {
    private int aantalDeuren = 4;
    private int aantalPassagiers = 5;

    public int getAantalDeuren() {
        return aantalDeuren;
    }

    public void setAantalDeuren(int aantalDeuren) {
        if (aantalDeuren > 0) {
            this.aantalDeuren = aantalDeuren;
        }
    }

    public int getAantalPassagiers() {
        return aantalPassagiers;
    }

    public void setAantalPassagiers(int aantalPassagiers) {
        if (aantalPassagiers > 0) {
            this.aantalPassagiers = aantalPassagiers;
        }
    }

    public Personenwagen(){
        super();
    }

    public Personenwagen(String polishouder, float kostprijs, int pk, float gemVerbruik, String nummerplaat, int aantalDeuren, int aantalPassagiers) {
        super(polishouder, kostprijs, pk, gemVerbruik, nummerplaat);
        this.aantalDeuren = aantalDeuren;
        this.aantalPassagiers = aantalPassagiers;
    }

    @Override
    public String toString(){
        return super.toString() + ", " + this.getAantalDeuren()  + ", " + this.getAantalPassagiers();
    }

    @Override
    public String toon(){
        return super.toon() +
                "\nAantal deuren: " + this.getAantalDeuren() +
                "\nAantal passagiers: " + this.getAantalPassagiers();
    }

    @Override
    public double getKyotoScore() {
        return (this.getGemVerbruik() * this.getPk())/this.getAantalPassagiers();
    }

    @Override
    public double berekenVervuiling() {
        return getKyotoScore() * 20;
    }
}

