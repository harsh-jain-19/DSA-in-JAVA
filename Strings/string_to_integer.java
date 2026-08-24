import java.util.*;
public class string_to_integer
{
    public static int str_to_int(String s)
    {
        s = s.trim();
        if(s.length() == 0)
        {
            return 0;
        }

        boolean neg = false;
        long ans = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(i == 0)
            {
                if(ch == '-')
                {
                    neg = true;
                    continue;
                }
                else if(ch == '+')
                {
                    neg = false;
                    continue;
                }
            }

            if(ch >= '0' && ch <= '9')
            {
                int dig = ch - '0';
                ans = ans * 10 + dig;
                if(neg)
                {
                    long check = -ans;
                    if(check < Integer.MIN_VALUE)
                    {
                        return Integer.MIN_VALUE;
                    }
                }
                else 
                {
                    if(ans > Integer.MAX_VALUE)
                    {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            else
            {
                break;
            }
        }
        if(neg)
        {
            ans = -ans;
        }
        return (int)ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String which you want to convert into integer.");
        String str = sc.nextLine();

        System.out.println("String You Have Entered = "+str);

        int str_int = str_to_int(str);
        System.out.println("String "+str+" = "+str_int);
    }
}