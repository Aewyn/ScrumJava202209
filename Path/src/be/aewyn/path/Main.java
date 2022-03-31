package be.aewyn.path;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        var afbeeldingen = Path.of("/data/afbeeldingen");
//        System.out.println(afbeeldingen.getParent());
//        var huidigeDirectory = Path.of("plaatselijk");
//        System.out.println(huidigeDirectory.toAbsolutePath());

        //Controleren of een locatie bestaat
//        System.out.println("Bestaat /data: " + Files.exists(Path.of("/data")));

        //Controleren of een locatie verwijst naar een directory of naar een file
//        var data = Path.of("/data");
//        System.out.println("\nIs directory: " + Files.isDirectory(data));
//        System.out.println("Is bestand: " + Files.isRegularFile(data));

        //Een directory maken
//        try{
//            Files.createDirectory(Path.of("/data/teksten"));
//        } catch (IOException ex){
//            System.out.println(ex);
//        }

        //Een directory hernoemen
//        try{
//            Files.move(Path.of("/data/afbeeldingen"), Path.of("/data/images"));
//        } catch (IOException ex){
//            System.out.println(ex);
//        }

        //Een directory verwijderen
//        try{
//            Files.delete(Path.of("/data/teksten"));
//        } catch (IOException ex){
//            System.out.println(ex);
//        }

        //Grootte van een bestand opvragen
//        try{
//            System.out.println(Files.size(Path.of("/data/images/duimop.jpg")));
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        //Een bestand kopiëren
//        try{
//            Files.copy(Path.of("/data/images/duimop.jpg"), Path.of("/data/images/thumbup.jpg"));
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        //Een bestand hernoemen
//        try{
//            Files.move(Path.of("/data/images/thumbup.jpg"), Path.of("/data/images/thumb.jpg"));
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        //Een bestand verwijderen
//        try{
//            Files.delete(Path.of("/data/images/thumb.jpg"));
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        //De volledige tekst van een bestand lezen in het interne geheugen
//        try{
//            var regels = Files.readAllLines(Path.of("/data/insecten1.csv"));
//            for (var regel : regels){
//                System.out.println(regel);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        //De tekst van een bestand in blokken lezen
//        try{
//            var reader = Files.newBufferedReader(Path.of("/data/insecten1.csv"));
//            try{
//                var regel = reader.readLine();
//                //Steek reader.readLine in de variabele regel en check of deze verschilt van null
//                while ((regel = reader.readLine()) != null){
//                    System.out.println(regel);
//                }
//            } catch (IOException e) {
//                System.out.println(e);
//            } finally {
//                reader.close();
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        //Try with resources
//        try (var reader = Files.newBufferedReader(Path.of("/data/insecten1.csv"))){
//            for (String regel; (regel = reader.readLine()) != null;){
//                System.out.println(regel);
//            }
//        } catch (IOException e){
//            System.out.println(e);
//        }

        //Tekst schrijven naar een bestand
//        try (var writer = Files.newBufferedWriter(Path.of("/data/naam.txt"))){
//            writer.write("Jean");
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        //Getallen schrijven
//        var typeScanner = new Scanner(System.in);
//        System.out.println("Tik getallen. Tik 0 om te stoppen:");
//        try(var writer = new PrintWriter(Files.newBufferedWriter(Path.of("/data/getallen.txt")))){
//            for (int getal; (getal = typeScanner.nextInt()) != 0;){
//                writer.println(getal);
//            }
//        } catch (IOException e){
//            System.out.println(e);
//        }

        //Getallen lezen
//        try(var readScanner = new Scanner(Files.newBufferedReader(Path.of("/data/getallen.txt")))){
//            while(readScanner.hasNext()){
//                System.out.println(readScanner.nextInt());
//            }
//        }catch (IOException e){
//            System.out.println(e);
//        }

        //Binaire bestanden -> code/afbeeldingen/geluid/video/...
        //Een kopie maken van een afbeelding maar byte per byte
//        try(var input = Files.newInputStream(Path.of("/data/images/duimop.jpg")); var output = Files.newOutputStream(Path.of("/data/images/thumb.jpg"))){
//            for (int eenByte; (eenByte = input.read()) != -1;){
//                output.write(eenByte);
//            }
//        } catch (IOException e){
//            System.out.println(e);
//        }

        //De inhoud van een directory opvragen
//        try(var stream = Files.newDirectoryStream(Path.of("/data"))){
//            for (var path : stream){
//                System.out.print(path);
//                System.out.println(Files.isDirectory(path) ? ":directory" : ":bestand");
//            }
//        } catch (IOException e){
//            System.out.println(e);
//        }

        //Serialization
//        try(var outStream = new ObjectOutputStream(Files.newOutputStream(Path.of("/data/punt.ser")))){
//            outStream.writeObject(new Punt(15,32));
//        } catch (IOException e){
//            System.out.println(e);
//        }

        //Deserialization
        try(var inStream = new ObjectInputStream(Files.newInputStream(Path.of("/data/punt.ser")))){
            var punt = (Punt) inStream.readObject();
            System.out.println(punt);
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
