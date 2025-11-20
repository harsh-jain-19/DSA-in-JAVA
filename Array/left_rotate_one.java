import java.util.Scanner;
public class left_rotate_one
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,temp;
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
        // Rotating Array from left by one.
        temp = arr[0];
        for(int i = 1; i < n; i++)
        {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        System.out.println("\nAfter Roatation");
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