package sk.tuke.oop.game.actors;

import java.awt.geom.Rectangle2D;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

public abstract class AbstractActor implements Actor {

    private final String name;
    private int x;
    private int y;
    private Animation animation;
    private World world;

    public AbstractActor(String name) {
        this.name = name;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.animation.getWidth();
    }

    @Override
    public int getHeight() {
        return this.animation.getHeight();
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Animation getAnimation() {
        return this.animation;
    }

    @Override
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public boolean intersects(Actor actor) {
        return new Rectangle2D.Float(getX(), getY(), getWidth(), getHeight()).intersects(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
    }

    @Override
    public void addedToWorld(World world) {
        this.world = world;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    public Actor getActorByName(String name) {
        for (Actor actor : getWorld()) {
            if (actor.getName().equals(name)) {
                return actor;
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
