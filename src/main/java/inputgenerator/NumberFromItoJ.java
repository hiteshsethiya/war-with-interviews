package inputgenerator;

import java.util.Scanner;

/**
 * Created by racit-2105 on 19/02/17.
 */
public class NumberFromItoJ {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        final int n = in.nextInt();

        for(; i <= n ; ++i) {
            System.out.print(i + " ");
        }

    }
}
