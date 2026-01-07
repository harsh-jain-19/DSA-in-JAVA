// SMALLEST DIVISOR GIVEN A THRESHOLD
// According to this problem we have to find the value which devides all the elements of array.
// After deviding we take the ceil of factrional values and keep integer values same. 
// Then sum of all the (ceils and normal int values) Should be less then equal to threshold value.
// TIME COMPLEXITY = O(log n)
import java.util.Scanner;
public class smallest_divisor
{
    public static int max_element(int [] arr, int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

    public static int search(int [] arr, int n, int threshold)
    {
        int low,high,mid,ans=0;
        low = 1;
        high = max_element(arr,n);
        while(low <= high)
        {
            mid = (low + high)/2;
            int sum = 0;
            
            for(int i = 0; i < n; i++)
            {
                sum += (arr[i] + mid - 1) / mid;  // CALCULATING CEIL
            }
            if(sum <= threshold)
            {
                high = mid -1;
                ans = mid;
            }
            else
            {
                low = mid + 1;
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
        int threshold;
        System.out.println("Enter the THRESHOLD value.");
        threshold = sc.nextInt();

        int ans = search(arr,n,threshold);
        System.out.println("SMALLEST DIVISOR = "+ans);
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