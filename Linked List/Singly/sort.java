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
public class sort
{
    public static node middle(node head)
    {
        node slow = head;
        node fast = head.next;
        while(fast !=  null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static node merge(node list1, node list2)
    {
        node dummyNode = new node(-1,null);
        node temp = dummyNode;
        while(list1 != null && list2 != null)
        {
            if(list1.data <= list2.data)
            {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else
            {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null)
        {
            temp.next = list1;
        }
        else
        {
            temp.next = list2;
        }
        return dummyNode.next;
    }

    public static node merge_sort(node head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        node mid = middle(head);
        
        node rightHead = mid.next;
        mid.next = null;
        node leftHead = head;

        leftHead = merge_sort(leftHead);
        rightHead = merge_sort(rightHead);

        return merge(leftHead,rightHead);
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
        head = merge_sort(head);
        traversal(head);
    }
}