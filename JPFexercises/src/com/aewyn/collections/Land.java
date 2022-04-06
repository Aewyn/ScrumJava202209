package com.aewyn.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Land {
    private String landCode;
    private String landNaam;
    private String hoofdStad;
    private BigInteger aantalInwoners;
    private BigInteger oppervlakte;
    private BigDecimal bevolkingsDichtheid;

    public Land(String landCode, String landNaam, String hoofdStad, int aantalInwoners, float oppervlakte) {
        setLandCode(landCode);
        setLandNaam(landNaam);
        setHoofdStad(hoofdStad);
        setAantalInwoners(aantalInwoners);
        setOppervlakte(oppervlakte);
    }

    public String getLandCode() {
        return landCode;
    }

    public void setLandCode(String landCode) {
        if (!landCode.equals("")) {
            this.landCode = landCode;
        }
    }

    public String getLandNaam() {
        return landNaam;
    }

    public void setLandNaam(String landNaam) {
        if (!landNaam.equals("")) {
            this.landNaam = landNaam;
        }
    }

    public String getHoofdStad() {
        return hoofdStad;
    }

    public void setHoofdStad(String hoofdStad) {
        if (!hoofdStad.equals("")) {
            this.hoofdStad = hoofdStad;
        }
    }

    public BigInteger getAantalInwoners() {
        return aantalInwoners;
    }

    public void setAantalInwoners(int aantalInwoners) {
        if (aantalInwoners > 0) {
            this.aantalInwoners = BigInteger.valueOf(aantalInwoners);
        } else { throw new LandException("Aantal inwoners moet groter dan 0 zijn."); }
    }

    public BigInteger getOppervlakte() {
        return oppervlakte;
    }

    public void setOppervlakte(float oppervlakte) {
        if (oppervlakte > 0.0F) {
            this.oppervlakte = BigDecimal.valueOf(oppervlakte).toBigInteger();
        } else { throw new LandException("Oppervlakte van het land moet groter dan 0 zijn.");}
    }

    public BigDecimal getBevolkingsDichtheid(){
        var inwonersBigDec = new BigDecimal(aantalInwoners);
        var oppervlakteBigDec = new BigDecimal(oppervlakte);
        return inwonersBigDec.divide(oppervlakteBigDec, 2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Landcode: " + getLandCode() +
                "\nNaam land: " + getLandNaam() +
                "\nHoofdstad: " + getHoofdStad() +
                "\nAantal inwoners : " + getAantalInwoners() +
                "\nOppervlakte: " + getOppervlakte()  + " km\u00B2";
    }
}
