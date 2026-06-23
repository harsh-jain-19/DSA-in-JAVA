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
public class postOrder_traversal_using_2stacks
{
    public static List<Integer> find_postOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();

        if(root == null)
        {
            return result;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        
        while(! st1.isEmpty())
        {
            root = st1.pop();
            st2.add(root);
            if(root.left != null)
            {
                st1.push(root.left);
            }
            if(root.right != null)
            {
                st1.push(root.right);
            }
        }
        while(! st2.isEmpty())
        {
            result.add(st2.pop().val);
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
        List<Integer> postOrder = new ArrayList<>();
        postOrder = find_postOrder(root);
        System.out.println("Post Order Traversal = "+postOrder);
    }
}