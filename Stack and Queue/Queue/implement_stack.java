// In this we will implement Queue using Stack.
import java.util.*;
class stImpl{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int x)
    {
        while(s1.size() != 0)
        {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while(s2.size() != 0)
        {
            s1.push(s2.peek());
            s2.pop();
        }
    }
    public void pop()
    {
        s1.pop();
    }
    public void top()
    {
        System.out.println(s1.peek());
    }
    public void size()
    {
        System.out.println(s1.size());
    }
}
public class implement_stack
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