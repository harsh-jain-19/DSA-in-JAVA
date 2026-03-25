// In This Problem we will be given an integer n.
// We have to find the XOR of all number till n.
// Example n = 5.
// XOR = 1 ^ 2 ^ 3 ^ 4 ^ 5.
import java.util.Scanner;
public class xor_all_numbers_till_n
{
    public static int xor_all(int n)
    {
        if(n % 4 == 1)
        {
            return 1;
        }
        else if(n % 4 == 2)
        {
            return n + 1;
        }
        else if(n % 4 == 3)
        {
            return 0;
        }
        else
        {
            return n;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number till which you want Xor of all numbers.");
        n = sc.nextInt();
        int ans = xor_all(n);
        System.out.println("Xor of all numbers till "+n+" = "+ans);
    }
}