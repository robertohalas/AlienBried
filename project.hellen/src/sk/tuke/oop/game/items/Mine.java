package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Mine extends AbstractActor {

    private Ripley ripley;
    private int time;
    private final Animation animationminex;
    private boolean on;

    public Mine(String name) {

        super(name);
        this.on = false;
        this.time = 100;
        Animation animationmine = new Animation("resources/sprites/mine.png", 16, 16, 100);
        animationminex = new Animation("resources/sprites/small_explosion.png", 16, 16, 200);
        setAnimation(animationmine);

    }

    @Override
    public void act() {
        for (Actor actor : getWorld()) {
            if (intersects(actor) == true && actor instanceof Ripley) {
                this.ripley = (Ripley) actor;
                this.ripley.setEnergy(0);
                this.on = true;
                setAnimation(animationminex);
            }
        }
        if (this.on == true && this.time > 0) {
            this.time -= 1;
        }
        if (this.time == 0) {
            this.ripley.getWorld().removeActor(this);
        }

    }

}
