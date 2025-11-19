import java.util.Scanner;
public class sorted
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        Boolean b = false;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
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
        for(int i = 0; i < n-1; i++)
        {
            if(arr[i]<=arr[i+1])
            {
                b = true;
            }
            else
            {
                b = false;
                break;
            }
        }
        if(b)
        {
            System.out.println("\nArray is Sorted");
        }
        else
        {
            System.out.println("\nArray is not Sorted");
        }
    }
}