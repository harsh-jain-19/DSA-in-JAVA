// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class intro_itrative
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
    public static void search(int [] arr, int n, int target)
    {
        int low,high,mid;
        low = 0;
        high = n-1;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[mid] == target)
            {
                System.out.println("Element is present at "+(mid+1)+" position.");
                break;
            }
            else if(arr[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        if(low > high)
        {
            System.out.println("Element you are searching is not present in the array");
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
        // BINARY SEARCH
        int target;
        System.out.println("Enter the element you are finding.");
        target = sc.nextInt();
        search(arr,n,target);
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