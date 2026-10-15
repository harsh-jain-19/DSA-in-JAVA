// Floor is the greatest value that is smaller then or equal to the key.
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
public class floor
{
    public static int find_floor(Node root, int key)
    {
        int floor = -1;
        while(root != null)
        {
            if(root.val == key)
            {
                floor = root.val;
                return floor;
            }
            if(key > root.val)
            {
                floor = root.val;
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }
        return floor;
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
        
        int ans = find_floor(root, key);
        System.out.println("Floor of "+key+" is "+ans);
    }
}