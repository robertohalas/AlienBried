package sk.tuke.oop.game.commands;

import sk.tuke.oop.game.actors.Bullet;
import sk.tuke.oop.game.actors.SuperBullet;
import sk.tuke.oop.game.actors.ripley.Ripley;

public class Shoot implements Command {

    private final Ripley ripley;
    private final String superBullet = "superbullet";
    private final String bulet = "Bullet";

    public Shoot(Ripley ripley) {
        this.ripley = ripley;
    }

    public void actor() {
        if (this.ripley.getAnimation().getRotation() == 135) {
            this.bshoot();
        } else if (this.ripley.getAnimation().getRotation() == 225) {
            this.cshoot();
        } else if (this.ripley.getAnimation().getRotation() == 315) {
            this.dshoot();
        } else if (this.ripley.getAnimation().getRotation() == 0) {
            this.eshoot();
        } else if (this.ripley.getAnimation().getRotation() == 90) {
            this.fshoot();
        } else if (this.ripley.getAnimation().getRotation() == 180) {
            this.gshoot();
        } else if (this.ripley.getAnimation().getRotation() == 270) {
            this.hshoot();
        }
    }

    public void ashoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(45);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(45);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    public void bshoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(135);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(135);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    public void cshoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(225);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(225);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    public void dshoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(315);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(315);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    public void eshoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(0);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(0);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    public void fshoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(90);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(90);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    public void gshoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(180);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(180);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    public void hshoot() {
        if (this.ripley.getMoney() == 100) {
            SuperBullet superbullet = new SuperBullet(this.superBullet);
            superbullet.setPosition(this.ripley.getX(), this.ripley.getY());
            superbullet.getAnimation().setRotation(270);
            this.ripley.getWorld().addActor(superbullet);
        } else {
            Bullet bullet = new Bullet(this.bulet);
            bullet.setPosition(this.ripley.getX(), this.ripley.getY());
            bullet.getAnimation().setRotation(270);
            this.ripley.getWorld().addActor(bullet);
        }
    }

    @Override
    public void execute() {

        if (this.ripley.getAmmo() > 0) {
            this.ripley.setAmmo(this.ripley.getAmmo() - 1);

            if (this.ripley.getAnimation().getRotation() == 45) {
                this.ashoot();
            } else {
                this.actor();
            }
        }
    }
}
