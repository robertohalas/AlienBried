package sk.tuke.oop.game;

import sk.tuke.oop.framework.SlickWorld;
import sk.tuke.oop.game.actors.ActorFactoryImpl;
import sk.tuke.oop.game.actors.enemies.Alien;
import sk.tuke.oop.game.actors.enemies.Monster;
import sk.tuke.oop.game.actors.enemies.Reactor;
import sk.tuke.oop.game.actors.openables.Door;
import sk.tuke.oop.game.actors.openables.ExitDoor;
import sk.tuke.oop.game.actors.openables.StrongDoor;
import sk.tuke.oop.game.actors.ripley.Ripley;
import sk.tuke.oop.game.items.AccessCard;
import sk.tuke.oop.game.items.Body;
import sk.tuke.oop.game.items.Cooler;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Locker;

public class Main {

    public static void main(String[] args) {

        SlickWorld slickworld = new SlickWorld("Alien Breed", 800, 600);
        ActorFactoryImpl actorfactoryimpl = new ActorFactoryImpl();
        slickworld.setFactory(actorfactoryimpl);
        slickworld.setMap("resources/levels/map.tmx");
        slickworld.run();

    }

    public static void scenario() {
        // Spawn hraca.
        Ripley ripley = new Ripley();
        // Zoberie peniaze.
        ripley.setMoney(ripley.getMoney() + 20);
        // Hrac prehlada skrinku.
        Locker locker = new Locker("Locker");
        locker.use(ripley);
        // Zo skrinky vypadne pristupova karta.
        AccessCard accessCard = new AccessCard("AccesCard");
        // Pristupovu kartu zoberie...
        // Hrac otvori zamknute dvere pomocou pristupovej karty.
        // Po otvoreni dveri sa siri po celom svete kontaminacia.
        Door door = new Door("Door", true);
        door.use(accessCard);
        
        // Hrac zabije nepriatela.
        Alien alien = new Alien("Alien");
        alien.setEnergy(alien.getEnergy() - 100);
        // Hrac vezme zo zeme naboje.
        ripley.setAmmo(ripley.getAmmo() + 100);
        // Hrac prehlada mrtvolu ...
        Body body = new Body("Body");
        body.use(ripley);
        // Z nej vypadne pristupova karta.
        // Pristupovu kartu zoberie...
        // Hrac otvori 2. zamknute dvere pomocou 2. pristupovej karty.
       
        // Hrac zabije nepriatelov.
        // Hrac zoberie zo zeme pristupovu kartu, z ktorou otvori dvere.
        
        // Hrac zabije dalsieho nepriatela.
        // Musi sa vsak vyhnut mine, ktora je na zemi aktivovana.
        // Prehlada skrinku, z ktorej vypadne kladivo.
        Hammer hammer = new Hammer("Hammer");
        // Zoberie peniaze.
        // Hrac sa vrati do predchadzajucej miestnosti, kde znici reaktor aby prestal napajat elektrinu dvom dveram, ktore sa nedaju otvorit.
        Reactor reactor = new Reactor("Reactor");
        ripley.setEnergy(reactor.getEnergy() - 5000);
        // Po zniceni reaktora sa dvere otvoria.
        
        // Hrac pojde do lavych dveri aby opravil chladic, ktory vyvetra vsetok kontaminovany vzduch vo svete.
        // Pouzije kladivo ...
        Cooler cooler = new Cooler("Cooler");
        cooler.use(hammer);
        // Zabije vsetkych nepriatelov v miestnosti.
        // Zoberie vsetky peniaze.
        // Cez laser sa dostane do zbrojovne, kde si doplni energiu ...
        ripley.setEnergy(ripley.getEnergy() + 100);
        // doplni si naboje ...
        ripley.setAmmo(ripley.getAmmo() + 100);
        // ... a vezme Raketomet z 5 nabojmi.
        // strely si aktivuje stlacenim tlacitla F1.
        // Hrac rozbije silne dvere pomocou rakety ...
        StrongDoor strongdoor = new StrongDoor("StrongDoor");
        ripley.setEnergy(strongdoor.getEnergy() - 200);
        // ... a stlacenim tlacidla F2 si aktivuje strely na povodne.
        // Hrac sa pokusi zobrat posledne peniaze, ktore su za dverami.
        // Ak hrac ma 100 dolarov, zmenia sa mu strely na superstrely (modre).
        // Pomocou superstriel hrac zabije matku nepriatelov.
        Monster monster = new Monster("Monster");
        ripley.setEnergy(monster.getEnergy() - 5000);
        // Otvorenie poslednych dveri.
        ExitDoor exitdoor = new ExitDoor("ExitDoor", true);
        exitdoor.use(null);
        // Koniec hry.
    }
}
