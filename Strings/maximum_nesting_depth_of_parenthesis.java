import java.util.*;
public class maximum_nesting_depth_of_parenthesis
{
    public static int depth(String s)
    {
        int cnt = 0;
        int depth = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                cnt++;
            }
            depth = Math.max(cnt,depth);
            if(s.charAt(i) == ')')
            {
                cnt--;
            }
        }
        return depth;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string whose depth you want to calculate.");
        String str = sc.nextLine();

        System.out.println("String You Have Entered = "+str);

        int max_depth = depth(str);
        System.out.println("Maximum nesting depth of parenthesis = "+max_depth);
    }
}