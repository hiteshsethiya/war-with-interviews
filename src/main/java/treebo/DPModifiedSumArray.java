package treebo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 12/02/17.
 */
public class DPModifiedSumArray {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        HashMap<Integer,Integer> halfSumsToM = new HashMap<Integer, Integer>();
        int T = s.nextInt();
        while(T-- != 0) {
            int sum = 0;
            int N = s.nextInt();
            long start = System.currentTimeMillis();
            for(int i = 1; i <= N; ++i) {
                System.out.println("i - "+ i + " sum = " + (sum+=i));
            }
            if(sum % 2 == 0) {
                int m = ((Double) Math.floor(N / 2)).intValue();
                int halfS = sum / 2;
                int forMapHalfS = halfS;
                int forMapM = m;
                if(halfSumsToM.containsKey(halfS)) {
                    halfS = 0;
                }
                for(int j = N; halfS > 0;--j) {
                    if(halfSumsToM.containsKey(halfS)) {
                        m -= halfSumsToM.get(halfS);
                        halfS = 0;
                    } else if(halfS >= j) {
                        halfS -= j;
                        m--;
                    }
                }
                if(m >= 0 && halfS == 0) {
                    if(!halfSumsToM.containsKey(forMapHalfS)) {
                        halfSumsToM.put(forMapHalfS,(forMapM - m));
                    }
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
            System.out.println((System.currentTimeMillis() - start) / 1000);
        }
    }
}
