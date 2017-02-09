import java.util.Queue;

/**
 * Created by racit-2105 on 09/02/17.
 * Question 2: Given a binary tree and two numbers (which represent two nodes in a tree) as input and are at the same level, write a program to find out distance between those two nodes. Distance between two nodes at a same level in a binary tree is defined as the number of nodes that would have existed between the two given nodes, had it been a complete binary tree.

 For example, in the following binary tree, distance between 1 and 9 would be 2. That is because if the following tree would have been a complete binary tree, it would have a right node at 3 and left node at 2, both of which would be existing between 1 and 9.


 4
 /     \
 3      2
 /         \
 1          9

 */
public class HanselIO {

    //Assumptions: Node will compose Integer as data
/*

    static class Node {
        Node left;
        Node right;
        Integer data;
    }

    Integer distanceBetweenNodes(Node root, Node a, Node b) {
        Integer distance = 0;
        Queue q = new Queue();
        q.enqueue(root);
//Node dummy = new Node(); //For roots with single leaves
//Dummy.left = null;
//Dummy.right = null;
        while(!q.isEmpty()) {
            Node temp = q.dequeue();
            if(temp != null && temp.data == a.data) {
                Node match = q.dequeue();
                distance = 1;
                while(!q.isEmpty() && (match == null || match.data != b.data)) {
                    distance++;
                    match = q.dequeue();
                } // inner while loop ends here
                if(match.data == b.data) {
                    return distance;
                } else {
                    return 0;
                }
            } //Temp condition ends here

            if(temp != null && temp.left != null) {
                q.enqueue(temp.left);
            }

            if(temp != null && temp.right != null) {
                q.enqueue(temp.right);
            }

//Now comes the scenario of single leaves or double leaves


            if(temp != null && temp.left != null && temp.right == null) {
                q.enqueue(null);
            }

            if(temp != null && temp.right != null && temp.left == null) {
                q.enqueue(null);
            }


            if(temp == null) {
                q.enqueue(null);
                q.enqueue(null);
            }


        }//while loop ends here
        return distance;
    } //function ends here*/
}
