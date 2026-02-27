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
public class add_2_numbers_as_LL
{
    public static node reverse(node head)
    {
        node temp = head;
        node prev = null;
        while(temp != null)
        {
            node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static void del_last(node head)
    {
        node temp = head;
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
    }

    public static node add2LL(node head1, node head2)
    {
        node dummy = new node(-1);
        node dTemp = dummy;
        head1= reverse(head1);
        head2 = reverse(head2);
        node temp1 = head1;
        node temp2 = head2;
        int carry = 0;
        while(temp1 != null || temp2 != null || carry == 1)
        {
            int sum = 0;
            if(temp1 != null)
            {
                sum = sum + temp1.data;
                temp1 = temp1.next;
            }
            if(temp2 != null)
            {
                sum = sum + temp2.data;
                temp2 = temp2.next;
            }
            sum = sum + carry;
            carry = sum / 10;
            node val = new node(sum % 10);
            dTemp.next = val;
            dTemp = dTemp.next;
        }
        reverse(head1);
        reverse(head2);
        node x = reverse(dummy);
        del_last(x);
        return x;
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
        System.out.println("Enter the Size of your Array1.");
        int n = sc.nextInt();
        int [] arr1 = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr1[i] = sc.nextInt();
        }
        
        node head1 = new node(arr1[0]);
        node temp = head1;
        for(int i = 1; i < n; i++)
        {
            node val = new node(arr1[i]);
            temp.next = val;
            temp = temp.next;
        }

// TAKING SECOND LINKED LIST 
        System.out.println("Enter the Size of your Array2.");
        int n2 = sc.nextInt();
        int [] arr2 = new int[n2];
        for(int i = 0; i < n2; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr2[i] = sc.nextInt();
        }
        node head2 = new node(arr2[0]);
        temp = head2;
        for(int i = 1; i < n2; i++)
        {
            node val = new node(arr2[i]);
            temp.next = val;
            temp = temp.next;
        }

        node x = add2LL(head1,head2);


        traversal(head1);
        traversal(head2);
        traversal(x);
    }
}