package be.aewyn.threads;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class InsectReader implements Runnable{
    private static final BigDecimal MAXIMUM = BigDecimal.valueOf(3);
    private final Path path;
    private final PrintStream stream;
    private int amountOfLines;

    public InsectReader(String file, PrintStream stream){
        this.path = Path.of(file);
        this.stream = stream;
    }

    @Override
    public void run() {
        try(var reader = Files.newBufferedReader(path)) {
            for(String line; (line = reader.readLine()) != null;){
                var parts = line.split(";");
                var price = new BigDecimal(parts[1]);
                if (price.compareTo(MAXIMUM) <= 0){
                    //stream.println(path.getFileName() + ":" + line);
                    ++amountOfLines;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getAmountOfLines(){
        return amountOfLines;
    }
}
