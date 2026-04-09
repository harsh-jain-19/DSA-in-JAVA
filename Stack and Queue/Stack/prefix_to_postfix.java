// In this Problem we will be given a prefix string.
// We have to convert it into postfix string.
import java.util.*;
public class prefix_to_postfix
{
    public static String postfix(String str)
    {
        Stack<String> stackk = new Stack<>();
        int n = str.length();
        int i = n-1;
        while(i  >= 0)
        {
            char ch = str.charAt(i);
            if(
                (str.charAt(i) >= 'A'  && str.charAt(i) <= 'Z')
                || (str.charAt(i) >= 'a'  && str.charAt(i) <= 'z')
                || (str.charAt(i) >= '0'  && str.charAt(i) <= '9')
            )
            {
                stackk.push(String.valueOf(ch));
            }
            else
            {
                String t1,t2;
                t1 = stackk.pop();
                t2 = stackk.pop();
                String s =  t1 + t2 + str.charAt(i);
                stackk.push(s);
            }
            i--;
        }
        return stackk.peek();
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

        String ans = postfix(str);

        System.out.println(str+" (Infix) = "+ans+" (Prefix)");

    }
}