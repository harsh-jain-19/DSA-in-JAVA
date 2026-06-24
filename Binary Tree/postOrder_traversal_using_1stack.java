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
public class postOrder_traversal_using_1stack
{
    public static List<Integer> find_postOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();

        Node curr = root;
        Stack<Node> st = new Stack<>();

        while( curr != null || ! st.isEmpty())
        {
            if(curr != null)
            {
                st.push(curr);
                curr = curr.left;
            }
            else
            {
                Node temp = st.peek().right;
                if(temp == null)
                {
                    temp = st.peek();
                    st.pop();
                    result.add(temp.val);
                    while(! st.isEmpty() && temp == st.peek().right)
                    {
                        temp = st.peek();
                        st.pop();
                        result.add(temp.val);
                    }
                }
                else
                {
                    curr = temp;
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
        List<Integer> postOrder = new ArrayList<>();
        postOrder = find_postOrder(root);
        System.out.println("Post Order Traversal = "+postOrder);
    }
}