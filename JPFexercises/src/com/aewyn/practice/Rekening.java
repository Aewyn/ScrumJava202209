package com.aewyn.practice;

public abstract class Rekening {
    private String rekeningNummer;
    private double saldo;

    public Rekening(String rekeningNummer){
        setRekeningNummer(rekeningNummer);
    }

    public Rekening(String rekeningNummer, double saldo){
        setRekeningNummer(rekeningNummer);
        if (saldo >= 0){
            this.saldo = saldo;
        }
    }

    public String getRekeningNummer() {

        return rekeningNummer;
    }

    public final void setRekeningNummer(String reknr) {
        if (reknr != null && !reknr.isEmpty())
        this.rekeningNummer = reknr;
    }

    public double getSaldo() {
        return saldo;
    }

    public void storten(double bedrag){
        if (checkBedrag(bedrag)){
            saldo += bedrag;
        }
    }

    public void afhalen(double bedrag){
        if(checkBedrag(bedrag)){
            saldo -= bedrag;
        }
    }

    public void overschrijven(Rekening rek, double bedrag){
        if(checkBedrag(bedrag)){
            saldo -= bedrag;
            rek.storten(bedrag);
        }
    }

    private boolean checkBedrag(double bedrag){
        return bedrag > 0.0;
    }

    @Override
    public String toString(){
        return rekeningNummer + ", " + saldo;
    }

    public abstract double berekenIntrest();

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Rekening rekening)) return false;
        return rekeningNummer.equals(rekening.getRekeningNummer());
    }
}
