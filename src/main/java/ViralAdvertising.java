import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 05/01/17.
 * https://www.hackerrank.com/challenges/strange-advertising
 */
public class ViralAdvertising {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int liked = 0;
        int people = 5;
        for(int i=1; i <= n; i++) {
            liked += Math.floor(people / 2);
            people = ((int)Math.floor(people / 2)) * 3;
        }
        System.out.println(liked);
    }

}
