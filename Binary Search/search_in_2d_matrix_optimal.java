// SEARCH IN 2D MATRIX     (OPTIMAL)
// You will be given a sorted matrix.
// You will be given an element as target.
// YOU HAVE TO TELL WETHER THE GIVEN ELEMENT IS PRESENT IN MATRIX OR NOT
import java.util.Scanner;
public class search_in_2d_matrix_optimal
{
    public static boolean search(int [][] matrix, int m, int n, int target)
    {
        int low,high,mid;
        low = 0;
        high = (m*n) - 1;
        while(low <= high)
        {
            mid = (low + high)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col] > target)
            {
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return false;
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