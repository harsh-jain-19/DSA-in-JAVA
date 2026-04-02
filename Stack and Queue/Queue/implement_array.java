// In this we will implement stack using array.
import java.util.Scanner;
class qImpl{
    int size = 100;
    int[] q = new int[size];
    int curr_size = 0;
    int front = -1, end = -1;
    public void push(int x)
    {
        if((front == 0 && end == size-1) || end == front-1)
        {
            System.out.println("Queue Overflow");
        }
        else if(front == -1 && end == -1)
        {
            front++;
            end++;
            q[end] = x;
            curr_size++;
        }
        else if(end == size-1 && front != 0)
        {
            end = 0;
            q[end] = x;
            curr_size++;
        }
        else
        {
            end++;
            q[end] = x;
            curr_size++;
        }
    }
    public void pop()
    {
        if(front == -1 && end == -1)
        {
            System.out.println("Queue Underflow");
        }
        else if(front == end)
        {
            front = -1;
            end = -1;
            curr_size--;
        }
        else if(front == size-1)
        {
            front = 0;
            curr_size--;
        }
        else
        {
            front++;
            curr_size--;
        }
    }
    public void top()
    {
        if(front == -1 && end == -1)
        {
            System.out.println("Queue Underflow");
        }
        else
        {
            System.out.println(q[front]);
        }
    }
    public void size()
    {
        System.out.println(curr_size);
    }
}
public class implement_array
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        qImpl qu = new qImpl();

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
                    qu.push(n);
                    break;
                case 2:
                    qu.pop();
                    break;
                case 3:
                    qu.top();
                    break;
                case 4:
                    qu.size();
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