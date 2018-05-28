package sk.tuke.oop.game.items;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Diera;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Switch extends AbstractActor implements Usable {

    private final Animation animationon;

    public Switch(String name) {

        super(name);
        Animation animationoff = new Animation("resources/sprites/switch_off.png", 16, 16, 100);
        animationon = new Animation("resources/sprites/switch_on.png", 16, 16, 100);
        setAnimation(animationoff);
    }

    @Override
    public void act() {

    }

    @Override
    public void use(Actor actor) {

        Diera diera = (Diera) getActorByName("Diera");
        diera.use();
        Ripley ripley = (Ripley) getActorByName("Ripley");
        ripley.setMessage(" Diera je deaktivovana! ", 80, 10);
        setAnimation(animationon);

    }
}
