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
public class min_burn_time
{
    public static Node markParent(Node root, Map<Node, Node> parent_track, int start)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        Node res = null;
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            if(curr.val == start)
            {
                res = curr;
            }
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
        return res;
    }
    public static int find_max_dist(HashMap<Node,Node> mpp, Node target)
    {
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(target);
        visited.put(target, true);
        int maxi = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            int fl = 0;
            for(int i = 0; i < size; i++)
            {
                Node current = queue.poll();
                if(current.left != null && visited.get(current.left) == null)
                {
                    fl = 1;
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null)
                {
                    fl = 1;
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(mpp.get(current) != null && visited.get(mpp.get(current)) == null)
                {
                    fl = 1;
                    queue.offer(mpp.get(current));
                    visited.put(mpp.get(current), true);
                }
            }
            if(fl == 1)
            {
                maxi++;
            }
        }
        return maxi;
    }
    public static int timeToBurnTree(Node root, int start)
    {
        if(root == null)
        {
            return 0;
        }
        HashMap<Node,Node> mpp = new HashMap<>();
        Node target = markParent(root, mpp, start);
        if(target == null)
        {
            return -1;
        }
        int maxi = find_max_dist(mpp, target);
        return maxi;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);      
        root.left.right = new Node(5);

        System.out.println("Enter the value of node from where you want to burn Binary Tree.");
        int k = sc.nextInt();

        int burn_time = timeToBurnTree(root, k);
        System.out.println("Minimum time to burn complete binary tree from node "+k+" = "+burn_time);
    }   
}