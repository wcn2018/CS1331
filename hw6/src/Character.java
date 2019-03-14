public abstract class Character{
    protected int health;
    protected int maxHealth;
    protected String name;

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}