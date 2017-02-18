package datastructures.array;

import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 10/02/17.
 * 2nd method using a new array and index shifts
 */
public class LeftRotationCTC {
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int[] out = new int[n];
        for(int i = 0; i < n; ++i) {
            if(i - k < 0) {
                out[n + i - k] = a[i];
            } else {
                out[i - k] = a[i];
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
