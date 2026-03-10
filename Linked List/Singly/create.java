import java.util.Scanner;
class node
{
    int data;
    node next;
}
public class create
{
    public static node insert(node head)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("Enter the Value You Want To Insert.");
        x = sc.nextInt();
        node val = new node();
        val.data = x;
        val.next = null;
        
        node temp = head;

        if(head == null)
        {
            head = val;
        }
        else
        {
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = val;
        }
        return head;
    }

    public static node delete(node head)
    {
        if(head == null)
        {
            System.out.println("Linked List Is Empty, So Deletion Is Not Possible.");
            return head;
        }
        else if(head.next == null)
        {
            return null;
        }
        else
        {
            node temp = head;
            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
        return head;
    }

    public static void traversal(node head)
    {
        if(head == null)
        {
            System.out.println("Linked List Is Empty.");
        }
        else
        {
            node temp = head;
            while(temp.next != null)
            {
                System.out.print(temp.data+" -> ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        node head = new node();
        
        System.out.println("Enter 1 To Add A Node.");
        System.out.println("Enter 2 To Delete A Node.");
        System.out.println("Enter 3 To Traverse A Linked List.");
        System.out.println("Enter 0 To Do Nothing.");
        
        int x = 1;
        while(x != 0)
        {
            System.out.println("Now Enter Your Choice.");
            x = sc.nextInt();
            switch(x){
                case 1 -> head = insert(head);
                case 2 -> head = delete(head);
                case 3 -> traversal(head);
                default -> System.out.println("Thank You!!");
            }
        }
    }
}