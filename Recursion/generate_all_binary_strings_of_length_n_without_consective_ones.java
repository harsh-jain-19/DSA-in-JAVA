import java.util.*;

public class generate_all_binary_strings_of_length_n_without_consective_ones
{
    public static void generate(int n, String curr, List<String> result)
    {
        if(curr.length() == n)
        {
            result.add(curr);
            return;
        }
        generate(n, curr + '0', result);
        if(curr.isEmpty() || curr.charAt(curr.length() - 1) != '1')
        {
            generate(n, curr + '1', result);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n.");
        int n = sc.nextInt();

        List<String> result = new ArrayList<>();
        
        generate(n, "", result);

        for(String s : result)
        {
            System.out.println(s+ " ");
        }
        System.out.println();
    }
}