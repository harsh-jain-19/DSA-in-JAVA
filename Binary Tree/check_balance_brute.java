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
public class check_balance_brute
{
    public static int find_max_height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int lh = find_max_height(root.left);
        int rh = find_max_height(root.right);

        return 1 + Math.max(lh,rh);
    }
    public static boolean find_balance(Node root)
    {
        if(root == null)
        {
            return true;
        }
        int lh = find_max_height(root.left);
        int rh = find_max_height(root.right);

        if(Math.abs(rh - lh) > 1)
        {
            return false;
        }

        boolean left = find_balance(root.left);
        boolean right = find_balance(root.right);

        if(! left || ! right)
        {
            return false;
        }

        return true;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        
        boolean balanced = find_balance(root);
        if(balanced)
        {
            System.out.println("Your Binary Tree Is Balanced.");
        }
        else
        {
            System.out.println("Your Binary Tree Is Not Balanced.");
        }
    }
}