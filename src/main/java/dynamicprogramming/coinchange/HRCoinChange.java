package dynamicprogramming.coinchange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by racit-2105 on 19/02/17.
 */
public class HRCoinChange {

    static long mem[][];

    static long count(int s[], int m, int n) {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins, then there is no solution
        if (m <= 0)
            return 0;

        if(mem[n][m] == -1) {
            // count is sum of solutions (i) excluding S[m-1] (ii) including S[m-1]
            mem[n][m] = count( s, m - 1, n ) + count( s, m, n-s[m-1] );
        }
        return mem[n][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        final int m = in.nextInt();
        mem = new long[n + 1][m + 1];
        for(int i = 0; i < mem.length; ++i) {
            Arrays.fill(mem[i],1,mem[i].length,-1);
        }
        int coins[] = new int[m];
        in.nextLine();
        for(int i = 0; i < m ; ++i) {
            coins[i] = in.nextInt();
        }
        System.out.println(count(coins,m,n));
    }
}
