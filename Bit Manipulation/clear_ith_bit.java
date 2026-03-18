// In this problem we will be given a number in decimal.
// We have to clear its ith bit.
// Clear here means convert 1 to 0 and if it is 0 do not do anything.

import java.util.Scanner;
public class clear_ith_bit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x,i;
        System.out.println("Enter the number whose bit you want to clear.");
        x = sc.nextInt();
        System.out.println("Enter the index of bit you want to clear");
        i = sc.nextInt();
        System.out.println("X before clearing ith bit "+x);

        // clear I th bit
        x = x & (~(1 << i));
        System.out.println("X after clearing ith bit "+x);
    }
}