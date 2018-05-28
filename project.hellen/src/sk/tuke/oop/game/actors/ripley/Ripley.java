package sk.tuke.oop.game.actors.ripley;

import sk.tuke.oop.framework.Item;
import sk.tuke.oop.framework.Message;
import sk.tuke.oop.framework.World;
import sk.tuke.oop.game.actors.AbstractCharacter;
import sk.tuke.oop.game.actors.Movable;
import sk.tuke.oop.game.items.BackpackImpl;

public class Ripley extends AbstractCharacter implements Movable {

    private final BackpackImpl backpack;
    private RipleyState ripleystate;
    private boolean toxic;
    private int armor;
    private int rocket;
    private String message;
    private int w;
    private int h;
    private int messageTimer;
    private boolean changedState;

    public Ripley() {

        super("Ripley");
        this.ripleystate = new Running(this);
        this.backpack = new BackpackImpl(30);
        this.toxic = false;
        this.armor = 0;
        this.w = 0;
        this.h = 0;
        this.changedState = false;
    }

    @Override
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        getWorld().showBackpack(backpack);
        getWorld().centerOn(this);
    }

    @Override
    public void act() {
        this.ripleystate.act();
        if (this.getEnergy() == 0 && !this.changedState) {
            this.ripleystate = new Dying(this);
            this.changedState = true;
        }
        showMessage();
    }

    private void showMessage() {
        if (this.messageTimer > 0) {
            getWorld().showMessage(new Message(this.message, this.w, this.h));
            this.messageTimer--;
        } else {
            getWorld().showMessage(new Message(" Energy: " + this.getEnergy() + "  Ammo: " + this.getAmmo() + "  Rockets: " + this.getRocket() + "  Armor: " + this.getArmor() + "  Money: " + this.getMoney(), 80, 10));
        }
    }

    public void setMessage(String text, int w, int h) {
        this.message = text;
        this.messageTimer = 100;
        this.w = w;
        this.h = h;

    }

    public boolean getToxic() {
        return this.toxic;
    }

    public void setToxic(boolean toxic) {
        this.toxic = toxic;
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getRocket() {
        return this.rocket;
    }

    public void setRocket(int rocket) {
        this.rocket = rocket;
    }

    public void takeItem(Item item) {
        backpack.add(item);
    }

    public void removeItem(Item item) {
        backpack.remove(item);
    }

    public BackpackImpl getBackpack() {
        return this.backpack;
    }

    public Item getItemByName(String name) {

        for (Item item : backpack) {
            if (name.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }
}
