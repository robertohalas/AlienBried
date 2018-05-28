package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Laser extends AbstractActor {

    private Ripley ripley;
    private int time;
    private boolean on;
    private int cyklus;

    public Laser(String name) {

        super(name);
        this.on = true;
        this.time = 150;
        this.cyklus = 1;
        Animation animationlaser = new Animation("resources/sprites/laser.png", 16, 48, 100);
        animationlaser.setPingPong(true);
        setAnimation(animationlaser);

    }

    public void offLaser() {
        this.on = false;
        getAnimation().stopAt(0);

    }

    public void onLaser() {
        this.on = true;
        getAnimation().start();
        getAnimation().stopAt(4);
    }

    @Override
    public void act() {

        this.time -= 1;
        if (this.time == 75) {
            offLaser();
        }
        if (this.time == 0) {
            onLaser();
            this.time = 150;
        }
        for (Actor actor : getWorld()) {
            if (intersects(actor) == true && actor instanceof Ripley) {
                this.ripley = (Ripley) actor;
                if (this.on == true && this.cyklus == 1) {
                    this.ripley.setEnergy(0);
                    this.cyklus -= 1;
                   
                }
            }
        }
    }
}
