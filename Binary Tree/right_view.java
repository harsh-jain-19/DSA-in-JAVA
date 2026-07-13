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

public class right_view
{
    public static void rightView(Node curr, List<Integer> res, int currDepth)
    {
        if(curr == null)
        {
            return;
        }
        if(currDepth == res.size())
        {
            res.add(curr.val);
        }
        rightView(curr.right, res, currDepth + 1);
        rightView(curr.left, res, currDepth + 1);
    }
    public static List<Integer> find_right_view(Node root)
    {
        List<Integer> res = new ArrayList<>();
        rightView(root, res, 0);
        return res;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        List<Integer> right_view = new ArrayList<>();
        right_view = find_right_view(root);
        System.out.println("Right View = "+right_view);
    }
}