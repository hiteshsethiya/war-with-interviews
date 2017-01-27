import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RotateArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        int[] te = new int[k];

        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.arraycopy(a, 0, te, 0, k);

        for(int a_i = 0, a_j = k; a_j < a.length; ++a_i, ++a_j) a[a_i] = a[a_j];

        for(int a_i = a.length - k, te_i = 0; te_i < te.length; ++te_i, ++a_i) a[a_i] = te[te_i];


        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            System.out.println(a[m]);

        }
    }
}
