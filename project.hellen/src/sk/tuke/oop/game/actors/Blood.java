package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;


public class Blood extends AbstractActor {
    private int time;
    private final boolean on;

    public Blood(String name, boolean on) {
        super(name);
        this.on = on;
        this.time = 100;
        Animation animationblood = new Animation("resources/sprites/blood.png", 32, 32, 200);
        animationblood.setPingPong(true);
        setAnimation(animationblood);
    }

    
    @Override
    public void act() {

        if (this.on == true && this.time > 0) {
            this.time -= 1;
        }
        if (this.time == 0) {
            getWorld().removeActor(this);
        }
    }
    
}
