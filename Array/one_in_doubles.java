import java.util.Scanner;
public class one_in_doubles
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,xor=0;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // Finding Single Element In Double
        for(int i = 0; i < n; i++)
        {
            xor = xor^arr[i];
        }
        System.out.println("Single element in array is "+xor);
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