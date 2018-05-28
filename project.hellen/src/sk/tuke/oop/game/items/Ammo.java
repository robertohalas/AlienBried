package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Ammo extends AbstractActor implements Item {

    private Ripley ripley;

    public Ammo(String name) {

        super(name);
        Animation animationa = new Animation("resources/sprites/ammo.png", 16, 16, 100);
        setAnimation(animationa);
    }

    @Override
    public void act() {

        for (Actor actor : getWorld()) {
            if (intersects(actor) == true && actor instanceof Ripley) {
                this.ripley = (Ripley) actor;
                if (this.ripley.getAmmo() < 100) {
                    this.ripley.setAmmo(100);
                    this.ripley.getWorld().removeActor(this);
                    return;
                }
            }
        }
    }

}
