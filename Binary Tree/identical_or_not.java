// In this problem you will be given an two binary trees.
// You have to find whether they are identical or not.

import java.util.*;
class Node
{
    int val;
    Node left;
    Node right;
    Node(int key)
    {
        this.val = key;
    }
}
public class identical_or_not
{
    public static boolean find_identical(Node root1, Node root2)
    {
        if(root1 == root2)
        {
            return (root1 == root2);
        }

        return (root1.val == root2.val) && find_identical(root1.left,root2.left) && find_identical(root1.right,root2.right);
    }
    public static void main(String args[])
    {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);      
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);      
        root2.left.right = new Node(5);
        
        boolean identical = find_identical(root1,root2);
        
        if(identical)
        {
            System.out.println("Yes both trees are identical.");
        }
        else
        {
            System.out.println("No both trees are not identical.");
        }
    }
}