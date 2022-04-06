package com.aewyn.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        var LandenLijst = new ArrayList<Land>();
        BigDecimal gemBevolkingsDichtheid = new BigDecimal(BigInteger.ZERO);
        try{
            LandenLijst.add(new Land("BE", "Belgie", "Brussel", 11_492_641, 30_689));
            LandenLijst.add(new Land("DE", "Duitsland", "Berlijn", 83_222_442, 357_121));
            LandenLijst.add(new Land("FR", "Frankrijk", "Parijs", 62_814_233, 551_500));
            LandenLijst.add(new Land("CH", "Zwitserland", "Bern", 8_403_994, 41_285));
            LandenLijst.add(new Land("LU", "Luxemburg", "Luxemburg", 628_381, 2_586));
            LandenLijst.add(new Land("JP", "Japan", "Tokio", 125_507_472, 377_930));
            LandenLijst.add(new Land("MC", "Monaco", "Monaco-Ville", 39_000, 2));
            LandenLijst.add(new Land("IL", "Israël", "Jeruzalem", 9_443_420, 22_072));
            LandenLijst.add(new Land("EG", "Egypte", "Caïro", 107_124_440, 1_002_000));
            LandenLijst.add(new Land("IS", "Ijsland", "Reykjavik", 368_792, 103_000));
            LandenLijst.add(new Land("SE", "Zweden", "Stockholm", 10_202_491, 450_295));
        }
        catch(LandException le){
            System.out.println(le.getMessage());
        }

        for (var l:LandenLijst) {
            System.out.println(l);
            gemBevolkingsDichtheid = gemBevolkingsDichtheid.add(l.getBevolkingsDichtheid());
            gemBevolkingsDichtheid = gemBevolkingsDichtheid.divide(new BigDecimal(LandenLijst.size()), 2, RoundingMode.HALF_UP);
            System.out.println(l.getBevolkingsDichtheid());
            System.out.println();
        }

        System.out.println("Gemiddelde bevolkingsdichtheid: " + gemBevolkingsDichtheid.toString() + " inw/km\u00B2");
    }
}
