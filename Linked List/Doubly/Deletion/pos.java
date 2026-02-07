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
public class pos
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
        int k;
        System.out.println("Enter the position of element you want to delete.");
        k = sc.nextInt();
        if(k > n)
        {
            System.out.println("Position You Have Entered Does not Exist");
            return head;
        }
        else if(k == 1)
        {
            head = del_first(head);
            return head;
        }
        else if(k == n)
        {
            head = del_last(head);
            return head;
        }
        else
        {
            node temp = head;
            int cnt = 0;
            while(temp != null)
            {
                cnt++;
                if(cnt == k)
                {
                    temp.next.back = temp.back;
                    temp.back.next = temp.next;
                    temp.next = null;
                    temp.back = null;
                    break;
                }
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
        head = del_pos(head,n);
        traversal(head);
    }
}