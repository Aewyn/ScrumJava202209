package be.aewyn.gastenboek;

import java.io.Serializable;
import java.util.ArrayList;

public final class Gastenboek implements Serializable {
    static final ArrayList<GastenboekEntry> entries = new ArrayList<>();

    public static void addEntry(String author, String message){
        entries.add(new GastenboekEntry(author,message));
    }

    @Override
    public String toString(){
        return String.valueOf(entries);
    }
}