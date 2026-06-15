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
public class inOrder_traversal
{
    public static List<Integer> find_inOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return new ArrayList<>();
        }
        result.addAll(find_inOrder(root.left));
        result.add(root.data);
        result.addAll(find_inOrder(root.right));
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