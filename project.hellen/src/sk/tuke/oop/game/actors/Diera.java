package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.enemies.GreenAlien;

public class Diera extends AbstractActor {
    private int timer;
    private boolean destroyed;

    public Diera(String name) {

        super(name);
        Animation animationh = new Animation("resources/sprites/tunnel_black.png", 32, 32, 100);
        animationh.stop();
        setAnimation(animationh);
        this.timer = 0;
        this.destroyed = false;
    }
    
    @Override
    public void act(){
        if(!this.destroyed) {
            if(this.timer == 0) {
                Animation animationh = getAnimation();
                animationh.setCurrentFrame(1);
                animationh.start();
                animationh.stopAt(0);
                GreenAlien greenalien = new GreenAlien("GreenAlien");
                greenalien.setPosition(getX(),getY());
                getWorld().addActor(greenalien);
                this.timer = 700;
            }
            else this.timer--;
        }
    }
    
    public void use() {
        this.destroyed = true;
    }
}
