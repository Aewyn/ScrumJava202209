package com.aewyn.practice;

public class KaartMain {
    public static void main(String[] args) {
        var kaart1 = new Kaart();
        kaart1.printKaart();

        var kaart2 = new Kaart();
        kaart2.printKaart();

        System.out.println(kaart1.isHogerDan(kaart2));
    }
}
