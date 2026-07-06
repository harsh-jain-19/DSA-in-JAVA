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
public class zig_zag_traversal
{
    public static List<List<Integer>> find_zigzag(Node root)
    {
        Queue<Node> qu = new LinkedList<>();
        List<List<Integer>> ds = new ArrayList<>();

        if(root == null)
        {
            return ds;
        }
        qu.add(root);

        boolean flag = false;
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
            if(flag == true)
            {
                Collections.reverse(subList);
            }
            flag = ! flag;
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
        List<List<Integer>> zig_zag = new ArrayList<>();
        zig_zag = find_zigzag(root);
        System.out.println("Zig Zag Traversal = "+zig_zag);
    }
}