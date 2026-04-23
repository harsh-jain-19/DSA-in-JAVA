// In this problem you will be given an array represebting the height of the rectangles.
// We have to return the largest area of rectangle that can be formed.

import java.util.*;
public class largest_rectangle_brute
{
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
    public static int[] find_pse(int [] arr)
    {
        int n = arr.length;
        int [] pse = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(! st.isEmpty() && arr[st.peek()] >= arr[i])
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
    public static long maximum_area(int nums[])
    {
        int n = nums.length;
        int [] nse = new int[n];
        int [] pse = new int[n];
        nse = find_nse(nums);
        pse = find_pse(nums);
        long maxi = 0;

        for(int i = 0; i < n; i++)
        {
            maxi = Math.max(maxi,((nums[i]) * (nse[i] - pse[i] - 1)));
        }
        return maxi;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of bars you have.");
        n = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter the height of "+i+" bar");
            arr[i] = sc.nextInt();
        }

        long maximum = maximum_area(arr);
        System.out.println("Biggest Rectangle That Can Be Fromed Is Of Area = "+maximum);

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