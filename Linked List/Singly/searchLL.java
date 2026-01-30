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
public class searchLL
{
    public static void search(node head,int x)
    {
        int i = 0;
        node temp = head;
        while(temp.next != null)
        {
            if(temp.data == x)
            {
                System.out.println(x+" is present in Linked List");
                i = 1;
            }
            temp = temp.next;
        }
        if(temp.data == x)
        {
            System.out.println(x+" is present in Linked List");
            i = 1;
        }
        if(i == 0)
        {
            System.out.println(x+" is not present in Linked List");
        }
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

        System.out.println("Enter the element you are searching.");
        int x = sc.nextInt();
        search(head,x);
        
    }
}