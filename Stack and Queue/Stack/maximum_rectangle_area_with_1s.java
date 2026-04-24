// In this problem we will be given an m x n matrix.
// Each cell of matrix will be filled from 1 or 0.
// We have to return the area of largest rectangle that containing 1 only.

import java.util.*;
public class maximum_rectangle_area_with_1s
{
    public static int maximum_area(int nums[])
    {
        Stack<Integer> stackk = new Stack<>();
        int n = nums.length;
        int maxi = 0;
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
    public static int maximum_1s_rectangle(int mat[][], int m, int n)
    {
        int maxArea = 0;
        int [] height = new int[n];

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 1)
                {
                    height[j]++;
                }
                else
                {
                    height[j] = 0;
                }
                
            }
            int area = maximum_area(height);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m,n;
        System.out.println("Enter the number of rows in array");
        m = sc.nextInt();
        System.out.println("Enter the numbers of collumm in array");
        n = sc.nextInt();
        int [][] arr = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.println("Enter the "+i+j+" element");
                arr[i][j] = sc.nextInt();
            }
        }
        int maxArea = maximum_1s_rectangle(arr,m,n);
        System.out.println("Maximum Area of Rectangle = "+maxArea);
        // PRINTING
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}