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
    public static node insert_first(node head, node neww)
    {
        node temp = head;
        temp.back = neww;
        neww.next = head;
        head = neww;
        return head;
    }
    public static node insert_last(node head, node neww)
    {
        node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = neww;
        neww.back = temp;
        return head;
    }
    public static node insert_pos(node head)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("Enter the value you want to insert.");
        x = sc.nextInt();
        node neww = new node(x);

        int k;
        System.out.println("Enter the position at which you want to insert.");
        k = sc.nextInt();

        node temp = head;
        int cnt = 0;
        while(temp.next != null)
        {
            cnt++;
            if(cnt == k)
            {
                break;
            }
            temp = temp.next;
        }
        if(temp.back == null)
        {
            head = insert_first(head,neww);
            return head;
        }
        else if(temp.next == null)
        {
            head = insert_last(head,neww);
            return head;
        }
        else
        {
            node prev = temp.back;
            neww.next = temp;
            neww.back = prev;
            prev.next = neww;
            temp.back = neww;
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
        head = insert_pos(head);
        traversal(head);
    }
}