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
public class morris_inorder_traversal
{
    public static List<Integer> find_inOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();
        Node curr = root;

        while(curr != null)
        {
            if(curr.left == null)
            {
                result.add(curr.val);
                curr = curr.right;
            }
            else
            {
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return result;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);        
        root.left.right = new Node(5);

        List<Integer> inOrder = new ArrayList<>();
        inOrder = find_inOrder(root);
        System.out.println("In Order Traversal = "+inOrder);
    }
}