package mathe;

/**
 * Created by Hitesh Sethiya on 09/02/17.
 */
public class GCD {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
}
