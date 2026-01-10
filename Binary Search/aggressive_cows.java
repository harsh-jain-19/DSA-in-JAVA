// AGGRESSIVE COWS
// In this problem we be given an array arr.
// arr will be representing the coordinates of each stall you have.
// We will be given a number of cows.
// So, The task is that we have to place one cow in each stall in such a manner
// That (MINIMUM DISTANCE BETWEEN COWS) IS MAXIMUM.
// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class aggressive_cows
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

    public static int canWePlace(int [] arr, int distance, int cows, int n)
    {
        int countCow = 1;
        int lastCow = arr[0];
        for(int i = 1; i < n; i++)
        {
            if((arr[i] - lastCow) >= distance )
            {
                countCow++;
                lastCow = arr[i];
            }
        }
        if(countCow >= cows)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static int search(int [] arr, int n, int cows)
    {
        int low,high,mid;
        low = 1;
        high = arr[n-1] - arr[0];
        
        while(low <= high)
        {
            mid = (low + high)/2;
            if(canWePlace(arr,mid,cows,n) == 1)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stalls you have.");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the coordinate of "+i+" stall");
            arr[i] = sc.nextInt();
        }

        // AS WE KNOW BINARY SEARCH IS ONLY APPLICABLE ON SORTED ARRAY 
        int lb,ub;
        lb = 0;
        ub = n-1;
        quick_sort(arr,lb,ub);

        // BINARY SEARCH
        int cows;
        System.out.println("Enter the number of cows you have.");
        cows = sc.nextInt();
        int ans = search(arr,n,cows);
        System.out.println("(Minimum Distance Between Cows) That Is Maximum = "+ans);

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