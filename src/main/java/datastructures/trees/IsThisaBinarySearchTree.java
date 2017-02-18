package datastructures.trees;

/**
 * Created by Hitesh Sethiya on 14/02/17.
 */
public class IsThisaBinarySearchTree {


    boolean check(Node root, int min, int max) {
        return root == null || min < root.data && root.data < max && (check(root.left, min, root.data) && check(root.right, root.data, max));

    }

    boolean checkBST(Node root) {
        return check(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
