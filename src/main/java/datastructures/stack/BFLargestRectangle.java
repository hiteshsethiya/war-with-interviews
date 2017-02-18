package datastructures.stack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 13/02/17.
 */
public class BFLargestRectangle {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            max = Math.max(ar[i],max);
            int l,r;
            for(l = i; l > 0 && ar[i] <= ar[l - 1];) {
                --l;
            }
            for(r = i; r < n - 1 && ar[i] <= ar[r + 1];) {
                ++r;
            }

            if(ar[i] <= ar[l - 1] && ar[i] <= ar[r + 1]) {
                int area = (r - l) * ar[i];
                max = Math.max(area,max);
            }

        }
        System.out.println(max);
    }
}
