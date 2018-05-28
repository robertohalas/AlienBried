package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.World;

public abstract class AbstractTool extends AbstractActor {

    public int remaining;

    public void use() {
        World aktor = this.getWorld();
        this.remaining -= 1;
        if (this.remaining == 0) {
            aktor.removeActor(this);
        }
    }
}
