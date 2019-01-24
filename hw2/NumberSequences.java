//Utilized previous assignments for scanner syntax
/*I worked with 2 friends who aren't in this class to learn how scanner is affected by looping,
and how one scanner should not be used to scan multiple types.*/
import java.util.Scanner;

public class NumberSequences {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the first character of the sequence to generate\n(C)ollatz, (F)ib, or (E)xit: ");
            String sequenceType = scan.nextLine();
            //whitespace checkstyle is stupid
            //if doing collatz sequence;
            if (sequenceType.equals("C")) {
                System.out.print("Enter the starting number (1 - 100): ");
                String printOut = scan.nextLine();
                int start = Integer.parseInt(printOut); //start is the working value
                int i;
                for (i = 0; start != 1; i++) {
                    if (start % 2 == 0) { //if even, do this
                        start /= 2;
                    } else {           //else it's odd, do this
                        start *= 3;
                        start += 1;
                    }               //add a space and then the new mod value of start
                    printOut += " ";
                    printOut += start;
                    //update count, because variable i won't keep scope in the print
                }
                System.out.println("\nCollatz Sequence: " + printOut + "\nNumber of steps: " + i);
            //if doing Fib sequence;
            //whitespace checkstyle is stupid
            //whitespace checkstyle is stupid
            } else if (sequenceType.equals("F")) {
                System.out.print("Enter the length of the desired fib sequence (1 - 40): ");
                String text = scan.nextLine(); //why is this a problem i hate scanner
                int max = Integer.parseInt(text); //apparently I cant scan two different types with scanner
                String printOut = "0 1 ";
                //whitespace
                if (max == 1) { //for the advanced test case where 1 is simply entered.
                    System.out.println("\nFib Sequence: 0");
                } else { //else run this loop normally, if other than 1
                    int prev = 1, prev2 = 0; //no working value is needed rn
                    int newVal;
                    for (int i = 2; i < max; i++) {
                        newVal = prev2 + prev;
                        //newVal is found, change the vals of previous
                        prev2 = prev;
                        prev = newVal;
                        printOut += newVal;
                        printOut += " ";
                    }
                    System.out.println("\nFib Sequence: " + printOut);
                }
            //whitespace checkstyle is stupid
            } else if (sequenceType.equals("E")) { // to kill the program
                break;
            } else {
                String iHateCheckstyle = null;
            } //empty else statement for good boy points
            //this is supposedly good practice but I guess checkstyle doesn't agree so i added a useless var

            System.out.println("--------------------");
        }
    }
}