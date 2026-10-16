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
public class maximum
{
    public static int find_maximum(Node root)
    {
        int ceil = -1;
        while(root.right != null)
        {
            root = root.right;
        }
        return root.val;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);
        
        int ans = find_maximum(root);
        System.out.println("Maximum of the Binary Search Tree is "+ans);
    }
}  