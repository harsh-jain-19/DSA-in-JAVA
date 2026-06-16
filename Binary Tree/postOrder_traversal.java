import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;
    Node(int key)
    {
        this.data = key;
    }
}
public class postOrder_traversal
{
    public static List<Integer> find_postOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return new ArrayList<>();
        }
        result.addAll(find_postOrder(root.left));
        result.addAll(find_postOrder(root.right));
        result.add(root.data);
        
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