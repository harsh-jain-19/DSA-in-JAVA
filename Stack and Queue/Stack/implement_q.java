// In this we will implement Stack using Queue.
import java.util.*;
class stImpl{
    Queue<Integer> qu = new LinkedList<>();
    int cnt = 0;
    public void push(int x)
    {
        int size = qu.size();
        qu.add(x);
        for(int i = 0; i < size; i++)
        {
            qu.add(qu.peek());
            qu.poll();
        }
    }
    public void pop()
    {
        qu.poll();
    }
    public void top()
    {
        System.out.println(qu.peek());
    }
    public void size()
    {
        System.out.println(qu.size());
    }
}
public class implement_q
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