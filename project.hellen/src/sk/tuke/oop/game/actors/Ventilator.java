package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;

public class Ventilator extends AbstractActor implements Usable{

    private boolean on;
    
    public Ventilator (String name){
        
        super(name);
        this.on = false;
        Animation animationv = new Animation("resources/sprites/ventilator.png", 32, 32, 100);
        animationv.setPingPong(true);
        setAnimation(animationv);
        getAnimation().stop();
    }
    
    @Override
    public void use(Actor actor) {

        if (this.on == false) {
            getAnimation().stop();
            this.on = true;
        }
        else if (this.on == true) {
            getAnimation().start();
            this.on = false;
        }
    }

    @Override
    public void act() {
     
    }
    
}
