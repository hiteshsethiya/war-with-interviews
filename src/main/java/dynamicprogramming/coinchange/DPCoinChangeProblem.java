package dynamicprogramming.coinchange;

import java.util.Scanner;

/**
 * Created by racit-2105 on 19/02/17.
 */
public class DPCoinChangeProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        in.nextLine();
        for(int i = 0; i < m ; ++i) {
            coins[i] = in.nextInt();
        }

        int c[] = new int[n + 1];
        int s[] = new int[n + 1];
        c[0] = s[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int coinUsed = 0,minCost = Integer.MAX_VALUE;
            for(int j = 0; j < m && coins[j] <= i; ++j) {
                int cost = c[i - coins[j]] + 1;
                if(cost < minCost) {
                    minCost = cost;
                    coinUsed = coins[j];
                }
            }
            c[i] = minCost;
            s[i] = coinUsed;
        }


        for(int i = s.length - 1; i > 0;) {
            System.out.print(s[i]+ " ");
            i = i - s[i];
        }

    }
}
