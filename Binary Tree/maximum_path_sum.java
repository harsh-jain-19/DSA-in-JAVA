// In this problem you will be given an binary tree.
// You have to find its diameter.

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
public class maximum_path_sum
{
    public static int find_max_height(Node root, int [] max_value)
    {
        if(root == null)
        {
            return 0;
        }
        int left = Math.max(0,find_max_height(root.left,max_value));
        int right = Math.max(0,find_max_height(root.right,max_value));
        max_value[0] = Math.max(max_value[0], (left + right + root.val));
        return root.val + Math.max(left,right);
    }
    public static int find_max_path(Node root)
    {
        int [] max_value = new int[1];
        max_value[0] = Integer.MIN_VALUE;
        find_max_height(root,max_value);
        return max_value[0];
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        
        int max_path = find_max_path(root);
        System.out.println("Maximum path of the given binary tree is "+max_path);
    }
}