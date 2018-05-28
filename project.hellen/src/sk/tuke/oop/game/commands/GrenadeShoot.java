package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.RocketShoot;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class GrenadeShoot implements Command {

    private final Ripley ripley;
    private final String rocketShoot = "rocketshoot";

    public GrenadeShoot(Ripley ripley) {
        this.ripley = ripley;
    }

    @Override
    public void execute() {

        if (this.ripley.getRocket() > 0) {
            this.ripley.setRocket(this.ripley.getRocket() - 1);

            this.overenie();

        }
    }

    public void overenie() {
        if (this.ripley.getAnimation().getRotation() == 45) {
            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(45);
            this.ripley.getWorld().addActor(rocketshoot);

        } else if (this.ripley.getAnimation().getRotation() == 135) {

            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(135);
            this.ripley.getWorld().addActor(rocketshoot);

        } else if (this.ripley.getAnimation().getRotation() == 225) {
            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(225);
            this.ripley.getWorld().addActor(rocketshoot);

        } else if (this.ripley.getAnimation().getRotation() == 315) {

            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(315);
            this.ripley.getWorld().addActor(rocketshoot);

        } else if (this.ripley.getAnimation().getRotation() == 0) {

            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(0);
            this.ripley.getWorld().addActor(rocketshoot);

        } else if (this.ripley.getAnimation().getRotation() == 90) {

            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(90);
            this.ripley.getWorld().addActor(rocketshoot);

        } else if (this.ripley.getAnimation().getRotation() == 180) {

            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(180);
            this.ripley.getWorld().addActor(rocketshoot);

        } else if (this.ripley.getAnimation().getRotation() == 270) {

            RocketShoot rocketshoot = new RocketShoot(this.rocketShoot);
            rocketshoot.setPosition(this.ripley.getX(), this.ripley.getY());
            rocketshoot.getAnimation().setRotation(270);
            this.ripley.getWorld().addActor(rocketshoot);

        }
    }
}
