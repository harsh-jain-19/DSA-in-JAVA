import java.util.Scanner;
public class divisor
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,a=0;
        System.out.println("Enter the number which you want to find all divisors");
        n = sc.nextInt();
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                System.out.println(i+" devides "+n);
                a++;
            }
        }
        System.out.println("Total "+a+" numbers devides "+n);
    }
}