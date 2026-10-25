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
public class bst_or_not
{
    public static boolean isBST(Node root, long minVal, long maxVal)
    {
        if(root == null)
        {
            return true;
        }
        if(root.val >= maxVal || root.val <= minVal)
        {
            return false;
        }
        return (isBST(root.left, minVal, root.val) && isBST(root.right, root.val, maxVal));
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        
        boolean ans = isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        if(ans)
        {
            System.out.println("Given Binary Tree Is A Binary Search Tree.");
        }
        else
        {
            System.out.println("Given Binary Tree Is Not A Binary Search Tree.");
        }
    }
}  