package sk.tuke.oop.game.actors.openables;

import sk.tuke.oop.game.items.Usable;

public class LockedDoor extends Door implements Usable {

    private boolean onn;
    
    public LockedDoor(String name, boolean vertical) {
        super(name, vertical);
        this.onn = false;
    }
    
    public void lock(){
        if (this.onn == false){
            this.onn = true;
        }
    }
    public void unlock() {
        if (this.onn == true){
            this.onn = false;
        }
    }
    public boolean isLocked() {
        return this.onn;
        
    }
}
