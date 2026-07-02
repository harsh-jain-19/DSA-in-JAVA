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
public class diameter
{
    public static int find_max_height(Node root, int [] diameter)
    {
        if(root == null)
        {
            return 0;
        }
        int lh = find_max_height(root.left,diameter);
        int rh = find_max_height(root.right,diameter);
        diameter[0] = Math.max(diameter[0], lh+rh);
        return 1 + Math.max(lh,rh);
    }
    public static int find_diameter(Node root)
    {
        int [] diameter = new int[1];
        find_max_height(root,diameter);
        return diameter[0];
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        
        int dia = find_diameter(root);
        System.out.println("Diameter of the given binary tree is "+dia);
    }
}