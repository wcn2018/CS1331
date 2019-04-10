import java.io.File;
import java.util.Scanner;

/**
 * @author William
 * @version 1.0
 */
public class Test {
    /**
     * main just calls test stuff
     * @param args s
     */
    public static void main(String[] args) {
        File a = new File(args[0]);
        try {
            Scanner s = new Scanner(a);
            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Integer[] intarray = new Integer[0];
        Scanner[] scanarray = new Scanner[0];

        System.out.println(intarray.toString());
        System.out.println(scanarray.toString());
    }
}
