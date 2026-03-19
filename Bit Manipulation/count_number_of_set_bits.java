// In this problem we will be given a number in decimal.
// We have to count the number of set bits.

import java.util.Scanner;
public class count_number_of_set_bits
{
    public static int count(int x)
    {
        int cnt = 0;
        while(x > 0)
        {
            if(x % 2 == 1)
            {
                cnt++;
            }
            x = x / 2;
        }
        return cnt;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int x,i;
        System.out.println("Enter the number of which you want to count set bits.");
        x = sc.nextInt();

        // Counting the number of set bits.
        int result = count(x);
        System.out.println("Number of set bits in "+x+" = "+result);
    }
}