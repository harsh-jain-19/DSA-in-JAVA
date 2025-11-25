import java.util.Scanner;
public class max_consective_one
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,count=0,max=0;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // COUNTING MAXIMUM ONE
        for(int i = 0; i < n; i++)
        {
            if(arr[i]==1)
            {
                count++;
            }
            else
            {
                count = 0;
            }
            if(count >= max)
            {
                max = count;
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

        System.out.println("\nMaximum Consective 1 in given array are "+max);
    }
}