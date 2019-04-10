/* In order to help learn course concepts, I worked on the homework assignment with
Mai Vo, discussed homework topics and issues with Mai Vo, and/or consulted material
that can be found at http://www.technofundo.com/tech/java/equalhash.html.
*/

/**
* This class represents a static CoffeeMachine with globally accessible pour method
* @author William Chen
* @version 1.0
*/
public class CoffeeMachine {
    private static int cupsUsed;
    private static double sales;
    private static Cup[] cups = new Cup[10];

    /**
    * Prints a string of statistics based off of static class data
    * "Today we made __sales__ and used __cupsUsed__ cups."
    */
    public static void stats() {
        System.out.printf("Today we made %.2f and used %d\n", sales, cupsUsed);
    }

    //pour method given a foreign cup
    /**
    * Pour method with 2 params, fills a given cup with the requested drink.
    * @param cup The cup given to the machine, to receive a drink, Cup object.
    * @param drink The drink to be put in the cup, Drink object.
    * @return The cup object input, with the new drink.
    */
    public static Cup pour(Cup cup, Drink drink) {
        cup.setDrink(drink);
        sales += drink.getPrice();
        return cup;
    }
    /*                  NOTES:
    The total number of cups used should accumulate to above 10.
    Think of this as an actual coffee machine which takes and dispenses cups.
    */

    //pour method using our cups
    /**
    * Takes a cup out of the machine's stock and fills with a requested drink.
    * If out of cups, this method restocks. These cups will always be stamped "Java".
    * @param drink The drink to put in the cup, Drink object
    * @return A cup object filled with desired drink, stamped "Java".
    */
    public static Cup pour(Drink drink) {
        //Check if we need cups, then add if we do.
        if (cupsUsed % 10 == 0) {
            for (int i = 0; i < 10; i++) {
                cups[i] = new Cup(Drink.EMPTY, "Java");
            }
        }
        //Set the correct cup
        Cup tempCup = cups[cupsUsed % 10];
        tempCup.setDrink(drink);
        cups[cupsUsed % 10] = null;
        //stats tracking
        cupsUsed += 1;
        sales += drink.getPrice();
        //return the temp back.
        return tempCup;
    }
}