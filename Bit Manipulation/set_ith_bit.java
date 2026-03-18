// In this problem we will be given a number in decimal.
// We have to set its ith bit.
// Set = 1, otherwise 0.

import java.util.Scanner;
public class set_ith_bit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x,i;
        System.out.println("Enter the number whose bit you want to set.");
        x = sc.nextInt();
        System.out.println("Enter the index of bit you want to set");
        i = sc.nextInt();
        System.out.println("X before setting ith bit "+x);

        // Set I th bit
        x = x | (1 << i);
        System.out.println("X after setting ith bit "+x);
    }
}