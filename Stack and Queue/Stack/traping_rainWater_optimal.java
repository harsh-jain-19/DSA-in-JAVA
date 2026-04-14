// Traping Rain Water
// In this problem we will be given an array of positive numbers including 0.
// Each Element of an array will be representing the height of the building.
// Assume that it is raining So, due to rain water wiil be filled in between the higher buildings.
// We have to tell the total amount of water filled between the buildings.
import java.util.Scanner;

public class traping_rainWater_optimal
{
    public static int total_water(int [] nums)
    {
        int n = nums.length;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        int l,r;
        l = 0;
        r = n - 1;
        while(l < r)
        {
            if(nums[l] <= nums[r])
            {
                if(leftMax > nums[l])
                {
                    total += leftMax - nums[l];
                }
                else
                {
                    leftMax = nums[l];
                }
                l++;
            }
            else
            {
                if(rightMax > nums[r])
                {
                    total += rightMax - nums[r];
                }
                else
                {
                    rightMax = nums[r];
                }
                r--;
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