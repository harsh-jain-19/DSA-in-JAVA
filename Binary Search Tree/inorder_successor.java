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
public class inorder_successor
{
    public static Node find_inorder_successor(Node root, Node p)
    {
        Node successor = null;
        while(root != null)
        {
            if(p.val >= root.val)
            {
                root = root.right;
            }
            else
            {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);
        
        Node ans = find_inorder_successor(root, root.left);
        System.out.println("Inorder Successor is "+ans.val);
    }
}