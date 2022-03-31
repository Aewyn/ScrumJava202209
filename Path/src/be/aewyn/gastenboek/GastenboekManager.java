package be.aewyn.gastenboek;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public abstract class GastenboekManager {
    public static void writeToFile(){
        if(Files.exists(Path.of("/data/guestbook/entries.txt"))){
            try(var stream = new ObjectOutputStream(Files.newOutputStream(Path.of("/data/guestbook/entries.txt")))){
                stream.writeObject(Gastenboek.entries);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try{
                Files.createFile(Path.of("/data/guestbook/entries.txt"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try(var stream = new ObjectOutputStream(Files.newOutputStream(Path.of("/data/guestbook/entries.txt")))){
                for (var entry:Gastenboek.entries) {
                    stream.writeObject(entry);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void readEntriesFromFile(){
        if(Files.exists(Path.of("/data/guestbook/entries.txt"))){
            System.out.println("Reading path found!");
            try(var stream = new ObjectInputStream(Files.newInputStream(Path.of("/data/guestbook/entries.txt")))){
                ArrayList<GastenboekEntry> entries = (ArrayList<GastenboekEntry>) stream.readObject();
                for (var i = entries.size(); i > 0; i-- ) {
                    System.out.println(entries.get(i-1));
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Reading path not found...");
        }
    }
}
