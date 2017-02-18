package datastructures.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 06/02/17.
 */
public class DynamicArray {

//    public static class Data {
//        List<Integer> a;
//        int size;
//
//        public Data(int n) {
//            a = new LinkedList<Integer>();
//            size = 0;
//        }
//
//        public void add(int v) {
//            a[size] = v;
//            size++;
//        }
//    }

    public static int getIndex(int x, int lastAns,Integer size) {
        return ((x ^ lastAns) % size);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();

        LinkedList<Integer>[] sequenceList = new LinkedList[n];
        int lastAns = 0;
        while(q-- != 0) {
            int queryType = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            in.nextLine();
            if(queryType == 1) {
                Integer index = getIndex(x, lastAns, n);
                if(sequenceList[index] == null) sequenceList[index] = new LinkedList<Integer>();
                sequenceList[index].add(y);
            } else if(queryType == 2) {
                int index = getIndex(x, lastAns, n);
                Integer ind = (y % sequenceList[index].size());
                lastAns = sequenceList[index].get(ind);
                System.out.println(lastAns);
            }
        }
    }
}
