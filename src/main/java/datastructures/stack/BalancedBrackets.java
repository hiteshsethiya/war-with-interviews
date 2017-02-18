package datastructures.stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Hitesh Sethiya on 13/02/17.
 */
public class BalancedBrackets {

    static HashMap<Character,Character> brackets;

    static boolean isItBalanced(String input) {

        if(input.isEmpty()) {
            return false;
        }

        Stack<Character> elements = new Stack<Character>();
        for(int i = 0; i < input.length(); ++i) {
            if(!brackets.containsKey(input.charAt(i))) {
                elements.push(input.charAt(i));
            } else {
                if(elements.isEmpty() || brackets.get(input.charAt(i)) != elements.pop()) {
                    return false;
                }
            }
        }
        return elements.isEmpty();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        brackets = new HashMap<Character, Character>();
        brackets.put('}','{');
        brackets.put(']','[');
        brackets.put(')','(');
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int to = n;
        while(n-- != 0) {
            String input = s.nextLine();
            if(isItBalanced(input)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
