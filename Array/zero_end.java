import java.util.Scanner;
public class zero_end
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,j=-1,temp;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // Putting zeros in end
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == 0 )
            {
                j = i;
                break;
            }
        }
        for(int i = j+1; i < n; i++)
        {
            if(arr[i] != 0)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        // Printing
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