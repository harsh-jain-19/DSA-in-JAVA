// In this problem we will be given a number in decimal.
// We have to remove its last set bit.

import java.util.Scanner;
public class remove_last_set_bit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x,i;
        System.out.println("Enter the number whose rightmost bit you want to remove.");
        x = sc.nextInt();
        System.out.println("X before clearing ith bit "+x);

        // Remove last (rightmost) set bit.
        x = x & (x - 1);
        System.out.println("X after clearing ith bit "+x);
    }
}