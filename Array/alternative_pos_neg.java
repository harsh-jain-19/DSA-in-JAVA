// In this problem we will take an even aize array as input.
// In which we will have equal number positive and negative elements.
// And we have arrange it in alternative positive and negative elements.
import java.util.Scanner;
public class alternative_pos_neg
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
        // Arranging in Alternate order
        int [] ans = new int[n];
        int pos = 0, neg = 1;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] >= 0)
            {
                ans[pos] = arr[i];
                pos = pos+2;
            }
            else
            {
                ans[neg] = arr[i];
                neg = neg+2;
            }
        }
        // Printing
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
        System.out.println("\nArray After Sorting");
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+ans[i]);
            }
            else
            {
                System.out.print(ans[i]);
            }
        }
    }
}