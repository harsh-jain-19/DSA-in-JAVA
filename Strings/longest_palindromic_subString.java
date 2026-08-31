import java.util.*;
public class longest_palindromic_subString
{
    public static String find_longest_palindromic_subString(String s)
    {
        if(s.length() <= 1)
        {
            return s;
        }

        String ans = "";

        for(int i = 1; i < s.length(); i++)
        {
            int low = i;
            int high = i;

            while(s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;
                if(low == -1 || high == s.length())
                {
                    break;
                }
            }
            String palindrome = s.substring(low+1, high);
            if(palindrome.length() > ans.length())
            {
                ans = palindrome;
            }

            // Consider Even Length
            low = i - 1;
            high = i;

            while(s.charAt(low) == s.charAt(high))
            {
                low--;
                high++;
                if(low == -1 || high == s.length())
                {
                    break;
                }
            }
            palindrome = s.substring(low+1, high);
            if(palindrome.length() > ans.length())
            {
                ans = palindrome;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string fromm which you have to find longest palindromic subString.");
        String s = sc.nextLine();

        System.out.println("Strings you have Entered = "+s);
        

        String subString = find_longest_palindromic_subString(s);
        System.out.println("Longest Palindromic subString = "+subString);
        
    }
}