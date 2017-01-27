package datastructures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by racit-2105 on 18/01/17.
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        Scanner in = new Scanner(System.in);
        while(true) {
            set.add(in.nextInt());
            int i = 1;
        }
    }
}
