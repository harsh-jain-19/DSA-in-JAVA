// LEAST CAPACITY TO SHIP PACKAGES WITHIN D DAYS
// In this problem we will be given a array weight[]
// weight is representing a weight of given packages.
// We will also given a number of days to ship all these packages as d.
// Ship only take one round a day.
// So, we have to find a least capacity ship should have in order to ship all the packages in
// given number of days.
// TIME COMPLEXITY = O(log n)
import java.util.*;
public class ship_packages
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
    public static int days_req(int [] weight, int capacity, int n)
    {
        int day = 1;
        int load = 0;
        for(int i = 0; i < n; i++)
        {
            if((load + weight[i]) > capacity)
            {
                day = day + 1;
                load = weight[i];
            }
            else
            {
                load += weight[i];
            }
        }
        return day;
    }
    public static int search(int [] weight, int n, int days)
    {
        int low,high,mid;
        low = max_element(weight,n);
        high = sum_array(weight,n);

        while(low <= high)
        {
            mid = (low + high)/2;
            int daysReq = days_req(weight,mid,n);
            if(daysReq <= days)
            {
                high = mid - 1;
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
        System.out.println("Enter the number of packages you have");
        n = sc.nextInt();
        int [] weight = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the weight of "+i+" package");
            weight[i] = sc.nextInt();
        }

        // BINARY SEARCH

        int days;
        System.out.println("Enter the number of days in which you want to ship all the packages.");
        days = sc.nextInt();
        int cap = search(weight,n,days);

        System.out.println("Minimum Capacity = "+cap);

        // PRINTING
        for(int i = 0; i < n; i++)
        {
            if(i!=0)
            {
                System.out.print(","+weight[i]);
            }
            else
            {
                System.out.print(weight[i]);
            }
        }
    }
}
