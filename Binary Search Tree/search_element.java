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
public class search_element
{
    public static Node search(Node root, int val)
    {
        while(root != null && root.val != val)
        {
            if(val < root.val)
            {
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }
        return root;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(9);
        root.left.left = new Node(1);      
        root.left.right = new Node(4);

        System.out.println("Enter the value you want to search in BST.");
        int val = sc.nextInt();
        
        Node temp = search(root, val);
        if(temp == null)
        {
            System.out.println(val+" does not exist in given BST.");
        }
        else
        {
            System.out.println(temp.val+" exist in given BST.");
        }
    }
}