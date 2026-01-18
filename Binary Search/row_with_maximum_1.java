// ROW WITH MAXIMUM 1's
// In this problem we will bw given a mXn matrix as matrix.
// Matrix will be containing only 0 and 1.
// We have to find the row containing maximum number of 1.
import java.util.Scanner;
public class row_with_maximum_1
{
    public static int lower_bound(int [] arr, int n, int target)
    {
        int low,high,mid,ans;
        low = 0;
        high = n-1;
        ans = n;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[mid] >= target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int search(int [][] matrix, int m, int n)
    {
        int cnt_max = 0;
        int idx  = -1;
        for(int i = 0; i < m; i++)
        {
            int x =lower_bound(matrix[i],n,1);
            int cnt_ones = n - x;
            if(cnt_ones > cnt_max)
            {
                cnt_max = cnt_ones;
                idx = i;
            }
        }
        return idx;
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
        int ans = search(matrix,m,n);
        System.out.println("Row with maximum number of 1 ="+ans);
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