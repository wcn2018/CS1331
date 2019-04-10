/*
In order to help learn course concepts, I worked on the homework with
Mai Vo, Andrew Li, and Bryan Zhao, discussed homework topics and issues with
the same people, and consulted resources that can be found at stackoverflow.com
 */

/***
 * stuff
 * @author William Chen
 * @version 1.0
 */
public abstract class Character {
    protected int health;
    protected int maxHealth;
    protected String name;

    /***
     * Getter for health
     * @return the health as an int
     */
    public int getHealth() {
        return health;
    }

    /***
     * Getter for max health
     * @return the max health as an int
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /***
     * Getter for the name
     * @return the name as a string
     */
    public String getName() {
        return name;
    }

    /***
     * Setter for the health
     * @param health an int to string
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /***
     * abstract method for interact, defined in subs
     * Only requires one other character for input.
     * @param otherCharacter a
     */
    protected abstract void interact(Character otherCharacter);

}