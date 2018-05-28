package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.enemies.Enemy;

public class StrongDoor extends AbstractCharacter implements Enemy {
    private final Animation animationexpl;
    private boolean on;
    private int time;

    public StrongDoor(String name) {
        super(name);
        setEnergy(200);
        this.time = 100;
        this.on = false;
        Animation animationsd = new Animation("resources/sprites/vdoor_strong.png", 16, 32, 100);
        animationexpl = new Animation("resources/sprites/large_explosion.png", 32, 32, 100);
        animationsd.setPingPong(true);
        setAnimation(animationsd);
        getAnimation().stop();
    }

    @Override
    public void act() {

        getWorld().setWall((int) getX() / 16, (int) getY() / 16, true);
        if (this.getEnergy() <=0){
            getWorld().setWall((int) getX() / 16, (int) getY() / 16, false);
            setAnimation(animationexpl);
            this.on = true;
            if (this.on == true && this.time > 0) {
            this.time -= 1;
            }
            if (this.time == 0) {
            getWorld().removeActor(this);
        }
        }
    }

}