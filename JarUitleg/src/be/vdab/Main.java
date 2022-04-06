package be.vdab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("centimeters:");
        var scanner = new Scanner(System.in);
        var centimeters = scanner.nextDouble();
        var converter = new Converter();
        System.out.println(converter.centimetersToInches(centimeters) + " inches");
    }
}