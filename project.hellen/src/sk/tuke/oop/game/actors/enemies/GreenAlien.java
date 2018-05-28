package sk.tuke.oop.game.actors.enemies;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Blood;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.commands.Move;

public class GreenAlien extends AbstractCharacter implements Movable, Enemy {

    private int a;
    private int b;

    public GreenAlien(String name) {

        super(name); 
        Animation animationga = new Animation("resources/sprites/spitter_alien.png", 32, 32, 100);
        animationga.setPingPong(true);
        setAnimation(animationga);
    }

    @Override
    public void act() {

        this.pohyb();
        this.over();
        this.aktr();
        if (this.getEnergy() <= 0) {
            this.getWorld().removeActor(this);
            Blood blood = new Blood("Blood",true);
            blood.setPosition(this.getX(), this.getY());
            this.getWorld().addActor(blood);
    
        }
        if (this.getWorld().intersectWithWall(this)) {
            this.setPosition(this.a, this.b);
        }
        this.a = this.getX();
        this.b = this.getY();
    }
    public void pohyb(){
        int random = (int) (Math.random() * (150 + 3));
        switch (random) {
            case 0:
                getAnimation().setRotation(0);
                break;
            case 1:
                getAnimation().setRotation(90);
                break;
            case 2:
                getAnimation().setRotation(180);
                break;
            case 3:
                getAnimation().setRotation(270);
                break;
            case 4:
                getAnimation().setRotation(45);
                break;
            case 5:
                getAnimation().setRotation(135);
                break;
            case 6:
                getAnimation().setRotation(225);
                break;
            case 7:
                getAnimation().setRotation(315);
                break;
            default:
                break;
        }
    }
    public void over(){
        if (getAnimation().getRotation() == 45) {
            Move move = new Move(this, 2, 1, -1);
            move.execute();
        } else if (getAnimation().getRotation() == 315) {
            Move move = new Move(this, 2, -1, -1);
            move.execute();
        } else if (getAnimation().getRotation() == 225) {
            Move move = new Move(this, 2, -1, 1);
            move.execute();
        } else if (getAnimation().getRotation() == 135) {
            Move move = new Move(this, 2, 1, 1);
            move.execute();
        } else if (getAnimation().getRotation() == 0) {
            Move move = new Move(this, 2, 0, -1);
            move.execute();
        } else if (getAnimation().getRotation() == 90) {
            Move move = new Move(this, 2, 1, 0);
            move.execute();
        } else if (getAnimation().getRotation() == 180) {
            Move move = new Move(this, 2, 0, 1);
            move.execute();
        } else if (getAnimation().getRotation() == 270) {
            Move move = new Move(this, 2, -1, 0);
            move.execute();
        }
    }
    public void aktr (){
        for (Actor actor : getWorld()) {

            if (intersects(actor) == true && actor instanceof Ripley) {

                if (((Ripley) actor).getArmor() > 0) {
                    ((Ripley) actor).setArmor(((Ripley) actor).getArmor() - 1);
                    break;
                }
                if (((Ripley) actor).getArmor() <= 0 && ((Ripley) actor).getEnergy() > 0) {
                    ((Ripley) actor).setEnergy(((Ripley) actor).getEnergy() - 1);
                    break;
                }
            }
        }
    }
}
