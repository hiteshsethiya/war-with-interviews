package problems;

import java.util.*;

/**
 * Created by Hitesh Sethiya on 22/01/17.
 */
public class PairsWIthSameDifference {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Integer[] a = new Integer[n];
        Set<Integer> aF = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            aF.add(a[i]);
        }
        Integer count = 0;
        for(Integer it : aF) {
            if(aF.contains(Math.abs(it + k))) ++count;
        }
        System.out.println(count);
    }
}
