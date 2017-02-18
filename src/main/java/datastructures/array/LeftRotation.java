package datastructures.array;

import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 07/02/17.
 */
public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt() % n;
        int[] a = new int[n];
        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        if(n == 1) {
            System.out.print(a[0]);
            return;
        }
        int[] temp = new int[d];
        System.arraycopy(a,0,temp,0,d);
        System.arraycopy(a,d,a,0,a.length - d);
        System.arraycopy(temp,0,a,a.length - d,temp.length);
        for(int i = 0; i < n; ++i) {
            System.out.print(a[i] + " ");
        }
    }
}
