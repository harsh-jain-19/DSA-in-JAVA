// In this problem we have to find all the prime numbers till n.
import java.util.*;
public class primes_from_L_to_R
{
    public static List<Integer> primes(int n)
    {
        List<Integer> ans = new ArrayList<>();
        int [] primes = new int[n+1];
        for(int i = 0; i <= n; i++)
        {
            primes[i] = 1;
        }
        for(int i = 2; i*i <= n; i++)
        {
            if(primes[i] == 1)
            {
                for(int j = i*i; j <= n; j += i)
                {
                    primes[j] = 0;
                }
            }
        }
        for(int i = 2; i <= n; i++)
        {
            if(primes[i] == 1)
            {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number till which you want prime number.");
        n = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        ans = primes(n);
        System.out.println("Prime Numbers Till "+n+" are "+ans);
    }
}