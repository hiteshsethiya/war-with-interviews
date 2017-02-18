package codeagon;

import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 26/01/17.
 */
public class BacktotheOrigin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long xTreasure = in.nextLong();
        long yTreasure = in.nextLong();
        int n = in.nextInt();
        long[][] direction = new long[n][2];
        for(int direction_i=0; direction_i < n; direction_i++){
            for(int direction_j=0; direction_j < 2; direction_j++){
                direction[direction_i][direction_j] = in.nextLong();
            }
        }


        for(int direction_i=0; direction_i < n; direction_i++) {
            for (int direction_j = 0; direction_j < 2; direction_j++) {
                if(direction_j == 0) {
                    xTreasure = xTreasure - direction[direction_i][direction_j];
                } else {
                    yTreasure = yTreasure - direction[direction_i][direction_j];
                }
            }
        }

        System.out.println(xTreasure + " " + yTreasure);
        // your code goes here
    }
}
