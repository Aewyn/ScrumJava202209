package be.aewyn.lambda;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    private static final Path COUNTRIES_PATH = Path.of("/data/countries.txt");
    private static final Path COUNTRIES_PATH_BACKUP = Path.of("/data/countries.bak");
    private static final Path LANGUAGES_PATH = Path.of("/data/languages.txt");
    private static final Path LANGUAGES_PATH_BACKUP = Path.of("/data/languages.bak");

    public static void main(String[] args) {
        EvenGetallen evenGetallen = getal -> getal %2 == 0;
        System.out.println(evenGetallen.isEven(8));

        var groenten = new String[]{"tomaat", "sla", "ui", "prei"};
        Arrays.sort(groenten, (groente1, groente2) -> {
            return groente2.length() - groente1.length();
        });
        System.out.println(Arrays.toString(groenten));

        new Thread(() -> legeRegelsVerwijderen()).start();
        new Thread(() -> dubbelsVerwijderen()).start();

        var optioneelCijfer = eersteCijfer("all4you");
        if(optioneelCijfer.isPresent()){
            System.out.println(optioneelCijfer.get() * 10);
        }
        optioneelCijfer = eersteCijfer("wrong");
        if(optioneelCijfer.isPresent()){
            System.out.println(optioneelCijfer.get() * 10);
        }

        optioneelCijfer = eersteCijfer("testje4mezelf");
        optioneelCijfer.ifPresent(cijfer -> System.out.println(cijfer * 10));
        optioneelCijfer = eersteCijfer("kakapeepeepoopoo");
        optioneelCijfer.ifPresent(cijfer -> System.out.println(cijfer * 10));

        eersteCijfer("Nou4ja").ifPresent(cijfer -> System.out.println(cijfer*10));

        var vegetables = new String[]{"tomaat","sla", "ui", "prei"};
        Arrays.stream(vegetables).forEach(veggie -> System.out.println(veggie));

        var vegetablesList = List.of("tomaat", "sla", "ui", "prei");
        vegetablesList.stream().forEach(veggie -> System.out.println(veggie));

        var holyNumbers = new LinkedHashSet<Integer>();
        holyNumbers.add(1);
        holyNumbers.add(3);
        holyNumbers.add(4);
        holyNumbers.add(7);
        holyNumbers.stream().forEach(number -> System.out.println(number));

        var languages = new LinkedHashMap<String, String>();
        languages.put("NL", "Nederlands");
        languages.put("FR", "Frans");
        languages.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + ": "+ entry.getValue()));

        "Lambdafun".chars().forEach(unicode -> System.out.println((char) unicode));

        try(var stream = Files.lines(LANGUAGES_PATH)){
            stream.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream.of("Adam", "Eva").forEach(name -> System.out.println(name));

        //Infinite loop
        //Stream.iterate(1, previous -> previous + 2).forEach(unevenNumber -> System.out.println(unevenNumber));

        //Limited loop
        Stream.iterate(1, previous -> previous + 2).limit(10).forEach(unevenNumber -> System.out.println(unevenNumber));

        IntStream.rangeClosed(1,10).forEach(number -> System.out.println("Closed: " + number));
        IntStream.range(1,10).forEach(number -> System.out.println("Not closed: " + number));

        System.out.println("\nSorted without parameters:");
        Stream.of("sla", "wortel", "kool", "biet").sorted().forEach(veggie -> System.out.println(veggie));

        System.out.println("\nSorted with parameters:");
        Stream.of("sla", "wortel", "kool", "biet").sorted((veggie1, veggie2) -> veggie1.length() - veggie2.length()).forEach(System.out::println);

        System.out.println("\nSort with multiple criteria:");
        Comparator<String> comparator = (veggie1, veggie2) -> veggie1.length() - veggie2.length();
        comparator = comparator.thenComparing((veggie1, veggie2) -> veggie1.compareTo(veggie2));
        Stream.of("sla", "wortel", "kool", "biet").sorted(comparator).forEach(veggie -> System.out.println(veggie));

        System.out.println("\nUsing filter, sort and forEach");
        Stream.of("sla", "wortel", "kool", "biet").filter(veggie -> veggie.length() == 4).sorted().forEach(veggie -> System.out.println(veggie));

        System.out.println("\nUsing Distinct: ");
        Stream.of("sla", "kool", "wortel", "biet", "sla").distinct().forEach(System.out::println);

        System.out.println("\nUsing custom objects");
        Stream.of(new Rectangle(6,2), new Rectangle(3,1), new Rectangle(5,4)).map(rectangle -> rectangle.getSurface()).sorted().forEach(System.out::println);

        System.out.println("\nallMatch");
        System.out.println(Stream.of("sla", "wortel", "kool", "biet").allMatch(veg -> veg.length() == 4));
    }

    private static void legeRegelsVerwijderen(){
        try{
            Files.deleteIfExists(COUNTRIES_PATH_BACKUP);
            Files.move(COUNTRIES_PATH, COUNTRIES_PATH_BACKUP);
            try(var reader = Files.newBufferedReader(COUNTRIES_PATH_BACKUP);
                var writer = Files.newBufferedWriter(COUNTRIES_PATH)){
                for (String regel; (regel = reader.readLine()) != null;){
                    if(!regel.isEmpty()){
                        writer.write(regel);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dubbelsVerwijderen(){
        var uniekeTalen = new LinkedHashSet<String>();
        try{
            Files.deleteIfExists(LANGUAGES_PATH_BACKUP);
            Files.move(LANGUAGES_PATH, LANGUAGES_PATH_BACKUP);
            try(var reader = Files.newBufferedReader(LANGUAGES_PATH_BACKUP)){
                for (String regel; (regel = reader.readLine()) != null;){
                    uniekeTalen.add(regel);
                }
            }
            try(var writer = new PrintWriter(Files.newBufferedWriter(LANGUAGES_PATH))){
                for (var taal : uniekeTalen){
                    writer.println(taal);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Optional<Integer> eersteCijfer(String string){
        for (int index = 0; index != string.length(); index ++){
            var teken = string.charAt(index);
            if(Character.isDigit(teken)){
                return Optional.of(Character.getNumericValue(teken));
            }
        }
        return Optional.empty();
    }
}
