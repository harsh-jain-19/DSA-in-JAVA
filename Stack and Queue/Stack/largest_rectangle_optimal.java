// In this problem you will be given an array represebting the height of the rectangles.
// We have to return the largest area of rectangle that can be formed.

import java.util.*;
public class largest_rectangle_optimal
{
    public static long maximum_area(int nums[])
    {
        Stack<Integer> stackk = new Stack<>();
        int n = nums.length;
        long maxi = 0;
        int nse,pse,element;

        for(int i = 0; i < n; i++)
        {
            while(! stackk.isEmpty() && nums[stackk.peek()] > nums[i])
            {
                element = stackk.peek();
                stackk.pop();
                nse = i;
                if(stackk.isEmpty())
                {
                    pse = -1;
                }
                else
                {
                    pse = stackk.peek();
                }
                maxi = Math.max(maxi,(nums[element] * (nse - pse - 1)));
            }
            stackk.push(i); 
        }

        while(! stackk.isEmpty())
        {
            nse = n;
            element = stackk.peek();
            stackk.pop();
            if(stackk.isEmpty())
            {
                pse = -1;
            }
            else
            {
                pse = stackk.peek();
            }
            maxi = Math.max(maxi,(nums[element] * (nse - pse - 1)));

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