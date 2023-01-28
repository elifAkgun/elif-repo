package code.elif.app.features.java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMismatchExample {
    public static void main(String[] args) throws IOException {
        Path first = Path.of("src/main/java/code/elif/app/features/java12/first.txt");
        Path second = Path.of("src/main/java/code/elif/app/features/java12/second.txt");

        long mismatch = Files.mismatch(first, second);

        System.out.println(mismatch);
    }
}
