import java.util.*;
public class leader
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
        // FINDING LEADER
        ArrayList<Integer> leader = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--)
        {
            if(arr[i] > maxi)
            {
                maxi = arr[i];
                leader.add(maxi);
            }
        }
        System.out.println("Leaders are:");
        for(int lead : leader)
        {
            System.out.println(lead);
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