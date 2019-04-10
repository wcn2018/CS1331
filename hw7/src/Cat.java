/**
 * @author William Chen
 * @version 1.0
 */
public class Cat extends Animal implements Comparable<Animal> {
    private int miceCaught;
    private boolean likesLasagna;

    /**
     * 4 parameter Constructor for Cat, including miceCaught, likesLasagna, name, and price.
     * All cats have store ID 200.
     * @param miceCaught int number of mice this cat has caught
     * @param likesLasagna boolean whether this cat likes LASAGAAA
     * @param name String name of cat
     * @param price Double price to purchase
     */
    public Cat(String name, double price, int miceCaught, boolean likesLasagna) {
        super(200, name, price);
        this.miceCaught = miceCaught;
        this.likesLasagna = likesLasagna;
    }

    /**
     * 2 parameter Constructor for cat, including miceCaught and likesLasagna
     * name is default to "none" and price at 30.0.
     * All cats have store ID 200
     * @param miceCaught int number of mice this cat has caught
     * @param likesLasagna boolean whether this cat likes LASAGAAA
     */
    public Cat(int miceCaught, boolean likesLasagna) {
        this("none", 30.0, miceCaught, likesLasagna);
    }
    /**
     * getter for miceCaught
     * @return int miceCaught
     */
    public int getMiceCaught() {
        return this.miceCaught;
    }

    /**
     * getter for likesLasagna
     * @return boolean likesLasagna
     */
    public boolean getLikesLasagna() {
        return this.likesLasagna;
    }

    /**
     * sets miceCaught
     * @param miceCaught number of mice caught
     */
    public void setMiceCaught(int miceCaught) {
        this.miceCaught = miceCaught;
    }

    /**
     * sets likeLasagna
     * @param likesLasagna boolean likes lasagna or not
     */
    public void setLikesLasagna(boolean likesLasagna) {
        this.likesLasagna = likesLasagna;
    }
    //--------------------------------OverRides--------------------------------

    /**
     * toString describing name, price, miceCaught, and opinion of lasagna
     * @return "Store ID: id, Name: name, Price: price, Likes Lasagna: likesLasagna"
     */
    @Override
    public String toString() {
        String returnIt = String.format("Store ID: %d, Name: %s, Price %.2f,"
                        + " Likes Lasagna: %b, Mice Caught: %d"
                , this.storeId, this.name, this.price, this.getLikesLasagna(), this.getMiceCaught());
        return returnIt;
    }

    /**
     * compares Cat to another object, depending on ordinality
     * first compares storeId then, if equal, sorts by alphabetical name.
     * @param a the object to compare to
     * @return same outputs as comparable, according to natural order.
     */
    @Override
    public int compareTo(Animal a) {
        if (a instanceof Cat) {
            int eqName = super.compareTo(a); //if names are equal (using animal's compareTo)
            if (eqName == 0) {
                int compareMice = ((Cat) a).getMiceCaught() - this.getMiceCaught();
                return compareMice;
            } else {
                return eqName;
            }
        } else {
            return super.compareTo(a);
        }
    }
}
