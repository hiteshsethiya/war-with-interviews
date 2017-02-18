package datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Hitesh Sethiya on 13/02/17.
 */
public class MaximumElement {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        Stack<Integer> elements = new Stack<Integer>();
        Stack<Integer> maxElement = new Stack<Integer>();
        int t = s.nextInt();
        while (t-- != 0) {
            int command = s.nextInt();
            switch (command) {
                case 1: {
                    int x = s.nextInt();
                    elements.push(x);
                    if(maxElement.isEmpty() || maxElement.peek() <= x) {
                        maxElement.push(x);
                    }
                    break;
                }
                case 2: {
                    int x = elements.pop();
                    if(!maxElement.isEmpty() && maxElement.peek() == x) {
                        maxElement.pop();
                    }
                    break;
                }
                case 3: {
                    System.out.println(maxElement.peek());
                    break;
                }

            }
        }
    }
}
