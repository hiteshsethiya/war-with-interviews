package codeagon;

import java.util.*;

/**
 * Created by Hitesh Sethiya on 26/01/17.
 */
public class MatchstickWarehouseThief {

    public static class match implements Comparable<match> {
        Long b;
        Long m;
        Long t;


        public int compareTo(match o) {
            Long diff = this.t - o.t;

            Long mDiff = this.m - o.m;
            if(mDiff == 0) return 0;
            else if(mDiff > 0) {
                return -1;
            } else {
                return 1;
            }

//            if(diff == 0) {
//
//            } else if(diff < 0) {
//                return 1;
//            } else {
//                return -1;
//            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();

        int[][] crate = new int[c][2];
        match[]  matches = new match[c];

        for(int crate_i=0; crate_i < c; crate_i++){
            for(int crate_j=0; crate_j < 2; crate_j++){
                crate[crate_i][crate_j] = in.nextInt();
            }
            match m = new match();
            m.b = (long)crate[crate_i][0];
            m.m = (long)crate[crate_i][1];
            m.t = m.b * m.m;
            matches[crate_i] = m;
        }

        Arrays.sort(matches);
        Long tm = 0L;

        for(int i = 0; i < matches.length && n > 0; ++i) {
            if(n - matches[i].b < 0) {
                tm += n * matches[i].m;
                n -= n;
            } else {
                tm += matches[i].t;
                n -= matches[i].b;
            }
        }

        System.out.println(tm);
        // your code goes here
    }
}
