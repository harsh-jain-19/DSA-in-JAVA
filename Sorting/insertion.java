// Time complexity
// Best Case =
// Worst Case =
import java.util.Scanner;
public class insertion
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
        // Insertion Sort
        for(int i = 0; i < n; i++)
        {
            int j=i;
            while(j > 0 && arr[j]<arr[j-1])
            {
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
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