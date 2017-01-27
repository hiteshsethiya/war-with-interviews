import java.util.Scanner;

/**
 * Created by racit-2105 on 03/01/17.
 * https://www.hackerrank.com/challenges/bon-appetit?h_r=next-challenge&h_v=zen
 */
public class BonAppétit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] c = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            c[a_i] = in.nextInt();
        }

        int b_charged = in.nextInt();

        int a_share = 0;
        for(int a_i=0; a_i < n; a_i++){
            if(a_i != k) {
                a_share += c[a_i];
            }
        }
        a_share /= 2;
        if(a_share == b_charged) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(Math.abs(a_share - b_charged));
        }
    }
}
