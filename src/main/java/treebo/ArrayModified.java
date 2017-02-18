package treebo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 13/02/17.
 */
public class ArrayModified {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while (T-- != 0) {
            int sum = 0;
            int N = s.nextInt();
            long start = System.currentTimeMillis();
            for (int i = 1; i <= N; ++i) {
                sum += i;
                //System.out.println("i - " + i + " sum = " + (sum += i));
            }
            if(sum % 2 == 0) {
                System.out.println("Yes");

            } else {
                System.out.println("No");
            }
            System.out.println((System.currentTimeMillis() - start) / 1000);
        }
    }
}
