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
public class boundry_traversal
{
    public static boolean isLeaf(Node root)
    {
        if(root.right == null && root.left == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void addLeftBoundry(Node root, List<Integer> result)
    {
        Node cur = root.left;
        while(cur != null)
        {
            if(isLeaf(cur) == false)
            {
                result.add(cur.val);
            }
            if(cur.left != null)
            {
                cur = cur.left;
            }
            else
            {
                cur = cur.right;
            }
        }
    }
    public static void addRightBoundry(Node root, List<Integer> result)
    {
        Node cur = root.right;
        Stack<Integer> temp = new Stack<>();
        while(cur != null)
        {
            if(isLeaf(cur) == false)
            {
                temp.push(cur.val);
            }
            if(cur.right != null)
            {
                cur = cur.right;
            }
            else
            {
                cur = cur.left;
            }
        }
        while(! temp.isEmpty())
        {
            result.add(temp.pop());
        }
    }
    public static void addLeaves(Node root, List<Integer> result)
    {
        if(isLeaf(root))
        {
            result.add(root.val);
            return;
        }
        if(root.left != null)
        {
            addLeaves(root.left,result);
        }
        if(root.right != null)
        {
            addLeaves(root.right,result);
        }
    }
    public static List<Integer> find_boundry(Node root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        if(isLeaf(root) == false)
        {
            result.add(root.val);
        }

        addLeftBoundry(root,result);
        addLeaves(root,result);
        addRightBoundry(root,result);

        return result;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        List<Integer> boundry = new ArrayList<>();
        boundry = find_boundry(root);
        System.out.println("Boundry Traversal = "+boundry);
    }
}