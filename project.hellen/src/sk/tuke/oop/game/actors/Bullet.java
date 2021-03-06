package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.enemies.GreenAlien;
import sk.tuke.oop.game.actors.enemies.Reactor;

public class Bullet extends AbstractActor implements Movable {

    private boolean trafeny;

    public Bullet(String name) {

        super(name);
        Animation animationb = new Animation("resources/sprites/bullet.png", 16, 16, 100);
        setAnimation(animationb);
        this.trafeny = false;
    }

    @Override
    public void act() {

        if (!this.getWorld().intersectWithWall(this)) {

            this.overenie();

            if (this.getWorld().intersectWithWall(this)) {
                this.getWorld().removeActor(this);
            }
            this.aktor();
            if (this.trafeny) {
                this.getWorld().removeActor(this);
                this.trafeny = false;
            }

        }

    }

    public void aktor() {
        for (Actor actr : getWorld()) {
            if (intersects(actr) && actr instanceof Alien) {
                ((Alien) actr).setEnergy(((Alien) actr).getEnergy() - 10);
                this.trafeny = true;
            }
            if (intersects(actr) && actr instanceof GreenAlien) {
                ((GreenAlien) actr).setEnergy(((GreenAlien) actr).getEnergy() - 10);
                this.trafeny = true;
            }
            if (intersects(actr) && actr instanceof Reactor) {
                ((Reactor) actr).setEnergy(((Reactor) actr).getEnergy() - 200);
                this.trafeny = true;
            }
        }
    }

    public void overenie() {
        if (getAnimation().getRotation() == 45) {
            this.setPosition(this.getX() + 10, this.getY() - 10);
        } else if (getAnimation().getRotation() == 135) {
            this.setPosition(this.getX() + 10, this.getY() + 10);
        } else if (getAnimation().getRotation() == 225) {
            this.setPosition(this.getX() - 10, this.getY() + 10);
        } else if (getAnimation().getRotation() == 315) {
            this.setPosition(this.getX() - 10, this.getY() - 10);
        } else if (getAnimation().getRotation() == 0) {
            this.setPosition(this.getX(), this.getY() - 10);
        } else if (getAnimation().getRotation() == 90) {
            this.setPosition(this.getX() + 10, this.getY());
        } else if (getAnimation().getRotation() == 180) {
            this.setPosition(this.getX(), this.getY() + 10);
        } else if (getAnimation().getRotation() == 270) {
            this.setPosition(this.getX() - 10, this.getY());
        }
    }
}
