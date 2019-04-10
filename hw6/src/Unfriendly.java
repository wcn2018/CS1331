/***
 * @author William Chen
 * @version 1.0
 */
public class Unfriendly extends Character {
    /***
     * Updated constructor for unfriendly class. prints this:
     * "The name's [name] I'm not friendly.
     * @param n a
     */
    public Unfriendly(String n) {
        System.out.println("The name's " + n + ". I'm not friendly.");
        maxHealth = 15;
        health = 15;
        name = n;
    }

    /***
     * Overide interaction method for unfriendly. Will print:
     * "[name]: What are you looking at [othername]!?"
     * @param otherCharacter a Character object to interact with.
     */
    @Override
    protected void interact(Character otherCharacter) {
        if (otherCharacter == this || otherCharacter.maxHealth == 15) {
            return;
        }
        String othername = otherCharacter.getName();
        System.out.println(this.name + ": What are you looking at "
                + othername + "!?");
    }
}
