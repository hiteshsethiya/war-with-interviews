package implementation;

import java.util.*;

/**
 * Created by racit-2105 on 20/02/17.
 */
public class EqualizetheArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        in.nextLine();
        int[] a = new int[n];
        int[] reps = new int[101];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
            reps[a[i]] += 1;
            if(reps[a[i]] > max) {
                max = reps[a[i]];
            }
        }
        System.out.println(a.length - max);
    }
}
