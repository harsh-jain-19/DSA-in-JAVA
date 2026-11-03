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
public class recover
{
    private static Node first;
    private static Node prev;
    private static Node middle;
    private static Node last;
    private static void inOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inOrder(root.left);
        if(prev != null && (root.val < prev.val))
        {
            if(first == null)
            {
                first = prev;
                middle = root;
            }
            else
            {
                last = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
    public static void recover_bst(Node root)
    {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inOrder(root);
        if(first != null && last != null)
        {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first != null && middle != null)
        {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);
        
        recover_bst(root);
        System.out.println("Root of correct BST = "+root.val);
    }
}