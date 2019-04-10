/**
* This class represents a Drink enum. Each constant has a name and price value.
* @author William Chen
* @version 1.0
*/
public enum Drink {
    /** Hot Chocolate and price */
    CHOCOLATE("hot chocolate", 1.50),
    /** Coffee and price */
    COFFEE("coffee", 2.00),
    /** Tea and price */
    TEA("tea", 1.00),
    /** Empty cup */
    EMPTY("nothing", 0.00);

    private String name;
    private double price;
    /**
    * Enum constructor, gives each value a drink and price attribute.
    * @param name String that gives the drink type
    * @param price double that tells the price of the drink
    */
    private Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
    * Getter for name
    * @return String name of drink
    */
    public String getName() {
        return this.name;
    }

    /**
    * Getter for price
    * @return Double price of drink.
    */
    public double getPrice() {
        return this.price;
    }
}