package sk.tuke.oop.aliens;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.aliens.actor.AbstractActor;

public class PowerSwitch extends AbstractActor {

    Animation switchAnimation;
    Switchable switchable;

    public PowerSwitch(Switchable switchable) {

        this.switchable = switchable;
        switchAnimation = new Animation("resources/images/switch.png", 16, 16, 100);
        switchAnimation.setPingPong(true);
        setAnimation(switchAnimation);
    }

    public void turnOn() {
        if(this.switchable != null){
        switchable.on();
        }
    }

    public void turnOff() {
        if(this.switchable != null){
        switchable.off();
        }
    }
}