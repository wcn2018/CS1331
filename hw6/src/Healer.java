/***
 * @author William Chen
 * @version 1.0
 */
public class Healer extends Friendly {
    private int healpoints;

    /***
     * Constructor just calls super for constructor in friendly class.
     * @param n a
     */
    public Healer(String n) {
        super(n);
    }

    /***
     * Overide Friendly class interact method. uses super to call original
     * greeting, then calls the heal method described below
     * @param otherCharacter a Character cbject to interact with
     */
    @Override
    protected void interact(Character otherCharacter) {
        super.interact(otherCharacter);
        heal(otherCharacter);
    }

    /***
     * This method heals another character. If friendly, heals for 4
     * If unfriendly, heal for 2
     * @param otherCharacter the character to heal.
     */
    public void heal(Character otherCharacter) {
        String othername = otherCharacter.getName();
        int healHP = otherCharacter.getHealth();

        if (healHP == 0) {
            System.out.println(name + ": I'm sorry " + othername
                    + ". Nothing is working!");
        } else {
            if (otherCharacter.getHealth() >= otherCharacter.getMaxHealth()) {
                System.out.println(name + ": Hey " + othername
                        + ". You look perfectly fine to me!");
            } else {
                int currentHealth = otherCharacter.getHealth();
                if (otherCharacter.getMaxHealth() == 15) {
                    healpoints = 2;
                } else if (otherCharacter.getMaxHealth() == 10) {
                    healpoints = 4;
                }
                currentHealth = (currentHealth + healpoints > 10 ? 10 : currentHealth + healpoints);
                otherCharacter.setHealth(currentHealth);
                System.out.println(name + ": Got you up to " + currentHealth
                        + " health. Hope you feel better " + othername + "!");
            }
        }
    }
}
