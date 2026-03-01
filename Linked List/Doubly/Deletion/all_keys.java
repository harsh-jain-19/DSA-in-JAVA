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
public class all_keys
{
    public static node del_pos(node head, int key)
    {
        node temp = head;
        while(temp != null)
        {
            if(temp.data == key)
            {
                if(temp.back == null)
                {
                    head = head.next;
                    head.back = null;
                    temp.next = null;
                    temp = head;
                }
                else if(temp.next == null)
                {
                    temp.back.next = null;
                    temp.back = null;
                    break;
                }
                else
                {
                    temp.back.next = temp.next;
                    temp.next.back = temp.back;
                    temp = temp.next;
                }
            }
            else
            {
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
        System.out.println("Enter the element you want to delete.");
        int key = sc.nextInt();
        head = del_pos(head,key);
        traversal(head);
    }
}