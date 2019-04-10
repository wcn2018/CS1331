/*
 * In order to help learn course concepts, I worked on the homework with
 * Mai Vo and Bryan Zhao, discussed homework topics and issues with the same people,
 * and consulted related course materials that can be found at stackoverflow
 * and GeeksforGeeks.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author William
 * @version 1.0
 */
public class Grep {
    private static String returnable = "";
    /**
     * Main, only serves to run Grep and print the results
     * @param args All args necessary for grep: optional '-1' for case insensitive,
     *             search term, then name of directory to search in.
     * @throws IllegalArgumentException tells if args are wrong length or type
     */
    public static void main(String[] args)
            throws IllegalArgumentException {
        String printer;
        try {
            if (args[0].equals("-1")) {
                if (args.length > 3) {
                    throw new IllegalArgumentException("too many args!");
                }
                if (args.length < 3) {
                    throw new IllegalArgumentException("too few args!");
                }
                File file = new File(args[2]);
                printer = grep(file, args[1], true);
            } else {
                if (args.length > 2) {
                    throw new IllegalArgumentException("too many args!");
                }
                if (args.length < 2) {
                    throw new IllegalArgumentException("too few args!");
                }
                File file = new File(args[1]);
                printer = grep(file, args[0], false);
            }
            System.out.println(printer);
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found while calling grep:");
            System.out.println(fnfe.getMessage());
        } catch (IOException io) {
            System.out.println("Non File not Found Error."
                    + "Some other IO error occurred in grep:");
            System.out.println(io.getMessage());
        } catch (InvalidSearchStringException invalid) {
            System.out.println("Invalid Search String: " + invalid.getMessage());
        } catch (IllegalArgumentException illegal) {
            System.out.println("Illegal Argument: " + illegal.getMessage());
        }
    }

    /**
     * Performs Grep search function, adds lines to static va returnable of Grep
     * @param case1 optional for non case sensitive
     * @param searchTerm String to search for
     * @param subDir Directory to search in
     * @throws InvalidSearchStringException when a newline is found in search term, caught in main
     * @throws IllegalArgumentException when the given directory is empty or nonexistent
     * @throws FileNotFoundException when a file cannot be found
     * @throws IOException to throw any other IO errors
     * @return returnable the string with all matches.
     */
    public static String grep(File subDir, String searchTerm, boolean case1)
        throws FileNotFoundException, IOException, IllegalArgumentException, InvalidSearchStringException {
        File[] inside = subDir.listFiles();
        if (searchTerm.contains("\n")) {
            throw new InvalidSearchStringException("Cannot have newline char in search term!");
        }
        if (inside == null) {
            throw new IllegalArgumentException("Given directory " + "'" + subDir + "'"
                    +  " does not exist or is empty!");
        }
        if (case1) {
            searchTerm = searchTerm.toLowerCase();
        }
//        try {
        for (File each : inside) {
            /* Recursive element: If each is a subDir, grep is called
             * again using the same arguments
             */
            if (each.isDirectory()) {
                grep(each, searchTerm, case1);
            } else {
                int line = 0;
                // Else, run this check on the file for the searchTerm.
                // Use a scanner to search line by line.
                Scanner scan = new Scanner(each);
                while (scan.hasNextLine()) {
                    line++;
                    String origLine = scan.nextLine();
                    String tempLine = origLine;
                    if (case1) {
                        tempLine = tempLine.toLowerCase();
                    }
                    if (tempLine.contains(searchTerm)) {
                        String foundLine = "";
                        foundLine += each.toString();
                        foundLine += ':';
                        foundLine += line;
                        foundLine += ':';
                        foundLine += origLine;
                        foundLine += '\n';

                        returnable += foundLine;
                    }
                }
            }
        }
        return returnable;
//        } catch (FileNotFoundException fnfe) {
//            System.out.println(fnfe.getMessage());
//        } catch (IOException io) {
//            System.out.println(io.getMessage());
//        }
    }
}
