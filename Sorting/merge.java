// Time Complexity
// Best Case = O(n log n)
// Worst Case = O( n log n)  
import java.util.Scanner;
public class merge
{
    public static void devide(int[] arr, int lb, int ub)
    {
        int mid;
        if(lb < ub)
        {
            mid = (lb + ub)/2;
            devide(arr,lb,mid);
            devide(arr,mid+1,ub);
            merge(arr,lb,mid,ub);
        }
    }
    public static void merge(int[] arr, int lb, int mid, int ub)
    {
        int [] b = new int [ub+1];
        int left,right,temp;
        left = lb;
        right = mid+1;
        temp = lb;
        while(left <= mid && right <= ub)
        {
            if(arr[left] <= arr[right])
            {
                b[temp] = arr[left];
                temp = temp + 1;
                left = left + 1;
            }
            else
            {
                b[temp] = arr[right];
                temp = temp + 1;
                right = right + 1;
            }
        }
        if(left <= mid)
        {
            while(left <= mid)
            {
                b[temp] = arr[left];
                temp = temp + 1;
                left = left + 1;
            }
        }
        if(right <= ub)
        {
            while(right <= ub)
            {
                b[temp] = arr[right];
                temp = temp + 1;
                right = right + 1;
            }
        }
        for(int i = lb; i < ub+1; i++)
        {
            arr[i] = b[i];
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,lb,ub;
        System.out.println("Enter the size of an array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        lb = 0;
        ub = n-1;
        devide(arr,lb,ub);
        System.out.println("Sorted Array Is Given Below:-");
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