import java.util.Scanner;
public class linear_search
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,x,a=0;
        System.out.println("Enter the Size of an array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" Element");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element which you want to find in array");
        x = sc.nextInt();
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
        for(int i = 0; i < n; i++)
        {
            if(x == arr[i])
            {
                System.out.println("\n"+x+" is present at "+i+" index");
                a = 1;
            }
        }
        if(a != 1)
        {
            System.out.println("\n"+x+" is not present in the array");
        }
    }
}