import java.util.*;
public class count_number_of_odd_digits_in_a_number
{
    public static int numberOfOddDigits(int n)
    {
        int cnt = 0;
        int lastdigit;
        while(n != 0)
        {
            lastdigit = n % 10;
            n = n / 10;
            if(lastdigit % 2 != 0)
            {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number whose odd digits you want to count.");
        int n = sc.nextInt();
        int x = numberOfOddDigits(n);
        System.out.println("Number of odd digits in "+n+" = "+x);
    }
}