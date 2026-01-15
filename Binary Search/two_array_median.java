// MEDIAN OF TWO SORTED ARRAY
// In this problem we will be given two sorted independent array.
// These Two Array Can Be Of Any Possible lenght.
// We have to find median of them.
// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class two_array_median
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
    public static double search(int [] arr1, int n1, int arr2[], int n2)
    {
        int i = 0;
        int j = 0;
        int n = (n1 + n2);
        int index2 = n/2;
        int index1 = index2 - 1;
        int cnt = 0;
        int index1_el = -1;
        int index2_el = -1;
        while(i < n1 && j < n2)
        {
            if(arr1[i] < arr2[j])
            {
                if(cnt == index1)
                {
                    index1_el = arr1[i];
                }
                if(cnt == index2)
                {
                    index2_el = arr1[i];
                }
                cnt++;
                i++;
            }
            else
            {
                if(cnt == index1)
                {
                    index1_el = arr2[j];
                }
                if(cnt == index2)
                {
                    index2_el = arr2[j];
                }
                cnt++;
                j++;
            }
        }
        while(i < n1)
        {
            if(cnt == index1)
            {
                index1_el = arr1[i];
            }
            if(cnt == index2)
            {
                index2_el = arr1[i];
            }
            cnt++;
            i++;
        }
        while(j < n2)
        {
            if(cnt == index1)
            {
                index1_el = arr2[j];
            }
            if(cnt == index2)
            {
                index2_el = arr2[j];
            }
            cnt++;
            j++;
        }
        if((n % 2) == 0)
        {
            double ans = (index1_el +index2_el)/2;
            return ans;
        }
        else
        {
            return (double)index2_el;
        }
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
        
        double ans = search(arr1,n1,arr2,n2);
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