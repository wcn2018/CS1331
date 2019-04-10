/*
I worked on the homework assigment alone, using only course materials.
*/

public class Musician {
    private String name;
    private String instrument;
    private int yearsPlaying;
    private double skillLevel;

    Musician(String name, String instrument) {
        this(name, instrument, 0);
    }

    Musician(String name, String instrument, int years) {
        this.name = name;
        this.instrument = instrument;
        this.yearsPlaying = years;
        skillLevel = yearsPlaying * 0.5 + 1.0;
    }

    public String getName() {
        return name;
    }

    public String getInstrument() {
        return instrument;
    }

    public int getYearsPlaying() {
        return yearsPlaying;
    }

    public double getSkillLevel() {
        return skillLevel;
    }

    public void rehearse() {
        this.skillLevel += .5;
        this.yearsPlaying += 1;
        return;
    }

    public void perform() {
        this.skillLevel += 1;
        return;
    }

    public String toString() {
        String a = "My name is " + this.name + ". I have been playing " + this.instrument
            + " for " + yearsPlaying + " years.";
        return a;
    }
}