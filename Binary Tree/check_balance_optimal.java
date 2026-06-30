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
public class check_balance_optimal
{
    public static int find_max_height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int lh = find_max_height(root.left);
        if(lh == -1)
        {
            return -1;
        }
        int rh = find_max_height(root.right);
        if(rh == -1)
        {
            return -1;
        }

        if(Math.abs(rh - lh) > 1)
        {
            return -1;
        }

        return 1 + Math.max(lh,rh);
    }
    public static boolean find_balance(Node root)
    {
        return find_max_height(root) != -1;
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