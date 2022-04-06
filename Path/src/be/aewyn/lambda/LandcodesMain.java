package be.aewyn.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class LandcodesMain {
    public static void main(String[] args){
        //getLand("DE").ifPresent(landnaam -> System.out.println(landnaam));
        showSorted();
    }

    private static void showSorted(){
        try(var stream = Files.lines(Path.of("/data/landcodes.txt"))){
            stream.map(line -> line.split(" ")[1]).sorted().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Optional<String> getLand(String landcode){
        try(var reader = Files.newBufferedReader(Path.of("/data/landcodes.txt"))){
            for(var line = ""; (line = reader.readLine()) != null;){
                var splittedLine = line.split(" ");
                if(landcode.equals(splittedLine[0])){
                    return Optional.of(splittedLine[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
