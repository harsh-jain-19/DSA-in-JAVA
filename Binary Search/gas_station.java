// MINIMIZE MAX DISTANCE BETWEEN GAS STATION.
// In this problem we will be given an array arr.
// arr will be containing the coordinates of N gas station.
// All the coordinates will be given in sorted order.
// You will be given a number of gas station as k which you have to insert in such a way that:-
// MAXIMUM DISTANCE BETWEEN THE GAS STATIONS IS MINIMUM.

import java.util.*;
public class gas_station
{
    public static void quick_sort(int [] arr, int lb, int ub)
    {
        int partition;
        if(lb < ub)
        {
            partition = sort(arr,lb,ub);
            quick_sort(arr,lb,partition-1);
            quick_sort(arr,partition+1,ub);
        }
    }
    public static int sort(int [] arr, int lb, int ub)
    {
        int pivot,i,j,temp;
        pivot = arr[lb];
        i = lb;
        j = ub;
        while(i < j)
        {
            while(arr[i] <= pivot  && i < ub)
            {
                i++;
            }
            while(arr[j] >= pivot && j > lb)
            {
                j--;
            }
            if(i < j)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[lb];
        arr[lb] = arr[j];
        arr[j] = temp;
        return(j);
    }
    public static int cnt_gasStation(double dist, int []arr, int n)
    {
        int cnt = 0;
        for(int i = 1; i < n-1; i++)
        {
            int numberInBetween = (int) ((arr[i] - arr[i-1]) / dist);
            if((arr[i] - arr[i-1]) / dist == numberInBetween * dist)
            {
                numberInBetween++;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

    public static double search(int [] arr, int n, int k)
    {
        double low,mid,high,ans=0;
        double diff;
        diff = 1e-6;  // Here 1e-6 = 10^ -6.
        low = 0;
        high = 0;
        for (int i = 0; i < n - 1; i++) 
        {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }
        while((high - low) > diff)
        {
            mid = (low + high)/2;
            int cnt = cnt_gasStation(mid,arr,n);
            if(cnt > k)
            {
                low = mid;
            }
            else
            {
                ans = high;
                high = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of gas stations you have.");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the coordinate of "+i+" gas station.");
            arr[i] = sc.nextInt();
        }
        // AS WE KNOW BINARY SEARCH IS ONLY APPLICABLE ON SORTED ARRAY 
        int lb,ub;
        lb = 0;
        ub = n-1;
        quick_sort(arr,lb,ub);

        // BINARY SEARCH
        int k;
        System.out.println("Enter the number of gas stations you want to insert.");
        k = sc.nextInt();
        double ans = search(arr,n,k);
        System.out.println("Maximum Diatance Between Gas Station That Is Minimum = "+ans);

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