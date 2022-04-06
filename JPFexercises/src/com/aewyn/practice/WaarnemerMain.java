package com.aewyn.practice;

import java.util.Scanner;

public class WaarnemerMain {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var input = scanner.nextFloat();

        while (input != 999){
            new Waarnemer(input);
            input = scanner.nextFloat();
        }
        Waarnemer.getAantalInputs();
        Waarnemer.getMaxTemp();
        Waarnemer.getMinTemp();
        Waarnemer.getAverageTemp();
    }
}
