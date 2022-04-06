package com.aewyn.practice;

public class BankBediende {
    public static void main(String[] args) {
        System.out.println("Intrestpercentage van de spaarrekening: " + Spaarrekening.getIntrest());

        var spaar = new Spaarrekening("BE12 3456 7890 1234", 1.5);
        var zicht = new Zichtrekening("BE 98 7654 3210 9876", 1000);

        System.out.println();
        System.out.println("Intrestpercentage van de spaarrekening: " + Spaarrekening.getIntrest());
        System.out.println("MaxKrediet an de zichtrekening is: " + zicht.getMaxKrediet());

        spaar.storten(600.0);
        zicht.storten(200.0);

        System.out.println();
        spaar.afhalen(25.0);
        System.out.println("Saldo van de spaarrekening: " + spaar.getSaldo());
        zicht.afhalen(50.0);
        System.out.println("Saldo van de zichtrekening: " + zicht.getSaldo());
        zicht.afhalen(2000);
        System.out.println("Saldo van de zichtrekening (na poging afhalen 2000): " + zicht.getSaldo());
        spaar.afhalen(600.0);
        System.out.println("Saldo van de spaarrekening (na poging afhalen 600): " + spaar.getSaldo());
        zicht.afhalen(1100);
        System.out.println("Saldo van de zichtrekening (na poging " + "afhalen 1100): " + zicht.getSaldo());
        zicht.setMaxKrediet(2000);
        System.out.println("MaxKrediet van de zichtrekening is: " + zicht.getMaxKrediet());
        zicht.afhalen(900);
        System.out.println("Saldo van de zichtrekening: " + zicht.getSaldo());

        System.out.println();
        System.out.println(spaar);
        System.out.println(zicht);

        System.out.println();
        System.out.println("Intrest op de spaarrekening: " + spaar.berekenIntrest());
        System.out.println("Intrest op de zichtrekening: " + zicht.berekenIntrest());

        //Toepassing polymorfisme
        System.out.println();
        var rekeningen = new Rekening[4];
        rekeningen[0] = new Spaarrekening("BE11 2233 4455 6677", 1.5);
        rekeningen[1] = new Spaarrekening("BE99 8877 6655 4433", 1.5);
        rekeningen[2] = new Zichtrekening("BE19 2837 4655 64730", 2000);
        rekeningen[3] = new Zichtrekening("BE91 8273 6455 4637", 1500);

        rekeningen[0].storten(500.0);
        rekeningen[1].storten(550.0);
        rekeningen[1].afhalen(120.0);
        rekeningen[2].storten(200.0);
        rekeningen[2].afhalen(20.0);
        rekeningen[3].storten(300.0);

        for (var rekening: rekeningen) {
            if(rekening != null){
                System.out.println("Saldo van de rekening: " + rekening.getSaldo());
            }
        }
    }
}
