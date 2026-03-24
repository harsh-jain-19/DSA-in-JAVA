// Set of the sub sets of an given array  is called power set.
import java.util.*;
public class power_set
{
    public static List<List<Integer>> power(int [] nums)
    {
        int n = nums.length;
        int subsets = 1 << n;   // Means 2^n.
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < subsets; i++)
        {
            List<Integer> xyz = new ArrayList<>();
            for(int j = 0; j < n; j++)
            {
                
                if( (i & (1 << j)) != 0)
                {
                    xyz.add(nums[j]);
                }
            }
            ans.add(xyz);
        }
        return ans;
    }
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
        List<List<Integer>> ans = new ArrayList<>();
        ans = power(arr);
        System.out.println("Power Set = "+ans);
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