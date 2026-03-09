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
public class rotate_k_times
{
    public static node rotate(node head, int k)
    {
        node temp = head;
        int cnt = 1;
        while(temp.next != null)
        {
            temp = temp.next;
            cnt++;
        }
        k = k % cnt;
        if(k == 0)
        {
            return head;
        }
        int x = cnt - k;
        temp.next = head;
        temp = head;
        for(int i = 1; i < x; i++)
        {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
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
        System.out.println("Enter how many times you want to rotate Linke List.");
        int k = sc.nextInt();

        head = rotate(head,k);

        traversal(head);
    }
}