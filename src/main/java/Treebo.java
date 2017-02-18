import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 11/02/17.
 */
public class Treebo {

    static HashMap<Integer,Integer> sumMap = new HashMap<Integer, Integer>();
    static Integer maxKey = 0;
    static boolean check(Integer n) {
        Integer sum = 0;
        if(sumMap.containsKey(n)) {
            sum = sumMap.get(n);
        } else {
            sum = sumMap.get(maxKey);
            for(int i = maxKey + 1; i <= n; ++i) {
                sum += i;
                if(!sumMap.containsKey(i)) {
                    sumMap.put(i,sum);
                    maxKey = i;
                }
            }
        }

        if(sum % 2 == 0) {
            Integer halfS = sum / 2;
            Integer modifications = ((Double)Math.floor(n / 2)).intValue();


            for(int j = n; halfS > 0 && halfS >= j ; --j) {
                halfS -= j;
                modifications--;
            }
            for(int i = 1; halfS > 0 && halfS >= i; ++i) {
                halfS -= i;
                modifications--;
            }
            if(modifications >= 0 && halfS == 0) {
                return true;
            } else if(modifications <= 0 && halfS < 0) {
                return false;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        sumMap.put(0,0);
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T-- != 0) {
            int N = s.nextInt();
            if(check(N)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
