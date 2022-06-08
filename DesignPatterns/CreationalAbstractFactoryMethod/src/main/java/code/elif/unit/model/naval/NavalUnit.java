package code.elif.unit.model.naval;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class NavalUnit {
    int coordinateX, coordinateY;

    public abstract void sail();
    public abstract void sendFrigate();
}
