package sk.tuke.oop.game.actors;

public abstract class AbstractCharacter extends AbstractActor {

    private int energy = 100;
    private int money = 0;
    private int ammo = 100;

    public AbstractCharacter(String name) {
        super(name);
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
