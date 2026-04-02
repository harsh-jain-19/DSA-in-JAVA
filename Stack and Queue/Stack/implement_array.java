// In this we will implement stack using array.
import java.util.Scanner;
class stImpl{
    int[] stackk = new int[100];
    int top = -1;
    public void push(int x)
    {
        if(top <= 100)
        {
            top = top + 1;
            stackk[top] = x;
        }
        else
        {
            System.out.println("Stack Overflow");
        }
    }
    public void pop()
    {
        if(top > -1)
        {
            top = top - 1;
        }
        else
        {
            System.out.println("Stack Under Flow.");
        }
    }
    public void top()
    {
        if(top > -1)
        {
            System.out.println(stackk[top]);
        }
        else
        {
            System.out.println("Stack does not have any value");
        }
    }
    public void size()
    {
        System.out.println(top+1);
    }
}
public class implement_array
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