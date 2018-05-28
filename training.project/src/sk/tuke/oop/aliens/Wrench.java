package sk.tuke.oop.aliens;

import sk.tuke.oop.framework.Animation;

public class Wrench extends AbstractTool {

    public Wrench() {

        this.remaining = 2;
        Animation wrenchAnimation = new Animation("resources/images/wrench.png", 16, 16, 100);
        setAnimation(wrenchAnimation);
    }
}
