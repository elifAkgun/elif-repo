package code.elif.app.features.funcInterface.biConsumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class BiConsumerTest {
    public static void main(String[] args) {

        int[] array = {0, 5, 10, 15, 20, 25};

        Predicate<Integer> isNumberEven = (i) -> i % 2 == 0;

        for (int x : array) {
            if (isNumberEven.test(x)) {
                System.out.println(x + " is even..");
            }
        }


        // run();
    }

    private static void run() {
        BiConsumer<Employee, BigDecimal> addPromotionToEmpSalary = (emp, promotion) -> {
            emp.setSalary(emp.getSalary().add(promotion));
        };

        Employee employee = new Employee("John White", new BigDecimal(10000));
        System.out.println("Before the promotion" + employee);
        BigDecimal promotion = new BigDecimal(200);
        addPromotionToEmpSalary.accept(employee, promotion);
        System.out.println("After the promotion" + employee);
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Employee {
    private String fullName;
    private BigDecimal salary;
}
