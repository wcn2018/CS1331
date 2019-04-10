/***
 * @author William Chen
 * @version 1.0
 */
public class Attacker extends Unfriendly {
    /***
     * updated constructor
     * @param n a
     */
    public Attacker(String n) {
        super(n);
    }

    /***
     * Overide the unfriendly interact method. This first calls the
     * interact from super unfriendly to greet, then calls the new
     * attack method to attack the other character. Will not attack itself
     * @param otherCharacter a Character object to interact with.
     */
    @Override
    protected void interact(Character otherCharacter) {
        super.interact(otherCharacter);
        attack(otherCharacter);
    }

    /***
     * attacks the other character. Will not attack itself.
     * Attacks a friendly character for 5 health, an unfriendly for 3.
     * @param otherCharacter a
     */
    private void attack(Character otherCharacter) {
        if (otherCharacter == this) {
            return;
        }

        int attackpoints = 0;
        int currentHealth = otherCharacter.getHealth();
        String othername = otherCharacter.getName();

        if (currentHealth == 0) {
            System.out.println(name + ": You show such weakness " + othername
                    + ".");
        } else {
            if (otherCharacter.getMaxHealth() == 15) {
                attackpoints = 3;
            } else if (otherCharacter.getMaxHealth() == 10) {
                attackpoints = 5;
            }
            if (currentHealth - attackpoints > 0) {
                currentHealth = currentHealth - attackpoints;
                otherCharacter.setHealth(currentHealth);
                System.out.println(name + ": Now you're only at " + currentHealth
                        + " health. How does it feel " + othername + "!?");
            } else {
                otherCharacter.setHealth(0);
                System.out.println(name + ": You were no match for me " + othername + ".");
            }
        }
    }
}
