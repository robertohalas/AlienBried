package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Teleport extends AbstractActor {

    public Teleport tele;
    private boolean test;

    public Teleport(Teleport teleport) {

        Animation teleportAnimation = new Animation("resources/images/lift.png", 48, 48, 100);
        setAnimation(teleportAnimation);
        this.tele = teleport;
        this.test = false;
    }

    public void teleportPlayer() {
        if (this.tele != null){
        this.getPlayer().setPosition(this.tele.getX()+8, this.tele.getY()+8);
        this.tele.test = true;
    }
    }

    @Override
    public void act() {
        if (this.test == false && intersects(getPlayer())) {
                teleportPlayer();
        }
        if (this.test == true && !intersects(getPlayer())) {
                this.test = false;
            
        }
    }

}