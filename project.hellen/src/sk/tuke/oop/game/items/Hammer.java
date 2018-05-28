package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.TakeItem;

public class Hammer extends AbstractActor implements Item, Usable {

    public Hammer(String name) {

        super(name);
        Animation animationh = new Animation("resources/sprites/hammer.png", 16, 16, 100);
        setAnimation(animationh);

    }

    @Override
    public void use(Actor actor) {
        
        Ripley ripley = (Ripley) getActorByName("Ripley");
        TakeItem takeitem = new TakeItem(ripley.getBackpack(), this);
        takeitem.execute();
        getWorld().removeActor(this);

    }
    @Override
    public void act() {
        
    }

}
