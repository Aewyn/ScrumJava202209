package com.aewyn.voorwerpen;

import com.aewyn.util.Voorwerp;

public abstract class Boek implements Voorwerp {
    private String titel;
    private String auteur;
    private final String eigenaar = "VDAB";
    private float aankoopprijs;
    private String genre;
    private String isbn13;

    public Boek() {

    }

    public Boek(String titel, String auteur, float aankoopprijs, String genre, String isbn13) {
        this.setTitel(titel);
        this.setAuteur(auteur);
        this.setAankoopprijs(aankoopprijs);
        this.setGenre(genre);
        this.setIsbn13(isbn13);
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        if (!titel.equals("")) {
            this.titel = titel;
        }
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        if(!auteur.equals("")){
            this.auteur = auteur;
        }
    }

    public String getEigenaar() {
        return eigenaar;
    }

    public void setAankoopprijs(float aankoopprijs) {
        if(aankoopprijs > 0){
            this.aankoopprijs = aankoopprijs;
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(!genre.equals("")){
            this.genre = genre;
        }
    }

    public String getIsbn13() {
        return isbn13;
    }

    public final void setIsbn13(String isbn13) {
        if(checkIsbn13(isbn13)){
            this.isbn13 = isbn13;
        }
        else{
            throw new Isbn13Exception("Error in isbn numbers");
        }
    }

    private boolean checkIsbn13(String isbn){
        var losseStrings = isbn.replaceAll("-", "").split("");

        if (losseStrings.length == 13){
            int[] getallen = new int[12];
            for (var i = 0; i < getallen.length; i++){
                if(i % 2 == 0){
                    getallen[i] = Integer.parseInt(losseStrings[i]);
                }
                else{
                    getallen[i] = Integer.parseInt(losseStrings[i]) * 3;
                }
            }
            var totaal = 0;
            for (int j : getallen) {
                totaal += j;
            }
            if (!(10 - (totaal % 10) == Integer.parseInt(losseStrings[losseStrings.length-1]))){
                return false;
            }
            else{
                return true;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "titel='" + titel + '\'' +
                "\nauteur='" + auteur + '\'' +
                "\neigenaar='" + eigenaar + '\'' +
                "\naankoopprijs=" + aankoopprijs +
                "\ngenre='" + genre + '\'' +
                "\nISBN='" + isbn13 + '\'';
    }

    public float getAankoopprijs() {
        return aankoopprijs;
    }

    @Override
    public abstract void gegevensTonen();

    @Override
    public abstract float winstBerekenen();
}
