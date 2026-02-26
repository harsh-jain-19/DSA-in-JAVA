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
public class add_1_brute
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

    public static node add_1(node head)
    {
        head = reverse(head);
        int carry = 1;
        node temp = head;
        while(temp != null)
        {
            if(temp.data < 9)
            {
                temp.data = temp.data + carry;
                carry = 0;
                break;
            }
            else
            {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        head = reverse(head);
        if(carry == 1)
        {
            node newNode = new node(1);
            newNode.next = head;
            head = newNode;
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
        head = add_1(head);
        traversal(head);
    }
}