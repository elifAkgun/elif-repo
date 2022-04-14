package code.elif.app.features.stream.count;

import code.elif.app.service.ShapeService;

import java.util.Arrays;
import java.util.List;

public class StreamCountExample {

    public static void main(String[] args) {
        processByCount();
        streamCountExample();
    }

    private static void processByCount() {
        ShapeService shapeService = new ShapeService();

        long count = shapeService.getShapes().stream()
                .filter(s -> s.getArea() > 50)
                .count();
        System.out.println("Only " + count + " shape(s) founded in the list.");
    }

    private static void streamCountExample() {
        List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);
        long count = list.stream()
                .filter(s -> s > 15)
                .count();
        System.out.println("Only " + count + " item(s) founded in the list.");
        //Only 2 item(s) founded in the list.
    }
}
