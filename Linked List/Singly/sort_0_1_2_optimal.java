// IN THIS PROBLEM LIST WILL ONLY HAVE 0,1,2.
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
public class sort_0_1_2_optimal
{
    public static node sort(node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        node zeroHead = new node(-1,null);
        node temp0 = zeroHead;

        node oneHead = new node(-1,null);
        node temp1 = oneHead;

        node twoHead = new node(-1,null);
        node temp2 = twoHead;

        node temp = head;
        while(temp != null)
        {
            if(temp.data == 0)
            {
                temp0.next = temp;
                temp0 = temp0.next;
            }
            else if(temp.data == 1)
            {
                temp1.next = temp;
                temp1 = temp1.next;
            }
            else
            {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp0.next = (oneHead.next != null)? oneHead.next:twoHead.next;
        temp1.next = twoHead.next;
        temp2.next = null;
        head = zeroHead.next;

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
        head = sort(head);
        traversal(head);
    }
}