package sk.tuke.oop.game.commands;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Item;
import sk.tuke.oop.game.items.BackpackImpl;

public class NextItem implements Command{
    
    private final BackpackImpl backpack;
    
    public NextItem(BackpackImpl backpack){
        
        this.backpack = backpack;
    }
    @Override
    public void execute() {
        List<Item> items = new ArrayList<>();

        while (this.backpack.getLastItem() != null) {
            items.add(this.backpack.getLastItem());
            this.backpack.remove(this.backpack.getLastItem());
        }
        
        Item it = items.get(items.size() - 1);
		items.remove(it);
		items.add(0,it);

        for (Item item : items) {
            this.backpack.add(item);
        }
    }
    
}
