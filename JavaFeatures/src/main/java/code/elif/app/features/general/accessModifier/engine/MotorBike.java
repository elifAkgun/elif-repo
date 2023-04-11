package code.elif.app.features.general.accessModifier.engine;

import code.elif.app.features.general.accessModifier.Bike;

public class MotorBike extends Bike {

    public static void main(String[] args) {
        MotorBike motorBike = new MotorBike();
        //System.out.println(motorBike.defaultValue);
        System.out.println(motorBike.protectedValue);
    }
}
