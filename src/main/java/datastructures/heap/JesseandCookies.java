package datastructures.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by racit-2105 on 09/02/17.
 */
public class JesseandCookies {
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

    public static Integer peak(ArrayList<Integer> heap) {
        if(!heap.isEmpty()) {
            return heap.get(0);
        }
        return Integer.MIN_VALUE;
    }

    public static Integer min(ArrayList<Integer> heap) {
        if(!heap.isEmpty()) {
            int v =  heap.get(0);
            heap.remove(0);
            return v;
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

    static int sweetness(int v1,int v2) {
        return v1 + 2 * v2;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        ArrayList<Integer> heap = new ArrayList<Integer>(n);
        for(int i = 0; i < n; ++i) {
            int v = in.nextInt();
            insert(heap,v);
        }
        int count = 0;
        for(int i = 0; i < n && peak(heap) < k; ++i) {
            int v1 = min(heap);
            int v2 = min(heap);
            int sweet = sweetness(v1,v2);
            insert(heap,sweet);
            count++;
        }

        if(min(heap) >= k) {
            System.out.println(count);
        } else {
            System.out.println("-1");
        }
    }

}
