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

public class root_to_node_path
{
    public static boolean getPath(Node root, ArrayList<Integer> path, int x)
    {
        if(root == null)
        {
            return false;
        }
        path.add(root.val);
        if(root.val == x)
        {
            return true;
        }
        if(getPath(root.left, path, x) || getPath(root.right, path, x))
        {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    public static ArrayList<Integer> find_path(Node A, int B)
    {
        ArrayList<Integer> path = new ArrayList<>();
        if(A == null)
        {
            return path;
        }
        getPath(A, path, B);
        return path;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        List <Integer> path = new ArrayList<>();
        path = find_path(root, root.left.right.val);
        System.out.println("Root to Node Path is "+path);
    }   
}