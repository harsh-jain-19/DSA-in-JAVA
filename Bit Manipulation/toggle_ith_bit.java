// In this problem we will be given a number in decimal.
// We have to toggle its i'th bit.
// Toggle here means convert 1 to 0 and 0 t0 1.

import java.util.Scanner;
public class toggle_ith_bit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x,i;
        System.out.println("Enter the number whose bit you want to toggle.");
        x = sc.nextInt();
        System.out.println("Enter the index of bit you want to toggle");
        i = sc.nextInt();
        System.out.println("X before clearing ith bit "+x);

        // Toggle I th bit
        x = x ^ (1 << i);
        System.out.println("X after clearing ith bit "+x);
    }
}