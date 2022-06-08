package code.elif;

import code.elif.unit.factory.GameUnitFactory;
import code.elif.unit.factory.IndustrialUnitGameAbstractFactory;
import code.elif.unit.model.land.LandUnit;
import code.elif.unit.model.naval.NavalUnit;

public class Client {

    LandUnit landUnit;
    NavalUnit navalUnit;

    public Client(GameUnitFactory gameUnitFactory){
        landUnit = gameUnitFactory.createLandUnit();
        navalUnit = gameUnitFactory.createNavalUnit();
    }

    public static void main(String[] args) {

        Client client = new Client(new IndustrialUnitGameAbstractFactory());

        client.landUnit.attack();
        client.navalUnit.sail();
    }
}
