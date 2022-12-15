package code.elif.app.features.stream.skip;

import code.elif.app.model.Employee;

import java.time.LocalDate;
import java.util.stream.Stream;

public class StreamSkipExample {

    public static void main(String[] args) {
        arrayStreamSkip();
        employeeStreamSkip();
        integerStreamSkip();
    }

    private static void arrayStreamSkip() {
        Double[] arrayDouble = {10.1, 10.2, 10.3, 10.4};
        Stream<Double> doubleStream = Stream.of(arrayDouble);
        doubleStream.skip(3)
                .forEach(System.out::println);
    }

    private static void employeeStreamSkip() {
        Stream<Employee> employeeStream = Stream.of(
                new Employee(1, "Lesley", LocalDate.now()),
                new Employee(2, "Yin", LocalDate.now()),
                new Employee(3, "Rafael", LocalDate.now())
        );

        employeeStream.skip(2).forEach(System.out::println);
    }

    private static void integerStreamSkip() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        integerStream.skip(2).forEach(s -> System.out.print(s + " "));
    }
}
