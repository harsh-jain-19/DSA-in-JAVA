// FIND Kth MISSING NUMBER FROM ARRAY
// In this problem an array is given in increasing order.
// Assume that array is from 1 to largest number present in given array.
// So, we have to find Kth missing number in given array.
// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class find_missing_number
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
    public static int search(int [] arr, int n, int k)
    {
        int low,high,mid;
        low = 0;
        high = n-1;
        while(low <= high)
        {
            mid = (low + high)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        int ans = high + k + 1; // OR low + k
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
        // SORTING
        int lb,ub;
        lb = 0;
        ub = n-1;
        quick_sort(arr,lb,ub);
        // BINARY SEARCH
        int k;
        System.out.println("Enter the Kth missing element's index.");
        k = sc.nextInt();
        
        int ans = search(arr,n,k);
        System.out.println("Kth Missing Element = "+ans);
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