package code.elif.app.features.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringToFile {
    public static final String TEXT_TXT = "src/main/java/code/elif/app/features/java11/first.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get(TEXT_TXT);

        String writtenFileContent = "Hello this is my first file!";
        Files.writeString(path, writtenFileContent);

        String readFileContent = Files.readString(path);
        System.out.println(writtenFileContent.equals(readFileContent));
        Thread.sleep(100000);
    }
}
