package be.aewyn.lambda;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class SterrenbeeldenMain {
    private static final Path STAR_PATH = Path.of("/data/sterrenbeelden.txt");

    public static void main(String[] args) throws IOException {
        //show();
        search("ee");
    }

    private static void show() {
        try (var reader = Files.lines(STAR_PATH)) {
            reader.forEach(line -> System.out.println(line.toUpperCase(Locale.ROOT)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void search(String word) throws IOException {
        try (var reader = Files.lines(STAR_PATH)) {
            reader.filter(line -> line.contains(word)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
