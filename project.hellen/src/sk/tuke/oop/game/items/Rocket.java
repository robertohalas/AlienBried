package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Rocket extends AbstractActor implements Item {

    private Ripley ripley;

    public Rocket(String name) {

        super(name);
        Animation animationro = new Animation("resources/sprites/grenade.png", 65, 20, 100);
        setAnimation(animationro);
    }

    @Override
    public void act() {
        for (Actor actor : getWorld()) {
            if (intersects(actor) == true && actor instanceof Ripley) {
                this.ripley = (Ripley) actor;
                {
                    this.ripley.setRocket(5);
                    this.ripley.getWorld().removeActor(this);
                    return;
                }
            }
        }
    }

}
