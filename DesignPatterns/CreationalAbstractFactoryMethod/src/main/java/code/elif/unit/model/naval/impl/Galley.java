package code.elif.unit.model.naval.impl;

import code.elif.unit.model.naval.NavalUnit;

public class Galley extends NavalUnit {
    public void sail() {
        System.out.println("Galley is sailing...");
    }

    public void sendFrigate() {
        System.out.println("Galley is sending frigate...");
    }
}