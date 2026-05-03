// In this problem you will be given an array.
// Array will be containing 0s and 1s.
// You will be given an integer k.
// k tells number of 0s you can flip to 1.
// You have to return the maximum number consective 1s after fliping k 0s.
import java.util.Scanner;
public class maximum_consective_1s_brute
{
    public static int k_flips(int nums[], int k)
    {
        int n  = nums.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeros = 0;
        while(r < n)
        {
            if(nums[r] == 0)
            {
                zeros++;
            }
            while(zeros > k)
            {
                if(nums[l] == 0)
                {
                    zeros--;
                }
                l++;
            }
            if(zeros <= k)
            {
                int len = r-l+1;
                maxLen = Math.max(maxLen,len);
            }
            r++;
        }
        return maxLen;
    }
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
            // You only give input as 0,1.
            arr[i] = sc.nextInt(2);
        }

        System.out.println("Enter the number 0s you can flip.");
        int k = sc.nextInt();

        int maxLen = k_flips(arr,k);
        System.out.println("Longest sub array with consective 1s after "+k+" 0's flips = "+maxLen);
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