package com.aewyn.voorwerpen;

public class Leesboek extends Boek{
    private String onderwerp;
    private final float winstmarge = 1.5F;

    public Leesboek(){

    }

    public Leesboek(String titel, String auteur, float aankoopprijs, String genre, String isbn, String onderwerp) {
        super(titel, auteur, aankoopprijs, genre, isbn);
        if (!onderwerp.equals("")){
            this.onderwerp = onderwerp;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nonderwerp='" + onderwerp + '\'' +
                "\nwinstmarge=" + winstmarge;
    }

    @Override
    public void gegevensTonen() {
        System.out.println(this);
        System.out.println("Winst: " + this.winstBerekenen());
    }

    @Override
    public float winstBerekenen() {
        return super.getAankoopprijs() * winstmarge;
    }
}
