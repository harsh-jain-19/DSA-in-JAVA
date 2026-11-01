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
public class iterator
{
    private static Stack<Node> stack = new Stack<Node>();
    public static void BSTiterator(Node root)
    {
        pushAll(root);
    }

    public static boolean hasNext()
    {
        return !stack.isEmpty();
    }

    public static int next()
    {
        Node tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.right.val;
    }

    private static void pushAll(Node node)
    {
        for(; node != null; stack.push(node), node = node.left);
    }
    
    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);

        BSTiterator(root);
        System.out.println(hasNext());
    }
}