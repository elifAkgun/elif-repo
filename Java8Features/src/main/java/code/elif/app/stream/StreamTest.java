package code.elif.app.stream;

import code.elif.app.Shape;
import code.elif.app.ShapeService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    static ShapeService shapeService = new ShapeService();
    static List<Shape>  shapeList = (List<Shape>) shapeService.getShapes(new ArrayList());

    public static void main(String[] args) {
      //  runFilterExample();
      //  runMapExample();
        processByCount();
    }

    private static void processByCount() {
       long count = shapeList.stream()
                .filter(s -> s.getArea() > 50)
                .count();
        System.out.println("Only " + count + " shape(s) founded in the list.");
    }

    private static void runMapExample() {
        List<Integer> list = Arrays.asList(0,5,10,15,20,25);
        List<Integer> doubledList = list.stream().map(l-> l*2).collect(Collectors.toList());
        for(int l : doubledList){
            System.out.println(l);
        }
    }

    private static void runFilterExample() {
        List<Shape> shapeList = (List<Shape>) shapeService.getShapes(new ArrayList());

        List<Shape> collectedList = shapeList.stream()
                .filter(s -> s.getArea() > 50)
                .collect(Collectors.toList());
        for (Shape s : collectedList) {
            s.draw();
        }
    }
}