// Ceil is the smallest value that is greater then or equal to the key.
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
public class minimum
{
    public static int find_minimum(Node root)
    {
        if(root.left != null)
        {
            return find_minimum(root.left);
        }
        else
        {
            return root.val;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);
        
        int ans = find_minimum(root);
        System.out.println("Minimum of the Binary Search Tree is "+ans);
    }
}  