import java.util.Scanner;

/**
 * Created by racit-2105 on 18/01/17.
 * INCOMPLETE
 */
public class MinimumElementInSortedRotatedArray {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n ; ++i) {
            a[i] = in.nextInt();
        }

        int l = 0, r = n - 1, m , mid = 0;
        while( l < r) {
            m = (l + r) / 2;
            mid = a[m];
            if(mid > a[r]) {
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(mid);

    }
}
