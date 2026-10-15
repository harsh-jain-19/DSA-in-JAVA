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
public class ceil
{
    public static int find_ceil(Node root, int key)
    {
        int ceil = -1;
        while(root != null)
        {
            if(root.val == key)
            {
                ceil = root.val;
                return ceil;
            }
            if(key > root.val)
            {
                root = root.right;
            }
            else
            {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);

        System.out.println("Enter the value of key.");
        int key = sc.nextInt();
        
        int ans = find_ceil(root, key);
        System.out.println("Ceil of "+key+" is "+ans);
    }
}