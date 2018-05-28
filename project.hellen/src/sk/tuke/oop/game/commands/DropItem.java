package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.items.BackpackImpl;

public class DropItem implements Command{
    
    private final BackpackImpl backpack;
    private final World world;
    private final int x;
    private final int y;
    
    public DropItem(BackpackImpl backpack, World world, int x, int y){
        
        this.backpack = backpack;
        this.world = world;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        Item item = this.backpack.getLastItem();
        ((Actor) item).setPosition(this.x, this.y);
        this.world.addActor(((Actor) item));
        this.backpack.remove(item);
    }

}
