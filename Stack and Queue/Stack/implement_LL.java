// In this we will implement stack using Linked List.
import java.util.Scanner;
class node
{
    int data;
    node next;
}
class stImpl{
    node top;
    int cnt = 0;
    public void push(int x)
    {
        node nd = new node();
        nd.data = x;
        nd.next = top;
        top = nd;
        cnt++;
    }
    public void pop()
    {
        node temp = top;
        top = top.next;
        cnt--;
    }
    public void top()
    {
        System.out.println(top.data);
    }
    public void size()
    {
        System.out.println(cnt);
    }
}
public class implement_LL
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        stImpl st = new stImpl();

        System.out.println("Enter 0 for Exit.");
        System.out.println("Enter 1 for push.");
        System.out.println("Enter 2 for pop.");
        System.out.println("Enter 3 for top.");
        System.out.println("Enter 4 for size.");
        int x;
        System.out.println("Now Enter Your Choice.");
        x = sc.nextInt();
        while(x != 0)
        {
            switch(x){
                case 1:
                    int n;
                    System.out.println("Enter the value you want to push.");
                    n = sc.nextInt();
                    st.push(n);
                    break;
                case 2:
                    st.pop();
                    break;
                case 3:
                    st.top();
                    break;
                case 4:
                    st.size();
                    break;
                default:
                    System.out.println("Enter A Valid Choice.");
                    break;
            }
            System.out.println("Now Enter Your Choice.");
            x = sc.nextInt();            
        }
    }
}