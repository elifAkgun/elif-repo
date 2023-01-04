package code.elif.app.features.java10.typeInference;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LocalVariableTypeInference {
    public static void main(String[] args) throws IOException {
        List<String> fruits = getFruits();
        createFile(fruits);
        readFile();
    }

    private static void createFile(List<String> fruits) throws IOException {
        File fruitFile = new File("text.txt");
        FileWriter fileWriter = new FileWriter(fruitFile);
        fileWriter.write(fruits.toString());
        fileWriter.close();
        fruitFile.createNewFile();
    }

    private static List<String> getFruits() {
        var fruits = List.of("Apple", "Orange", "Strawberry");
        for (var fruit : fruits) {
            System.out.println(fruit);
        }
        return fruits;
    }

    private static void readFile() {
        try(var scanner = new Scanner(new File("text.txt"))){
            while (scanner.hasNext())
                System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
