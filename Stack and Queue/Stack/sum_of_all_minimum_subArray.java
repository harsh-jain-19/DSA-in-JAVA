// In this problem you will be given an array.
// You have to find out all the sub-array.
// Then find out minimum element of all the sub-arrays.
// And return the sum of all the minimum elements.
import java.util.*;

public class sum_of_all_minimum_subArray
{
    public static int[] find_pse(int [] arr)
    {
        int n = arr.length;
        int [] pse = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(! st.isEmpty() && arr[st.peek()] > arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pse[i] = -1;
            }
            else
            {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }

    public static int[] find_nse(int [] arr)
    {
        int n = arr.length;
        int [] nse = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--)
        {
            while(! st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nse[i] = n;
            }
            else
            {
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    public static int total_sum(int [] nums)
    {
        int n = nums.length;
        int [] nse = find_nse(nums);
        int [] pse = find_pse(nums);
        long total = 0;
        int mod = (int)(1e9+7);

        for(int i = 0; i < n; i++)
        {
            int left = i - pse[i];
            int right = nse[i] - i;
            long contribution = (long)left * right * nums[i];
            total = (total + contribution) % mod;
        }

        return (int)total;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of elements.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the "+i+" element");
            arr[i] = sc.nextInt();
        }
        int total = total_sum(arr);
        System.out.println("Total of all the minimums of all the sub-array = "+total);

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