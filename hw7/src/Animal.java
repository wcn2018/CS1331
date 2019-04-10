/*
In order to help learn course concepts, I worked on the homework with
Mai Vo, Andrew Li, and Bryan Zhao, discussed homework topics and issues
with the same people, and/or consulted related materials that can be
found at the online JDK11 documentation and stackoverflow.
 */

/**
 * General Animal class extended by Dog and Cat
 * implements comparable for custom compareTo method.
 * @author William Chen
 * @version 1.0
 */
public abstract class Animal implements Comparable<Animal> {
    protected int storeId;
    protected String name;
    protected double price;

    /**
     * 3 param Constructor for Animal
     * @param storeId int store ID for the animal
     * @param name String name of the animal
     * @param price double price for the animal
     */
    public Animal(int storeId, String name, double price) {
        this.storeId = storeId;
        this.name = name;
        this.price = price;
    }

    /**
     * 1 parameter constructor for animal
     * default name is "Buzz" and price is 222.0
     * @param storeId the int storeId of the animal
     */
    public Animal(int storeId) {
        this(storeId, "Buzz", 222.00);
    }

    /**
     * getter for name
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter for storeId
     * @return int storeId
     */
    public int getStoreId() {
        return this.storeId;
    }

    /**
     * getter for price
     * @return double describing the animal's price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * setter for name
     * @param name String name to be set to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for price
     * @param price double price to set to
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * setter for store ID
     * @param storeId int store ID to set
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    /**
     * a method for implementation in subclasses that implement
     * comparable. Takes a range of inputs and returns just -1, 0, or 1
     * @param compare integer input from a compare method to be simplified
     * @return integer -1 if compare < 0, 0 if == 0, 1 if > 0.
     */
    protected static int returnSimpleInts(int compare) {
        if (compare < 0) {
            return -1;
        } else if (compare > 0) {
            return 1;
        } else {
            return 0;
        }
    }
    //---------------------------------------toString-----------------------------------------

    /**
     * toString method that describes the Animal
     * @return "Store ID: storeId, Name: name, Price: price"
     */
    @Override
    public String toString() {
        String returnIt = String.format("Store ID: %d, Name: %s, Price %.2f"
                , this.storeId, this.name, this.price);
        return returnIt;
    }

    //--------------------------------------IMPLEMENTS----------------------------------------

    /**
     * This method overrides the compareTo seen in comparable.
     * Return shows if animal is naturally ordered before, after, or at
     * the same place as another animal it is compared to.
     * @param a object to compare to
     * @return negative if animal is ordinally before, 0 if equals, positive if after.
     */
    @Override
    public int compareTo(Animal a) {
        int compareInt = this.getStoreId() - a.getStoreId();
        if (compareInt == 0) {
            int compareNum = this.getName().compareTo(a.getName());
            return compareNum;
        } else {
            return compareInt;
        }
    }
}
