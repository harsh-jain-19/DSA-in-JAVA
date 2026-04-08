// In this Problem we will be given a infix string.
// We have to convert it into prefix string.
import java.util.*;
public class infix_to_prefix
{
    public static int priority(char c) {
        if (c == '^')  // Exponent operator has highest precedence
            return 3;
        else if (c == '/' || c == '*')  // Multiplication and division have higher precedence than addition
            return 2;
        else if (c == '+' || c == '-')  // Addition and subtraction have lowest precedence
            return 1;
        else
            return -1;
    }
    public static String prefix(String original)
    {
        StringBuilder str = new StringBuilder(original).reverse();
        int n = str.length();
        for(int i = 0; i < n; i++)
        {
            if(str.charAt(i) == '(')
            {
                str.setCharAt(i,')');
            }
            else if(str.charAt(i) == ')')
            {
                str.setCharAt(i,'(');
            }
            else if(str.charAt(i) == '[')
            {
                str.setCharAt(i,']');
            }
            else if(str.charAt(i) == ']')
            {
                str.setCharAt(i,'[');
            }
            else if(str.charAt(i) == '{')
            {
                str.setCharAt(i,'}');
            }
            else if(str.charAt(i) == '}')
            {
                str.setCharAt(i,'{');
            }
        }
        String ans = "";
        Stack<Character> stackk = new Stack<>();
        int i = 0;
        while( i < n)
        {
            if(
                (str.charAt(i) >= 'A'  && str.charAt(i) <= 'Z')
                || (str.charAt(i) >= 'a'  && str.charAt(i) <= 'z')
                || (str.charAt(i) >= '0'  && str.charAt(i) <= '9')
            )
            {
                ans = ans + str.charAt(i);
            }
            else if(str.charAt(i) == '(')
            {
                stackk.push(str.charAt(i));
            }
            else if(str.charAt(i) == ')')
            {
                while(stackk.isEmpty() != true && stackk.peek() != '(')
                {
                    ans = ans + stackk.peek();
                    stackk.pop();
                }
                stackk.pop();
            }
            else
            {
                if(str.charAt(i) == '^')
                {
                    while(stackk.isEmpty() != true && priority(str.charAt(i)) <= priority(stackk.peek()))
                    {
                        ans = ans + stackk.peek();
                        stackk.pop();
                    }
                }
                else
                {
                    while(stackk.isEmpty() != true && priority(str.charAt(i)) < priority(stackk.peek()))
                    {
                        ans = ans + stackk.peek();
                        stackk.pop();
                    }
                }
                
                stackk.push(str.charAt(i));
            }
            i++;
        }
        while(stackk.isEmpty() != true)
        {
            ans = ans + stackk.peek();
            stackk.pop();
        }
        ans = new StringBuilder(ans).reverse().toString();
        return ans;
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

        String ans = prefix(str);

        System.out.println(str+" (Infix) = "+ans+" (Prefix)");

    }
}