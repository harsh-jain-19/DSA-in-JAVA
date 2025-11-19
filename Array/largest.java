import java.util.Scanner;
public class largest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,a=Integer.MIN_VALUE;
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
            if(arr[i]>a)
            {
                a = arr[i];
            }
            if(i!=0)
            {
                System.out.print(","+arr[i]);
            }
            else
            {
                System.out.print(arr[i]);
            }
        }
        System.out.println("\nBiggest Element from the given Array is "+a);
    }
}