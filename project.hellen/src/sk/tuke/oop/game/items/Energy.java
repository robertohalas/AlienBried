package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Energy extends AbstractActor implements Item {

    private Ripley ripley;

    public Energy(String name) {

        super(name);
        Animation animatione = new Animation("resources/sprites/energy.png", 16, 16, 100);
        setAnimation(animatione);

    }

    @Override
    public void act() {

        for (Actor actor : getWorld()) {
            if (intersects(actor) == true && actor instanceof Ripley) {
                this.ripley = (Ripley) actor;
                if (this.ripley.getEnergy() < 100) {
                    this.ripley.setEnergy(100);
                    this.ripley.getWorld().removeActor(this);
                    return;
                }
            }
        }
    }

}
