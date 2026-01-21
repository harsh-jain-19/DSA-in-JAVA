// PEAK ELEMENT IN MATRIX
// Peak Element: if an element is greater then its left,right,up and down elelment.
// We have to return any one peak element of matrix.

import java.util.Scanner;
public class peak_element_matrix
{
    public static int max_el_of_col(int [][] matrix, int m, int n, int col)
    {
        int max = 0;
        int x = 0;
        for(int row = 0; row < m; row++)
        {
            if(max < matrix[row][col])
            {
                max = matrix[row][col];
                x = row;
            }
        }
        return x;
    }
    public static void search(int [][] matrix, int m, int n)
    {
        int low,high,mid;
        low = 0;
        high = n - 1;
        while(low <= high)
        {
            mid = (low + high)/2;
            int row = max_el_of_col(matrix,m,n,mid); // Here we will find the row number of 
            int left, right;                         // maximum element of collumn.
            left = ((mid-1) >= 0) ? matrix[row][mid-1] : Integer.MIN_VALUE;
            right = ((mid+1) < n) ? matrix[row][mid+1] : Integer.MIN_VALUE;
            if(matrix[row][mid] > left && matrix[row][mid] > right)
            {
                System.out.println(matrix[row][mid]+" is a peak element.");
                break;
            }
            else if(matrix[row][mid] < left)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
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

        search(matrix,m,n);

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