import java.util.*;
public class longest_common_prefix
{
    public static String find_longest_common_prefix(String [] strs)
    {
        StringBuilder prefix = new StringBuilder();
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        
        {
            if(first.charAt(i) != last.charAt(i))
            {
                return prefix.toString();
            }
            prefix.append(first.charAt(i));
        }
        return prefix.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of strings you have.");
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the value of "+i+"string.");
            strs[i] = sc.nextLine();
        }

        System.out.println("Strings you have Entered.");
        for(int i = 0; i < n; i++)
        {
            System.out.print(strs[i]+" ,");
        }

        String prefix = find_longest_common_prefix(strs);
        if(prefix == "")
        {
            System.out.println("\nLongest Common Prefix = null");
        }
        else
        {
            System.out.println("\nLongest Common Prefix = "+prefix);
        }
        
    }
}
