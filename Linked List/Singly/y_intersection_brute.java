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
public class y_intersection_brute
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

    public static node intersection(node head1, node head2)
    {
        int n1,n2;
        n1 = length(head1);
        n2 = length(head2);
        node temp1 = head1;
        node temp2 = head2;
        if(n1 > n2)
        {
            int diff = n1 - n2;
            while(diff != 0)
            {
                temp1 = temp1.next;
                diff--;
            }
        }
        else
        {
            int diff = n2 - n1;
            while(diff != 0)
            {
                temp2 = temp2.next;
                diff--;
            }
        }
        while(temp1 != null)
        {
            if(temp1 == temp2)
            {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
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

// TAKING SECOND LINKED LIST FOR MAKING Y INTERSECTION
        System.out.println("Enter the Size of your Array2.");
        int n2 = sc.nextInt();
        int [] arr2 = new int[n];
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
        temp.next = head1.next.next;  //MAKING Y INTERSECTION.

        node x = intersection(head1,head2);
        System.out.println("Node At Which List1 And List2 Are Intersecting Is : "+x.data);

        traversal(head1);
        traversal(head2);
    }
}