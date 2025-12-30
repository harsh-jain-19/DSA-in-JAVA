// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class single_element_in_sorted_array_brute
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
        for(int i = 0; i < n-1; i++)
        {
            if( n == 1)
            {
                System.out.println("Single element is "+arr[i]);
            }
            else if(i == 0)
            {
                if( arr[i] != arr[i+1])
                {
                    System.out.println("Single element is "+arr[i]);
                }
            }
            else if(i == n-1)
            {
                if( arr[i] != arr[i-1])
                {
                    System.out.println("Single element is "+arr[i]);
                }
            }
            else
            {
                if(arr[i] != arr[i+1] && arr[i] != arr[i-1])
                {
                    System.out.println("Single element is "+arr[i]);
                }
            }
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