package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class ExitDoor extends Door implements Usable {

    private int timer;

    public ExitDoor(String name, boolean vertical) {
        super(name, vertical);
        this.timer = 0;
    }

    @Override
    public void use(Actor actor) {

        Ripley ripley = (Ripley) getActorByName("Ripley");
        ripley.setMessage(" Well done.", 80, 10);
        super.open();
    }

    @Override
    public void act() {
        if (super.isOpen()) {
            timer++;
            if (timer == 100) {
                System.exit(0);
            }
        }

    }
}
