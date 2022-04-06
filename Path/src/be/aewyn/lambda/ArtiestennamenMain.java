package be.aewyn.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ArtiestennamenMain {
    public static void main(String[] args) {
        try (var stream = Files.lines(Path.of("/data/albumsartists.txt"))) {
            stream.map(line -> line.split(",",2)[1]).distinct().sorted().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(var stream = Files.lines(Path.of("/data/albumsartists.txt"))){
            stream.map(line -> line.substring(line.indexOf(',') + 1)).distinct().sorted().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
