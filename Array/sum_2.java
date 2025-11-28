import java.util.*;
public class sum_2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,sum,rem=0,count=0;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        // FINDING TWO ELEMENTS 
        HashMap<Integer,Integer> hashh = new HashMap<>();
        System.out.println("Enter the value the sum");
        sum = sc.nextInt();
        for(int i = 0; i < n; i++)
        {
            hashh.put(arr[i], hashh.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = 0; i < n; i++)
        {
            rem = sum - arr[i];
            if(hashh.get(rem) != null)
            {
                System.out.println(rem+" + "+arr[i]+" = "+sum);
                count = 1;
            }
        }
        if(count == 0)
        {
            System.out.println("The Sum You Have Entered Can Not Be Done By Using The Element Of This Array");
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