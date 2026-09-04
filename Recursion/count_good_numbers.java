import java.util.*;

public class count_good_numbers
{
    static final long MOD = 1000000007;

    public static long power(long x, long n)
    {
        if(n == 0)
        {
            return 1;
        }

        long temp = power(x, n / 2);

        long res = (temp * temp) % MOD;

        if(n % 2 == 1)
        {
            res = (res * x) % MOD;
        }

        return res;
    }

    public static long find_count(long n)
    {
        long even = n / 2;
        long odd = n / 2;

        if(n % 2 == 1)
        {
            even++;
        }

        return (power(5, even) * power(4, odd)) % MOD;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number n from which you want good numbers.");
        long n = sc.nextLong();

        long good_numbers = find_count(n);

        System.out.println("Total Good numbers = " + good_numbers);
    }
}