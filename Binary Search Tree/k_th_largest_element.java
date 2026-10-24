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
public class k_th_largest_element
{
    public static int find_kth_largest(Node root, int k)
    {
        Node curr = root;
        int count = 0;

        while (curr != null) {
            if (curr.right == null) {
                count++;

                if (count == k) {
                    return curr.val;
                }

                curr = curr.left;
            } else {
                Node prev = curr.right;

                while (prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }

                if (prev.left == null) {
                    prev.left = curr;
                    curr = curr.right;
                } else {
                    prev.left = null;
                    count++;

                    if (count == k) {
                        return curr.val;
                    }

                    curr = curr.left;
                }
            }
        }

        return -1; // k is invalid
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
        
        int ans = find_kth_largest(root,k);
        System.out.println(k+" Largest element of the Binary Search Tree is "+ans);
    }
}  