package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.game.items.Usable;
import sk.tuke.oop.game.commands.DropItem;
import sk.tuke.oop.game.commands.GrenadeShoot;
import sk.tuke.oop.game.commands.Move;
import sk.tuke.oop.game.commands.NextItem;
import sk.tuke.oop.game.commands.Shoot;
import sk.tuke.oop.game.commands.Use;

public class Running implements RipleyState {

    private final Ripley ripley;
    private Move move;
    private int a;
    private int b;
    private boolean shot;

    public Running(Ripley ripley) {

        this.shot = false;
        this.ripley = ripley;
        Animation animation = new Animation("resources/sprites/player.png", 32, 32, 100);
        animation.setPingPong(true);
        ripley.setAnimation(animation);
    }

    @Override
    public void act() {

        Input input = Input.getInstance();

        this.guninput();

        if (input.isKeyPressed(Input.Key.ESCAPE)) {
            System.exit(0);
        }
        this.ripley.getAnimation().stop();

        if (input.isKeyPressed(Input.Key.BACK)) {
            DropItem dropitem = new DropItem(this.ripley.getBackpack(), this.ripley.getWorld(), this.ripley.getX(), this.ripley.getY());
            dropitem.execute();
        }
        if (input.isKeyPressed(Input.Key.N)) {
            NextItem nextitem = new NextItem(this.ripley.getBackpack());
            nextitem.execute();
        }
        if (input.isKeyDown(Input.Key.UP) && input.isKeyDown(Input.Key.RIGHT)) {
            this.move = new Move(this.ripley, 2, 1, -1);
            move.execute();
        } else if (input.isKeyDown(Input.Key.UP) && input.isKeyDown(Input.Key.LEFT)) {
            this.move = new Move(this.ripley, 2, -1, -1);
            move.execute();
        } else 
            this.movieinput();
        this.aktor();

        if (this.ripley.getWorld().intersectWithWall(this.ripley)) {

            this.ripley.setPosition(this.a, this.b);

        }
        this.a = this.ripley.getX();
        this.b = this.ripley.getY();

        this.toxik();
    }
    public void toxik (){
        if (this.ripley.getToxic() == true) {
            int nahodne = (int) (Math.random() * (150 + 1));
            if (nahodne == 2 && this.ripley.getEnergy() > 0) {
                this.ripley.setEnergy(this.ripley.getEnergy() - 1);
            }
        }
    }
    public void guninput(){
        Input input = Input.getInstance();

        if (input.isKeyPressed(Input.Key.F1)){
            this.shot = true;
        }
        if (input.isKeyPressed(Input.Key.F2)){
            this.shot = false;
        }
        if (input.isKeyPressed(Input.Key.SPACE)) {

            if (this.shot == false) {
                Shoot shoot = new Shoot(this.ripley);
                shoot.execute();
            } else if (this.shot == true) {
                GrenadeShoot grenadeshoot = new GrenadeShoot(this.ripley);
                grenadeshoot.execute();
            }
        }
    }
    public void movieinput(){
        
        Input input = Input.getInstance();
        
        if (input.isKeyDown(Input.Key.DOWN) && input.isKeyDown(Input.Key.LEFT)) {
            this.move = new Move(this.ripley, 2, -1, 1);
            move.execute();
        } else if (input.isKeyDown(Input.Key.DOWN) && input.isKeyDown(Input.Key.RIGHT)) {
            this.move = new Move(this.ripley, 2, 1, 1);
            move.execute();
        } else if (input.isKeyDown(Input.Key.UP)) {
            this.move = new Move(this.ripley, 2, 0, -1);
            move.execute();
        } else if (input.isKeyDown(Input.Key.RIGHT)) {
            this.move = new Move(this.ripley, 2, 1, 0);
            move.execute();
        } else if (input.isKeyDown(Input.Key.DOWN)) {
            this.move = new Move(this.ripley, 2, 0, 1);
            move.execute();
        } else if (input.isKeyDown(Input.Key.LEFT)) {
            this.move = new Move(this.ripley, 2, -1, 0);
            move.execute();
        }
    }
    public void aktor(){
        Input input = Input.getInstance();
        for (Actor actor : this.ripley.getWorld()) {

            if (this.ripley.intersects(actor) == true && actor instanceof Usable && input.isKeyPressed(Input.Key.E)) {
                Use use = new Use(actor, (Actor) this.ripley.getBackpack().getLastItem());
                use.execute();
                break;
            }
        }
    }
}
