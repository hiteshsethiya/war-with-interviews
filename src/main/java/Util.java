/**
 * Created by Hitesh Sethiya on 27/12/16.
 */
public class Util {

    public static Boolean contains(int[] array ,int value) {
        if(array == null || array.length ==0) return Boolean.FALSE;
        for (int anArray : array) {
            if (anArray == value) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private static String getAppnameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1,url.length());
    }

    private static int getGCD(int a, int b) {
        int remainder,divisor,dividend;
        dividend = Math.max(a,b);
        divisor = Math.min(a,b);
        do {
            remainder = dividend % divisor;
            dividend = divisor;
            if(remainder != 0) divisor = remainder;
        } while(remainder != 0);
        return divisor;
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

    public static void main(String args[]) {
            System.out.println(contains(new int[]{502,503,504,598,599},503));
        System.out.println(getAppnameFromUrl("https://s3.ap-south-1.amazonaws.com/partners-apk/app-release-2.0.0.apk"));
        getGCD(7, 13);
        System.out.println(gcd(13,45));
    }
}
