// MOORE'S VOTING ALGORITHM
// IN THIS ALGO WE WILL FIND MAJORITY ELEMENT(>N/2)
import java.util.Scanner;
public class majority
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
        // FINDING MAJORITY ELEMENT BIGGER THEN N/2
        int el=0,count=0,count2=0;
        for(int i = 0; i < n; i++)
        {
            if(count == 0)
            {
                count = 1;
                el = arr[i];
            }
            else if(el == arr[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        for(int i = 0; i < n; i++)
        {
            if(el == arr[i])
            {
                count2++;
            }
        }
        if(count2 > n/2)
        {
            System.out.println(el+" appear more then size of half array times");
        }
        else
        {
            System.out.println("No element appears more then size of half array times");
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
    }
}