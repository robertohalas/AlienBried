package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class LockerH extends AbstractActor implements Usable {

    private boolean pocet = true;

    public LockerH(String name) {

        super(name);
        Animation animationl = new Animation("resources/sprites/locker.png", 16, 16, 100);
        animationl.setPingPong(true);
        setAnimation(animationl);

    }

    @Override
    public void use(Actor actor) {

        Ripley ripley = (Ripley) getActorByName("Ripley");
        if (this.pocet == true && (ripley.getItemByName("Hammer")) == null) {
            ripley.getBackpack().add(new Hammer("Hammer"));
            this.pocet = false;
        }
    }

    @Override
    public void act() {

    }

}
