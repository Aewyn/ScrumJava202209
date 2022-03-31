package be.aewyn.gastenboek;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GastenboekEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private final LocalDateTime date = LocalDateTime.now();
    private String author;
    private String message;

    public GastenboekEntry(String author, String message){
        setAuthor(author);
        setMessage(message);
    }

    private void setAuthor(String author){
        if (author != null && !author.equals("")){
            this.author = author;
        }
        else{
            throw new IllegalArgumentException("Probleem in de naam van de auteur");
        }
    }

    private void setMessage(String message){
        if (message != null && !message.equals("")){
            this.message = message;
        }
        else {
            throw new IllegalArgumentException("Probleem in het bericht");
        }
    }

    @Override
    public String toString() {
        return "Datum: " + date +
                ", Auteur: " + author +
                ", Bericht: " + message;
    }
}