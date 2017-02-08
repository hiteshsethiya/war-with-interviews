package datastructures.heap;

import java.util.ArrayList;
import java.util.Scanner;

public class QHEAP1 {

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static int left(int i) {
        return (2 * i) + 1;
    }

    public static int right(int i) {
        return (2 * i) + 2;
    }

    static int find(ArrayList<Integer> heap, int v) {
        for(int i = 0; i < heap.size(); ++i) {
            if(heap.get(i) == v) {
                return i;
            }
        }
        return -1;
    }

    public static Integer min(ArrayList<Integer> heap) {
        if(!heap.isEmpty()) {
            return heap.get(0);
        }
        return Integer.MIN_VALUE;
    }

    static void swap(ArrayList<Integer> heap,int min, int p) {
        int tmp = heap.get(min);
        heap.set(min, heap.get(p));
        heap.set(p, tmp);
    }

    public static void insert(ArrayList<Integer> heap, int v) {
        heap.add(v);
        int i = heap.size() - 1;
        int p;
        int l,r,min;
        while(i > 0) {
            p = parent(i);
            min = p;
            l = left(p);
            r = right(p);
            if(l < heap.size() && heap.get(l) < heap.get(min)) {
                min = l;
            }

            if(r < heap.size() && heap.get(r) < heap.get(min)) {
                min = r;
            }

            if(min != p) {
                swap(heap,min,p);
            } else {
                break;
            }
            i = p;
        }
    }

    static void delete(ArrayList<Integer> heap, int v) {
        if(heap.isEmpty()) return;
        int i = find(heap,v),l,r,min;
        if(i > -1) {
            swap(heap,i,heap.size() -1);
            heap.remove(heap.size() - 1);
            while( i < heap.size()) {
                l = left(i);
                r = right(i);
                min = i;

                if(l < heap.size() && heap.get(l) < heap.get(min)) {
                    min = l;
                }
                if(r < heap.size() && heap.get(r) < heap.get(min)) {
                    min = r;
                }
                if(min != i) {
                    swap(heap,min,i);
                } else {
                    break;
                }
                i = min;
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        //in.nextLine();
        ArrayList<Integer> heap = new ArrayList<Integer>(q);
        while(q-- != 0) {
            int qt = in.nextInt();
            //in.nextLine();
            switch(qt) {
                case 1: {
                    int v = in.nextInt();
                    //insert
                    insert(heap,v);
                    break;
                }
                case 2: {
                    int v = in.nextInt();
                    //delete
                    delete(heap,v);
                    break;
                }
                case 3: {
                    //min heap
                    System.out.println(min(heap));
                    break;
                }
            }
        }
    }
}