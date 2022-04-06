package be.aewyn.threads;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        var readerOne = new InsectReader("/data/insecten1.csv",System.out);
//        var threadOne = new Thread(readerOne);
//        var readerTwo = new InsectReader("/data/insecten2.csv",System.err);
//        var threadTwo = new Thread(readerTwo);
//
//        threadOne.start();
//        threadTwo.start();
//
//        try{
//            threadOne.join();
//            threadTwo.join();
//        } catch (InterruptedException e) {
//            System.err.println(e);
//        }
//
//        System.out.println(readerOne.getAmountOfLines() + readerTwo.getAmountOfLines() + " regels");
//
//        var clock = new Clock();
//        var threadClock = new Thread(clock);
//        threadClock.setDaemon(true);
//        threadClock.start();
//        var scanner = new Scanner(System.in);
//        scanner.nextLine();
//
//        var stack = new Stack();
//        var threadStackOne = new Thread(new Chef(stack));
//        var threadStackTwo = new Thread(new Chef(stack));
//
//        threadStackOne.start();
//        threadStackTwo.start();
//
//        try{
//            threadStackOne.join();
//            threadStackTwo.join();
//        } catch (InterruptedException e) {
//            System.err.println(e);
//        }
//        System.out.println(stack.getAmountOfPancakes());

        double[] randomDoubles = new double[1_000_000];
        var random = new Random();
        for (var i = 0; i < randomDoubles.length; i++){
            randomDoubles[i] = random.nextInt();
        }

        var calcOne = new GemiddeldeRekenaar(randomDoubles,0,randomDoubles.length/2);
        var calcTwo = new GemiddeldeRekenaar(randomDoubles,randomDoubles.length/2,randomDoubles.length);

        var thread1 = new Thread(calcOne);
        var thread2 = new Thread(calcTwo);

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread one average: " + calcOne.getAverage());
        System.out.println("Thread two average: " + calcTwo.getAverage());

        System.out.println("Average of the two averages: " + (calcOne.getAverage() + calcTwo.getAverage()) / 2);
    }

}
