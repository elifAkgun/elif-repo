package code.elif.app.stream;

import code.elif.app.Shape;
import code.elif.app.ShapeService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
      //  runFilterExample();
        runMapExample();
    }

    private static void runMapExample() {
        List<Integer> list = Arrays.asList(0,5,10,15,20,25);
        List<Integer> doubledList = list.stream().map(l-> l*2).collect(Collectors.toList());
        for(int l : doubledList){
            System.out.println(l);
        }
    }

    private static void runFilterExample() {
        ShapeService shapeService = new ShapeService();
        List<Shape> shapeList = (List<Shape>) shapeService.getShapes(new ArrayList());

        List<Shape> collectedList = shapeList.stream()
                .filter(s -> s.getArea() > 50)
                .collect(Collectors.toList());
        for (Shape s : collectedList) {
            s.draw();
        }
    }
}