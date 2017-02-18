import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 19/01/17.
 */
public class InputTest {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);
          /* Declare second integer, double, and String variables. */

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */

        /* Print the sum of the double variables on a new line. */

    /* Concatenate and print the String variables on a new line;
        the 's' variable above should be printed first. */
        int j;
        double e;
        String p;

        HashMap hashMap = new HashMap();

        j = scan.nextInt();
        scan.nextLine();
        e = scan.nextDouble();
        scan.nextLine();
        p = scan.nextLine();

        System.out.println(i + j);
        System.out.println(d + e);
        System.out.println(s + p);
    }
}
