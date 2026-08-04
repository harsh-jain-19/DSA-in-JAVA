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
public class flatten_BT_to_LinkedList
{
    public static void printTree(Node root, int level) {
        if (root == null)
            return;

        // Print right subtree first
        printTree(root.right, level + 1);

        // Print current node
        for (int i = 0; i < level; i++)
            System.out.print("    "); // 4 spaces

        System.out.println(root.val);

        // Print left subtree
        printTree(root.left, level + 1);
    }
    public static void flatten_bt_to_ll(Node root)
    {
        Node curr = root;

        while (curr != null) {
            if (curr.left != null) {
                Node pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);        
        root.left.right = new Node(5);

        flatten_bt_to_ll(root);
        System.out.println("After Flattening the binary tree to linked list.");
        printTree(root,3);
    }
}