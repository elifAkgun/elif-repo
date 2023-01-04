package code.elif.app.features.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileContentToString {

    public static final String TEXT_TXT = "src/main/java/code/elif/app/features/java11/text.txt";

    public static void main(String[] args) throws IOException {
        printFileContentUsingReadString();
    }

    private static void printFileContent() throws IOException {
        String fileContent =
                new String(Files.readAllBytes(Paths.get(TEXT_TXT)));

        System.out.println(fileContent);
    }

    private static void printFileContentUsingReadString() throws IOException {
        String fileContent = Files.readString(Paths.get("src/main/java/code/elif/app/features/java11/text.txt"));
        System.out.println(fileContent);
    }
}
