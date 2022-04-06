package com.aewyn.voertuigen;

public class TestProgramma {
    public static void main(String[] args) {
//        var voertuigen = new Voertuig[4];
//
//        voertuigen[0] = new Personenwagen();
//        voertuigen[1] = new Personenwagen("Willemsons", 27.000F, 12, 6.6F, "1-ELZ-168", 5, 5);
//        voertuigen[2] = new Vrachtwagen();
//        voertuigen[3] = new Vrachtwagen("DeWielen", 107000.0F, 30, 12.7F, "2-OOP-256", 7000);
//
//        for (var voertuig:voertuigen) {
//            System.out.println(voertuig);
//        }
//
//        System.out.println("\nMet toon(): ");
//        for (var voertuig:voertuigen) {
//            System.out.println();
//            System.out.println(voertuig.toon());
//            System.out.println("Kyoto-score: " + voertuig.getKyotoScore());
//        }
        var vervuilers = new Vervuiler[3];
        vervuilers[0] = new Personenwagen("Karlson", 25000.0F, 10, 6.5F, "1-ABC-345", 5, 4);
        vervuilers[1] = new Vrachtwagen("Declair", 60000.0F, 25, 10.5F,"Q-ABC-456", 6);
        vervuilers[2] = new Stookketel(60.0F);

        for (var v:vervuilers) {
            System.out.println("Vervluiling van type: " + v.getClass() + ": " + v.berekenVervuiling());
        }

        System.out.println("\nObjecten van de interface Privaat: ");
        var privaten = new Privaat[4];
        privaten[0] = new Personenwagen("Karlson", 25000.0F, 10, 6.5F, "1-ABC-345", 5, 4);
        privaten[1] = new Personenwagen("Srumstrom", 21500.0F, 8, 7.2F, "1-FIS-256", 5, 4);
        privaten[2] = new Vrachtwagen("Willemson", 70000.0F, 22, 11.5F,"Q-ILP-683", 5);
        privaten[3] = new Vrachtwagen("Jacobs", 36000.0F, 17, 16.3F,"Q-YUP-160", 8);

        for (var p:privaten) {
            p.geefPrivateData();
        }

        System.out.println("\nObjecten van de interface Milieu: ");
        var milieus = new Milieu[2];
        milieus[0] = new Personenwagen("Plop", 22000.0F, 12, 6.6F, "1-FLS-326", 5, 4);
        milieus[1] = new Vrachtwagen("Samson", 80000.0F, 23, 14.1F,"Q-FOS-183", 7);

        for (var m: milieus) {
            m.geefMilieuDetail();
        }
    }
}
