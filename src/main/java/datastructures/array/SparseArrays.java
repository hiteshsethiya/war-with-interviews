package datastructures.array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by racit-2105 on 07/02/17.
 */
public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        HashMap<String,Integer> counter = new HashMap<String, Integer>();
        for(int i = 0; i < n; ++i) {
            String str = in.nextLine();
            if(!counter.containsKey(str)) {
                counter.put(str,1);
            } else {
                counter.put(str,counter.get(str)+1);
            }
        }
        int q = in.nextInt();
        in.nextLine();
        for(int i = 0; i < q; ++i) {
            String str = in.nextLine();
            if(!counter.containsKey(str)) {
                System.out.println(0);
            } else {
                System.out.println(counter.get(str));
            }
        }

    }
}
