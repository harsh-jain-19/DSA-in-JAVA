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
public class palindrome
{
    public static node middle(node head)
    {
        node slow = head;
        node fast = head;
        while(fast.next != null && fast.next.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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

    public static boolean palindrome_OR_not(node head)
    {
        node mid = middle(head);
        node newhead = reverse(mid.next);
        node temp1 = head;
        node temp2 = newhead;
        while(temp2 != null)
        {
            if(temp1.data != temp2.data)
            {
                reverse(newhead);
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        reverse(newhead);
        return true;
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
        boolean x = palindrome_OR_not(head);
        if(x == false)
        {
            System.out.println("Given Linked List Is Not Palindrome Linked List.");
        }
        else
        {
            System.out.println("Given Linked List Is Palindrome Linked List.");
        }
        traversal(head);
    }
}