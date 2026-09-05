import java.util.*;
public class sort_stack
{
    public static Stack<Integer> sort(Stack<Integer> s)
    {
        if(s.isEmpty() || s.size() == 1)
        {
            return s;
        }
        int top = s.pop();
        sort(s);
        insert(top,s);
        return s;
    }

    public static void insert(int element, Stack<Integer> s)
    {
        if(s.isEmpty() || s.peek() <= element)
        {
            s.push(element);
            return;
        }
        int top = s.pop();
        insert(element,s);
        s.push(top);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter 0 for Exit.");
        System.out.println("Enter 1 for push.");
        System.out.println("Enter 2 for pop.");
        System.out.println("Enter 3 for top.");
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
                    stack.push(n);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                default:
                    System.out.println("Enter A Valid Choice.");
                    break;
            }
            System.out.println("Now Enter Your Choice.");
            x = sc.nextInt();
        }
        System.out.println("Stack you have entered.");
        for (int item : stack) {
            System.out.println(item);
        }

        Stack<Integer> sorted = new Stack<>();
        sorted = sort(stack);

        System.out.println("Stack you after sorting.");
        for (int item : sorted) {
            System.out.println(item);
        }
    }
}