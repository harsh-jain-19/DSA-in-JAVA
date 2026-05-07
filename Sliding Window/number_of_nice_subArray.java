// In this problem you will be given an array containing integers.
// You will also be given an integer k.
// You to return number of subArrays with k odd integers.

import java.util.Scanner;
public class number_of_nice_subArray
{
    public static int cnt_nice(int nums[], int k)
    {
        if(k < 0)
        {
            return 0;
        }
        int l = 0, r = 0, cnt = 0, sum = 0;
        while(r < nums.length)
        {
            sum = sum + (nums[r] % 2);
            while(sum > k)
            {
                sum = sum - (nums[l] % 2);
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
        System.out.println("Enter the number of elements you have.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element.");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number of odd element you want.");
        int k = sc.nextInt();

        int cnt = cnt_nice(arr,k) - cnt_nice(arr,k-1);
        System.out.println("Number of nice subArray = "+cnt);

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