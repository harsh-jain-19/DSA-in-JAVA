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

class Tuple
{
    Node node;
    int row;
    int col;
    public Tuple(Node _node, int _row, int _col)
    {
        node = _node;
        row = _row;
        col = _col;
    }
}

public class vertical_traversal
{
    
    public static List<List<Integer>> find_vertical(Node root)
    {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();

        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty())
        {
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(x))
            {
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y, new PriorityQueue<>());
            }
            
            map.get(x).get(y).offer(node.val);

            if(node.left != null)
            {
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null)
            {
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values())
        {
            res.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values())
            {
                while(!nodes.isEmpty())
                {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
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
        List<List<Integer>> vertical = new ArrayList<>();
        vertical = find_vertical(root);
        System.out.println("Vertical Traversal = "+vertical);
    }
}