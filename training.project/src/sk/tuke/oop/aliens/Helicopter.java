package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Helicopter extends AbstractActor {

    private boolean start;
    private int playerx;
    private int playery;
    private int helix;
    private int heliy;

    public Helicopter() {

        Animation heliAnimation = new Animation("resources/images/heli.png", 64, 64, 200);
        setAnimation(heliAnimation);
        this.start = false;
    }

    public void searchAndDestroy() {
        if (this.start == false) {
            this.start = true;
        }
    }

    @Override
    public void act() {
        if (this.start == true) {
            this.playerx = this.getPlayer().getX();
            this.playery = this.getPlayer().getY();
            this.helix = this.getX();
            this.heliy = this.getY();
            if (this.playerx - 16 > this.helix) {
	this.helix += 1;
            }
            if (this.playery - 16 > this.heliy) {
                this.heliy += 1;
            }
            if (this.playerx - 16 < this.helix) {
	this.helix -= 1;
            }
            if (this.playery - 16 < this.heliy) {
	this.heliy -= 1;
            }
            this.setPosition(this.helix, this.heliy);
            if (intersects(getPlayer())) {
                this.getPlayer().setEnergy(this.getPlayer().getEnergy() - 1);
            }
        }
    }
}