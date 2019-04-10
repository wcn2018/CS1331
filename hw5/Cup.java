/**
* This class represents a Dog object, holding a drink and with identifying stamp
* @author William Chen
* @version 1.0
*/
public class Cup {
    private Drink drink;
    private String stamp;
    /**
    * Constructs a Cup object, given a Drink object and stamp string.
    * @param drink Drink object put into the cup
    * @param stamp stamp String describing where the coffee is from.
    */
    public Cup(Drink drink, String stamp) {
        this.drink = drink;
        this.stamp = stamp;
    }
    /**
    * Getter for drink in the cup
    * @return the Drink object in the cup
    */
    public Drink getDrink() {
        return this.drink;
    }

    /**
    * Getter for the stamp String
    * @return the stamp of the cup, string.
    *
    */
    public String getStamp() {
        return this.stamp;
    }

    /**
    * Setter for stamp
    * @param stamp the stamp to set, String object.
    */
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    /**
    * Setter for drink
    * @param drink the drink to set, Drink object.
    */
    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    /**
    * Override Object toString method. Returns a string description of the cup and its data.
    * @return string of fomrat: "A cup of __drink name__ from __stamp__."
    */
    public String toString() {
        return ("A cup of " + this.getDrink().getName() + " from " + this.getStamp());
    }

    /**
    * Override Object equals method. checks if name and stamp are equal.
    * @param checkCup the Cup object to compare with for equality.
    * @return boolean if stamps are equal and drink names are equal.
    */
    public boolean equals(Object checkCup) {
        if (checkCup instanceof Cup) {
            Cup checkCups = (Cup) checkCup;
            return (this.getStamp().equals(checkCups.getStamp()))
                && (this.getDrink().getName().equals(checkCups.getDrink().getName()));
        } else {
            return false;
        }
    }
    /**
    * Overridden hashcode method, determines hash off of drink and stamp.
    * @return the hashcode of the Cup object
    */
    public int hashCode() {
        int hash = 7;
        hash = hash * 31 + (null == this.getDrink() ? 0 : this.getDrink().hashCode());
        hash = hash * 31 + (null == this.getStamp() ? 0 : this.getStamp().hashCode());
        return hash;
    }

}