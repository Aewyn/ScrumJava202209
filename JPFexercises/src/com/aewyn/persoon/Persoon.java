package com.aewyn.persoon;

public class Persoon {
    private String voornaam;
    private String familienaam;
    private Geslacht geslacht;

    public Persoon(String voornaam, String familienaam, Geslacht geslacht) {
        setVoornaam(voornaam);
        setFamilienaam(familienaam);
        setGeslacht(geslacht);
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public void setGeslacht(Geslacht geslacht) {
        try {
            if(geslacht instanceof Geslacht){
                this.geslacht = geslacht;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Voornaam: " + voornaam +
                "\nFamilienaam: " + familienaam +
                "\nGeslacht: " + geslacht;
    }
}
