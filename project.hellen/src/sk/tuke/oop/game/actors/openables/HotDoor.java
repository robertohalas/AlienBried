package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.enemies.Reactor;

public class HotDoor extends AbstractActor implements Item {

    private final Animation animationvdo;
    private final Animation animationhdo;
    private boolean on;
    private boolean nastav;
    private boolean anim;

    public HotDoor(String name) {

        super(name);

        this.nastav = false;
        this.anim = false;
        animationvdo = new Animation("resources/sprites/vdoor.png", 16, 32, 100);
        animationhdo = new Animation("resources/sprites/hot_door.png", 16, 32, 100);
        animationvdo.setPingPong(true);
        setAnimation(animationvdo);
        getAnimation().stop();
        this.on = false;
    }

    public void open() {
        this.on = true;
        setAnimation(animationhdo);
        getAnimation().start();
        getAnimation().stopAt(3);
        getWorld().setWall((int) getX() / 16, (int) getY() / 16, false);
    }

    public void close() {
        getWorld().setWall((int) getX() / 16, (int) getY() / 16, true);
        getAnimation().stop();
        this.on = false;
    }

    public boolean isOpen() {
        return this.on;
    }

    @Override
    public void act() {
        Reactor reactor = (Reactor) getActorByName("Reactor");
        if (reactor.getEnergy() <= 2500 && reactor.getEnergy() > 0) {
            this.nastav = true;
        } else if (reactor.getEnergy() <= 0) {
            this.nastav = false;
            this.anim = true;
            use();
            
        }
        if (this.nastav == true) {
            setAnimation(animationhdo);
            getAnimation().stop();
        }
        if (isOpen() == false && nastav == false && this.anim == false) {
            getWorld().setWall((this.getX() / 16), (this.getY() / 16), true);
            setAnimation(animationvdo);
        }

    }

    public void use() {

        addedToWorld(getWorld());
        if (this.isOpen() == false) {

            this.open();

        } else {
            this.close();
        }

    }
}
