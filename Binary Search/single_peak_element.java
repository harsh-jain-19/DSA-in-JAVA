// TIME COMPLEXITY = O(log n)
// PEAK ELEMENT = Element which is greater then its previous and next element.
import java.util.Scanner;
public class single_peak_element
{
    public static int search(int [] arr, int n)
    {
        int low,high,mid;
        low = 1;
        high = n-2;

        if(n == 1)
        {
            return arr[0];
        }

        if(arr[0] > arr[1])
        {
            return arr[0];
        }

        if(arr[n-1] > arr[n-2])
        {
            return arr[n-1];
        }

        while(low <= high)
        {
            mid = (low + high)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            {
                return arr[mid];
            }
            else if(arr[mid] < arr[mid+1])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
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
        // BINARY SEARCH
        int ans;
        ans = search(arr,n);
        System.out.println("Peak Element Is "+ans);
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