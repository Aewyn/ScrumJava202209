package be.aewyn.gastenboek;

import java.util.Scanner;

public class GastenboekMain {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Wat zou je willen doen (T om te tonen, S om te schrijven, E om te stoppen: ");
        var input = scanner.next();
        while (!input.equals("E")){
            try{
                if (input.equals("T")){
                    //Code voor tonen van de lijst in omgekeerde volgorde
                    GastenboekManager.readEntriesFromFile();
                    System.out.print("\nWat zou je willen doen (T om te tonen, S om te schrijven, E om te stoppen: ");
                    input = scanner.next();
                }
                else if (input.equals("S")){
                    //Code voor het wegschrijven van nieuwe entry
                    System.out.print("Geef de naam van de schrijver in: ");
                    var tempAuthor = scanner.next();
                    scanner.nextLine();
                    System.out.print("Geef de boodschap: ");
                    var tempMessage = scanner.nextLine();

                    Gastenboek.addEntry(tempAuthor, tempMessage);

                    GastenboekManager.writeToFile();

                    System.out.print("\nWat zou je willen doen (T om te tonen, S om te schrijven, E om te stoppen: ");
                    input = scanner.next();
                }
                else {
                    System.out.print("\nType T,S, of E: ");
                    input = scanner.next();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
