// In this problem you will be given an array containing integers.
// You will also be given an integer k.
// You have to return number of subArrays with k diffrent integers.

import java.util.*;
public class number_of_subArray_with_k_diffrent_integer
{
    public static int cnt_subArray(int nums[], int k)
    {
        int l,r,cnt;
        l = r = cnt =0;
        HashMap<Integer,Integer> hashh = new HashMap<>();
        while(r < nums.length)
        {
            hashh.put(nums[r],hashh.getOrDefault(nums[r],0)+1);
            while(hashh.size() > k)
            {
                hashh.put(nums[l],hashh.get(nums[l])-1);
                if(hashh.get(nums[l]) == 0)
                {
                    hashh.remove(nums[l]);
                }
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of integers you have.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" integer.");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number of diffrent integer you can have.");
        int k = sc.nextInt();

        int cnt = cnt_subArray(arr,k) - cnt_subArray(arr,k-1);
        System.out.println("Number of subArray with "+k+" diffrent integer = "+cnt);

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