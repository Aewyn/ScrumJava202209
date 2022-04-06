package com.aewyn.voertuigen;

public class Vrachtwagen extends Voertuig implements Vervuiler{
    private float maxLading = 10000.0F;

    public float getMaxLading() {
        return maxLading;
    }

    public void setMaxLading(float maxLading) {
        if (maxLading > 0) {
            this.maxLading = maxLading;
        }
    }
    public Vrachtwagen(){
        super();
    }
    public Vrachtwagen(String polishouder, float kostprijs, int pk, float gemVerbruik, String nummerplaat, float maxLading){
        super(polishouder, kostprijs, pk, gemVerbruik, nummerplaat);
        this.setMaxLading(maxLading);
    }

    @Override
    public String toString(){
        return super.toString() + ", " + this.getMaxLading();
    }

    @Override
    public double getKyotoScore() {
        return (this.getGemVerbruik() * this.getPk())/this.getMaxLading();
    }

    @Override
    public double berekenVervuiling() {
        return getKyotoScore() * 20;
    }
}
