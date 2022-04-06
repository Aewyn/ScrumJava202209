
package com.aewyn.emailcontrole;

import java.util.Scanner;

public class EmailControle {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var input = sc.next();
        var aantalKlinkers = 0;
        var isPalindroom = true;
        var isPalindroom2 = true;
        var result = 0;
/*

        for (var i = 0; i < input.length(); i++) {
            var letter = input.charAt(i);
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                aantalKlinkers++;
            }
        }

        var teller = 0;
        while (teller < input.length() / 2) {
            if (input.charAt(teller) != input.charAt(input.length() - 1 - teller)) {
                isPalindroom = false;
            }
            teller++;
        }

        var a = new StringBuilder(input).reverse();
        System.out.println(a);
        if(input.equals(a.toString())){
            isPalindroom2 = true;
        } else { isPalindroom2 = false; }
*/

        var bewerking = input.split(" ");
        System.out.println(bewerking);
        for (var item:bewerking) {
            System.out.println(item);
        }


/*        System.out.println("Aantal klinkers: " + aantalKlinkers);
        System.out.println("Is palindroom: " + isPalindroom);
        System.out.println("Is palindroom2: " + isPalindroom2);*/
        System.out.println("Resultaat: " + result);
    }
}
