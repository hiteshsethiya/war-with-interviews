import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 09/01/17.
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited?h_r=next-challenge&h_v=zen
 */
public class JumpingontheCloudsRevisited {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        int E = 100;
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        if(k == 0) {
            System.out.println(E);
        } else {

            int i = k;
            if(c[k] == 1)
                E -= 3;
            else
                E -= 2;

            for( i += k ; i != 0 || E == 0; i = (i + k) % n) {
                if(c[i] == 1) {
                    E -= 3;
                } else {
                    E -= 2;
                }
            }
            System.out.println(E);
        }
    }
}
