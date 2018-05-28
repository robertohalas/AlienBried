package sk.tuke.oop.game.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import sk.tuke.oop.framework.Backpack;
import sk.tuke.oop.framework.Item;

public class BackpackImpl implements Backpack {

    private final List<Item> item;
    private final int capacity;

    public BackpackImpl(int capacity) {
        this.item = new ArrayList(capacity);
        this.capacity = capacity;
    }

    @Override
    public void add(Item item) {
        if (this.item.size() < this.capacity) {
            this.item.add(item);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(Item item) {
        if (this.item.size() > 0 && this.item.contains(item)) {
            this.item.remove(item);
        } else {
            throw new NoSuchElementException();
        }
    }
    

    @Override
    public Iterator<Item> iterator() {
        return this.item.iterator();

    }

    public Item getLastItem() {
        if (this.item.size() > 0) {
            return this.item.get(this.item.size() - 1);
        } else {
            return null;
        }
    }
}
