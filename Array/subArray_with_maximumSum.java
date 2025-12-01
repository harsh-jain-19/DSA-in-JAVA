// KADANE'S ALGORITHM
import java.util.Scanner;
public class subArray_with_maximumSum
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
        // FINDING SUBARRAY WITH MAXIMUM SUM
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        int start=0,ansStart=-1,ansEnd=-1;

        for(int i = 0; i < n; i++)
        {
            if(sum == 0)
            {
                start = i;
            }
            sum = sum + arr[i];
            if(sum > maxi)
            {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }
            if(sum < 0)
            {
                sum = 0;
            }
        }
        System.out.println("Sub Array With Maximum Sum is :");
        for(int i = ansStart; i <= ansEnd; i++)
        {
            if(i!=ansStart)
            {
                System.out.print(","+arr[i]);
            }
            else
            {
                System.out.print(arr[i]);
            }
        }
        System.out.println(" = "+maxi);
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