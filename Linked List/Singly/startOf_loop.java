// TORTOISE AND HARE 
// In this problem return the node from which a loop/cycle is starting in linked list.
// Return null if there no loop in linked list.
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
public class startOf_loop
{
    public static node startingOfLoop(node head)
    {
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                slow = head;
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
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

        temp.next = head.next.next; // This Line Is Used To Form A Loop In Linked List.

        node x = startingOfLoop(head);
        if(x == null)
        {
            System.out.println("There Is No Loop In Linked List.");
        }
        else
        {
            System.out.println("The Loop Is Starting At Node "+x.data);
        }
    }
}