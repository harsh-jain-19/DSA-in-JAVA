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
public class pos
{
    public static int length(node head)
    {
        int i = 0;
        node temp = head;
        while(temp.next != null)
        {
            i++;
            temp = temp.next;
        }
        i++;
        return i;
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

    public static node del_pos(node head, int k)
    {
        int n = length(head);
        if(k > n)
        {
            System.out.println("Deletion Not Possible");
        }

        else if(k == 1)
        {
            if(head.next == null)
            {
                System.out.println("You only have one element in Linked List.");
                return head;
            }
            node temp = head;
            head = head.next;
            // In java we do not need to free temp GARBAGE COLLECTOR will delete it.
            return head;
        }
        else if(k == n)
        {
            node temp = head;
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        else if(k < n && k > 1)
        {
            int cnt = 0;
            node temp = head;
            node pre = null;
            while(temp != null)
            {
                cnt++;
                if(cnt == k)
                {
                    pre.next = pre.next.next;
                    break;
                }
                pre = temp;
                temp = temp.next;
            }
        }
        return head;
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
        node mover = head;
        for(int i = 1; i < n; i++)
        {
            node temp = new node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        System.out.println("Enter position of Element You want to delete.");
        int k = sc.nextInt();
        // LL should have atleast two elements.
        head = del_pos(head,k);
        traversal(head);
    }
}