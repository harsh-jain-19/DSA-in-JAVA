// In this problem we will be given a number in decimal.
// We have to check that its i th bit is set or not.
// Set = 1, otherwise 0.

import java.util.Scanner;
public class i_th_bit_set_or_not
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x,i;
        System.out.println("Enter the number whose bit you want to check.");
        x = sc.nextInt();
        System.out.println("Enter the index of bit you want to check");
        i = sc.nextInt();

        if((x & (1 << i)) != 0)
        {
            System.out.println(x+"'s "+i+" bit is set.");
        }
        else
        {
            System.out.println(x+"'s "+i+" bit is not set.");
        }
    }
}