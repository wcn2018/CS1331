/**
 * @author William Chen
 * @version 1.0
 */
public class Dog extends Animal implements Comparable<Animal> {
    private boolean curlyTail;
    private int droolRate;

    /**
     * 4 parameter constructor
     * Constructs a dog with bool curlyTail, int droolRate, String name, double Price.
     * All dogs have store ID 100
     * @param curlyTail boolean whether this dog has a curly tail
     * @param droolRate int the rate of this dog's drooling
     * @param name String name
     * @param price double Price for sale
     */
    public Dog(String name, double price, boolean curlyTail, int droolRate) {
        super(100, name, price);
        this.curlyTail = curlyTail;
        this.droolRate = droolRate;
    }

    /**
     * 2 param constructor with only curlyTail and droolRate,
     * name defaults to "none" and price to 50.0
     * All dogs have store ID 100
     * @param curlyTail boolean curly tail or no
     * @param droolRate rate of drool int
     */
    public Dog(boolean curlyTail, int droolRate) {
        this("none", 50.0, curlyTail, droolRate);
    }

    /**
     * getter for drool rate
     * @return int drool rate
     */
    public int getDroolRate() {
        return this.droolRate;
    }

    /**
     * getter for curlyTail
     * @return boolean curlyTail
     */
    public boolean getCurlyTail() {
        return this.curlyTail;
    }

    /**
     * setter for drool rate
     * @param droolRate int to set to
     */
    public void setDroolRate(int droolRate) {
        this.droolRate = droolRate;
    }

    /**
     * setter for curlytail
     * @param curlyTail boolean to set to
     */
    public void setCurlyTail(boolean curlyTail) {
        this.curlyTail = curlyTail;
    }
//------------------------------------overRides--------------------------------

    /**
     * toString method for Dog describing all characteristics of the Dog
     * @return "Store ID: id, Name: name, Price: price, Curly Tail: curlyTail, Drool Rate: droolRate"
     */
    @Override
    public String toString() {
        String returnIt = String.format("Store ID: %d, Name: %s, Price %.2f,"
                        + " Curly Tail: %b, Drool Rate: %d"
                , this.storeId, this.name, this.price, this.curlyTail, this.droolRate);
        return returnIt;
    }

    /**
     * compares ordinality of object to the parameter object.
     * @param a the object to compare to (this should be an Animal)
     * @return -1 if Dog is ordinally before, 0 if equals, 1 if after. -2 if not an Animal, -3 for serious error.
     */
    @Override
    public int compareTo(Animal a) {
        if (a instanceof Dog) {
            int eqName = super.compareTo(a);
            if (eqName == 0) {
                int compareDrool = ((Dog) a).getDroolRate() - this.getDroolRate();
                return compareDrool;
            } else {
                return eqName;
            }
        } else {
            return super.compareTo(a);
        }
    }

    /**
     * calls the Animal toString, only exists for testing
     * @return String, see Animal toString.
     */
    public String superToString() {
        return super.toString();
    }
}
