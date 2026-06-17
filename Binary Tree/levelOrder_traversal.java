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
public class levelOrder_traversal
{
    public static List<List<Integer>> find_levelOrder(Node root)
    {
        Queue<Node> qu = new LinkedList<>();
        List<List<Integer>> ds = new ArrayList<>();

        if(root == null)
        {
            return ds;
        }
        qu.add(root);
        while(! qu.isEmpty())
        {
            int levelNum = qu.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < levelNum; i++)
            {
                if(qu.peek().left != null)
                {
                    qu.add(qu.peek().left);
                }
                if(qu.peek().right != null)
                {
                    qu.add(qu.peek().right);
                }
                subList.add(qu.poll().val);
            }
            ds.add(subList);
        }
        return ds;
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);        
        root.left.right = new Node(5);

        List<List<Integer>> levelOrder = new ArrayList<>();
        levelOrder = find_levelOrder(root);
        System.out.println("Post Order Traversal = "+levelOrder);
    }
}