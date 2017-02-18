import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 22/12/16.
 */
public class MaxMinSum {

    static Long min = Long.MAX_VALUE;
    static Long max = 0L;
    static void minMax(Long a) {
        if(min > a) min = a;
        if(max < a) max = a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long a = in.nextLong();
        Long b = in.nextLong();
        Long c = in.nextLong();
        Long d = in.nextLong();
        Long e = in.nextLong();


        Long total = a + b + c + d + e;
        minMax(a);
        minMax(b);
        minMax(c);
        minMax(d);
        minMax(e);

        System.out.print(total - max + " ");
        System.out.print(total - min);

    }
}
