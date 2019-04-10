/**
*Tester Class
*/
public class PersonTest{
	/**
	* Main, prints various values to check them.
	* Calls methods of CoffeeMachine
	*/
	public static void main(String[] args){
		Cup[] test = new Cup[30];
		
		System.out.println("no cup pours");
		System.out.println("before pouring 20: ");
		CoffeeMachine.stats();
		for (int i = 0; i < 20; i++){
			test[i] = CoffeeMachine.pour(Drink.CHOCOLATE);
		}

		System.out.println("after pouring: ");
		CoffeeMachine.stats();
		System.out.println("");
		System.out.println("cup 1 in array");
		System.out.println(test[1].getStamp());
		System.out.println(test[1].getDrink().getName());
		System.out.println("cup 11 in array");
		System.out.println(test[11].getStamp());
		System.out.println(test[11].getDrink().getName());
		System.out.println("");

		System.out.println("Test the pour with cup, 10 times coffee");

		// a bunch more pours of coffee
		Cup test2 = new Cup(Drink.EMPTY, "Test2");
		test2 = CoffeeMachine.pour(test2, Drink.TEA);
		System.out.println(test2.toString());
		CoffeeMachine.stats();

		Cup[] test3 = new Cup[10];
		Cup dumpCup = new Cup(Drink.EMPTY, "dumpCup");
		for(int i = 0; i < 10; i++) {
			test3[i] = new Cup(Drink.EMPTY, "Test3");
		}
		System.out.println(test3[2].toString());

		for(int i = 0; i < 10; i++) {
			dumpCup = CoffeeMachine.pour(test3[i], Drink.COFFEE);
		}
		System.out.println(test3[2].toString());
		CoffeeMachine.stats();

		System.out.println("One last pour");
		CoffeeMachine.pour(test2, Drink.CHOCOLATE);
		System.out.println(test2.getStamp());
		System.out.println(test2.getDrink().getName());
		CoffeeMachine.stats();
	}
}