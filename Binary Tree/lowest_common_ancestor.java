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

public class lowest_common_ancestor
{
    public static Node find_lca(Node root,Node p, Node q)
    {
        if(root == null || root == p || root == q)
        {
            return root;
        }
        Node left = find_lca(root.left, p, q);
        Node right = find_lca(root.right, p, q);

        if(left == null)
        {
            return right;
        }
        else if(right == null)
        {
            return left;
        }
        else
        {
            return root;
        }
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        Node lca = find_lca(root, root.left.left, root.left.right);
        System.out.println("Lowest Common Ancestor = "+lca.val);
    }   
}