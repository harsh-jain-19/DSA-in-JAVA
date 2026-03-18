// We will be swaping two numbers in this question without using third variable.
import java.util.Scanner;
public class swap_xor
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers you want to swap.");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("a = "+a+" b = "+b);
        System.out.println("SWAPING A AND B......");

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a = "+a+" b = "+b);
    }
}