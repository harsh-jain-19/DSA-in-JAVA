// We will solve this problem by using dutch national flag algorithm.
// TIME COMPLEXITY = O(n)
// SPACE COMPLEXITY = O(1)
import java.util.Scanner;
public class dutch_sort_0_1_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            // You only give input as 0,1,2.
            arr[i] = sc.nextInt(3);
        }
        // SORTING 0,1,2 ARRAY
        int low,mid,high,temp;
        low = 0;
        mid = 0;
        high = n-1;
        while(mid <= high)
        {
            if(arr[mid] == 0)
            {
                temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            }
            else if(arr[mid] == 1)
            {
                mid++;
            }
            else if(arr[mid] == 2)
            {
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
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