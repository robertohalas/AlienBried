package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Light extends AbstractActor implements Switchable, EnergyConsumer {

    private final Animation lightonAnimation;
    private final Animation lightoffAnimation;
    private boolean powered;
    private boolean on1;

    public Light() {

        this.on1 = false;
        this.powered = false;
        lightonAnimation = new Animation("resources/images/light_on.png", 16, 16, 10);
        lightoffAnimation = new Animation("resources/images/light_off.png", 16, 16, 10);
        setAnimation(lightoffAnimation);
    }

    @Override
    public void setElectricityFlow(boolean set) {
        this.powered = set;
        this.on1 = !this.on1;
        toggle();
    }

    public void toggle() {

        if (this.powered == true) {
            if (this.on1 == false) {
                this.on1 = true;
                setAnimation(lightonAnimation);
            } else {
                this.on1 = false;
                setAnimation(lightoffAnimation);
            }
        } else {
            setAnimation(lightoffAnimation);
            if (this.on1 == true) {
                this.on1 = false;
            } else {
                this.on1 = true;
            }
        }
    }

    @Override
    public void on() {
        this.on1 = false;
        toggle();
    }

    @Override
    public void off() {
        this.on1 = true;
        toggle();
    }

    @Override
    public boolean isOn() {
        return this.on1;
    }

}
