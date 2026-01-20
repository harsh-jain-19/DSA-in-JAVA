// SEARCH IN 2D MATRIX     
// You will be given a sorted matrix. 
// Here Sorted means matrix will not be entirely sorted.
// It will be sorted by rows and columns.
// You will be given an element as target.
// YOU HAVE TO TELL THE INDEX OF THE GIVEN ELEMENT IF PRESENT IN MATRIX.
import java.util.Scanner;
public class search_in_2d_matrix
{
    public static void search(int [][] matrix, int m, int n, int target)
    {
        int low,high,mid,x=0;
        int row = 0;
        int col = n - 1;
        low = 0;
        high = (m*n) - 1;
        while(row < m && col >= 0)
        {
            if(matrix[row][col] == target)
            {
                System.out.println(target+" is present at index matrix["+row+"]["+col+"]");
                x = 1;
                break;
            }
            else if(matrix[row][col] > target)
            {
                col--;
            }
            else
            {
                row++;
            }
        }
        if(x == 0)
        {
            System.out.println(target+" is not present in the matrix");
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

        int target;
        System.out.println("Enter the element you are searching");
        target = sc.nextInt();
        search(matrix,m,n,target);

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