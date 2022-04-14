package code.elif.app.features.stream.of;

import code.elif.app.model.Employee;

import java.time.LocalDate;
import java.util.stream.Stream;

public class StreamOfExample {
    public static void main(String[] args) {
        integerStream();
        employeeStream();
        arrayStream();
    }

    private static void arrayStream() {
        Double [] arrayDouble = {10.1,10.2,10.3,10.4};
        Stream<Double> doubleStream = Stream.of(arrayDouble);
        doubleStream.forEach(System.out::println);
    }

    private static void employeeStream() {
        Stream<Employee> employeeStream = Stream.of(
                new Employee(1, "Lesley", LocalDate.now()),
                new Employee(2, "Yin", LocalDate.now()),
                new Employee(3, "Rafael", LocalDate.now())
        );

        employeeStream.forEach(System.out::println);
    }

    private static void integerStream() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.forEach(System.out::println);
    }
}
