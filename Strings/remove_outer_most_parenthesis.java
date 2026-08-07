// In this problem you will be given an string of valid parenthesis.
// You have to remove outer most parenthesis.

import java.util.*;
public class remove_outer_most_parenthesis
{
    public static String remove_outermost_parenthesis(String s)
    {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                if(st.size() > 0)
                {
                    sb.append(ch);
                }
                st.push(ch);
            }
            else
            {
                st.pop();
                if(st.size() > 0)
                {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the valid parenthesis string.");
        String str = sc.next();

        System.out.println("String You Have Entered = "+str);

        String strr = remove_outermost_parenthesis(str);
        System.out.println("String after removing outer most Parenthesis = "+strr);
    }
}