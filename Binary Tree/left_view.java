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

public class left_view
{
    public static void leftView(Node curr, List<Integer> res, int currDepth)
    {
        if(curr == null)
        {
            return;
        }
        if(currDepth == res.size())
        {
            res.add(curr.val);
        }
        leftView(curr.left, res, currDepth + 1);
        leftView(curr.right, res, currDepth + 1);
    }
    public static List<Integer> find_left_view(Node root)
    {
        List<Integer> res = new ArrayList<>();
        leftView(root, res, 0);
        return res;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        List<Integer> left_view = new ArrayList<>();
        left_view = find_left_view(root);
        System.out.println("Left View = "+left_view);
    }
}