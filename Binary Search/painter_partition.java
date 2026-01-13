// PAINTER'S PARTITION OR SPLIT ARRAY LARGEST SUM
// In this problem we will be given array arr.
// arr will be representing number of units each portion have.
// We will be given a number of painters as k.
// RULES
// 1. Every Painter Should Get Atlest One Portion Of Units.
// 2. Portions will be assigned in consective manner to painters.
// OUR TASK IS TO ASSIGN THE PORTIONS TO THE K PAINTERS IN SUCH A WAY THAT:-
// MAXIMUM TIME THEY TAKE TO COMPLETE THEIR TASK IS MINIMUM.

import java.util.Scanner;
public class painter_partition
{
    public static int max_element(int [] arr, int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    public static int sum_array(int [] arr, int n)
    {
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            ans += arr[i];
        }
        return ans;
    }

    public static int count_painter(int [] arr, int units_allowed, int n)
    {
        int painter = 1;
        int paint_unit = 0;
        for(int i = 0; i < n; i++)
        {
            if((paint_unit + arr[i]) <= units_allowed)
            {
                paint_unit += arr[i];
            }
            else
            {
                painter++;
                paint_unit = arr[i];
            }
        }
        return painter;
    }

    public static int search(int [] arr, int n, int k)
    {
        if(k > n)
        {
            System.out.println("Number of painters are then number of portions.");
            return 0;
        }
        int low,high,mid;
        low = max_element(arr,n);
        high = sum_array(arr,n);
        while(low <= high)
        {
            mid = (low + high)/2;
            int cnt_painter;
            cnt_painter = count_painter(arr,mid,n);
            if(cnt_painter <= k)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of portions you have.");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the units in "+i+" portion.");
            arr[i] = sc.nextInt();
        }
        
        // BINARY SEARCH
        int k;
        System.out.println("Enter the number of painters you have.");
        k = sc.nextInt();
        int ans = search(arr,n,k);
        System.out.println("Maximum Number Of Units That Are Minimum = "+ans);

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