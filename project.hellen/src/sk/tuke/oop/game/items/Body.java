package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Body extends AbstractActor implements Usable {

    private boolean pocet = true;
    
    public Body(String name) {

        super(name);
        Animation animationbo = new Animation("resources/sprites/body.png", 64, 48, 100);
        setAnimation(animationbo);
    }

    @Override
    public void use(Actor actor) {


            Ripley ripley = (Ripley) getActorByName("Ripley");
            if (this.pocet == true && (ripley.getItemByName("AccessCard")) == null) {
                ripley.getBackpack().add(new AccessCard("AccessCard"));
                this.pocet = false;
            }
    }
    @Override
    public void act() {

    }

}
