package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Cooler extends AbstractActor implements Switchable {

    private final Animation coolerAnimation;
    public Reactor reactor;
    private boolean status;

    public Cooler(Reactor reactor) {

        this.status = true;
        this.reactor = reactor;
        coolerAnimation = new Animation("resources/images/fan.png", 32, 32, 200);
        setAnimation(coolerAnimation);
        coolerAnimation.stop();
    }

    @Override
    public void act() {

     if(this.reactor != null){
        if (this.status == true) {
            coolerAnimation.start();
        } else {
            coolerAnimation.stop();
        }
         if (this.status == true) {
            this.reactor.decreaseTemperature(1);
            coolerAnimation.start();
        }
    }
    }

    @Override
    public void on() {
        this.status = true;
        coolerAnimation.start();
    }

    @Override
    public void off() {
        this.status = false;
        coolerAnimation.stop();
    }

    @Override
    public boolean isOn() {
        if(this.status == true){
            return true;
        }
        else return false;
    }
}