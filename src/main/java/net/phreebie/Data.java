package net.phreebie;

public class Data {
    private Temperature temperature = new Temperature();

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    private Timer timer = new Timer();

    private boolean contur1 = false;
    private boolean contur2 = false;
    private boolean switched = false;

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }


    public boolean isContur1() {
        return contur1;
    }

    public void setContur1(boolean contur1) {
        this.contur1 = contur1;
    }

    public boolean isContur2() {
        return contur2;
    }

    public void setContur2(boolean contur2) {
        this.contur2 = contur2;
    }

    public boolean isSwitched() {
        return switched;
    }

    public void setSwitched(boolean switched) {
        this.switched = switched;
    }
}
