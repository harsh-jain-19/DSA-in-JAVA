import java.util.*;
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int key)
    {
        this.val = key;
    }
}
public class binary_tree_from_postorder_and_inorder
{
     public static void printTree(TreeNode root, int level) {
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



    public static TreeNode buildTree(int [] postOrder, int [] inOrder)
    {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < postOrder.length; i++)
        {
            inMap.put(inOrder[i],i);
        }
        TreeNode root = buildTree(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1, inMap);
        return root;
    }
    public static TreeNode buildTree(int [] postOrder, int postStart, int postEnd, int [] inOrder, int inStart, int inEnd, Map<Integer,Integer> inMap)
    {
        if(postStart > postEnd || inStart > inEnd)
        {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postEnd]);

        int inRoot = inMap.get(postOrder[postEnd]);
        int numsLeft = inRoot - inStart;
        
        root.left = buildTree(postOrder, postStart, postStart+numsLeft-1, inOrder, inStart, inRoot-1, inMap);
        root.right = buildTree(postOrder, postStart+numsLeft, postEnd-1, inOrder, inRoot+1, inEnd, inMap);

        return root;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of your tree.");
        int n = sc.nextInt();

        int [] inOrder = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" value of Inorder traversal");
            inOrder[i] = sc.nextInt();
        }

        int [] postOrder = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" value of Preorder traversal");
            postOrder[i] = sc.nextInt();
        }

        TreeNode root = buildTree(postOrder, inOrder);
        printTree(root,0);
    }
}