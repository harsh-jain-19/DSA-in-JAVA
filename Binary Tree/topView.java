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
    int num;

    Pair(Node node, int num)
    {
        this.node = node;
        this.num = num;
    }
}

public class topView
{
    
    public static List<Integer> find_topView(Node root)
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
        {
            return res;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root,0));

        while(!q.isEmpty())
        {
            Pair it = q.remove();
            int num = it.num;
            Node temp = it.node;
            if(map.get(num) == null)
            {
                map.put(num, temp.val);
            }
            if(temp.left != null)
            {
                q.add(new Pair(temp.left, num-1));
            }
            if(temp.right != null)
            {
                q.add(new Pair(temp.right, num+1));
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
        List<Integer> topView = new ArrayList<>();
        topView = find_topView(root);
        System.out.println("Vertical Traversal = "+topView);
    }
}