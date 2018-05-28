package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Controller extends AbstractActor {

    public Reactor reactor;
    public boolean on;

    public Controller(Reactor reactor) {

        this.reactor = reactor;
        on = false;
        Animation switchAnimation = new Animation("resources/images/switch.png", 16, 16, 100);
        setAnimation(switchAnimation);
    }

    public void toggle() {

        if (reactor.isOn()) {
            reactor.off();
        } else {
            reactor.on();
        }
    }
}
