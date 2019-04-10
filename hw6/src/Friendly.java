/***
 * stuff
 * @author William Chen
 * @version 1.0
 */
public class Friendly extends Character {
    /***
     * Updated constructor for Friendly class.
     * Implements health and maxhealth as well as name
     * @param n input string for name
     */
    public Friendly(String n) {
        System.out.println("Hi my name is " + n + "! I am friendly!");
        maxHealth = 10;
        health = 10;
        name = n;
    }

    /***
     * Updated interact method for friendly, this interaction prints:
     * "Name: Hi [othername]!"
     * as a greeting towards othercharacter
     * @param otherCharacter a Character cbject to interact with
     */

    @Override
    protected void interact(Character otherCharacter) {
        if (otherCharacter == this) {
            return;
        }
        String othername = otherCharacter.getName();
        System.out.println(name + ": Hi " + othername + "!");
    }
}
