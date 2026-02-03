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
public class pos
{
    public static node add_pos(node head)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position of element where you want to insert element.");
        int k = sc.nextInt();
        System.out.println("Enter the value you want to insert.");
        int val = sc.nextInt();
        node value = new node(val);
        if(k == 1)
        {
            value.next = head;
            head = value;
            return head;
        }
        else
        {
            int cnt = 0;
            node temp = head;
            while(temp != null)
            {
                cnt++;
                if(cnt == (k-1))
                {
                    value.next = temp.next;
                    temp.next = value;
                    return head;
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
        node mover = head;
        for(int i = 1; i < n; i++)
        {
            node temp = new node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        System.out.println("Enter how many elements you want to insert");
        int x = sc.nextInt();
        for(int i = 0; i < x; i++)
        {
            head = add_pos(head);
        }
        traversal(head);
    }
}