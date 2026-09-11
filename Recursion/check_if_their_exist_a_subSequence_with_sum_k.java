import java.util.*;

public class check_if_their_exist_a_subSequence_with_sum_k
{
    public static void helper(String s, int index, StringBuilder curr, List<String> result, int k)
    {
        if(index == s.length())
        {
            if(curr.length() == 0)
            {
                return;
            }
            int num = Integer.parseInt(curr.toString());
            int sum = 0;
            int lastdigit;
            while(num != 0)
            {
                lastdigit = num % 10;
                num = num / 10;
                sum += lastdigit;
            }
    
            if(sum == k)
            {
                result.add(curr.toString());
            }
            
            return;
        }

        helper(s, index+1, curr, result, k);

        curr.append(s.charAt(index));
        helper(s, index+1, curr, result, k);

        curr.deleteCharAt(curr.length() - 1);
    }
    public static List<String> generate(String s, int k)
    {
        List<String> result = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(s, 0, curr, result, k);
        return result;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string of which you want power set with sum k.");
        String s = sc.nextLine();
        System.out.println("Enter the value of k.");
        int k = sc.nextInt();
        List<String> result = new ArrayList<>();
        result = generate(s,k);
        if(!result.isEmpty())
        {
            System.out.println("Yes their is a sub sequence with sum k.");
        }
        else
        {
            System.out.println("No their is not a sub sequence with sum k.");
        }
    }
}  