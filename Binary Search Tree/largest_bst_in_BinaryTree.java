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
class NodeValue
{
    public int maxNode, minNode, maxSize;
    NodeValue(int minNode, int maxNode, int maxSize)
    {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
public class largest_bst_in_BinaryTree
{
    public static NodeValue find_largest_bst_helper(Node root)
    {
        if(root == null)
        {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = find_largest_bst_helper(root.left);
        NodeValue right = find_largest_bst_helper(root.right);
        if(left.maxNode < root.val && root.val < right.minNode)
        {
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode), left.maxSize + right.maxSize + 1);
        }
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
    
    public static int find_largest_bst(Node root)
    {
        return find_largest_bst_helper(root).maxSize;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(15);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);
        
        int ans = find_largest_bst(root);
        System.out.println("Largest BST = "+ans);
    }
}