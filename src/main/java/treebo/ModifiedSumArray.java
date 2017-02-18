package treebo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This is brute force
 * Created by Hitesh Sethiya on 12/02/17.
 */
public class ModifiedSumArray {



    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int sum = 0;
        while(T-- != 0) {
            int N = s.nextInt();
            long start = System.currentTimeMillis();
            for(int i = 1; i < N; ++i) {
                System.out.println("i - "+ " sum = " + (sum+=i));
            }
            if(sum % 2 == 0) {
                int m = ((Double) Math.floor(N / 2)).intValue();
                int halfS = sum / 2;
                for(int j = N; halfS > 0;--j) {
                    if(halfS >= j) {
                        halfS -= j;
                        m--;
                    }
                }
                if(m >= 0 && halfS == 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
            System.out.println(System.currentTimeMillis() - start);

//            if(true) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
        }
    }
}
