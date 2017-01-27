import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by racit-2105 on 03/01/17.
 * https://www.hackerrank.com/challenges/sock-merchant?h_r=next-challenge&h_v=zen
 */
public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        Set<Integer> sockSet = new HashSet<Integer>();
        int sockPairs = 0;
        for(int c_i=0; c_i < n; c_i++) {
            if (sockSet.contains(c[c_i])) {
                ++sockPairs;
                sockSet.remove(c[c_i]);
            } else {
                sockSet.add(c[c_i]);
            }
        }
        System.out.println(sockPairs);
    }
}
