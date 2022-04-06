package be.aewyn.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OnevenGetallenMain {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Voer een getal in: ");
        var input = sc.next();
        sc.nextLine();
        while (!input.equals("0")){
            numbers.add(Integer.parseInt(input));
            System.out.print("Voer een getal in: ");
            input = sc.next();
        }
        numbers.stream().filter(number -> number % 2 != 0).sorted().forEach(System.out::println);
    }
}
