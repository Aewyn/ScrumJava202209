package com.aewyn.voorwerpen;

public class Woordenboek extends Boek{
    private String taal;
    private final float winstmarge = 1.75F;

    public Woordenboek(){

    }

    public Woordenboek(String titel, String auteur, float aankoopprijs, String genre, String isbn, String taal) {
        super(titel, auteur, aankoopprijs, genre, isbn);
        if(!taal.equals("")){
            this.taal = taal;
        }
    }

    @Override
    public String toString() {
        return "Woordenboek{" +
                "taal='" + taal + '\'' +
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
        return super.getAankoopprijs() * winstmarge;
    }
}
