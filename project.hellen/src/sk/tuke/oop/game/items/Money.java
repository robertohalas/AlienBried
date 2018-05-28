package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Money extends AbstractActor implements Item {

    private Ripley ripley;

    public Money(String name) {

        super(name);
        Animation animationmo = new Animation("resources/sprites/money.png", 16, 16, 100);
        setAnimation(animationmo);
    }

    @Override
    public void act() {
        for (Actor actor : getWorld()) {
            if (intersects(actor) == true && actor instanceof Ripley) {
                this.ripley = (Ripley) actor;
                if (this.ripley.getMoney() < 100) {
                    this.ripley.setMoney(this.ripley.getMoney() + 20);
                    this.ripley.getWorld().removeActor(this);
                    return;
                }
            }
        }
    }
}
