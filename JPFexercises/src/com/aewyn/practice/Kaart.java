package com.aewyn.practice;

public class Kaart {
    private int suit;
    private int rang;

    public Kaart() {
        suit = (int) (Math.random() * 4 + 1);
        rang = (int) (Math.random() * 13 + 1);
    }

    public void printKaart() {
        String suitName = "";
        String rangName = "";

        switch (this.suit) {
            case 1 -> suitName = "Harten";
            case 2 -> suitName = "Ruiten";
            case 3 -> suitName = "Klaveren";
            case 4 -> suitName = "Schoppen";
        }

        switch (rang) {
            case 1 -> rangName = "aas";
            case 2, 3, 4, 5, 6, 7, 8, 9, 10 -> rangName = Integer.toString(rang);
            case 11 -> rangName = "boer";
            case 12 -> rangName = "vrouw";
            case 13 -> rangName = "heer";
            default -> throw new IllegalStateException("Unexpected value: " + rang);
        }

        System.out.println(suitName + " " + rangName);
    }

    public boolean isHogerDan(Kaart k) {
        return this.rang > k.rang;
    }
}
