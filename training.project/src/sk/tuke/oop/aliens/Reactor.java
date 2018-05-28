package sk.tuke.oop.aliens;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Reactor extends AbstractActor implements Switchable, Repairable {

    private final Animation normalAnimation;
    private final Animation offAnimation;
    private final Animation animationHot;
    private final Animation animationBroken;
    private int temperature;
    private int damage;
    private EnergyConsumer energyconsumer;
    private final List<EnergyConsumer> devices;
    private boolean on1;
    private String manufacturer;
    private int yearOfProduction;

    public Reactor(String manufacturer, int yearOfProduction) {
        normalAnimation = new Animation("resources/images/reactor_on.png", 80, 80, 100);
        normalAnimation.setPingPong(true);
        offAnimation = new Animation("resources/images/reactor.png", 80, 80, 100);
        offAnimation.setPingPong(true);
        animationHot = new Animation("resources/images/reactor_hot.png", 80, 80, 50);
        animationHot.setPingPong(true);
        animationBroken = new Animation("resources/images/reactor_broken.png", 80, 80, 100);
        animationBroken.setPingPong(true);
        setAnimation(offAnimation);
        this.energyconsumer = null;
        this.temperature = 0;
        this.on1 = false;
        this.manufacturer = manufacturer;
        if (yearOfProduction > 0) {
            this.yearOfProduction = yearOfProduction;
        } else {
            this.yearOfProduction = 1;
        }
        this.devices = new ArrayList<>();

    }

    public void setManufacturer(String manu) {
        this.manufacturer = manu;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setYearOfProduction(int year) {
        if (year > 0) {
            this.yearOfProduction = year;
        } else {
            this.yearOfProduction = 1;
        }
    }

    public int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getDamage() {
        return this.damage;
    }

    public void increaseTemperature(int increment) {

	if(increment > 5001) {
	this.temperature = 5001;
	this.damage = 100;	
	}
        if (increment >= 0 && on1 == true) {
            this.temperature += increment;
        }
        if (this. damage > 50){
            this.temperature += increment;
        }
    }

    public void decreaseTemperature(int increment) {
        if (increment >= 0 && this.damage != 100 && on1 == true) {
			if (this.damage >= 50){
				this.temperature -= (int) (increment/2);
			}
			else {
				this.temperature -= increment;
			}
        }
    }

    public boolean isServiceNeeded() {
	    if (this.temperature >= 3000 && this.damage >= 50) {
            return true;
        }
        else{
			return false;
		}
    }
	
	public void helper() {
		if (this.temperature <= 4000) {
			setAnimation(normalAnimation);
		}
		if (this.temperature <= 2000) {
			this.damage = 0;
		}
		if ((this.temperature >= 2000) && (this.temperature <= 5000)) {

			this.damage = (int) ((this.temperature - 2000) * 0.0333);
			animationHot.setDuration(150 - this.damage);

		}
	}

    @Override
    public void act() {
        if (isOn() == true) {
            increaseTemperature(1);

            helper();
            
            if (this.temperature == 4000 || this.temperature == 4001) {

                setAnimation(animationHot);
            } else if (this.temperature >= 5000) {
                if (this.energyconsumer != null) {
                    this.energyconsumer.setElectricityFlow(false);
                }
                setAnimation(animationBroken);
                this.damage = 100;
                this.temperature = 5000;
            }
        } else {
            setAnimation(offAnimation);
        }
    }
	
	public void repair1() {
		if ((this.damage > 0 && this.damage <= 50) || (this.damage == 0 && this.temperature > 1000)) {

			this.temperature = 1000;
			this.damage = 0;
			if (this.energyconsumer != null) {
				this.energyconsumer.setElectricityFlow(true);
			}
			setAnimation(normalAnimation);
		}
	}

    @Override
    public void repair(AbstractTool abstracttool) {

        if (abstracttool instanceof Hammer) {
            if (abstracttool != null) {
                if (this.damage >= 51 && this.damage <= 100) {
                    this.temperature = 1000;
                    this.damage = 50;
                    if (this.energyconsumer != null) {
                        this.energyconsumer.setElectricityFlow(true);
                    }
                    setAnimation(normalAnimation);
                }
				else {
					repair1();
				}
            }
            if (abstracttool != null) {
                abstracttool.use();
            }
        }
    }

    @Override
    public void on() {
        this.on1 = true;
        if (this.energyconsumer != null) {
            this.energyconsumer.setElectricityFlow(true);
        }

    }

    @Override
    public void off() {
        this.on1 = false;
        if (this.energyconsumer != null) {
            this.energyconsumer.setElectricityFlow(false);
        }

    }

    public void addDevice(EnergyConsumer energyconsumer) {
        this.devices.add(energyconsumer);
        this.energyconsumer = energyconsumer;
        if (this.on1) {
            this.energyconsumer.setElectricityFlow(true);
        }

    }

    public void removeDevice(EnergyConsumer energyconsumer) {
        this.devices.remove(energyconsumer);
        this.energyconsumer.setElectricityFlow(false);
        this.energyconsumer = null;
    }

    @Override
    public boolean isOn() {
        return this.on1;
    }
}