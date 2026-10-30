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
public class construct_BST_from_preorder
{
    public static Node form_BST(int []preOrder, int bound, int [] i)
    {
        if(i[0] == preOrder.length || preOrder[i[0]] > bound)
        {
            return null;
        }
        Node root = new Node(preOrder[i[0]++]);
        root.left = form_BST(preOrder, root.val, i);
        root.right = form_BST(preOrder, bound, i);
        return root;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of PreOrder traversal.");
        int n = sc.nextInt();

        int [] preOrder = new int[n];
        System.out.println("Enter the PreOrder Traversal.");
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the value of "+i+" element.");
            preOrder[i] = sc.nextInt();
        }

        System.out.println("PreOrder traversal you have entered.");
        for(int i = 0; i < n; i++)
        {
            if(i == 0)
            {
                System.out.print(preOrder[i]);
            }
            else
            {
                System.out.print(", "+preOrder[i]);
            }
            
        }

        Node root = form_BST(preOrder, Integer.MAX_VALUE, new int[]{0});
        System.out.println("\nRoot of BST = "+root.val);
    }
}