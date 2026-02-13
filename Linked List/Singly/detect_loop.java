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
public class detect_loop
{
    public static boolean detect_loop(node head)
    {
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                return true;
            }
        }
        return false;
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

        // temp.next = head.next;  THIS LINE CAN BE USED TO FORM LOOP IN LINKED LIST.

        boolean x = detect_loop(head);
        if(x == true)
        {
            System.out.println("Yes! There Is A Loop In Linked List.");
        }
        else
        {
            System.out.println("No! There Is Not A Loop In Linked List.");
        }
        traversal(head);
    }
}