import java.util.Scanner;

public class NumberSequences{
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true){
			System.out.println("Enter the first character of the sequence to generate\n(C)ollatz, (F)ib, or (E)xit: ");
			String sequenceType = scan.nextLine();
			
			//if doing collatz sequence;
			if (sequenceType.equals("C")){
				System.out.println("Enter the starting number (1 - 100): ");
				String printOut = scan.nextLine();
				int start = Integer.parseInt(printOut); //start is the working value
				int i;
				for (i = 0; start != 1; i++){
					if (start%2==0){ //if even, do this
						start /= 2;
					}
					else{			//else it's odd, do this
						start *= 3;
						start += 1;
					}				//add a space and then the new mod value of start
					printOut += " ";
					printOut += start;
					//update count, because variable i won't keep scope in the print
				}
				System.out.println("\nCollatz Sequence: " + printOut +"\nNumber of steps: " + i);
			}

			//if doing Fib sequence;
			else if (sequenceType.equals("F")){
				System.out.println("Enter the length of the desired fib sequence (1 - 40): ");
				String text = scan.nextLine(); //why is this a problem i hate scanner
				int max = Integer.parseInt(text); //apparently I cant scan two different types with scanner
				int prev = 1, prev2 = 0; //no working value is needed rn
				String printOut = "0 ";
				int newVal;
				for(int i = 2; i <= max; i++){
					newVal = prev2 + prev;
					//newVal is found, change the vals of previous
					prev2 = prev;
					prev = newVal;
					printOut += newVal;
					printOut += " ";
				}
				System.out.println("\nFib Sequence: " + printOut);
			}

			else if (sequenceType.equals("E")){ // to kill the program
				break; 
			}

			else {} //empty else statement for good boy points

			System.out.println("--------------------");		
		}
	}
}