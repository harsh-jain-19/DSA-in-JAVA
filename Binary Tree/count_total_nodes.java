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
public class count_total_nodes
{
    
    public static int find_total_nodes(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = getHeightLeft(root);
        int right = getHeightRight(root);

        if(left == right)
        {
            return ((2<<(left)) - 1);
        }
        else
        {
            return find_total_nodes(root.left) + find_total_nodes(root.right) + 1;
        }
    }
    public static int getHeightLeft(Node root)
    {
        int count = 0;
        while(root.left != null)
        {
            count++;
            root = root.left;
        }
        return count;
    }
    public static int getHeightRight(Node root)
    {
        int count = 0;
        while(root.right != null)
        {
            count++;
            root = root.right;
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);

        int count = find_total_nodes(root);
        System.out.println("Total number of nodes in given binary tree = "+count);
    }   
}