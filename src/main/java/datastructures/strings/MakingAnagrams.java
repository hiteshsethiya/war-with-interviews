package datastructures.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 14/02/17.
 */
public class MakingAnagrams {

    /**
     * Method using hashmap, will run for any character
     * @param first
     * @param second
     * @return
     */
    public static int numberNeeded(String first, String second) {
        int ops = 0;
        HashMap<Character,Integer> firstMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> secondMap = new HashMap<Character,Integer>();
        for(int i = 0; i < first.length(); ++i) {
            if(firstMap.containsKey(first.charAt(i))) {
                firstMap.put(first.charAt(i),firstMap.get(first.charAt(i)) + 1);
            } else {
                firstMap.put(first.charAt(i),1);
            }
        }

        for(int i = 0; i < second.length(); ++i) {
            if(secondMap.containsKey(second.charAt(i))) {
                secondMap.put(second.charAt(i),secondMap.get(second.charAt(i)) + 1);
            } else {
                secondMap.put(second.charAt(i),1);
            }
        }

        Iterator<Map.Entry<Character,Integer>> iter = firstMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character,Integer> entry = iter.next();
            if(secondMap.containsKey(entry.getKey())) {
                if(!secondMap.get(entry.getKey()).equals(entry.getValue())) {
                    ops += Math.abs(secondMap.get(entry.getKey()) - entry.getValue());
                }
                secondMap.remove(entry.getKey());
            } else {
                ops += entry.getValue();
            }
            iter.remove();
        }

        for(HashMap.Entry<Character,Integer> entry : secondMap.entrySet()) {
            ops += entry.getValue();
        }

        return ops;
    }

    public static int numberNeededAr(String a,String b) {
        int[] af = new int[26];
        int ops = 0;
        for(int i = 0; i < a.length(); ++i) af[a.charAt(i) - 'a']++;
        for(int i = 0; i < b.length(); ++i) af[b.charAt(i) - 'a']--;
        for (int anAf : af) ops += Math.abs(anAf);
        return ops;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeededAr(a, b));
    }
}
