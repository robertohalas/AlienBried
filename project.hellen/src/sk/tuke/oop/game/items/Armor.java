package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Armor extends AbstractActor implements Item {

    private Ripley ripley;
    
    public Armor(String name) {

        super(name);
        Animation animationre = new Animation("resources/sprites/life.png", 16, 16, 100);
        setAnimation(animationre);
    }
    @Override
    public void act() {
        for (Actor actor : getWorld()) {
            if (intersects(actor) == true && actor instanceof Ripley) {
                this.ripley = (Ripley) actor;
                if (this.ripley.getArmor() < 100) {
                    this.ripley.setArmor(100);
                    this.ripley.getWorld().removeActor(this);
                    return;
                }
            }
        }
    }
    
}
