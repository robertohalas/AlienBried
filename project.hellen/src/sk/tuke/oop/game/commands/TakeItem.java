package sk.tuke.oop.game.commands;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.BackpackImpl;

public class TakeItem implements Command{
    
    private final BackpackImpl backpack;
    private final Item item;
    
    public TakeItem(BackpackImpl backpack, Item item){
        
        this.backpack = backpack;
        this.item = item;
    }

    @Override
    public void execute() {
        this.backpack.add(this.item);
        this.item.getWorld().removeActor(this.item);
    }
    
}
