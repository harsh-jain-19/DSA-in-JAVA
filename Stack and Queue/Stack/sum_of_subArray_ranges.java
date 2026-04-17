// In this problem you will be given an array.
// You have to find out all the sub-array.
// Then find out range of all the sub-arrays.
// Range = biggest element of sub-array - smallest element of sub-array.
// And return the sum of all the ranges of sub-array.
import java.util.*;

public class sum_of_subArray_ranges
{
    public static int[] find_pge(int [] arr)
    {
        int n = arr.length;
        int [] pge = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(! st.isEmpty() && arr[st.peek()] < arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                pge[i] = -1;
            }
            else
            {
                pge[i] = st.peek();
            }
            st.push(i);
        }
        return pge;
    }

    public static int[] find_nge(int [] arr)
    {
        int n = arr.length;
        int [] nge = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--)
        {
            while(! st.isEmpty() && arr[st.peek()] <= arr[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nge[i] = n;
            }
            else
            {
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }

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

    public static int total_maximum(int [] nums)
    {
        int n = nums.length;
        int [] nge = find_nge(nums);
        int [] pge = find_pge(nums);
        long total = 0;
        int mod = (int)(1e9+7);

        for(int i = 0; i < n; i++)
        {
            int left = i - pge[i];
            int right = nge[i] - i;
            long contribution = (long)left * right * nums[i];
            total = (total + contribution) % mod;
        }

        return (int)total;
    }

    public static int total_minimum(int [] nums)
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
        int maximum = total_maximum(arr);
        int minimum = total_minimum(arr);
        System.out.println("Sum of all the ranges of all the sub-array = "+(maximum-minimum));

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