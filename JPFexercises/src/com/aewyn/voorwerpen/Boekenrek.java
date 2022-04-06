package com.aewyn.voorwerpen;

import com.aewyn.util.Voorwerp;

public class Boekenrek implements Voorwerp {
    private final String eigenaar = "VDAB";
    private int hoogte;
    private int breedte;
    private float aankoopprijs;
    private final float winstmarge = 2.0F;

    public Boekenrek(){

    }

    public Boekenrek(int hoogte, int breedte, float aankoopprijs) {
        if(hoogte > 0){
            this.hoogte = hoogte;
        }
        if(breedte > 0){
            this.breedte = breedte;
        }
        if(aankoopprijs > 0){
            this.aankoopprijs = aankoopprijs;
        }
    }

    @Override
    public String toString() {
        return "Boekenrek{" +
                "eigenaar='" + eigenaar + '\'' +
                ", hoogte=" + hoogte +
                ", breedte=" + breedte +
                ", aankoopprijs=" + aankoopprijs +
                ", winstmarge=" + winstmarge +
                '}';
    }

    @Override
    public void gegevensTonen() {
        System.out.println(this);
        System.out.println("Winst: " + this.winstBerekenen());
    }

    @Override
    public float winstBerekenen() {
        return aankoopprijs * winstmarge;
    }
}
