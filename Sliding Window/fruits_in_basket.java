// In this problem you will be given an array containing diffrent types of fruits.
// You will be given two baskets.
// Each basket can have only one type of fruit.
// We have to return the maximum number of fruit that you can collect.

import java.util.*;
public class fruits_in_basket
{
    public static int max_fruits(int nums[], int k)
    {
        int n  = nums.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(r < n)
        {
            mpp.put(nums[r],mpp.getOrDefault(nums[r],0)+1);
            if(mpp.size() > k)
            {
                mpp.put(nums[l],mpp.get(nums[l])-1);
                if(mpp.get(nums[l]) == 0)
                {
                    mpp.remove(nums[l]);
                }
                l++;
            }
            if(mpp.size() <= k)
            {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of fruits you have.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the type of "+i+" fruit.");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number of baskets you have.");
        int k = sc.nextInt();

        int maxFruit= max_fruits(arr,k);
        System.out.println("Maximum fruits you can have in your two baskets = "+maxFruit);

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