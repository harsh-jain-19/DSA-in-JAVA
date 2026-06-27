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
public class height
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
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        int max_height = find_max_height(root);
        System.out.println("Maximum Depth = "+max_height);
    }
}