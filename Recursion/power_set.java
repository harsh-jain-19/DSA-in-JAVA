import java.util.*;

public class power_set
{
    public static void helper(String s, int index, StringBuilder curr, List<String> result)
    {
        if(index == s.length())
        {
            result.add(curr.toString());
            return;
        }

        helper(s, index+1, curr, result);

        curr.append(s.charAt(index));
        helper(s, index+1, curr, result);

        curr.deleteCharAt(curr.length() - 1);
    }
    public static List<String> generate(String s)
    {
        List<String> result = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(s, 0, curr, result);
        return result;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string of which you want power set.");
        String s = sc.nextLine();
        List<String> result = new ArrayList<>();
        result = generate(s);
        System.out.println("Power of set of "+s+" = "+result);
    }
}