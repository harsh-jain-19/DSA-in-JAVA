// CONCEPT OF BUCKETS
// In this problem we will be given an array.
// Array will have two distinct single numbers.
// All other numbers will be in pairs.
// We have to find two distinct single numbers.
import java.util.Scanner;
public class two_single_element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // Finding Two Distinct Single Element In Double

        int xorr = 0;
        for(int i = 0; i < n; i++)
        {
            xorr = xorr^arr[i];
        }
        int rightmost = (xorr & (xorr - 1)) ^ xorr;
        int  b1 = 0, b2 = 0;
        for (int i = 0; i < n; i++)
        {
            if((arr[i] & rightmost) != 0)
            {
                b1 = b1 ^ arr[i];
            }
            else
            {
                b2 = b2 ^ arr[i];
            }
        }
        System.out.println("Single elements in array are "+b1+" , "+b2);

        // PRINTING
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr[i]);
            }
            else
            {
                System.out.print(arr[i]);
            }
        }
    }
}