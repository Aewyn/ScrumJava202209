package be.aewyn.gastenboek;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class GastenboekManager {
    private final static Path PATH = Path.of("/data/guestbook/");
    private final static Path FILE = Path.of("/data/guestbook/entries.txt");
    public static void writeToFile(Gastenboek gastenBoek){
        if(Files.exists(FILE)){
            try(var stream = new ObjectOutputStream(Files.newOutputStream(FILE))){
                stream.writeObject(gastenBoek);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try{
                Files.createDirectory(PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                Files.createFile(FILE);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try(var stream = new ObjectOutputStream(Files.newOutputStream(FILE))){
                stream.writeObject(gastenBoek);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static Gastenboek readEntriesFromFile(){
        if(Files.exists(FILE)){
            System.out.println("Reading path found!");
            try(var stream = new ObjectInputStream(Files.newInputStream(FILE))){
                return (Gastenboek) stream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("Reading path not found...");
        }
        return new Gastenboek();
    }
}
