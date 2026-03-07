// In this we will be given a sorted Doubly Linked List and We Have To REMOVE DUPLICATES.
import java.util.Scanner;
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
public class remove_duplicates
{
    public static node removeDupli(node head)
    {
        node temp = head;
        node Nodenext = head.next;
        while(Nodenext != null)
        {
            if(temp.data == Nodenext.data)
            {
                Nodenext = Nodenext.next;
                temp.next = Nodenext;
                if(Nodenext != null)
                {
                    Nodenext.back = temp;
                }
            }
            else
            {
                Nodenext = Nodenext.next;
                temp = temp.next;
            }
        }
        return head;
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
        head = removeDupli(head);
        traversal(head);
    }
}