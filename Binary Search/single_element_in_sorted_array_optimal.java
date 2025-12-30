// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class single_element_in_sorted_array_optimal
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
        low = 1;
        high = n-2;

        if(n == 1)
        {
            return arr[0];
        }

        if(arr[0] != arr[1])
        {
            return arr[0];
        }

        if(arr[n-1] != arr[n-2])
        {
            return arr[n-1];
        }

        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
            {
                return arr[mid];
            }
            else if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid % 2 == 0 && arr[mid] == arr[mid +1]))
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
            
        }
        return 0;
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
        int ans = search(arr,n);
        System.out.println("Single Element Is "+ans);
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