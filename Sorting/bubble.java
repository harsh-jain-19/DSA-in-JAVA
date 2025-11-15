// Time complexity
// Best Case = O(n)
// Worst Case = O(n*n)
import java.util.Scanner;
public class bubble
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,temp;
        System.out.println("Enter the size of an array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element of array");
            arr[i] = sc.nextInt();
        }
        // Bubble Sort
        for(int i = 0; i < n-1; i++)
        {
            int swap = 0; // For Optimisation
            for(int j = 0; j < n-1-i; j++)
            {
                if(arr[j]>arr[j+1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = 1; //For Optimisation
                }
            }
            if(swap == 0) //For Optimisation
            {
                break;
            }
        }
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