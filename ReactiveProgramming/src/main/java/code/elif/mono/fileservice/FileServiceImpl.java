package code.elif.mono.fileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl {
    protected static void writeFile(String fileName, String content) throws IOException {
        Files.writeString(Path.of(fileName), content);
    }

    protected static String readFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }

    protected static void delete(String fileName) throws IOException {
        Files.delete(Path.of(fileName));
    }
}
