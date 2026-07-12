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

class Pair
{
    Node node;
    int hd; // horizontal distance

    Pair(Node node, int hd)
    {
        this.node = node;
        this.hd = hd;
    }
}

public class bottom_view
{
    
    public static List<Integer> find_bottom_view(Node root)
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
        {
            return res;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty())
        {
            Pair curr = q.remove();
            Node temp = curr.node;
            int hd = curr.hd;

            map.put(hd,temp.val);
            if(temp.left != null)
            {
                q.add(new Pair(temp.left,hd - 1));
            }
            if(temp.right != null)
            {
                q.add(new Pair(temp.right,hd + 1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            res.add(entry.getValue());
        }
        return res;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);
        List<Integer> bottom_view = new ArrayList<>();
        bottom_view = find_bottom_view(root);
        System.out.println("Bottom View = "+bottom_view);
    }
}