package code.elif.unit.model.land;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class LandUnit {
    int coordinateX, coordinateY;

    public abstract void attack();
    public abstract void defence();
}
