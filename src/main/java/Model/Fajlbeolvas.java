package Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fajlbeolvas {

    public static void main(String[] args) {
        String fajlnev = "fajl.txt";
        try {
            List<String> sorok = beolvas(fajlnev);
            sorok.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Hiba történt a fájl beolvasásakor: " + e.getMessage());
        }
    }

    public static List<String> beolvas(String fajlnev) throws IOException {
        Path utvonal = Paths.get(fajlnev);
        try (Stream<String> stream = Files.lines(utvonal)) {
            return stream.collect(Collectors.toList());
        }
    }
}