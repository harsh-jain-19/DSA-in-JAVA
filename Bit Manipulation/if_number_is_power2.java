// In this problem we will be given a number in decimal.
// We have to check that it is off power 2 or not.

import java.util.Scanner;
public class if_number_is_power2
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x,i;
        System.out.println("Enter the number which you want to check is off power 2 or not.");
        x = sc.nextInt();

        // Checking if number is of power 2 or not.
        if((x & (x-1)) == 0)
        {
            System.out.println(x+" is a power of 2");
        }
        else
        {
            System.out.println(x+" is not a power of 2");
        }
    }
}