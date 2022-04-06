package com.aewyn.voertuigen;

public abstract class Voertuig implements Privaat,Milieu {
    private String polishouder = "onbepaald";
    private float kostprijs;
    private int pk;
    private float gemVerbruik;
    private String nummerplaat = "onbepaald";

    public String getPolishouder() {
        return polishouder;
    }

    public void setPolishouder(String polishouder) {
        this.polishouder = polishouder;
    }

    public float getKostprijs() {
        return kostprijs;
    }

    public void setKostprijs(float kostprijs) {
        this.kostprijs = kostprijs;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public float getGemVerbruik() {
        return gemVerbruik;
    }

    public void setGemVerbruik(float gemVerbruik) {
        this.gemVerbruik = gemVerbruik;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    public Voertuig(){

    }

    public Voertuig(String polishouder, float kostprijs, int pk, float gemVerbruik, String nummerplaat){
        if (polishouder != null && !polishouder.isEmpty()){
            this.polishouder = polishouder;
        }
        if(kostprijs >0){
            this.kostprijs = kostprijs;
        }
        if(pk > 0){
            this.pk = pk;
        }
        if(gemVerbruik > 0){
            this.gemVerbruik = gemVerbruik;
        }
        if(nummerplaat != null && !nummerplaat.isEmpty()){
            this.nummerplaat = nummerplaat;
        }
    }

    @Override
    public String toString(){
        return this.getPolishouder() + ", " +
                this.getKostprijs() + ", " +
                this.getPk() + ", " +
                this.getGemVerbruik() + ", " +
                this.getNummerplaat();
    }

    public String toon(){
        return "Polishouder: " + this.getPolishouder() +
                "\nKostprijs: " + this.getKostprijs() +
                "\nPKs: " + this.getPk() +
                "\nGemiddeld verbruik: " + this.getGemVerbruik() +
                "\nNummerplaat: " + this.getNummerplaat();
    }

    public abstract double getKyotoScore();

    @Override
    public void geefPrivateData(){
        System.out.println(getPolishouder() + ";" + getNummerplaat());
    }

    @Override
    public void geefMilieuDetail() {
        System.out.println(getPk() + ";" + getKostprijs() + ";" + getGemVerbruik());
    }
}
