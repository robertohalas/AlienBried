package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Computer extends AbstractActor implements EnergyConsumer {

    private final Animation computerAnimation;

    public Computer() {

        computerAnimation = new Animation("resources/images/computer.png", 80, 48, 200);
        setAnimation(computerAnimation);
        computerAnimation.stop();
    }

    @Override
    public void setElectricityFlow(boolean set) {

        if (set == true) {
            this.computerAnimation.start();
        } else {
            this.computerAnimation.stop();
        }
    }

    public int add(int a, int b) {
        return a + b;
    }

    public float add(float a, float b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public long add(long a, long b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public float sub(float a, float b) {
        return a - b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public long sub(long a, long b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public float mul(float a, float b) {
        return a * b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public long mul(long a, long b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public float div(float a, float b) {
        return a / b;
    }

    public double div(double a, double b) {
        return a / b;
    }

    public long div(long a, long b) {
        return a / b;
    }
}