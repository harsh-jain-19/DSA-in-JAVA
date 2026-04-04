// In this Problem we will be given a string of some opening and closing barckets.
// We have to tell that it is balanced or not.
import java.util.*;
public class balanced_paranthesis
{
    public static boolean check(String str)
    {
        Stack<Character> stackk = new Stack<>();
        int n = str.length();
        for(int i = 0; i < n; i++)
        {
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
            {
                stackk.push(str.charAt(i));
            }
            else
            {
                if(stackk.isEmpty())
                {
                    return false;
                }
                char ch = stackk.pop();
                
                if((str.charAt(i) == ')' && ch == '(') || (str.charAt(i) == '}' && ch == '{') || (str.charAt(i) == ']' && ch == '['))
                {

                }
                else
                {
                    return false;
                }
            }
        }
        return stackk.isEmpty();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of your String");
        int n = sc.nextInt();
        char [] arr = new char[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.next().charAt(0);
        }
        String str = new String(arr);

        boolean ans = check(str);
        if(ans)
        {
            System.out.println("Your String is Balanced");
        }
        else
        {
            System.out.println("Your String is not Balanced");
        }
        System.out.println(str);

    }
}