package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Hitesh Sethiya on 25/02/17.
 * Constraints
 * 1 <= N <= 1024
 * 1 <= T <= 100
 * 1 <= K <= N
 * Either a = -1 or 2 <= a <= N
 * Either b = -1 or 2 <= b <= N
 * Index of (non-null) child will always be greater than that of parent.
 */
public class SwapNodes {

    static int treeDepth = 1;
    static class Node {
        //* Defines the depth of the entire tree.
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * Level order traversal modification to create the tree.
     * creates a tree with the following input and format.
     * Sample input:
     11
     2 3
     4 -1
     5 -1
     6 -1
     7 8
     -1 9
     -1 -1
     10 11
     -1 -1
     -1 -1
     -1 -1
     creates the following tree for the above input.

                1
              /   \
             /    \
            2     3
           /      /
          /      /
         4      5
        /      / \
       /      /   \
      6      7     8
       \          / \
       \        /   \
       9      10   11
     * @param n is the number of lines as input. in the above example its 11.
     * @param in from where the input has to be read.
     * @return root of the new tree
     */
    static Node createTree(int n, Scanner in) {

        Node root = new Node(1);
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while(n-- != 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            Node t = q.remove();
            if(t == null) {
                treeDepth += 1;
                q.add(null);
                t = q.remove();
            }

            if(a != -1) {
                t.left = new Node(a);
                q.add(t.left);
            }

            if(b != -1) {
                t.right = new Node(b);
                q.add(t.right);
            }
        }
        return root;
    }

    static void inOrder(final Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    static void swapChildren(Node root) {
        Node t = root.left;
        root.left = root.right;
        root.right = t;
    }

    static void swapNodesAlgo(int k, Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        int j = 2,cd = 1, i = k;

        while( i < treeDepth && cd <= treeDepth ) {
            Node t = q.remove();
            if(t == null) {
                ++cd;
                q.add(null);
            } else {
                if(t.left != null) {
                    q.add(t.left);
                }

                if(t.right != null) {
                    q.add(t.right);
                }

                if(cd == i) {
                    while(t != null) {
                        if(t.left != null || t.right != null) {
                            swapChildren(t);;
                        }
                        t = q.remove();
                        if(t != null) {
                            if(t.left != null) q.add(t.left);
                            if(t.right != null) q.add(t.right);
                        }
                    }
                    i = k * j++;
                    q.add(null); ++cd;
                }
            }
        }

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = createTree(n, in);
        int T = in.nextInt();
        while(T-- != 0) {
            int k = in.nextInt();
            swapNodesAlgo(k,root);
            inOrder(root);
            System.out.println();
        }
    }
}
