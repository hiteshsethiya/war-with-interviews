import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 05/01/17.
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies?h_r=next-challenge&h_v=zen
 */
public class BeautifulDaysattheMovies {

    public static Long reverse(Long n) {
        Long reverse = 0L;
        while(n != 0) {
            reverse += n % 10;
            n /= 10;
            if(n != 0) reverse *= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long i = in.nextLong();
        Long j = in.nextLong();
        Long k = in.nextLong();

        Long count = 0L;
        for(Long d = i ; d <= j ; d++) {
            Long rem = Math.abs(reverse(d) - d) % k;
            if(rem == 0) ++count;
        }
        System.out.println(count);
    }
}
