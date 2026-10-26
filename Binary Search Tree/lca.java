// LCA : LOWEST COMMOM ANCHESTOR
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
public class lca
{
    public static Node find_lca(Node root, Node p, Node q)
    {
        if(root == null)
        {
            return null;
        }
        int curr = root.val;
        if(curr < p.val && curr < q.val)
        {
            return find_lca(root.right,p,q);
        }
        if(curr > p.val && curr > q.val)
        {
            return find_lca(root.left,p,q);
        }
        return root;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);
        
        Node ans = find_lca(root, root.left.left, root.left.right);
        
        if(ans == null)
        {
            System.out.println("NULL");
        }
        else
        {
            System.out.println("Lca is "+ans.val);
        }
    }
}