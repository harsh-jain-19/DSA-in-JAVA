import java.util.*;
public class sliding_window_maximum_brute
{
    public static List<Integer> find_swm(int [] nums, int k)
    {
        int n = nums.length;
        List<Integer> swm = new ArrayList<>();
        if(k > n)
        {
            return swm;
        }
        for(int i = 0; i <= n-k; i++)
        {
            int maxi = 0;
            for(int j = i; j <= i+k-1; j++)
            {
                maxi = Math.max(maxi,nums[j]);
            }
            swm.add(maxi);
        }
        return swm;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of your array.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the length of your window");
        int k = sc.nextInt();

        List<Integer> swm = new ArrayList<>();
        swm = find_swm(arr,k);

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

        System.out.println("\nSliding Window Maximum = "+swm);
    }
}