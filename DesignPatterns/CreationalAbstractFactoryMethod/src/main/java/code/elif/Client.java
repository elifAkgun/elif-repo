package code.elif;

import code.elif.unit.factory.GameUnitFactory;
import code.elif.unit.factory.IndustrialUnitGameAbstractFactory;
import code.elif.unit.model.land.LandUnit;
import code.elif.unit.model.naval.NavalUnit;

public class Client {

    public static void main(String[] args) {
        GameUnitFactory gameUnitFactory = new IndustrialUnitGameAbstractFactory();

        LandUnit landUnit = gameUnitFactory.createLandUnit();
        NavalUnit navalUnit = gameUnitFactory.createNavalUnit();

        landUnit.attack();
        navalUnit.sail();
    }
}
