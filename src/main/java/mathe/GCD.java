package mathe;

/**
 * Created by racit-2105 on 09/02/17.
 */
public class GCD {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
}
