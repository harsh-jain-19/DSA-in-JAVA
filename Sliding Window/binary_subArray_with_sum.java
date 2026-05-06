// In this problem you will be given an array containing 0 and 1.
// You will also be given an integer sum.
// You have to return the number of subArray with sum.
import java.util.Scanner;

public class binary_subArray_with_sum
{
    public static int number_of_subArray(int nums[], int goal)
    {
        if(goal < 0)
        {
            return 0;
        }
        int l = 0, r = 0, cnt = 0, sum = 0;
        while(r < nums.length)
        {
            sum = sum + nums[r];
            while(sum > goal)
            {
                sum = sum - nums[l];
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            // You only give input as 0,1.
            arr[i] = sc.nextInt(2);
        }

        System.out.println("Enter the Sum.");
        int k = sc.nextInt();

        int subArray = number_of_subArray(arr,k) - number_of_subArray(arr,k-1);
        System.out.println("Number of subArray with sum "+k+" = "+subArray);
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