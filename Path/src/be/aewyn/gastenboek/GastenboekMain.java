package be.aewyn.gastenboek;

import java.util.Scanner;

public class GastenboekMain {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var newGastenboek = new Gastenboek();
        var gelezenGastenboek = new Gastenboek();

        System.out.print("Wat zou je willen doen (T om te tonen, S om te schrijven, E om te stoppen: ");
        var input = scanner.next();
        while (!input.equals("E")){
            try{
                if (input.equals("T")){
                    //Code voor tonen van de lijst in omgekeerde volgorde
                    gelezenGastenboek = GastenboekManager.readEntriesFromFile();
                    System.out.println(gelezenGastenboek);
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

                    newGastenboek.addEntry(new GastenboekEntry(tempAuthor, tempMessage));

                    GastenboekManager.writeToFile(newGastenboek);

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
