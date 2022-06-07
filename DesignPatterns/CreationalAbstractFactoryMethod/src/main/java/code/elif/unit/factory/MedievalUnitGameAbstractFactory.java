package code.elif.unit.factory;

import code.elif.unit.model.land.LandUnit;
import code.elif.unit.model.land.impl.RiffleMan;
import code.elif.unit.model.land.impl.SwordsMan;
import code.elif.unit.model.naval.NavalUnit;
import code.elif.unit.model.naval.impl.Galley;

public class MedievalUnitGameAbstractFactory implements GameUnitFactory{

    public LandUnit createLandUnit() {
        LandUnit landUnit = new SwordsMan();
        return landUnit;
    }

    public NavalUnit createNavalUnit() {
        NavalUnit navalUnit = new Galley();
        return navalUnit;
    }
}
