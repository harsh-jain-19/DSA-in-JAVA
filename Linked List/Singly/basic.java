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
public class basic
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.println("Enter the Value Of x.");
        x = sc.nextInt();

        node n1 = new node(x);
        System.out.println(n1.data);
        System.out.println(n1.next);

    }
}