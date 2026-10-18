// Ceil is the smallest value that is greater then or equal to the key.
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
public class insert
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
    public static Node insert_node(Node root, int val)
    {
        if(root == null)
        {
            return new Node(val);
        }
        Node curr = root;
        while(true)
        {
            if(curr.val <= val)
            {
                if(curr.right != null)
                {
                    curr = curr.right;
                }
                else
                {
                    curr.right = new Node(val);
                    break;
                }
            }
            else
            {
                if(curr.left != null)
                {
                    curr = curr.left;
                }
                else
                {
                    curr.left = new Node(val);
                    break;
                }
            }
        }
        return root;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);      
        root.left.right = new Node(8);

        System.out.println("Enter the value of node you want to insert.");
        int val = sc.nextInt();
        
        root = insert_node(root,val);

        printVisual(root, 0);
    }
}  