// TIME COMPLEXITY = O(log n)
// PEAK ELEMENT = Element which is greater then its previous and next element.
import java.util.*;
public class multiple_peak_element
{
    public static ArrayList<Integer> search(int [] arr, int n)
    {
        ArrayList <Integer> ans = new ArrayList<>();

        int low,high,mid;
        low = 1;
        high = n-2;

        if(n == 1)
        {
            ans.add(arr[0]);
            return ans;
        }

        if(arr[0] > arr[1])
        {
            ans.add(arr[0]);
        }

        if(arr[n-1] > arr[n-2])
        {
            ans.add(arr[n-1]);
        }

        while(low <= high)
        {
            mid = (low + high)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            {
                ans.add(arr[mid]);
            }

            else if(arr[mid] > arr[mid-1])
            {
                low = mid + 1;
            }

            else
            {
                high = mid - 1;
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
        // BINARY SEARCH
        ArrayList<Integer> ans = new ArrayList<>();

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
