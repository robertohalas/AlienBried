package sk.tuke.oop.aliens;

public class SmartCooler extends Cooler {

    private final Reactor reactor;

    public SmartCooler(Reactor reactor) {
        super(reactor);
        this.reactor = reactor;

    }

    @Override
    public void act() {

        if (this.reactor.getTemperature() >= 2000) {
            on();
            isOn();
        }
        if (this.reactor.getTemperature() <= 1000) {
            off();
            isOn();

        }
    }

}