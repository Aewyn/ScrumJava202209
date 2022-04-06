package com.aewyn.datumsentijden;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var vandaag = LocalDate.now();
        System.out.print("Geef je geboortedatum in het formaat dag/maand/jaar: ");
        var geboorteDatumAlsString = scanner.next();
        var geboorteDatum = LocalDate.parse(geboorteDatumAlsString, formatter);
        var aantalJaren = ChronoUnit.YEARS.between(geboorteDatum, vandaag);
        var geboorteDag = geboorteDatum.getDayOfWeek();

        System.out.println("\nJe geboortedatum is: " + geboorteDatum);
        System.out.println("\nJe bent geboren op een: " + geboorteDag);
        System.out.println("\nJe bent " + aantalJaren + " jaar oud.");

    }
}
