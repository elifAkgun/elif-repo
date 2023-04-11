package code.elif.app.features.general.accessModifier.engine;

import code.elif.app.features.general.accessModifier.Vehicle;

public class Car extends Vehicle {

    public static void main(String[] args) {
        Car car = new Car();
        // System.out.println(car.defaultValue);
        System.out.println(car.protectedValue);
    }
}
