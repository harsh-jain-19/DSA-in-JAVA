import java.util.Scanner;
public class remove_duplicate
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
        // REMOVING DUPLICATES
        int x = 0;
        for(int y = 1; y < n; y++)
        {
            if(arr[x]!=arr[y])  // Finding Unique Element
            {
                arr[x+1] = arr[y]; // Placing the unique element next to the first unique element
                x++;               // Increasing the index of unique element by 1.
            }
        }
        n = x+1;
        System.out.println("\nAfter removing duplicates");
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