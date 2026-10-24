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
public class k_th_smallest_element
{
    public static int find_kth_smallest(Node root, int k)
    {
        Node curr = root;
        int cur = 0;
        int ans = 0;

        while(curr != null)
        {
            if(curr.left == null)
            {
                cur++;
                if(cur == k)
                {
                    ans = curr.val;
                }
                curr = curr.right;
            }
            else
            {
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right = null;
                    cur++;
                    if(cur == k)
                    {
                        ans = curr.val;
                    }
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);

        System.out.println("Enter the value of k.");
        int k = sc.nextInt();
        
        int ans = find_kth_smallest(root,k);
        System.out.println(k+" Largest element of the Binary Search Tree is "+ans);
    }
}  