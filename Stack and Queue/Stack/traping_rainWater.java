// Traping Rain Water
// In this problem we will be given an array of positive numbers including 0.
// Each Element of an array will be representing the height of the building.
// Assume that it is raining So, due to rain water wiil be filled in between the higher buildings.
// We have to tell the total amount of water filled between the buildings.
import java.util.Scanner;

public class traping_rainWater
{
    public static int[] find_prefixMax(int [] nums)
    {
        int n = nums.length;
        int [] prefix_max = new int[n];
        prefix_max[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            prefix_max[i] = Math.max(prefix_max[i-1] , nums[i]);
        }
        return prefix_max;
    }
    public static int[] find_suffixMax(int [] nums)
    {
        int n = nums.length;
        int [] suffix_max = new int[n];
        suffix_max[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--)
        {
            suffix_max[i] = Math.max(suffix_max[i+1] , nums[i]);
        }
        return suffix_max;
    }
    public static int total_water(int [] nums)
    {
        int n,total;
        n = nums.length;
        total = 0;

        int [] prefix_max = new int[n];
        prefix_max = find_prefixMax(nums);
        int [] suffix_max = new int[n];
        suffix_max = find_suffixMax(nums);

        for(int i = 0; i < n; i++)
        {
            int leftMax,rightMax;
            leftMax = prefix_max[i];
            rightMax = suffix_max[i];            
            if(nums[i] < leftMax && nums[i] < rightMax)
            {
                total += Math.min(leftMax, rightMax) - nums[i];
            }
        }
        return total;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of buildings you have.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the height of "+i+" building");
            arr[i] = sc.nextInt();
        }
        int water = total_water(arr);
        System.out.println("Total water between all the buoldings = "+water);

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