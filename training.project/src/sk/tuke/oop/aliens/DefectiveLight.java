package sk.tuke.oop.aliens;

import java.util.Random;

public class DefectiveLight extends Light implements Repairable {

    private final Random rand = new Random();
    private boolean on;
    private int cyklov;

    public DefectiveLight() {

        this.on = false;
        this.cyklov = 0;
    }

    @Override
    public void act() {

        if (this.cyklov == 1000) {
            this.on = false;
            this.cyklov = 0;
        }
        if (this.on == false && rand.nextInt(10) == 1) {
            toggle();
        }
        if (this.on == true) {
            this.cyklov++;
        }
    }

    @Override
    public void repair(AbstractTool tool) {
        if (tool instanceof Wrench) {
            if (tool != null) {
                this.on = true;
                this.cyklov = 0;
            }
        if (tool != null) {
                tool.use();
        }
    }
    } 
}