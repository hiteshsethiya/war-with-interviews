package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 18/02/17.
 * https://www.hackerrank.com/contests/cse-830-homework-3/challenges/edit-distance/submissions/code/1300553587
 * This program gives the total number of operations required.
 * For every insertion we move right
 * deletion we move downwards
 * substitution/replace/copy we move diagonally downwards.
 * All these operations are to compute the result.
 */
public class EditDistanceForNoOfOps {
    public static char charAt(String a, int index) {
        if(index <= 0) return '0';
        return a.charAt(index - 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        while(N-- != 0) {
            final String a = in.nextLine();
            final String b = in.nextLine();
             final int n = a.length() + 1; // + 1 to denote empty string
            final int m = b.length() + 1; // + 1 to denote empty string
            int arr[][] = new int[n][m]; //Dp cache

            for(int i = 0; i < arr.length ; ++i) {
                for(int j = 0; j < arr[i].length ; ++j) {
                    if(i == 0) {
                        arr[i][j] = j; //This is one of the base case, where you are trying to build string b from an empty string.
                    } else if(j == 0) {
                        arr[i][j] = i; //This is the second base case, where we creating a empty string from a.
                    } else if(charAt(a,i) == charAt(b,j)) {
                        arr[i][j] = arr[i - 1][j -1]; //When the characters are same, we move diagonally and copying has a cost of 0
                    } else {
                        //Get the minimum cost of insertion,deletion or replace by trying all the combinations.
                        arr[i][j] = 1 + Math.min(arr[i][j-1] //INSERT
                                ,Math.min(arr[i-1][j-1] //REPLACE
                                ,arr[i-1][j])); //DELETE
                    }
                }
            }
            System.out.println(arr[n - 1][m - 1]); //The last cell contains the total number of operations.
        }
    }
}
