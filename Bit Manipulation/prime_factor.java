// In this problem we will bw given an number.
// We have to find its prime factors.
import java.util.*;
public class prime_factor
{
    public static List<Integer> primeFactors(int n)
    {
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++)
        {
            if(n % i == 0)
            {
                ans.add(i);
                while(n % i == 0)
                {
                    n = n / i;
                }
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number whose prime factor you want to find.");
        n = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        ans = primeFactors(n);
        System.out.println("Prime Factors of "+n+" = "+ans);
    }
}