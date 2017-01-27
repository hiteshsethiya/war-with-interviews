import java.io.*;
import java.util.*;

public class Solution {

    static Tri isTri(Long[] arr, int i) {
        Long a = arr[i];
        Long b = arr[i+1];
        Long c = arr[i+2];
        Tri t = null;
         if(Math.addExact(a, b) > c && Math.addExact(b, c) > a && Math.addExact(c, a) > b) {
             t = new Tri();
             t.peri = Math.addExact(Math.addExact(a,b),c);
             t.longSide = Math.max(Math.max(a, b), c);
             t.shortSide = Math.min(Math.min(a, b), c);
             t.startIndex = i;
         }
        return t;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. PrLong output to STDOUT. Your class should be named Solution. */
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        Long[] inp = new Long[n];
        for(int i = 0; i < n; ++i) {
            inp[i] = scan.nextLong();
        }

        if(inp.length < 3) {
            System.out.println("-1");
            return;
        }

        //Arrays.sort(inp);
        Tri maxTri = null;
        Map<Long,Tri> map = new HashMap<Long, Tri>();
        for(int i = 0; (i + 2) < inp.length; ++i) {
            Tri t = isTri(inp,i);
            if(t != null) {
                if(maxTri == null) maxTri = t;
                else {
                    if(t.peri > maxTri.peri) {
                        maxTri = t;
                    } else if(t.peri == maxTri.peri) {
                        if(t.longSide > maxTri.longSide) {
                            maxTri = t;
                        } else if(t.longSide == maxTri.longSide) {
                            if(t.shortSide > maxTri.shortSide) {
                                maxTri = t;
                            }
                        }
                    }
                }
            }
        }

        if(maxTri == null) {
            System.out.println("-1");
        } else {
            for(int i = maxTri.startIndex; i < (maxTri.startIndex + 3); ++i) {
                System.out.print(inp[i] + " ");
            }
        }
    }

    public static class Tri {
        Long peri;
        Long longSide;
        Long shortSide;
        int startIndex;
    }
}