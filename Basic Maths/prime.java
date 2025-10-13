import java.util.Scanner;
public class prime
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,count = 0;
        System.out.println("Enter the number you want to check is prime or not.");
        n = sc.nextInt();
        // for(int i = 1; i <= n; i++)
        // {
        //     if(n % i == 0)
        //     {
        //         count++;
        //     }
        // } WE WILL NOT USE THIS METHOD
        // Because It has time complexity O(n)

        for(int i = 1; i*i <= n; i++)
        {
            if(n % i == 0)
            {
                count++;
                if(n/i != i)
                {
                    count++;
                }
            }
        }
        // Time Complexity = O(Sq.root(n)).

        if(count == 2)
        {
            System.out.println(n+" is a prime number.");
        }
        else
        {
            System.out.println(n+" is not a prime number.");
        }
    }
}