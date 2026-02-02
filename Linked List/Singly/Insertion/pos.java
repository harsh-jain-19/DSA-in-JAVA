import java.util.Scanner;
class node
{
    int data;
    node next;
}
public class pos
{
    public static node head = new node();
    public static node add_pos()
    {

        Scanner sc = new Scanner(System.in);
        node temp = new node();
        System.out.println("Enter the value you want to add in LL");
        temp.data = sc.nextInt();
        temp.next = null;

        System.out.println("Enter at which position you want to add element.");
        int k = sc.nextInt();
        if(k == 1)
        {
            temp.next = head;
            head = temp;
        }
        if(head == null)
        {
            head = temp;
        }
        else 
        {
            node temp2 = new node();
            temp2 = head;
            int cnt = 0;
            while(temp.next != null)
            {
                cnt++;
                if(cnt == k-1)
                {
                    temp.next = temp2.next;
                    temp2.next = temp;
                }
                temp2 = temp2.next;
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
        
        System.out.println("Enter the number of element you want to add at first position.");
        int n = sc .nextInt();
        for(int i = 0; i < n; i++)
        {
            head = add_pos();
        }
        traversal(head);
    }
}