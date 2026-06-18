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
public class preOrder_traversal_itrative
{
    public static List<Integer> find_preOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
        {
            return result;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);
        while(! st.isEmpty())
        {
            root = st.pop();
            result.add(root.val);
            if(root.right != null)
            {
                st.push(root.right);
            }
            if(root.left != null)
            {
                st.push(root.left);
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
        List<Integer> preOrder = new ArrayList<>();
        preOrder = find_preOrder(root);
        System.out.println("Pre Order Traversal = "+preOrder);
    }
}