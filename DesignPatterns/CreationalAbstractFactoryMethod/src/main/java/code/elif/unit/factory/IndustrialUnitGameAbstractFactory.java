package code.elif.unit.factory;

import code.elif.unit.model.land.LandUnit;
import code.elif.unit.model.land.impl.RiffleMan;
import code.elif.unit.model.naval.NavalUnit;
import code.elif.unit.model.naval.impl.Ironclad;

public class IndustrialUnitGameAbstractFactory implements GameUnitFactory{

    public LandUnit createLandUnit() {
        LandUnit landUnit = new RiffleMan();
        return landUnit;
    }

    public NavalUnit createNavalUnit() {
        NavalUnit navalUnit = new Ironclad();
        return navalUnit;
    }
}
