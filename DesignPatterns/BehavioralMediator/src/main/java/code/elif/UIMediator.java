package code.elif;

import java.util.ArrayList;
import java.util.List;

//Mediator
public class UIMediator {

    List<UIControl> uiControls = new ArrayList<UIControl>();

    public void register(UIControl control) {
        uiControls.add(control);
    }

    public void valueChanged(UIControl control) {
        uiControls.stream()
                .filter(c -> c != control)
                .forEach(c -> c.controlChanged(control));
    }
}
