package dynamicprogramming;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 18/02/17.
 * Find the distance between strings a and b.
 */
public class EditDistance {

    enum Operation {
        CPY(0),
        SUB(1),
        INS(1),
        DEL(1);
        int cost;

        Operation(int cost) {
            this.cost = cost;
        }
    }

    static class CostOp {
        int cost;
        Operation operation;

        public CostOp(int cost, Operation operation) {
            this.cost = cost;
            this.operation = operation;
        }

        public static CostOp min(CostOp one, CostOp other) {
            if(one.cost < other.cost) {
                return one;
            }
            return other;
        }
    }

    public static void printMat(CostOp[][] a) {
        for(int i = 0; i < a.length; ++i) {
            for(int j = 0; j < a[i].length; ++j) {
                System.out.print(a[i][j].cost + " - " + a[i][j].operation + " | ");
            }
            System.out.println();
        }
    }

    public static char charAt(String a, int index) {
        if(index <= 0) return '0';
        return a.charAt(index - 1);
    }

    public static int costOf(CostOp a[][],int i, int j) {
        return a[i][j].cost;
    }

    public static ArrayList<CostOp> constructOps(CostOp arr[][]) {
        ArrayList<CostOp> costOps = new ArrayList<CostOp>();
        for(int j = arr[0].length - 1, i = arr.length - 1; j > 0 && i > 0;) {
            CostOp op = arr[i][j];
            costOps.add(op);
            if(op.operation.equals(Operation.CPY) || op.operation.equals(Operation.SUB)) {
                --i;
                --j;
            } else if(op.operation.equals(Operation.INS)) {
                --j;
            } else if(op.operation.equals(Operation.DEL)) {
                --i;
            }
        }
        return costOps;
    }

    public static CostOp[][] editDistance(final String a, final String b) {
        final int n = a.length();
        final int m = b.length();

        CostOp arr[][] = new CostOp[n + 1][m + 1];
        for(int i = 0; i <= n ; ++i) {
            for(int j = 0; j <= m; ++j) {

                //Base cases
                if(i == 0) {
                    arr[i][j] = new CostOp(j,Operation.INS); //Create String b from an empty string will have j insertions at the jth character
                } else if(j == 0) {
                    arr[i][j] = new CostOp(i,Operation.DEL); //Create an Empty String from string a will have i deletions at the ith character
                } else if(charAt(a,i) == charAt(b,j)) {
                    arr[i][j]  = new CostOp(costOf(arr,i-1,j-1) + Operation.CPY.cost,Operation.CPY); //Create the instance only if required.
                } else {
                    //Last possibilities
                    // new objects to find minimum and add it at arr[i][j]
                    CostOp delete = new CostOp(costOf(arr,i - 1,j) + Operation.DEL.cost,Operation.DEL), //Go up
                            insert =  new CostOp(costOf(arr,i,j - 1) + Operation.INS.cost,Operation.INS), //Go left
                            substitute = new CostOp(costOf(arr,i-1,j-1) + Operation.SUB.cost,Operation.SUB); //go diagonal
                    arr[i][j] = CostOp.min(substitute,CostOp.min(delete,insert)); //Minimum of all should be the cost until i,jth sequence
                }
            }
        }
        return arr;
    }

    public static ArrayList<CostOp> editOperations(final String a, final String b) {
        CostOp arr[][] = editDistance(a,b);
        printMat(arr);
        return constructOps(arr);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String a = in.nextLine();
        final String b = in.nextLine();

        ArrayList<CostOp> costOps = editOperations(a,b);
        for(int i = costOps.size() - 1; i >= 0; --i) {
            System.out.println(costOps.get(i).operation);
        }
    }
}
