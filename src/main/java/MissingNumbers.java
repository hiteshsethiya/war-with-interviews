import java.util.*;

/**
 * Created by racit-2105 on 22/01/17.
 */
public class MissingNumbers {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        HashMap<Integer,Integer> aF = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
            if(aF.containsKey(a[i])) {
                aF.put(a[i],aF.get(a[i]) + 1);
            } else {
                aF.put(a[i],1);
            }
        }

        int m = in.nextInt();
        int[] b = new int[m];
        HashMap<Integer,Integer> bF = new HashMap<Integer, Integer>();
        for(int i = 0; i < m; i++){
            b[i] = in.nextInt();
            if(bF.containsKey(b[i])) {
                bF.put(b[i],bF.get(b[i]) + 1);
            } else {
                bF.put(b[i],1);
            }
        }

        ArrayList<Integer> op = new ArrayList<Integer>();
        for(HashMap.Entry<Integer,Integer> bFreq : bF.entrySet()) {
            if(aF.containsKey(bFreq.getKey())) {
                if(aF.get(bFreq.getKey()) -  bFreq.getValue() != 0) {
                    op.add(bFreq.getKey());
                }
            } else {
                op.add(bFreq.getKey());
            }
        }

        Arrays.sort(op.toArray()); //Need to do this for java 7 and not for 8. As java 8 keeps the elements in the order inserted in the map.
        //The op array is mutable in java 8, changed by the fn itself without creating new object but creates a new object in java 7
        for(int i = 0; i < op.size(); i++){
            System.out.print(op + " ");
        }


    }
}
