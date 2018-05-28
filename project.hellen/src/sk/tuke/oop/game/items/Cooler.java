package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Cooler extends AbstractActor implements Usable {

    private boolean defective = true;

    public Cooler(String name) {

        super(name);
        Animation animationc = new Animation("resources/sprites/fan.png", 32, 32, 200);
        animationc.setPingPong(true);
        setAnimation(animationc);
        this.defective = true;

    }

    @Override
    public void use(Actor actor) {
        addedToWorld(getWorld());
        Ripley ripley = (Ripley) getActorByName("Ripley");
        if (actor instanceof Hammer) {
            this.defective = false;
            ripley.removeItem(ripley.getItemByName("Hammer"));
            ripley.setToxic(false);
        }
        act();

    }

    @Override
    public void act() {

        getAnimation().stop();

        if (this.defective == true) {
            getAnimation().stop();
        }

        if (this.defective == false) {
            getAnimation().start();
        }
    }
}
