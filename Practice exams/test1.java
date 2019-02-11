import java.util.Scanner;
public class test1{
	
	enum TA {jeff, bob, greg};

	public static void main(String[] args) {
		// int arrays[];
		// double val;
		// double d1, d2;
		// d2 = 10.0;
		// d1 = d2 / 2;
		// val = 4 + (2.0 * d1);
		// System.out.println("the value is " + d1);

		// String a = (1.5f == 1.5 ? "false" : "true");
		// // for(char c:a){
		// // 	System.out.println(c);
		// // }
		// float num, nums[];
		// // System.out.println(a);
		// // Scanner price = new Scanner(System.in);
		// // System.out.println("please enter price: ");
		// // double prices = Double.parseDouble(price.nextLine());
		// // System.out.println(prices);
		// TA favoriteTA = TA.greg;
		// float f = 4.5f;
		// System.out.println("jan");
		// System.out.print("feb\n\n");
		// System.out.println("july");

		// // int i = 10;
		// // for (int j = 0; j<i; j+=2){
		// // 	System.out.println(j);
		// // 	i--;
		// int i,j;
		// for( i=10,j=0; j<i ; j+=2,i--){ // j<i is correct
		// 	System.out.println(j);
		// }
		//System.out.println(sumInputsName());
		System.out.println(reverseString("Word"));
	}
	public static String sumInputsName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter an int: ");
		scan.useDelimiter("\n");
		int int1 = Integer.parseInt(scan.nextLine());
		System.out.println("Please enter your full name: ");
		String name = scan.nextLine();
		System.out.println("Please enter another int: ");
		int int2 = Integer.parseInt(scan.nextLine());
		return(name+(int1+int2));
	}
	public static String reverseString(String str){
		String revSTring = "";
		int strLen = str.length();
		for (int i = strLen-1; i>=0; i--){
			revSTring += str.charAt(i);
		}
		return revSTring;
	}
}