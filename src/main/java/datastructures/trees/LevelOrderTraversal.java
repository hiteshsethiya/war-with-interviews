package datastructures.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Hitesh Sethiya on 10/02/17.
 */
public class LevelOrderTraversal {

    static class Node {
        Node left;
        Node right;
        Integer data;
    }

    public void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node t;
        while(!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.data + " ");
            if(t.left != null) q.add(t.left);
            if(t.right != null) q.add(t.right);
        }
    }


    /**
     * Checks if a binary tree is a binary search tree.
     * @param root
     * @return
     */
    public boolean checkBst(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node t;
        while(!q.isEmpty()) {
            t = q.remove();
            if(t.left != null) {
                if(t.left.data >= t.data) return false;
                q.add(t.left);
            }
            if(t.right != null) {
                if(t.right.data <= t.data) return false;
                q.add(t.right);
            }
        }
        return true;
    }

    /**
     * Checks if a binary tree is a binary search tree.
     * Considering duplicate values also a taboo.
     * @param root
     * @return
     */
    public boolean checkBstDup(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Set<Integer> dupes = new HashSet<Integer>();
        q.add(root);
        Node t;
        while(!q.isEmpty()) {
            t = q.remove();
            if(dupes.contains(t.data)) {
                return false;
            }
            dupes.add(t.data);
            if(t.left != null) {
                if(t.left.data >= t.data) return false;
                q.add(t.left);
            }
            if(t.right != null) {
                if(t.right.data <= t.data) return false;
                q.add(t.right);
            }
        }
        return true;
    }

}
