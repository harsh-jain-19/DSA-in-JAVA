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
public class preOrder_traversal
{
    public static List<Integer> find_preOrder(Node root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return new ArrayList<>();
        }
        result.add(root.data);
        result.addAll(find_preOrder(root.left));
        result.addAll(find_preOrder(root.right));
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