import java.util.*;
public class longest_subArray_withSumK_positives
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n,k,left=0,right=0,maxLen=0;
        System.out.println("Enter the size of an Array");
        n = sc.nextInt();

        int [] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }

        int sum = arr[0];

        System.out.println("Enter the value of sum of sub array");
        k = sc.nextInt();

        // FINDING LONGEST SUB ARRAY WITH SUM K
        while(right < n)
        {
            while(left <= right && sum > k)
            {
                sum = sum-arr[left];
                left++;
            }
            if(sum == k)
            {
                if(maxLen > right - left + 1)
                {
                    maxLen = maxLen;
                }
                else
                {
                    maxLen = right - left + 1;
                }
            }
            right = right + 1;
            if(right < n)
            {
                sum = sum + arr[right];
            }
        }
        System.out.println("Longest sub array having sum "+k+" is "+maxLen);
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