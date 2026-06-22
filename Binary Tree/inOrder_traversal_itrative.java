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
public class inOrder_traversal_itrative
{
    public static List<Integer> find_inOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();

        Stack<Node> st = new Stack<>();
        Node node = root;
        
        while(true)
        {
            if(node != null)
            {
                st.push(node);
                node = node.left;
            }
            else
            {
                if(st.isEmpty())
                {
                    break;
                }
                node = st.pop();
                result.add(node.val);
                node = node.right;
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