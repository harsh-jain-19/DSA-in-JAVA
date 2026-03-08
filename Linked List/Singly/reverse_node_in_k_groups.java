// In this problem we will be given a head of a linked list.
// We have to break down it into given number(k) of groups.
// Then we have to reverse all the groups.
import java.util.Scanner;
class node
{
    int data;
    node next;
    node(int d, node n)  //CONSTRUCTOR
    {
        this.data = d;
        this.next = n;
    }
    node(int d)  // CONSTRUCTOR
    {
        this.data = d;
        this.next = null;
    }
}
public class reverse_node_in_k_groups
{
    public static node reverse(node head)
    {
        node temp = head;
        node prev = null;
        while(temp != null)
        {
            node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static node kth_node(node head, int k)
    {
        node temp = head;
        int cnt = 1;
        while(cnt != k)
        {
            temp = temp.next;
            if(temp == null)
            {
                return null;
            }
            cnt++;
        }
        return temp;
    }

    public static node reverse_nodes(node head, int k)
    {
        node temp = head;
        node nextnode = null;
        node prenode = null;
        while(temp != null)
        {
            node kth = kth_node(temp,k);
            if(kth == null)
            {
                if(prenode != null)
                {
                    prenode.next = temp;
                }
                break;
            }
            nextnode = kth.next;
            kth.next = null;
            node newhead = reverse(temp);
            if(temp == head)
            {
                head = newhead;
            }
            else
            {
                prenode.next = newhead;
            }
            prenode = temp;
            temp = nextnode;
        }
        
        return head;
    }

    public static void traversal(node head)
    {
        node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.data+" -> ");
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
        node temp = head;
        for(int i = 1; i < n; i++)
        {
            node val = new node(arr[i]);
            temp.next = val;
            temp = temp.next;
        }
        System.out.println("Enter the Number of which you want to make groups of node.");
        int k = sc.nextInt();

        head = reverse_nodes(head,k);
        traversal(head);
    }
}