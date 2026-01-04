// KOKO EATING BANANAS
// In this problem koko will be given some bunches of Bananas.
// We will be representing these bunches in array.
// We will give some time to koko in hours.
// So, we have to find the speed of koko for eating all the bunches of bananas in given time.
// TIME COMPLEXITY = O(log n)
import java.util.*;
public class koko_eating_bananas
{
    public static int hours(int [] arr,int n, int hourly)
    {
        int total_hrs = 0;
        for(int i = 0; i < n; i++)
        {
            int x = (arr[i]+hourly-1) / hourly; // It tells how many hours did one bunch take to
            total_hrs = total_hrs + x;          // be eaten at speed of hourly.
        }
        return total_hrs;
    }
    public static int speed(int [] arr, int n, int time)
    {
        // Here N is last Biggest Element of array.
        int low,high,mid,ans;
        low = 1;
        high = arr[n-1];
        ans = 1;
        int total_hrs = 0;
        while(low <= high)
        {
            mid = (low + high)/2;
            total_hrs = hours(arr,n,mid); // It will tell total hours taken to eat all the bunches
                                          // at the speed of mid.
            if(total_hrs <= time)
            {
                ans = low;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Bunches");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the number of bananas in "+i+" bunch");
            arr[i] = sc.nextInt();
        }

        // BINARY SEARCH
        int time,ans;
        System.out.println("Enter the Time You are giving to KOKO");
        time = sc.nextInt();
        Arrays.sort(arr);
        ans = speed(arr,n,time);
        System.out.println("Minimum Speed In Which KOKO Can Eat All Buches = "+ans+" banana/hour");
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