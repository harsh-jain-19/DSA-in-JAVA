import java.util.*;
public class generate_parenthesis
{
    public static void generate(int n, String curr, List<String> result, int open, int close)
    {
        if(curr.length() == 2*n)
        {
            result.add(curr);
            return;
        }
        if(open < n)
        {
            generate(n, curr + "(", result, open + 1, close );
        }
        if(close < open)
        {
            generate(n, curr + ")", result, open, close + 1);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of given valid parenthesis.");
        int n = sc.nextInt();

        List<String> result = new ArrayList<>();
        
        generate(n, "", result, 0 ,0);

        for(String s : result)
        {
            System.out.println(s+ " ");
        }
        System.out.println();
    }
}