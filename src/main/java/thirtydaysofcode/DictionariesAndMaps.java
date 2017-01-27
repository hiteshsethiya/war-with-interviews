package thirtydaysofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by racit-2105 on 20/01/17.
 */
public class DictionariesAndMaps {
    static String conv(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        while(n > 0) {
            stack.push(n % 2);
            n /= 2;
        }
        StringBuilder d = new StringBuilder();
        while(!stack.isEmpty()) {
            d.append(stack.pop()) ;
        }
        return d.toString();
    }

    static int maxOnes(String binary) {
        int count = 0, maxCount = 0;
        for(int i = 0; i < binary.length(); ++i) {
            if(binary.charAt(i) == '1') {
                ++count;
            } else {
                if(maxCount < count) maxCount = count;
                count = 0;
            }
        }
        if(maxCount < count) maxCount = count;
        return maxCount;
    }


    public static void main(String []argh){
        Map<String,String> phoneMap = new HashMap<String, String>();
        System.out.println(conv(439));
        System.out.println(Integer.toBinaryString(439));
        System.out.println(maxOnes(conv(439)));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            phoneMap.put(name,String.valueOf(phone));
            // Write code here
        }

        while(in.hasNext()){
            String s = in.next();
            if(phoneMap.containsKey(s)) {
                System.out.println(s + "="+phoneMap.get(s));
            } else {
                System.out.println("Not found");
            }
            // Write code here
        }
        in.close();
    }
}
