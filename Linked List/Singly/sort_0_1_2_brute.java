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
public class sort_0_1_2_brute
{
    public static node sort(node head)
    {
        int cnt_0 = 0;
        int cnt_1 = 0;
        int cnt_2 = 0;
        node temp = head;

        while(temp != null)
        {
            if(temp.data == 0)
            {
                cnt_0++;
            }
            else if(temp.data == 1)
            {
                cnt_1++;
            }
            else
            {
                cnt_2++;
            }
            temp = temp.next;
        }
        temp = head;
        while(cnt_0 != 0)
        {
            temp.data = 0;
            temp = temp.next;
            cnt_0--;
        }
        while(cnt_1 != 0)
        {
            temp.data = 1;
            temp = temp.next;
            cnt_1--;
        }
        while(cnt_2 != 0)
        {
            temp.data = 2;
            temp = temp.next;
            cnt_2--;
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
        head = sort(head);
        traversal(head);
    }
}