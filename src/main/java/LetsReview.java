import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 20/01/17.
 */
public class LetsReview {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        2
//        Hacker
//                Rank
        int T = scan.nextInt();
        scan.nextLine();
        while(T != 0) {
            T--;
            String s = scan.nextLine();
            StringBuilder oddChars = new StringBuilder();
            for(int i = 0; i < s.length(); ++i) {
                if(i % 2 == 0) {
                    System.out.print(s.charAt(i));
                } else {
                    oddChars.append(s.charAt(i));
                }
            }

            System.out.println(" " + oddChars);
        }

    }
}
