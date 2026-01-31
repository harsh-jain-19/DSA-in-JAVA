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
public class val
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

    public static node del_val(node head, int k)
    {
        int x = 0;
        node temp = head;
        if(temp.data == k)
        {
            head = head.next;
            x = 1;
            return head;
        }
        node pre = null;
        while(temp != null)
        {
            if(temp.data == k)
            {
                pre.next = pre.next.next;
                x = 1;
                break;
            }
            pre = temp;
            temp = temp.next;
        }
        if(x == 0)
        {
            System.out.println("Value You Have Entered Is Not Present In Linked List");
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
        System.out.println("Enter the Element You want to delete.");
        int k = sc.nextInt();
        // LL should have atleast two elements.
        head = del_val(head,k);
        traversal(head);
    }
}