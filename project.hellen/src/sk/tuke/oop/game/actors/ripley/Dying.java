package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Animation;

public class Dying implements RipleyState {

    private int time;

    public Dying(Ripley ripley) {

        this.time = 100;
        Animation animation = new Animation("resources/sprites/player_die.png", 32, 32, 100);
        animation.setPingPong(true);
        ripley.setAnimation(animation);
        ripley.setMessage(" Si mrtvy! ", 80, 10);
    }

    @Override
    public void act() {
        if (this.time == 0) {
            System.exit(0);
        }
        this.time -= 1;
    }
}
