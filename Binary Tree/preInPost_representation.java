import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;
    Node(int key)
    {
        this.data = key;
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
public class preInPost_representation
{
    public static void preInPost_traversal(Node root)
    {
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while(!st.isEmpty())
        {
            Pair it = st.pop();

            if(it.num == 1)
            {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left != null)
                {
                    st.push(new Pair(it.node.left, 1));
                }
            }
            else if(it.num == 2)
            {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right != null)
                {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            else
            {
                post.add(it.node.data);
            }
        }

        System.out.println("PreOrder Traversal = "+pre);
        System.out.println("InOrder Traversal = "+in);
        System.out.println("PostOrder Traversal = "+post);
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);        
        root.left.right = new Node(5);
        preInPost_traversal(root);
    }
}