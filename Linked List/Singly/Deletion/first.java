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
public class first
{
    public static node del_first(node head)
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
        node head = new node(0); head = new node(arr[0]);
        node mover = head;
        for(int i = 1; i < n; i++)
        {
            node temp = new node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        head = del_first(head);
        traversal(head);
    }
}