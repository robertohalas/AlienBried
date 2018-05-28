package sk.tuke.oop.game.actors.openables;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractActor;
import sk.tuke.oop.game.actors.Observer;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Usable;

public class Door extends AbstractActor implements Openable, Usable {

    private boolean on;
    private boolean nastav;
    private final List<Observer> observerlist;

    public Door(String name, boolean vertical) {

        super(name);
        this.observerlist = new ArrayList<>();
        setPosition(getX(), getY());
        this.nastav = true;
        if (vertical == true) {
            Animation animationvd = new Animation("resources/sprites/vdoor.png", 16, 32, 100);
            animationvd.setPingPong(true);
            setAnimation(animationvd);
            getAnimation().stop();

        } else {
            Animation animationhd = new Animation("resources/sprites/hdoor.png", 32, 16, 100);
            animationhd.setPingPong(true);
            setAnimation(animationhd);
            getAnimation().stop();
        }
        this.on = false;

    }

    public void addObserver(Observer observer) {
        observerlist.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (observerlist.contains(observer)) {
            observerlist.remove(observer);
        }
    }

    @Override
    public void open() {
        this.on = true;
        getAnimation().start();
        getAnimation().stopAt(3);
        getWorld().setWall((int) getX() / 16, (int) getY() / 16, false);
        for (Observer observer : this.observerlist) {
            observer.wakeUp();
        }

    }

    @Override
    public void close() {
        getWorld().setWall((int) getX() / 16, (int) getY() / 16, true);
        getAnimation().stop();
        this.on = false;
    }

    @Override
    public boolean isOpen() {
        return this.on;
    }

    @Override
    public void use(Actor actor) {

        addedToWorld(getWorld());
        Ripley ripley = (Ripley) getActorByName("Ripley");
        if (actor instanceof AccessCard) {
            if (this.isOpen() == false) {
                this.open();
                ripley.setMessage(" Dvere su otvorene! ", 80, 10);
            } else {
                this.close();
            }
            ripley.removeItem(ripley.getItemByName("AccessCard"));
            ripley.setToxic(true);
        }
        if (this.isOpen() == false) {
            ripley.setMessage(" Dvere su zatvorene! Pouzi pristupovu kartu! ", 80, 10);
        }
    }

    @Override
    public void act() {

        if (isOpen() == false && nastav == true) {
            getWorld().setWall((this.getX() / 16), (this.getY() / 16), !isOpen());
            nastav = false;
        }
    }
}
