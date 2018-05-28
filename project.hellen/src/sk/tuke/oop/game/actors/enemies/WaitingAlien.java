package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.openables.Door;

public class WaitingAlien extends Alien implements Observer {

    private boolean waiting = true;
    private boolean on = true;
    private Door door;

    public WaitingAlien(String name) {
        super(name);
    }

    @Override
    public void wakeUp() {
        this.waiting = false;

    }

    @Override
    public void act() {

        Door frontDoor = (Door) this.getActorByName("FrontVerticalDoor");
        if (frontDoor != null && this.on) {
            this.door = frontDoor;
            this.door.addObserver(this);
            this.on = false;
        }
        if (!this.waiting) {
            if (this.getEnergy() <= 0) {
                this.door.removeObserver(this);
            }
            super.act();
        } else {
            this.getAnimation().stop();
        }
    }

}
