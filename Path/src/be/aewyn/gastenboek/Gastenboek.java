package be.aewyn.gastenboek;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Gastenboek implements Serializable {
    private final List<GastenboekEntry> entries = new ArrayList<>();

    public void addEntry(GastenboekEntry ge){
        entries.add(ge);
    }

    @Override
    public String toString(){
        return String.valueOf(entries);
    }
}