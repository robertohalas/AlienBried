package sk.tuke.oop.aliens;

import sk.tuke.oop.framework.Animation;

public class Hammer extends AbstractTool {

    public Hammer() {
        this.remaining = 1;
        Animation hammerAnimation = new Animation("resources/images/hammer.png", 16, 16, 10);
        setAnimation(hammerAnimation);
    }
}
