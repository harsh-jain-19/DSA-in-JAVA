// In this problem we have to design getMin() function.
// getMin() function is used to return the minimum value in the stack.
import java.util.*;
class stImpl{
    Stack<Integer> stackk = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int x)
    {
        if(stackk.isEmpty())
        {
            min = x;
            stackk.push(x);
        }
        else
        {
            if(x > min)
            {
                stackk.push(x);
            }
            else
            {
                stackk.push((2*x) - min);
                min = x;
            }
        }
    }
    public void pop()
    {
        if(stackk.isEmpty())
        {
            System.out.println("Stack UnderFlow");
        }
        int x = stackk.pop();
        if(x < min)
        {
            min = (2 * min) - x;
        }
    }
    public void top()
    {
        if(stackk.isEmpty())
        {
            System.out.println("Stack UnderFlow");
        }
        int x = stackk.peek();
        if(min < x)
        {
            System.out.println(x);
        }
        else
        {
            System.out.println(min);
        }
    }
    public void size()
    {
        System.out.println(stackk.size());
    }
    public void getMin()
    {
        System.out.println(min);
    }
}
public class min_stack
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
        System.out.println("Enter 5 for getMin.");
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
                case 5:
                    st.getMin();
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