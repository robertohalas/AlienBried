package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;

public class Reactor extends AbstractCharacter implements Enemy {

    private final Animation animationro;
    private final Animation animationrh;
    private final Animation animationrb;

    public Reactor(String name) {

        super(name);
        setEnergy(5000);
        animationro = new Animation("resources/sprites/reactor_on.png", 80, 80, 100);
        animationrh = new Animation("resources/sprites/reactor_hot.png", 80, 80, 100);
        animationrb = new Animation("resources/sprites/reactor_broken.png", 80, 80, 100);
        animationro.setPingPong(true);
        setAnimation(animationro);

    }

    @Override
    public void act() {
        if (this.getEnergy() <= 2500 && this.getEnergy() > 0) {
            setAnimation(animationrh);

        } else if (this.getEnergy() > 2500) {
            setAnimation(animationro);

        } else if (this.getEnergy() <= 0) {
            setAnimation(animationrb);

        }
    }

}
