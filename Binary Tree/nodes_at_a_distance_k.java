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
public class nodes_at_a_distance_k
{
    public static void markParent(Node root, Map<Node, Node> parent_track, Node target)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            if(curr.left != null)
            {
                parent_track.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if(curr.right != null)
            {
                parent_track.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
    public static List<Integer> find_nodes_at_k_dist(Node root, Node target, int k)
    {
        Map<Node, Node> parent_track = new HashMap<>();
        markParent(root, parent_track, root);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            if(curr_level == k)
            {
                break;
            }
            curr_level++;
            for(int i = 0; i < size; i++)
            {
                Node current = queue.poll();
                if(current.left != null && visited.get(current.left) == null)
                {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null)
                {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current)) == null)
                {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }

        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty())
        {
            Node current = queue.poll();
            result.add(current.val);
        }
        return result;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);

        System.out.println("Enter the distance at which you want all nodes.");
        int k = sc.nextInt();

        List<Integer> nodes_at_k_dist = new ArrayList<>();
        nodes_at_k_dist = find_nodes_at_k_dist(root, root.left, k);
        System.out.println("All nodes from "+root.left.val+" at distance "+k+" = "+nodes_at_k_dist);
    }   
}