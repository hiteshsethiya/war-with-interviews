package search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by racit-2105 on 21/02/17.
 */
public class HackerlandRadioTransmitters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<Integer>();
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
            max = Math.max(x[x_i],max);
            set.add(x[x_i]);
        }

        for(int i = 1; i <= max;) {
            if(set.contains(i)) {
                if(set.contains((i + k))) {

                }
            }
        }

    }
}
