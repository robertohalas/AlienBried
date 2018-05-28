package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

public class TimeBomb extends AbstractActor {

    private int time;
    private boolean on;
    private final Animation activoffAnimation;
    private final Animation activonAnimation;
    private final Animation explosAnimation;

    public TimeBomb(int time) {

        this.time = time + 100;
        this.on = false;
        activoffAnimation = new Animation("resources/images/bomb.png", 16, 16, 100);
        activonAnimation = new Animation("resources/images/bomb_activated.png", 16, 16, 200);
        explosAnimation = new Animation("resources/images/small_explosion.png", 16, 16, 200);
        setAnimation(activoffAnimation);
    }

    public void activate() {

        if (this.on == false) {
            this.on = true;
        }
        setAnimation(activonAnimation);
    }

    @Override
    public void act() {
        World aktor = this.getWorld();
        if (this.on == true) {
            if (this.time > 0) {
                this.time -= 1;
            } else {
                setAnimation(activoffAnimation);
            }
        }
        if (this.time == 100) {
            setAnimation(explosAnimation);
        }
        if (this.time == 0) {
            aktor.removeActor(this);
        }
    }

}
