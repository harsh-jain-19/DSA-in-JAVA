import java.util.Scanner;
public class right_rotate_n
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,temp,d;
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
        // Rotating Array from left by n places.

        System.out.println("\nEnter from how many places you want to rotate array.");
        d = sc.nextInt();
        d = d % n; // For Optimisation
        for(int j = 0; j < d; j++)
        {
            temp = arr[n-1];
            for(int i = n-2; i >= 0; i--)
            {
                arr[i+1] = arr[i];
            }
            arr[0] = temp;
        }
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