package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.actors.Movable;

public class Move implements Command {

    private final int dx;
    private final int dy;
    private final int step;
    private final Actor actor;

    public Move(Movable actor, int step, int dx, int dy) {

        this.dx = dx;
        this.dy = dy;
        this.step = step;
        this.actor = actor;
    }

    public void amove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 180) {
                anim.setRotation(180);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX(), this.actor.getY() + this.step);
        }
    }

    public void bmove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 270) {
                anim.setRotation(270);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX() - this.step, this.actor.getY());
        }
    }

    public void cmove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 90) {
                anim.setRotation(90);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX() + this.step, this.actor.getY());
        }
    }

    public void dmove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 0) {
                anim.setRotation(0);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX(), this.actor.getY() - this.step);
        }
    }

    public void emove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 315) {
                anim.setRotation(315);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX() - this.step, this.actor.getY() - this.step);
        }
    }

    public void fmove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 225) {
                anim.setRotation(225);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX() - this.step, this.actor.getY() + this.step);
        }
    }

    public void gmove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 45) {
                anim.setRotation(45);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX() + this.step, this.actor.getY() - this.step);
        }
    }

    public void hmove() {
        if (this.actor != null && this.actor instanceof Movable) {
            Animation anim = this.actor.getAnimation();
            if (anim.getRotation() != 135) {
                anim.setRotation(135);
            }
            anim.start();
            this.actor.setPosition(this.actor.getX() + this.step, this.actor.getY() + this.step);
        }
    }

    public void suhrn() {
        if (this.dx == -1 && this.dy == -1) {
            this.emove();
        } else if (this.dx == -1 && this.dy == 1) {
            this.fmove();
        } else if (this.dx == 1 && this.dy == -1) {
            this.gmove();
        } else if (this.dx == 1 && this.dy == 1) {
            this.hmove();
        }
    }

    @Override
    public void execute() {

        if (this.dx == 0 && this.dy == 1) {
            this.amove();
        } else if (this.dx == -1 && this.dy == 0) {
            this.bmove();
        } else if (this.dx == 1 && this.dy == 0) {
            this.cmove();
        } else if (this.dx == 0 && this.dy == -1) {
            this.dmove();
        } else {
            this.suhrn();
        }
    }
}
