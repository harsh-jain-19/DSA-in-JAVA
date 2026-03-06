// In This We Will Be Given A SORTED Doubly Linked List.
// We Found The Pairs In DLL With Given Sum.
import java.util.*;
class node
{
    int data;
    node next;
    node back;
    node(int d, node n, node b)  //CONSTRUCTOR
    {
        this.data = d;
        this.next = n;
        this.back = b;
    }
    node(int d)  // CONSTRUCTOR
    {
        this.data = d;
        this.next = null;
        this.back = null;
    }
}
public class pairs_with_sum
{
    public static List<List<Integer>> sum_pairs(node head, int sum)
    {
        node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        node left = head;
        node right = temp;
        List<List<Integer>> ans = new ArrayList<>();
        while(left.data < right.data)
        {
            int x = left.data + right.data;
            if(x == sum)
            {
                List<Integer> xyz = new ArrayList<>();
                xyz.add(left.data);
                xyz.add(right.data);
                ans.add(xyz);
                left = left.next;
                right = right.back;
            }
            else if(x < sum)
            {
                left = left.next;
            }
            else
            {
                right = right.back;
            }
        }
        return ans;
    }

    public static void traversal(node head)
    {
        node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.data+" <=> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of your Array.");
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        
        node head = new node(arr[0]);
        node prev = head;
        for(int i = 1; i < n; i++)
        {
            node val = new node(arr[i],null,prev);
            prev.next = val;
            prev = prev.next;
        }
        System.out.println("Enter the sum whose pairs you want.");
        int sum = sc.nextInt();
        List<List<Integer>> ans = new ArrayList<>();
        ans = sum_pairs(head,sum);
        System.out.println("Pairs With Sum "+sum+" = "+ans); 

        traversal(head);
    }
}