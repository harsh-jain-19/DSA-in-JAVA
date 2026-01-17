// Kth ELEMENT OF TWO SORTED ARRAY
// In this problem we will be given two sorted arrays.
// We have to find the kth element after merging them.

import java.util.*;
public class two_array_kth_element
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
    public static double search(int [] arr1, int arr2[], int n1, int n2, int k)
    {
        if(n1 > n2)
        {
            return (search(arr2,arr1,n2,n1,k));
        }
        int low = Math.max(0,(k-n2));
        int high = Math.min(k,n1);
        int left = k;
        int n = n1 + n2;
        while(low < high)
        {
            int mid1 = (low + high)/2;
            int mid2 = (left - mid1);
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MAX_VALUE;
            int r1 = Integer.MIN_VALUE;
            int r2 = Integer.MIN_VALUE;
            if(mid1 < n1)
            {
                r1 = arr1[mid1];
            }
            if(mid2 < n2)
            {
                r2 = arr2[mid2];
            }
            if((mid1 - 1) >= 0)
            {
                l1 = arr1[mid1-1];
            }
            if((mid2 -1) >= 0)
            {
                l2 = arr2[mid2-1];
            }
            if(l1 <= r2 && l2 <= r1)
            {
                return Math.max(l1,l2);
            }
            else if(l1 > r2)
            {
                high = mid1 -1;
            }
            else
            {
                low = mid1 + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args)
    {
        // First Array
        int n1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an Array1");
        n1 = sc.nextInt();
        int [] arr1 = new int [n1];
        for(int i = 0; i < n1; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr1[i] = sc.nextInt();
        }
        // AS WE KNOW BINARY SEARCH IS ONLY APPLICABLE ON SORTED ARRAY 
        int lb,ub;
        lb = 0;
        ub = n1-1;
        quick_sort(arr1,lb,ub);

        // First Array
        int n2;
        System.out.println("Enter the size of an Array2");
        n2 = sc.nextInt();
        int [] arr2 = new int [n2];
        for(int i = 0; i < n2; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr2[i] = sc.nextInt();
        }
        // AS WE KNOW BINARY SEARCH IS ONLY APPLICABLE ON SORTED ARRAY 
        lb = 0;
        ub = n2-1;
        quick_sort(arr2,lb,ub);

        // BINARY SEARCH
        
        int k;
        System.out.println("Enter the position of kth element.");
        k = sc.nextInt();
        double ans = search(arr1,arr2,n1,n2,k);
        System.out.println("The median of given two arrays = "+ans);

        // PRINTING
        for(int i = 0; i < n1; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr1[i]);
            }
            else
            {
                System.out.print(arr1[i]);
            }
        }
        System.out.println(" ");
        // PRINTING
        for(int i = 0; i < n2; i++)
        {
            if(i!=0)
            {
                System.out.print(","+arr2[i]);
            }
            else
            {
                System.out.print(arr2[i]);
            }
        }
    }
}