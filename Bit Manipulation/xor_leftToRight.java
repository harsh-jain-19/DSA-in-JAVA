// In This Problem we will be given two integers left and right.
// We have to find the XOR of all number from left to right.
// Example left = 5 and right = 8.
// XOR = 5 ^ 6 ^ 7 ^ 8.
import java.util.Scanner;
public class xor_leftToRight
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
        int left,right;
        System.out.println("Enter the number from which you want Xor of all numbers.");
        left = sc.nextInt();
        System.out.println("Enter the number till which you want Xor of all numbers.");
        right = sc.nextInt();
        int ans = xor_all(left - 1) ^ xor_all(right);
        System.out.println("Xor of all numbers from "+left+" to "+right+" = "+ans);
    }
}