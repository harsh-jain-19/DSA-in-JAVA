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

public class serialize_and_deserialize
{
    public static void printTree(Node root, int level) {
        if (root == null)
            return;

        // Print right subtree first
        printTree(root.right, level + 1);

        // Print current node
        for (int i = 0; i < level; i++)
            System.out.print("    "); // 4 spaces

        System.out.println(root.val);

        // Print left subtree
        printTree(root.left, level + 1);
    }
    
    public static String serialize(Node root)
    {
        if(root == null)
        {
            return "";
        }
        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node == null)
            {
                res.append("n ");
                continue;
            }
            res.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }
    public static Node deserialize(String data)
    {
        if(data == "")
        {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i = 1; i < values.length; i++)
        {
            Node parent = q.poll();
            if(!values[i].equals("n"))
            {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n"))
            {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);

        String str = serialize(root);
        System.out.println("Serialized Bt = "+str);

        Node rt = deserialize(str);
        System.out.println("Deserialized String :");
        printTree(rt,3);
    }   
}