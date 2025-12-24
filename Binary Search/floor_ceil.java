// FLOOR  = Largest number in array <= x.
// CEIL = Smallest number in array >= x.
// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class floor_ceil
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
    public static int ceil(int [] arr, int n, int target)
    {
        int low,high,mid,ans;
        low = 0;
        high = n-1;
        ans = -1;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[mid] >= target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int floor(int [] arr, int n, int target)
    {
        int low,high,mid,ans;
        low = 0;
        high = n-1;
        ans = -1;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[mid] <= target)
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // AS WE KNOW BINARY SEARCH IS ONLY APPLICABLE ON SORTED ARRAY 
        int lb,ub;
        lb = 0;
        ub = n-1;
        quick_sort(arr,lb,ub);
        // BINARY SEARCH
        int target;
        System.out.println("Enter the element.");
        target = sc.nextInt();
        int ceil = ceil(arr,n,target);
        int f = floor(arr,n,target);
        if(ceil == -1)
        {
            System.out.println("Number you Entered has no ceil in given array.");
        }
        else
        {
            System.out.println("CEIL = "+arr[ceil]);
        }
        if(f == -1)
        {
            System.out.println("Number you Entered has no floor in given array.");
        }
        else
        {
            System.out.println("FLOOR = "+arr[f]);
        }
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