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
public class middleLL_brute
{
    public static int length(node head)
    {
        int i = 0;
        node temp = head;
        while(temp.next != null)
        {
            i++;
            temp = temp.next;
        }
        i++;
        return i;
    }
    public static node middle(node head)
    {
        int n = length(head);
        int x = (n/2)+1;
        node temp = head;
        while(temp.next != null)
        {
            x--;
            if(x == 0)
            {
                break;
            }
            temp = temp.next;
        }
        return temp;
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
        node mid = middle(head);
        System.out.println("Middle of LL = "+mid.data);
        traversal(head);
    }
}