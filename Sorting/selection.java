import java.util.Scanner;
public class selection
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,min,temp;
        System.out.println("Enter the size of an array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element of array");
            arr[i] = sc.nextInt();
        }
        // Selection Sort
        for(int i = 0; i < n-1; i++)
        {
            min = i;
            for(int j = i+1; j < n; j++)
            {
                if(arr[min] > arr[j])
                {
                    min = j;
                }
            }
            if (min != i)
            {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
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