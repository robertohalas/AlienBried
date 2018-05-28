package sk.tuke.oop.aliens;

public class Switch extends PowerSwitch {

    public Switch(Switchable switchable) {
        super(switchable);
    }

    public void toggle() {
        turnOn();
        turnOff();
    }

}
