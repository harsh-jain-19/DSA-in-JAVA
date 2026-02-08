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
public class val
{
    public static node del_last(node head)
    {
        node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        node prev = temp.back;
        prev.next = null;
        temp.back = null;
        return head;
    }
    public static node del_first(node head)
    {
        node temp = head;
        head = temp.next;
        head.back = null;
        temp.next = null;
        return head;
    }
    public static node del_pos(node head, int n)
    {
        Scanner sc = new Scanner(System.in);
        int val;
        System.out.println("Enter the element you want to delete.");
        val = sc.nextInt();
        if(val == head.data)
        {
            head = del_first(head);
            return head;
        }
        else
        {
            node temp = head;
            while(temp.next != null)
            {
                if(val == temp.data)
                {
                    temp.next.back = temp.back;
                    temp.back.next = temp.next;
                    temp.next = null;
                    temp.back = null;
                    return head;
                }
                temp = temp.next;
            }
            if(val == temp.data)
            {
                head = del_last(head);
                return head;
            }
            else
            {
                System.out.println("Value You Have Entered Does Not Exist In DLL.");
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
        head = del_pos(head,n);
        traversal(head);
    }
}