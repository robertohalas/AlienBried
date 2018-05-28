package sk.tuke.oop.game.actors;

import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.ActorFactory;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.enemies.Monster;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.openables.ExitDoor;
import sk.tuke.oop.game.actors.openables.LockedDoor;
import sk.tuke.oop.game.actors.openables.StrongDoor;
import sk.tuke.oop.game.items.Ammo;
import sk.tuke.oop.game.items.Cooler;
import sk.tuke.oop.game.items.Energy;
import sk.tuke.oop.game.items.Armor;
import sk.tuke.oop.game.items.Body;
import sk.tuke.oop.game.items.Locker;
import sk.tuke.oop.game.items.Mine;
import sk.tuke.oop.game.items.Money;
import sk.tuke.oop.game.actors.enemies.Reactor;
import sk.tuke.oop.game.actors.enemies.WaitingAlien;
import sk.tuke.oop.game.actors.openables.HotDoor;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Laser;
import sk.tuke.oop.game.items.LockerH;
import sk.tuke.oop.game.items.Rocket;
import sk.tuke.oop.game.items.Switch;

public class ActorFactoryImpl implements ActorFactory {

    public ActorFactoryImpl() {
    }

    public Actor create3(String type, String name) {
        if ("Ripley".equals(name)) {
            return new Ripley();
        }
        if ("Alien".equals(name)) {
            return new Alien("Alien");
        }
        if ("WaitingAlien".equals(name)) {
            return new WaitingAlien("WaitingAlien");
        }
        if ("Monster".equals(name)) {
            return new Monster("Monster");
        }
        return null;
    }

    public Actor create2(String type, String name) {
        if ("BackVerticalDoor".equals(name)) {
            return new Door("Door", true);
        }
        if ("FrontVerticalDoor".equals(name)) {
            return new Door("FrontVerticalDoor", true);
        }
        if ("Hammer".equals(name)) {
            return new Hammer("Hammer");
        }
        if ("HotD".equals(name)) {
            return new HotDoor("HotDoor");
        }
        if ("HorizontalDoor".equals(name)) {
            return new LockedDoor("LockedDoor", false);
        }
        if ("VDoor_strong".equals(name)) {
            return new StrongDoor("StrongDoor");
        }
        if ("ExitDoor".equals(name)) {
            return new ExitDoor("ExitDoor", true);
        }
        if ("Mine".equals(name)) {
            return new Mine("Mine");
        } else {
            return create3(type, name);
        }
    }

    public Actor create1(String type, String name) {
        if ("Reactor".equals(name)) {
            return new Reactor("Reactor");
        }
        if ("Life".equals(name)) {
            return new Armor("Armor");
        }
        if ("Body".equals(name)) {
            return new Body("Body");
        }
        if ("AccessCard".equals(name)) {
            return new AccessCard("AccessCard");
        }
        if ("Cooler".equals(name)) {
            return new Cooler("Cooler");
        }
        if ("Rocket".equals(name)) {
            return new Rocket("Rocket");
        }
        if ("Locker".equals(name)) {
            return new Locker("Locker");
        }
        if ("Ammo".equals(name)) {
            return new Ammo("Ammo");
        } else {
            return create2(type, name);
        }
    }

    @Override
    public Actor create(String type, String name) {

        if ("Hole".equals(name)) {
            return new Diera("Diera");
        }
        if ("Laser".equals(name)) {
            return new Laser("Laser");
        }
        if ("Switch".equals(name)) {
            return new Switch("Switch");
        }
        if ("Energy".equals(name)) {
            return new Energy("Energy");
        }
        if ("Money".equals(name)) {
            return new Money("Money");
        }
        if ("LockerH".equals(name)) {
            return new LockerH("LockerH");
        } else {
            return create1(type, name);
        }
    }
}
