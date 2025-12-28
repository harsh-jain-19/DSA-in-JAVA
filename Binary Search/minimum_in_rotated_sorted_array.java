// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class minimum_in_rotated_sorted_array
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


    public static int search(int [] arr, int n)
    {
        int low,high,mid;
        low = 0;
        high = n-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[low] <= arr[mid]) //Means Left Half Of Array Is Sorted.
            {
                if(arr[low] < ans)
                {
                    ans = arr[low];
                }
                low = mid+1;
            }
            else  //Means Right Half Of Array Is Sorted.
            {
                if(arr[mid] < ans)
                {
                    ans = arr[mid];
                }
                high = mid-1;
            }
        }
        return ans;
    }


    public static void rotate(int [] arr, int n)
    {
        Scanner sc = new Scanner(System.in);
        int d,temp;
        System.out.println("\nEnter from how many places you want to rotate array.");
        d = sc.nextInt();
        d = d % n; // For Optimisation
        for(int j = 0; j < d; j++)
        {
            temp = arr[n-1];
            for(int i = n-2; i >= 0; i--)
            {
                arr[i+1] = arr[i];
            }
            arr[0] = temp;
        }
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

        // ROTATING
        rotate(arr,n);

        // BINARY SEARCH
        int ans;
        ans = search(arr,n);
        System.out.println("Smallest Value is "+ans);

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