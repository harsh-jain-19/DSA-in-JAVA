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
public class delete
{
    public static void printVisual(Node node, int space) {
        if (node == null) return;

        // Increase distance between levels
        space += 5;

        // Process right child first (top of screen)
        printVisual(node.right, space);

        // Print current node after spacing
        System.out.println();
        for (int i = 5; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(node.val);

        // Process left child (bottom of screen)
        printVisual(node.left, space);
    }
    public static Node delete_node(Node root, int key)
    {
        if(root == null)
        {
            return null;
        }
        if(root.val == key)
        {
            return helper(root);
        }
        Node dummy = root;
        while(root != null)
        {
            if(root.val > key)
            {
                if(root.left != null && root.left.val == key)
                {
                    root.left = helper(root.left);
                    break;
                }
                else
                {
                    root = root.left;
                }
            }
            else
            {
                if(root.right != null && root.right.val == key)
                {
                    root.right = helper(root.right);
                    break;
                }
                else
                {
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public static Node helper(Node root)
    {
        if(root.left == null)
        {
            return root.right;
        }
        else if(root.right == null)
        {
            return root.left;
        }
        else
        {
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    public static Node findLastRight(Node root)
    {
        if(root.right == null)
        {
            return root;
        }
        return findLastRight(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);

        System.out.println("Enter the value of node you want to delete.");
        int key = sc.nextInt();
        
        root = delete_node(root,key);

        printVisual(root, 0);
    }
}  