import java.util.Scanner;
class node
{
    int data;
    node next;
}
public class last
{
    public static node head = new node();
    public static node add_last()
    {
        Scanner sc = new Scanner(System.in);
        node temp = new node();
        System.out.println("Enter the value you want to add in LL");
        temp.data = sc.nextInt();
        temp.next = null;

        if(head == null)
        {
            head = temp;
        }
        else 
        {
            node temp2 = head;
            while(temp2.next != null)
            {
                temp2 = temp2.next;
            }
            temp2.next = temp;
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
            head = add_last();
        }
        traversal(head);
    }
}