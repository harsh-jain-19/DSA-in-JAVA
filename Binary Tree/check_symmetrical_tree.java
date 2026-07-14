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

public class check_symmetrical_tree
{
    public static boolean isSymmetrical(Node left, Node right)
    {
        if(left == null || right == null)
        {
            return left == right;
        }
        if(left.val != right.val)
        {
            return false;
        }
        return isSymmetrical(left.left, right.right) &&
               isSymmetrical(left.right, right.left);
    }
    public static boolean check_symmetric(Node root)
    {
        return root == null || isSymmetrical(root.left, root.right);
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        root.right.left = new Node(5);      
        root.right.right = new Node(4);
        boolean sym = check_symmetric(root);
        if(sym)
        {
            System.out.println("Your Binary Tree Is Symmetrical");
        }
        else
        {
            System.out.println("Your Binary Tree Is Not Symmetrical");
        }
    }
}