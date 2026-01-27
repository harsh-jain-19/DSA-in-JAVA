// MEDIAN OF A MATRIX
// In this we will be given matrix with ODD NUMBER OF ROWS AND COLLUMNS.

import java.util.Scanner;
public class median_matrix
{
    public static int upper_bound(int [] arr, int n, int target)
    {
        int low,high,mid,ans;
        low = 0;
        high = n-1;
        ans = n;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[mid] > target)
            {
                ans = mid;
                high = mid -1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int smaller(int [][] matrix, int x, int m, int n)
    {
        int cnt = 0;
        for(int i = 0; i < m; i++)
        {
            cnt += upper_bound(matrix[i],n-1,x);
        }
        return cnt;
    }
    public static int search(int [][] matrix, int m, int n)
    {
        int low,high,mid;
        int req = (m*n)/2;
        low = matrix[0][0];
        high = matrix[0][n-1];
        for(int i = 0; i < m; i++)
        {
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][n-1]);
        }
        while(low <= high)
        {
            mid = (low + high)/2;
            int smallerEql = smaller(matrix,mid,m,n);
            if(smallerEql <= req)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m,n;
        System.out.println("Enter the number of rows");
        m = sc.nextInt();
        System.out.println("Enter the Number of Collumns");
        n = sc.nextInt();
        int [][] matrix = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.println("Enter the "+i+j+" element");
                matrix[i][j] = sc.nextInt();
            }
        }
        // FINDING

        int ans = search(matrix,m,n);
        System.out.println("Median Of The Given Matrix Is "+ans);

        // PRINTING
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("Hello World");
    }
}