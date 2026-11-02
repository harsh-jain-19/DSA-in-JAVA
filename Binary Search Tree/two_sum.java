
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int key) {
        this.val = key;
    }
}

class BSTIterator {
    private Stack<Node> stack = new Stack<>();
    private boolean reverse;

    public BSTIterator(Node root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node tmpNode = stack.pop();

        if (!reverse) {
            pushAll(tmpNode.right);
        } else {
            pushAll(tmpNode.left);
        }

        return tmpNode.val;
    }

    private void pushAll(Node node) {
        while (node != null) {
            stack.push(node);

            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}

public class two_sum {

    public static boolean find_two(Node root, int k) {
        if (root == null) {
            return false;
        }

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        if (!left.hasNext() || !right.hasNext()) {
            return false;
        }

        int i = left.next();
        int j = right.next();

        while (i < j) {
            int sum = i + j;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                if (!left.hasNext()) {
                    return false;
                }
                i = left.next();
            } else {
                if (!right.hasNext()) {
                    return false;
                }
                j = right.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);

        System.out.println("Enter the value of sum:");
        int sum = sc.nextInt();

        boolean ans = find_two(root, sum);

        if (ans) {
            System.out.println(
                "Yes, there are two integers in BST whose sum = " + sum
            );
        } else {
            System.out.println(
                "No, there are no two integers in BST whose sum = " + sum
            );
        }

        sc.close();
    }
}
