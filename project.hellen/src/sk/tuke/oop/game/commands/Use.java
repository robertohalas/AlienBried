package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.game.actors.openables.Openable;
import sk.tuke.oop.game.items.Usable;

public class Use implements Command {
    
    private final Actor actuator;
    private final Actor actor;

    public Use(Actor actor, Actor actuator) {
        this.actuator = actuator;
        this.actor = actor;
    }

    @Override
    public void execute() {
        if (this.actor instanceof Usable) {
            ((Usable) this.actor).use(this.actuator);
        } else if (this.actor instanceof Openable) {
            ((Openable) this.actor).open();
        }
    }
}
