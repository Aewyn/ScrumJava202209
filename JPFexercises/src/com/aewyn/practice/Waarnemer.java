package com.aewyn.practice;

public class Waarnemer {
    private static float minTemperatuur = Integer.MAX_VALUE;
    private static float maxTemperatuur = Integer.MIN_VALUE;
    private static int aantalInputs;
    private static float totaleTemp;

    public Waarnemer(float temp){
        aantalInputs++;
        totaleTemp += temp;

        if(temp < minTemperatuur){
            minTemperatuur = temp;
        }
        if(temp > maxTemperatuur){
            maxTemperatuur = temp;
        }
    }

    public static void getAantalInputs(){
        System.out.println("Aantal inputs: " + aantalInputs);
    }

    public static void getMaxTemp(){
        System.out.println("Max temperatuur: " + maxTemperatuur);
    }

    public static void getMinTemp(){
        System.out.println("Min temperatuur: " + minTemperatuur);
    }

    public static void getAverageTemp(){
        System.out.println("Gemiddelde temperatuur: " + totaleTemp/aantalInputs);
    }
}
