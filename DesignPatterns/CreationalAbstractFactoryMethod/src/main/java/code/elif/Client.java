package code.elif;

import code.elif.unit.factory.GameUnitFactory;
import code.elif.unit.factory.IndustrialUnitGameAbstractFactory;
import code.elif.unit.model.land.LandUnit;
import code.elif.unit.model.naval.NavalUnit;

public class Client {
    private GameUnitFactory gameUnitFactory;

    public Client(GameUnitFactory gameUnitFactory) {
        this.gameUnitFactory = gameUnitFactory;
    }

    public static void main(String[] args) {
        Client client = new Client(new IndustrialUnitGameAbstractFactory());

        LandUnit landUnit = client.gameUnitFactory.createLandUnit();
        NavalUnit navalUnit = client.gameUnitFactory.createNavalUnit();

        landUnit.attack();
        navalUnit.sail();
    }
}
