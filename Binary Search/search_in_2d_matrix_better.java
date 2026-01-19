// SEARCH IN 2D MATRIX     (BETTER)
// You will be given a sorted matrix.
// You will be given an element as target.
// YOU HAVE TO TELL WETHER THE GIVEN ELEMENT IS PRESENT IN MATRIX OR NOT
import java.util.Scanner;
public class search_in_2d_matrix_better
{
    public static boolean b_search(int [] arr, int n, int target)
    {
        if(arr[0] > target)
        {
            return false;
        }
        int low,high,mid;
        low = 0;
        high = n-1;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(arr[mid] == target)
            {
                return true;
            }
            else if(arr[mid] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        if(low > high)
        {
            return false;
        }
        return false;
    }
    
    public static boolean search(int [][] matrix, int m, int n, int target)
    {
        boolean ans = false;
        for(int i = 0; i < m; i++)
        {
            ans = b_search(matrix[i],n,target);
        }
        return ans;
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

        int target;
        System.out.println("Enter the element you are searching");
        target = sc.nextInt();
        boolean ans = search(matrix,m,n,target);
        if(ans == true)
        {
            System.out.println("Element you are finding is present in matrix.");
        }
        else
        {
            System.out.println("Element you are finding is not present in matrix.");
        }

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