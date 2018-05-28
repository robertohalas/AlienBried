package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.TakeItem;

public class AccessCard extends AbstractActor implements Item, Usable {

    public AccessCard(String name) {

        super(name);
        Animation animationac = new Animation("resources/sprites/key.png", 16, 16, 100);
        animationac.setPingPong(true);
        setAnimation(animationac);

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
