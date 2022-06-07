package code.elif.unit.factory;

import code.elif.unit.model.land.LandUnit;
import code.elif.unit.model.naval.NavalUnit;

public interface GameUnitFactory {
    public LandUnit createLandUnit();
    public NavalUnit createNavalUnit();
}
